package it.beije.cilacap.crystal;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import it.beije.cilacap.crystal.ReadCrystal;
import static it.beije.cilacap.crystal.ParserXML.*;

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
		System.out.println("6- export db a xml con HIBERNATE \n");
		
		System.out.println("Utilizzando JPA:");
		System.out.println("7-inserire testdata da file in db JPA");
		System.out.println("8-inserire testdata da xml in db JPA");
		System.out.println("9- export db a xml con JPA");

		@SuppressWarnings("resource")
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
		
		case 6: 
			System.out.println(DBtools.leggiTestDataHibernate().size());
			testDataCrystal=DBtools.leggiTestDataHibernate().get(0);
			createXML(testDataCrystal);
			break;
			
		case 7:

			contenutoCrystal = ReadCrystal.readFileRows(fileCrystalCSV);

			testDataCrystal = ReadCrystal.getTestData(contenutoCrystal);

			testDataCrystal
					.setIdComputer(fileCrystalCSV.getPath().substring(15, fileCrystalCSV.getPath().length() - 4));

			DBtools.insertTestDataJPA(testDataCrystal);
			break;

		case 8:
			testDataCrystal = getTestDataFromFileXML(fileCrystalXML);
			DBtools.insertTestDataJPA(testDataCrystal);
			// DBtools.scriviTestDataHibernate(testData);
			break;

		case 9:
			testDataCrystal = DBtools.leggiTestDataJDBC();
			createXML(testDataCrystal);

			break;

		}
	}
}
