package it.beije.cilacap.crystal;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import it.beije.cilacap.crystal.ReadCrystal;
import static it.beije.cilacap.crystal.ParserXML.*;
import static it.beije.cilacap.crystal.CrystalXML.*;

public class GestoreCrystalDB {

	private static Log logger = LogFactory.getLog(HDBtools.class);

	public static void main(String[] args) throws Exception {
		logger.debug("INIZIO");

		System.out.println("Menu:");
		System.out.println("Utilizzando JDBC:");
		System.out.println("1-inserire testdata da file in db JDBC");
		System.out.println("2- inserire testdata da xml in db JDBC");
		System.out.println("3- export db  a xml con JDBC \n");
		System.out.println("Utilizzando HIBERNATE:");
		System.out.println("4-inserire testdata da file in db HIBERNATE");
		System.out.println("5-inserire testdata da xml in db HIBERNATE");
		System.out.println("6- export db a xml con HIBERNATE");

		Scanner s = new Scanner(System.in);
		int risposta = s.nextInt();
		File fileCrystalCSV = new File("crystal/01/CDM_20200102131948.txt");
		List<String> contenutoCrystal = new ArrayList<String>();
		TestData testDataCrystal = null;
		File fileCrystalXML = new File("crystal/crystaldata.xml");

		switch (risposta) {

		case 1:

			contenutoCrystal = ReadCrystal.readFileRows(fileCrystalCSV);

			testDataCrystal = ReadCrystal.getTestData(contenutoCrystal);

			testDataCrystal
					.setIdComputer(fileCrystalCSV.getPath().substring(15, fileCrystalCSV.getPath().length() - 4));

			DBtools.insertTestDataJDBC(testDataCrystal);
			break;

		case 2:
			testDataCrystal = getTestDataFromFileXML(fileCrystalXML);
			DBtools.insertTestDataJDBC(testDataCrystal);
			// DBtools.scriviTestDataHibernate(testData);
			break;

		case 3:
			testDataCrystal = DBtools.leggiTestDataJDBC();
			createXML(testDataCrystal);

			break;
		case 4:
			contenutoCrystal = new ArrayList<String>();
			contenutoCrystal =ReadCrystal.readFileRows(fileCrystalCSV);
			testDataCrystal = ReadCrystal.getTestData(contenutoCrystal);
			testDataCrystal
					.setIdComputer(fileCrystalCSV.getPath().substring(15, fileCrystalCSV.getPath().length() - 4));
			DBtools.scriviTestDataHibernate(testDataCrystal);

		case 5:

			testDataCrystal= getTestDataFromFileXML(fileCrystalXML);
			DBtools.scriviTestDataHibernate(testDataCrystal);
			// DBtools.scriviTestDataHibernate(testData);
			break;
			

		}
	}
}
