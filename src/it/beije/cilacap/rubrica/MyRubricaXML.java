package it.beije.cilacap.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyRubricaXML
{

	public static void main(String[] args) throws Exception
	{
		int scelta = 3;
		boolean again = false; //variabile d'appoggio. Ripetere inserimento?
		File f = new File("csv\\rubrica1.csv");//riferimento al pathfile (CSV)
		ArrayList<Contatto> listacontatti = new ArrayList<Contatto>();//creazione struttura principale
		List<String> righeCSV = new ArrayList<String>();//
		File fileCSV = new File("csv\\XMLtoCSV.csv");
		
		switch(scelta)
		{
		case 1: //inserimento da tastiera dei campi e salvataggio in file XML
			do 
			{
				setContatti(listacontatti);//metodo per inserimento contatti in listacontatti
				again = MyRubrica.askNewValue();
			}
			while(again);
			writeContattiInFile(listacontatti, "xml\\MyRubricaXML.xml");//scrittura file XML
			break;
			
		case 2: //da file CSV a file XML
			righeCSV = MyRubrica.readContent(f);//estrapolare le righe utlizzando il readcontent
			CSVToXML(righeCSV, listacontatti);//ordine + inserimento in listacontatti
			writeContattiInFile(listacontatti, "xml\\CSVtoXML.xml");//scrittura file XML
			break;
			
		case 3: //da file XML a CSV
			getContattiFromXML(listacontatti, "xml\\MyRubricaXML.xml");
			writeContattiInFileCSV(listacontatti, "csv\\XMLtoCSV.csv");//scrittura file CSV da contenuto Bean
			
		}
	}
	
	public static void writeContattiInFile(List<Contatto> contatti, String pathfile) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument(); //creazione nuovo documento XML
        Element docElement = document.createElement("rubrica"); //creazione elemento radice rubrica
        document.appendChild(docElement); //appendo l'elemento radice al documento XML
        
        for (Contatto c : contatti) { //aggiungo i seguenti tag per ciascun tag di tipo Contatto
        	Element contatto = document.createElement("contatto");
        	Element nome = document.createElement("nome");
        	Element cognome = document.createElement("cognome");
        	Element telefono = document.createElement("telefono");
        	Element email = document.createElement("email");
        	
        	nome.setTextContent(c.getNome()); //popolo i Contatto utilizando i metodi get
        	cognome.setTextContent(c.getCognome());
        	telefono.setTextContent(c.getTelefono());
        	email.setTextContent(c.getEmail());
        	
        	contatto.appendChild(nome); //appendo gli Element a contatto
        	contatto.appendChild(cognome);
        	contatto.appendChild(telefono);
        	contatto.appendChild(email);

        	docElement.appendChild(contatto); //infine appendo contatto all'elemento radice
        }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File (pathfile));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}
	
	public static void setContatti (List<Contatto> contatti)
	{
		Contatto valore = new Contatto();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci il nome:");
		String myInput = input.nextLine();
		valore.setNome(myInput);
		
		System.out.println("Inserisci il cognome:");
		myInput = input.nextLine();
		valore.setCognome(myInput);
		
		System.out.println("Inserisci il telefono:");
		myInput = input.nextLine();
		valore.setTelefono(myInput);
		
		System.out.println("Inserisci il email:");
		myInput = input.nextLine();
		valore.setEmail(myInput);
		
		contatti.add(valore);
	}
	
	public static void CSVToXML (List<String> listarighe, List<Contatto> contatti)
	{
		String riga; //estrapola ciascuna riga
		String[] campo = new String[1]; //array di stringa per memorizzare ciascun campo della riga
		
		riga = listarighe.get(0);
		campo = riga.split(";");
		final int[] indice = new int[5];
		for (int i=0; i<campo.length; i++)
		{
			if ("COGNOME".equalsIgnoreCase(campo[i])) indice[0] = i;
			if ("NOME".equalsIgnoreCase(campo[i])) indice[1] = i;
			if ("TELEFONO".equalsIgnoreCase(campo[i])) indice[2] = i;
			if ("EMAIL".equalsIgnoreCase(campo[i])) indice[3] = i;
			if ("INDIRIZZO".equalsIgnoreCase(campo[i])) indice[4] = i;
		}
		
		for (int i=1; i<listarighe.size(); i++)
		{
			Contatto valore = new Contatto();
			riga = listarighe.get(i);
			campo = riga.split(";");
			
			valore.setNome(campo[indice[1]]);
			valore.setCognome(campo[indice[0]]);
			valore.setTelefono(campo[indice[2]]);
			valore.setEmail(campo[indice[3]]);
			
			contatti.add(valore);
		}

	}
	
	public static void getContattiFromXML(List<Contatto> contatti, String pathfile) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(pathfile);
        Element element = document.getDocumentElement();       
        //System.out.println(element.getTagName()); //Nome del nodo principale
        
        //System.out.println(element.getChildNodes().getLength()); //Numero elementi contatto
        NodeList contacts = element.getElementsByTagName("contatto");
        //System.out.println("contatti : " + contacts.getLength()); //Numero elementi contatto

        for (int i = 0; i < contacts.getLength(); i++) {
        	Element utente = (Element)contacts.item(i);
        	//System.out.println(utente.getTagName() + " " + i); N contatto
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
        	contatti.add(contatto);
        }
	}
	
	public static void writeContattiInFileCSV(List<Contatto> contatti, String pathfile) throws IOException
	{
		StringBuilder sbInput = new StringBuilder();
		sbInput.append("NOME;COGNOME;TELEFONO;EMAIL;\n");
		
		for (Contatto c : contatti)
		{
			sbInput.append(c.getNome());
			sbInput.append(";");
			
			sbInput.append(c.getCognome());
			sbInput.append(";");
			
			sbInput.append(c.getTelefono());
			sbInput.append(";");
			
			sbInput.append(c.getEmail());
			sbInput.append(";");
			
			sbInput.append("\n");
			
		}
		
		String contenuto = sbInput.toString();
		
		FileWriter f = new FileWriter(pathfile);
		f.write(contenuto); //Scrivo il contenuto di una stringa su un file
		System.out.println("File salvato.");

		f.close();
		
	}

}
