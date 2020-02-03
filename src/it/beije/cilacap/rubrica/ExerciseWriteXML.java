package it.beije.cilacap.rubrica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ExerciseWriteXML {
	
	
	
	public static void inputContacts(ArrayList<Contatto>Contacts) throws Exception {
		
		
		Contatto data = new Contatto();
        Scanner input = new Scanner(System.in);
        
        
		System.out.println("Enter name");
		data.setNome(input.nextLine());
					
		System.out.println("Enter surname");
		data.setCognome(input.nextLine());
					
		System.out.println("Enter telephone");
		data.setTelefono(input.nextLine());
				
		System.out.println("Enter email");
		data.setEmail(input.nextLine());
		
		Contacts.add(data);
		
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
		String answer;
		
		do {
		
			inputContacts(listContacts);
		
			writeContattiInFile(listContacts, "xml\\MyRubricaXML.xml");
			
			Scanner newInput = new Scanner(System.in);
			System.out.println("Would you like to register a new contact? (Y/N)");
			answer = newInput.nextLine();
		
		} while (answer.equalsIgnoreCase("Y"));
		
		System.out.println("File saved!");
	}

}
