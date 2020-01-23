package it.beije.cilacap.esercizi.FileXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import it.beije.cilacap.esercizi.FileManager.Contatto;


public class parserXML {
	
	public static void writeContattiInFile(List<contatto> contatti, String pathFile) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(pathFile);
		Element docElement = document.createElement("rubrica");
		document.appendChild(docElement);
		
		for (Contatto c : contatti) {
			Element contatto = document.createElement("contatto");
			
			Element nome = (Element)document.createElement("nome");
			Element cognome = (Element)document.createElement("cognome");
			Element telefono = (Element)document.createElement("telefono");
			Element email = (Element)document.createElement("email");
			
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
	}
	
	public static List<contatto> readContattiInFile(File pathFile){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document = builder.parse(pathFile);
		Element element = document.getDocumentElement();
		
		NodeList utenti = element.getElementsByTagName("utente");
		
		for (int i = 0; i < utenti.getLength(); i++) {
			Element utente =(Element)utenti.item(i);
			System.out.println(utente.getTagName() + " " + i);
			System.out.println("\tanni" + utente.getAttribute("anni"));
			
			Element nome = (Element)utente.getElementsByTagName("nome").item(0);
			Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
			Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
			Element email = (Element)utente.getElementsByTagName("email").item(0);
			
			Contatto contatto = new Contatto();
			
			contatto.setNome(nome.getTextContent());
			contatto.setCognome(cognome.getTextContent());
			contatto.setTelefono(telefono.getTextContent());
			contatto.setEmail(email.getTextContent());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("xml//rubricaXML.xml");
		readContattiInFile(file);
		
	}
}
	

