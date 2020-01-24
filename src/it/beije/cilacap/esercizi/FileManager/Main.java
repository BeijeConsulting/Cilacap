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
		ArrayList<Contatto> contatti = f.getContattiFromFile(PATH_XML_FILE);
//		ArrayList<Contatto> contattiXml = f.getContattiFromFile(PATH_XML_FILE);
		
		Scanner scn = new Scanner(System.in);
		while (!menuOn) {
			System.out.println("Rubrica dello zio 1.0\n\n1- Visualizzazione rubrica"
					+ "\n2- Inserimento nuovo numero"
					+ "\n3- Copia file .csv esterno nella Rubrica"
					+ "\n4- Copia file .xml esterno nella Rubrica"
					+ "\n5- Esporta rubrica in un file .csv"
					+ "\n6- Esporta rubrica in un file .xml");
			String scelta1 = scn.nextLine();
			
			switch(scelta1) {
			case "1":
				f.printRubrica(contatti);
				break;
			case "2":
				f.writeRubrica(f.addContatti(contatti), PATH_CSV_FILE,PATH_XML_FILE);
				break;
			case "3":
				String pathFileCopiaCsv = "";
				System.out.println("Specificare il path del File .csv da copiare...");
				
				pathFileCopiaCsv = scn.nextLine();
				
				ArrayList<Contatto> contattiCopiaCsv = f.readRubricaCSV(pathFileCopiaCsv);
				
				f.writeRubrica(contattiCopiaCsv, PATH_CSV_FILE ,PATH_XML_FILE);
				break;
				
			case "4":
				String pathFileCopiaXml = "";
				System.out.println("Specificare il path del File .csv da copiare...");
				
				pathFileCopiaXml = scn.nextLine();
				
				ArrayList<Contatto> contattiCopiaXml = f.readRubricaXML(pathFileCopiaXml);
				
				f.writeRubrica(contattiCopiaXml,PATH_CSV_FILE ,PATH_XML_FILE);
				break;
				
			case "5":
				String pathFileExportCsv = "";
				System.out.println("Specificare il path del nuovo File .csv da creare...");
				
				pathFileExportCsv = scn.nextLine();
				
				f.writeRubricaCSV(contatti,pathFileExportCsv);
				break;
			
			case "6":
				String pathFileExportXml = "";
				System.out.println("Specificare il path del nuovo File .xml da creare...");
				
				pathFileExportXml = scn.nextLine();
				
				f.writeRubricaXML(contatti,pathFileExportXml,true);
				break;
			}
			System.out.println("Tornare al menu principale?\ts/n");
			if (scn.nextLine().contentEquals("n"))
				menuOn = true;
		}
		System.exit(0);
	}
}
