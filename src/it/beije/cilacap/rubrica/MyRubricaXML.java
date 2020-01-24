package it.beije.cilacap.rubrica;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MyRubricaXML
{

	public static void main(String[] args)
	{
		File f = new File("xml\\MyRubricaXML.xml");//riferimento al pathfile
		//creazione struttura principale
		
		
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

}
