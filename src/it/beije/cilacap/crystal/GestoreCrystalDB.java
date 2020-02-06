package it.beije.cilacap.crystal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import it.beije.cilacap.crystal.GestoreReadCrystal;
import static it.beije.cilacap.crystal.ParserXML.*;
public class GestoreCrystalDB {

	
	private static Log logger = LogFactory.getLog(HDBtools.class);

	public static void main(String[] args) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
		
		logger.debug("INIZIO");

		
		System.out.println("Menu:");
		System.out.println("1-inserire testdata da file in db");
		System.out.println("2- inserire testdata da xml in db");
		System.out.println("3- visualizzazione contenuto db");
		
		Scanner s=new Scanner(System.in);
		int risposta=s.nextInt();
		
		switch(risposta) {
		case 1:
			File fileCrystalCSV= new File("crystal/01/CDM_20200102131948.txt");
			List <String> contenutoCrystal = new ArrayList<String>();
			contenutoCrystal=GestoreReadCrystal.readFileRows(fileCrystalCSV);
			TestData datiDiCrystal=GestoreReadCrystal.createListOfData(contenutoCrystal);
			datiDiCrystal.setIdComputer(fileCrystalCSV.getPath().substring(15,fileCrystalCSV.getPath().length()-4));
			DBtools.insertTestData(datiDiCrystal);
			break;
		
		case 2: 
			File fileCrystalXML= new File("crystal/crystaldata.xml");
			TestData testData= getTestDataFromFileXML(fileCrystalXML);
			
			break;
			
		case 3: 
			break;
		
		}

		
		
		
		
	}

}
