package it.beije.cilacap.esercizi.FileManager;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static final String PATH_CSV_FILE = "csv/rubricaCSV.csv";
	public static final String PATH_XML_FILE = "xml/rubricaXML.xml";

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean menuOn = false;
		
		FileManager f = new FileManager();
		ArrayList<Contatto> contatti = f.readRubricaCSV(PATH_CSV_FILE);
		
		Scanner scn = new Scanner(System.in);
		while (!menuOn) {
			System.out.println("Rubrica dello zio 1.0\n\n1- Visualizzazione rubrica\n2- Inserimento nuovo numero");
			String scelta1 = scn.nextLine();
			
			switch(scelta1) {
			case "1":
				f.printRubrica(contatti);
				break;
			case "2":
				f.writeRubrica(f.addContatti(contatti), PATH_CSV_FILE);
				f.writeRubricaXML(contatti, PATH_XML_FILE);
				break;
			}
			System.out.println("Tornare al menu principale?\ts/n");
			if (scn.nextLine().contentEquals("n"))
				menuOn = true;
		}
		System.exit(0);
	}
}
