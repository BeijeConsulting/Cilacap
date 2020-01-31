package it.beije.cilacap.esercizi.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.cilacap.rubrica.Contatto;
import jdk.nashorn.internal.runtime.ListAdapter;

public class EsercizioRubrica {
	
	public static String readFileContent(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileContent(file);
	}

	public static String readFileContent(File file) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		FileReader fileReader = new FileReader(file);

		int c;
		while ((c = fileReader.read()) > -1) {
			//System.out.print((char)c);
			builder.append((char)c);
		}
		
		fileReader.close();
		return builder.toString();
	}
	
	public static void writeFileContent(String content, String filePath) throws IOException {
		File file = new File(filePath);
		writeFileContent(content, file);
	}
	
	public static void writeFileContent(String content, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		
		fileWriter.write(content);
		
		fileWriter.flush();
		fileWriter.close();
	}
	
	public static String insertData() {
		Scanner s = new Scanner(System.in);
		String dato;
		dato=s.nextLine();
		boolean noChar= false;
		while(dato.isEmpty() || dato == null || dato.trim().isEmpty()) {
			System.out.println("Campo obbligatorio, non può essere vuoto"); 
			dato=s.nextLine();
			
		}		
		return dato;
	}
	
	
	public static List<Contatto> loadContactListFromCSV (File file) throws IOException{
		List <Contatto>  contactList= new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row=reader.readLine();
		while ((row = reader.readLine()) != null) {
			Contatto c1=new Contatto();
			String [] info= row.split(";");
			c1.setCognome(info[0]);
			c1.setNome(info[1]);
			c1.setTelefono(info[2]);
			c1.setEmail(info[3]);
			contactList.add(c1);
			}
		return contactList;	
	}
	
	public static void writeInFileCSV(List <Contatto> contatti, File f1 ) throws IOException {
		
		StringBuilder contenuto= new StringBuilder();
		for(Contatto contatto: contatti) {
			contenuto.append(contatto.getCognome()+";");
			contenuto.append(contatto.getNome()+";");
			contenuto.append(contatto.getTelefono()+";");
			contenuto.append(contatto.getEmail()+"\n");
		}
	
		String intestazione ="COGNOME;NOME;TELEFONO;EMAIL\n";
		String nuovoContenuto=contenuto.toString();
		
		if(f1.exists()) {
			String contenutoFile =readFileContent(f1);
			System.out.println(contenutoFile);
			String stringContenutoFile=intestazione.concat(contenutoFile.substring(contenutoFile.indexOf('\n')+1).concat(nuovoContenuto));
			writeFileContent(stringContenutoFile, f1);
		}else {
			String contenuto2=intestazione.concat(nuovoContenuto);
			writeFileContent(contenuto2, f1);
			
		}
	}
	

	public static List<Contatto> createContacts() {
		
		Scanner s= new Scanner(System.in);
		boolean finito=false;
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		//CE 20200122: ciclo inserimento dati
		do { 		
			Contatto c=new Contatto();
			System.out.println("Cognome: ");
			c.setCognome(insertData());
			System.out.println("Nome: " );
			c.setNome(insertData());			
			System.out.println("Telefono: ");
			c.setTelefono(insertData());			
			System.out.println("Email: ");
			c.setEmail(insertData());
			listaContatti.add(c);
			System.out.println("Hai altri contatti o vuoi inserire altri contatti?");
				if(s.nextLine().equalsIgnoreCase("n")) {
					finito=true;
				}
		}while (!finito);
		return listaContatti;
	}
	//CE 20200124: Metodo per caricare i contatti da CSV in un file XML
	public static void transferCSVToXML(File csvFile, File xmlFile) throws Exception {
		List<Contatto> listaContatti= loadContactListFromCSV(csvFile);
		writeInXML(listaContatti,xmlFile);
		
	}
	
	//CE 20200124: Metodo per scrivere in un file XML
	public static void writeInXML(List<Contatto> contatti,File file) throws ParserConfigurationException, TransformerException  {
		
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
		StreamResult result = new StreamResult(file);

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
		
	}
	public static List<Contatto> getContattiFromFile(File file) throws Exception {
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
//        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	System.out.println(utente.getTagName() + " " + i);
//        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
       
        	listaContatti.add(contatto);
        }
        
        return listaContatti;
	}
	
	//CE 20200124: Metodo aggiungere a un file CVS i contatti di XML
	public static void appendXMLIntoCSV(File fileXML, File fileCSV) throws Exception{
		List <Contatto> listaContatti=getContattiFromFile(fileXML);
		writeInFileCSV(listaContatti, fileCSV);	
	}
	
	public static void createCSVCopyOfXML(File fileXML) throws Exception{
		List <Contatto> listaContatti=getContattiFromFile(fileXML);
//		String [] nomeFileXML=fileXML.getAbsolutePath().split("\");
//		String nomeFileCopiaCSV="csv/"+nomeFileXML[nomeFileXML.length-1];
//		File fileCSV = new File (nomeFileCopiaCSV);
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Come vuoi chiamare il file di copia?");
		String nomeFile= "csv/"+scan.next()+".csv";
		File fileCSV = new File (nomeFile);
		while(fileCSV.exists()) {
			System.out.println("Esiste già un file con questo nome, inserisci un altro nome");
			nomeFile= "csv/"+scan.next();
			fileCSV=new File(nomeFile);
		}	
		
		writeInFileCSV(listaContatti, fileCSV);	
	}
	

	
	public static void main(String[] args) throws Exception {
		//CE 20200122: Inizio soluzione esercizio mia rubrica

		Scanner s= new Scanner(System.in);
		
		
		boolean continua=false;
		do {
			System.out.println("Menu: \n 1-scrivere un file CSV \n 2-scrivere un file XML \n 3-Conversione CSV a XML \n 4-Conversione XML a CSV \n 5- Aggiungere al CSV i contatti XML ");
			int selezione= s.nextInt();
			switch(selezione) {
			case 1: 
				{//CE 20200123: creazione contatti
					List<Contatto> listaContatti= createContacts();
					File f1=new File ("csv/miaRubrica.csv");
					//CE 20200123:  caricamento lista di contatti nel file CSV 
					writeInFileCSV(listaContatti, f1);
				}
				break;
			case 2: 
				{
					File f1=new File ("xml/miaRubrica.xml");
					List<Contatto> listaContatti= createContacts();
					writeInXML(listaContatti, f1);
				}
				break;
			case 3:
				{
						//CE 20200124: trasferimento dei dati da un file CSV a un file XML
						File f1=new File ("csv/miaRubrica.csv");
						List<Contatto> contattiNelFile= loadContactListFromCSV(f1);
						File f2=new File("xml/miaRubrica.xml");
						transferCSVToXML(f1,f2);
				}
				break;
				
			case 4:
				{
					//CE 20200124: crea copia CSV di un file XML
					File f3=new File ("xml/miaRubrica.xml");
					createCSVCopyOfXML(f3);
				}
				break;
			case 5:
				{
					//CE 20200124: aggiunta dei dati di in un XML in un file CSV
					File f1=new File ("xml/miaRubrica.xml");
					File f3=new File ("csv/miaRubrica.csv");
					appendXMLIntoCSV(f1,f3);
				}
				break;
			default: break;
			}
			
	System.out.println("Vuoi fare qualcos'altro?");
	Scanner risposta= new Scanner(System.in);
	String ris=risposta.next();
	if(ris.equalsIgnoreCase("s")) {
		continua=true;
	} else {
		continua=false;
	}
		}while(continua==true);
	
	
		System.out.println("the end");
		
	}

	


}
