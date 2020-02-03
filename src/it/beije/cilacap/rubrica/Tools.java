package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Tools {
	
	
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
	
	public static List<Contatto> getContattiFromFile(String pathfile) throws Exception {
		File file = new File(pathfile);
		
		return getContattiFromFile(file);
	}

	public static List<Contatto> getContattiFromFile(File file) throws ParserConfigurationException, SAXException, IOException {
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
        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	System.out.println(utente.getTagName() + " " + i);
        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
        	System.out.println("\tnome = " + contatto.getNome());
        	System.out.println("\tcognome = " + contatto.getCognome());
        	System.out.println("\ttelefono = " + contatto.getTelefono());
        	System.out.println("\temail = " + contatto.getEmail());
        	
        	listaContatti.add(contatto);
        }
        
        return listaContatti;
	}

	
}
