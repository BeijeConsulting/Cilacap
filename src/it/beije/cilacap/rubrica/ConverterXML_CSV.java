package it.beije.cilacap.rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ConverterXML_CSV {

	public static List<Contatto> getContattiFromFile(String pathfile) throws Exception {
		
		File file = new File(pathfile);
		
		return getContattiFromFile(file);
	}
	
	public static List<Contatto> getContattiFromFile(File file) throws Exception {
		
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        //System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
        //System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	//System.out.println(utente.getTagName() + " " + i);
        	//System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
//        	System.out.println("\tnome = " + contatto.getNome());
//        	System.out.println("\tcognome = " + contatto.getCognome());
//        	System.out.println("\ttelefono = " + contatto.getTelefono());
//        	System.out.println("\temail = " + contatto.getEmail());
        	
        	listaContatti.add(contatto);
        }
        
        return listaContatti;
	}
	
	public static void writerFile(List<Contatto> listaContatti, String pathFile) throws IOException {
		
		File file = new File(pathFile);
		FileWriter fileWriter = new FileWriter(file);
		//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		fileWriter.write("NOME;COGNOME;TELEFONO;EMAIL;\n");
		
		for (Contatto contacts : listaContatti) {		
			fileWriter.write(contacts.getNome() + ";");
			fileWriter.write(contacts.getCognome() + ";");
			fileWriter.write(contacts.getTelefono() + ";");
			fileWriter.write(contacts.getEmail() + ";");
			fileWriter.write("\n");
		}

		fileWriter.flush();
		fileWriter.close();
		
		System.out.println("File Saved");
	}
	public static void main(String[] args) throws Exception {
		
		List<Contatto> contacts = getContattiFromFile("xml/rubrica.xml");
		writerFile(contacts,"csv/MyRubricaXMLtoCSV.csv");	}

}
