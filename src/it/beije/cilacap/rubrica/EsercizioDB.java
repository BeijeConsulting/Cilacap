package it.beije.cilacap.rubrica;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertContentAction;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import it.beije.cilacap.rubrica.Tools;
//import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.writeInFileCSV;
//import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.writeInXML;
//import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.loadContactListFromCSV;
//import static it.beije.cilacap.rubrica.ParserXML.getContattiFromFile;


public class EsercizioDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParserConfigurationException, TransformerException, SAXException {
		System.out.println("Cosa vuoi fare?");
		System.out.println("1-leggere il database");
		System.out.println("2-esportare il db in un csv");
		System.out.println("3- esportare il db in un xml");
		System.out.println("4- importare il file csv in db");
		System.out.println("5- importare il file xml in db");
		
		Scanner s=new Scanner(System.in);
		int risposta= s.nextInt();
		
		switch(risposta) {
			case 1:
				List<Contatto> listaContatti=new ArrayList<Contatto>();
				listaContatti=DBtools.leggiContatti();
				break;
			case 2:
				File f1=new File("csv/database.csv");
				List<Contatto> listaContatti2=new ArrayList<Contatto>();
				listaContatti2=DBtools.leggiContatti();
				Tools.writeInFileCSV(listaContatti2, f1);
				break;
			case 3:
				File f2=new File("xml/database.xml");
				List<Contatto> listaContatti3=new ArrayList<Contatto>();
				listaContatti3=DBtools.leggiContatti();
				Tools.writeInXML(listaContatti3, f2);
				break;
			case 4:
				File f3=new File("csv/rubrica.csv");
				fromCSVToDatabase(f3);
				break;
			case 5:
				File f4=new File("xml/rubrica.xml");

				fromXMLToDatabase(f4);
				break;
			default: break;
				
		
		
		}
		
		
		
		
		
		
	}
	
	public static void fromCSVToDatabase(File f1) throws IOException, ClassNotFoundException {
		List<Contatto> listaContatti=new ArrayList <Contatto>();
		listaContatti=Tools.loadContactListFromCSV(f1);
		
		for(int i=0; i< listaContatti.size();i++) {
			DBtools.insertContatto(listaContatti.get(i));
		}
		
		
		
	}
	
	public static void fromXMLToDatabase(File f1) throws IOException, ClassNotFoundException, ParserConfigurationException, SAXException {
		List<Contatto> listaContatti=new ArrayList <Contatto>();
		listaContatti=Tools.getContattiFromFile(f1);
		
		for(int i=0; i< listaContatti.size();i++) {
			DBtools.insertContatto(listaContatti.get(i));
		}
		
		
		
	}
}
