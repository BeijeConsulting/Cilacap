package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConverterCSV_XML {
	
	
	public static void readCSVFile(List<Contatto> contacts, String pathFile) throws Exception {
		
		File sheet = new File(pathFile); // import the file
		
		FileReader fileReader = new FileReader(sheet); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line

		
		String row = reader.readLine();
		String[] fields = row.split(";");
		final int[] arrayIndex = new int[5];
  		int counterColumns;       // Variable to count number of columns in the first line
  		
		//Creating indexes for each column
		
		for(counterColumns = 0; counterColumns <= fields.length-1; counterColumns++) {
			
			if (fields[counterColumns].contentEquals("NOME")) {
				arrayIndex[0] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("COGNOME")) {
				arrayIndex[1] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("TELEFONO")) {
				arrayIndex[2] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("EMAIL")) {
				arrayIndex[3] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("INDIRIZZO")) {
				arrayIndex[4] = counterColumns;
			}
				
		}
		
		// Organization of the data according to the columns
		
		row = reader.readLine();
		
		while (row != null) {
			
			Contatto data = new Contatto();
			
			fields = row.split(";"); //Divide row 
				
			if (arrayIndex[0] < fields.length) {
				data.setNome(fields[arrayIndex[0]]);
				//System.out.println("Nome: " + fields[arrayIndex[0]]);
			}
			if (arrayIndex[1] < fields.length) {
				data.setCognome(fields[arrayIndex[1]]);
				//System.out.println("Cognome: " + fields[arrayIndex[1]]);
			}
			if (arrayIndex[2] < fields.length) {
				data.setTelefono(fields[arrayIndex[2]]);
				//System.out.println("Telefono: " + fields[arrayIndex[2]]);
			}
			if (arrayIndex[3] < fields.length) {
				data.setEmail(fields[arrayIndex[3]]);
				//System.out.println("Email: " + fields[arrayIndex[3]]);
			}
//			if (arrayIndex[4] < fields.length) {
//				data.setIndirizzo(fields[arrayIndex[4]]);
//				//System.out.println("Indirizzo: " + fields[arrayIndex[4]]);
//			}
				
			contacts.add(data);
				
			row = reader.readLine();
			}
		
		reader.close();	
	}
		
	public static void writeContattiInFile(List<Contatto> contatti, String pathfile) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element docElement = document.createElement("rubrica");
        document.appendChild(docElement);
        
        for (Contatto c : contatti) {
        	Element contatto = document.createElement("contatto");
        	Element nome = document.createElement("nome");
        	Element cognome = document.createElement("cognome");
        	Element telefono = document.createElement("telefono");
        	Element email = document.createElement("email");
        	
        	nome.setTextContent(c.getNome());
        	cognome.setTextContent(c.getCognome());
        	telefono.setTextContent(c.getTelefono());
        	email.setTextContent(c.getEmail());
        	
        	contatto.appendChild(nome);
        	contatto.appendChild(cognome);
        	contatto.appendChild(telefono);
        	contatto.appendChild(email);

        	docElement.appendChild(contatto);
        }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathfile));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}

	public static void main(String[] args) throws Exception {
		
		
		ArrayList<Contatto> listContacts = new ArrayList<Contatto>();
		
		readCSVFile(listContacts, "csv/rubrica3.csv");
		
		writeContattiInFile(listContacts, "xml\\MyRubricaCSVtoXML2.xml");
		
	}

}
