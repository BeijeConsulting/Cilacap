package it.beije.cilacap.rubrica;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertContentAction;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.xml.sax.SAXException;

import antlr.build.Tool;
import it.beije.cilacap.rubrica.Tools;
import it.beije.cilacap.rubrica.HibernateMethods;
import it.beije.cilacap.rubrica.JpaMethods;

//import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.writeInFileCSV;
//import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.writeInXML;
//import static it.beije.cilacap.esercizi.rubrica.EsercizioRubrica.loadContactListFromCSV;
//import static it.beije.cilacap.rubrica.ParserXML.getContattiFromFile;

public class EsercizioDB {
	private static Log logger = LogFactory.getLog(EsercizioDB.class);

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException,
			ParserConfigurationException, TransformerException, SAXException {
		logger.debug("INIZIO");

		boolean continua = true;
		do {
			System.out.println("Cosa vuoi fare? \n");
			System.out.println("Se vuoi usare JDBC:");
			System.out.println("1-leggere il database usando jdbc");
			System.out.println("2-esportare il db in un csv usando jdbc");
			System.out.println("3- esportare il db in un xml usando jdbc");
			System.out.println("4- importare il file csv in db usando jdbc");
			System.out.println("5- importare il file xml in db usando jdbc  \n");

			System.out.println("Se vuoi usare HIBERNATE: ");
			System.out.println("6-leggere il database usando hibernate");
			System.out.println("7- esportare il db in un csv usando hibernate");
			System.out.println("8- esportare il db in un xml usando hibernate");
			System.out.println("9- importare il file csv in db usando hibernate");
			System.out.println("10- importare il file xml in db usando hibernate\n");

			System.out.println("Se vuoi usare JPA:");
			System.out.println("11-leggere il database usando jpa");
			System.out.println("12-esportare il db in un csv usando jpa");
			System.out.println("13-esportare il db in un xml usando jpa");
			System.out.println("14-importare il file csv in db usando jpa");
			System.out.println("15-importare il file xml in db usando jpa   \n");

			Scanner s = new Scanner(System.in);
			int risposta = s.nextInt();
			List<Contatto> listaContatti = null;
			File f1 = null;
			switch (risposta) {
			case 1:
//				leggere il database usando jdbc
				listaContatti = new ArrayList<Contatto>();
				listaContatti = DBtools.leggiContatti();

				break;

			case 2:
//				esportare il db in un csv usando jdbc

				f1 = new File("csv/database.csv");
				listaContatti = DBtools.leggiContatti();
				Tools.writeInFileCSV(listaContatti, f1);
				break;

			case 3:
//				esportare il db in un xml usando jdbc

				f1 = new File("xml/database.xml");
				listaContatti = DBtools.leggiContatti();
				Tools.writeInXML(listaContatti, f1);

				break;

			case 4:
//				importare il file csv in db usando jdbc
				f1 = new File("csv/rubrica.csv");
				Tools.fromCSVToDatabase(f1);
				break;

			case 5:
//				importare il file xml in db usando jdbc

				f1 = new File("xml/rubrica.xml");
				Tools.fromXMLToDatabase(f1);

				break;
			case 6:
//				leggere il database usando hibernate

				listaContatti = HibernateMethods.leggiContatti();
				break;

			case 7:
//				esportare il db in un csv usando hibernate

				f1 = new File("csv/database.csv");
				listaContatti = HibernateMethods.leggiContatti();
				Tools.writeInFileCSV(listaContatti, f1);
				break;

			case 8:
//				esportare il db in un xml usando hibernate

				f1 = new File("xml/database.xml");
				listaContatti = HibernateMethods.leggiContatti();
				Tools.writeInXML(listaContatti, f1);
				break;

			case 9:

				f1 = new File("csv/rubrica1.csv");
				listaContatti = Tools.loadContactListFromCSV(f1);
				try {
					HibernateMethods.inserisciContatti(listaContatti);
				} catch (ConstraintViolationException e) {
					System.out.println(
							"Email già esistente, non è possibile avere duplicati di email, scegli un altro file");
				}
				break;

			case 10:

				f1 = new File("xml/rubrica.xml");
				listaContatti = Tools.getContattiFromFile(f1);
				try {
					HibernateMethods.inserisciContatti(listaContatti);
				} catch (ConstraintViolationException e) {
					System.out.println(
							"Email già esistente, non è possibile avere duplicati di email, scegli un altro file");
				}
				break;

			case 11:
//				leggere il database usando jpa

				listaContatti = new ArrayList<Contatto>();
				listaContatti = JpaMethods.leggiContatti();

				break;

			case 12:
//				esportare il db in un csv usando jpa

				f1 = new File("csv/database.csv");
				listaContatti = JpaMethods.leggiContatti();
				Tools.writeInFileCSV(listaContatti, f1);
				break;

			case 13:
//				esportare il db in un xml usando jpa

				f1 = new File("xml/database.xml");
				listaContatti = JpaMethods.leggiContatti();
				Tools.writeInXML(listaContatti, f1);

				break;

			case 14:
//				importare il file csv in db usando jpa 
				f1 = new File("csv/rubrica1.csv");
				listaContatti = Tools.loadContactListFromCSV(f1);
				try {
					JpaMethods.inserisciContatti(listaContatti);
				} catch (java.sql.SQLIntegrityConstraintViolationException e) {
					System.out.println(
							"Email già esistente, non è possibile avere duplicati di email, scegli un altro file");
				}
				
				break;

			case 15:
//				importare il file xml in db usando jpa 


				f1 = new File("xml/rubrica.xml");
				listaContatti = Tools.getContattiFromFile(f1);
				try {
					JpaMethods.inserisciContatti(listaContatti);
				} catch (java.sql.SQLIntegrityConstraintViolationException e) {
					System.out.println(
							"Email già esistente, non è possibile avere duplicati di email, scegli un altro file");
				}
				break;

			}
			System.out.println("Vuoi fare qualco'altro?");
			String risp = s.next();
			if (risp.equals("n"))
				continua = false;
		} while (continua);

		logger.debug("FINE");

	}

}
