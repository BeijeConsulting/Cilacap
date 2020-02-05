package it.beije.cilacap.rubrica;
import java.io.*;
import java.util.*;

public class CaricaListaContatti  {
	
	public static void main(String[] args) throws Exception {
	Scanner input = new Scanner(System.in);
	Scanner input2=new Scanner(System.in);
	String path;
	String csvSplitBy=";";
	Methods m = new Methods();
	System.out.println("Inserire la path del file");
	path=input.nextLine();
	//Controllo se il file esiste, se non esiste lo creo.
	try {
	File file = new File(path);
	if (file.exists()) {
	System.out.println("Il file " + path + " esiste");
	System.out.println(file.getAbsolutePath());
	}
	else if (file.createNewFile()) {
	System.out.println("Il file " + path + " è stato creato");
	System.out.println(file.getAbsolutePath());
	}
	else
	System.out.println("Il file " + path + " non può essere creato");
	} catch (IOException e) {
	e.printStackTrace();
	}
	
	// Aggiungo uno o più contatti al file CSV
	
	List<String[]> lc= new ArrayList<String[]>();
	System.out.println("Vuoi aggiungere un contatto alla rubrica? S/N?");
	if(input.next().equalsIgnoreCase("s")){
		lc=Methods.getFileCsvContent(csvSplitBy, path);
		String[]intestazioneFile=lc.get(0);
		lc=m.setContatto(intestazioneFile, lc);
		Methods.writeToCsvFile(lc, csvSplitBy, path);
		System.out.println("Rubrica aggiornata correttamente");
	}
	input.close();
	
		// Trasformazione da CSV ad XML e viceversa
		
		System.out.println("Si vuole convertire un file CSV o un file XML?");
		if(input2.nextLine().equalsIgnoreCase("xml")) {
			System.out.println("Inserire la path del file XML da convertire in CSV");
			String pathfile =input2.nextLine();
			String pathFileCsv="C:\\Users\\Padawan07\\git\\Cilacap\\csv\\trasformato.csv";
			Methods.writeToCsvFile(Methods.getCsvListFromXmlFile(Methods.getContattiFromFileXml(pathfile)), csvSplitBy, pathFileCsv );
			System.out.println("File XML trasformato correttamente in CSV");
			}
		else {
			String pathFileXml="C:\\Users\\Padawan07\\git\\Cilacap\\csv\\trasformato.xml";
			System.out.println("Inserire la path del file CSV da convertire in XML");
			String pathfile =input2.nextLine();
			Methods.writeContattiInFileXml(Methods.getXmlListFromCsvFile(csvSplitBy,pathfile),pathFileXml);
			System.out.println("File CSV trasformato correttamente in XML");
			
		}
		input2.close();
	}	
}
