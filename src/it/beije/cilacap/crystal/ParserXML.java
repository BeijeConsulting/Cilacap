package it.beije.cilacap.crystal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


public class ParserXML {

	public static TestData getTestDataFromFile(String pathfile) throws Exception {
		File file = new File(pathfile);
		
		return getTestDataFromFile(file);
	}

	public static TestData getTestDataFromFile(File file) throws ParserConfigurationException, SAXException, IOException {
		TestData testData=new TestData();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
       Element test = (Element) element.getElementsByTagName("test").item(0);
       testData.setDate(test.getAttribute("date"));
       testData.setIdComputer(test.getAttribute("id_computer"));
       testData.setIntervalInSeconds(Integer.parseInt(test.getAttribute("interval")));
       testData.setIterations(Integer.parseInt(test.getAttribute("iterations")));
       testData.setOs(test.getAttribute("type"));
       testData.setType(test.getAttribute("type"));
       testData.setVersion(test.getAttribute("version"));
       
       


	}
}
	
//	public static void writeContattiInFile(List<Contatto> contatti, String pathfile) throws Exception {
//
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        Document document = builder.newDocument();
//        Element docElement = document.createElement("rubrica");
//        document.appendChild(docElement);
//        
//        for (Contatto c : contatti) {
//        	Element contatto = document.createElement("contatto");
//        	Element nome = document.createElement("nome");
//        	Element cognome = document.createElement("cognome");
//        	Element telefono = document.createElement("telefono");
//        	Element email = document.createElement("email");
//        	
//        	nome.setTextContent(c.getNome());
//        	cognome.setTextContent(c.getCognome());
//        	telefono.setTextContent(c.getTelefono());
//        	email.setTextContent(c.getEmail());
//        	
//        	contatto.appendChild(nome);
//        	contatto.appendChild(cognome);
//        	contatto.appendChild(telefono);
//        	contatto.appendChild(email);
//
//        	docElement.appendChild(contatto);
//        }
//
//		// write the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(document);
//		StreamResult result = new StreamResult(new File(pathfile));
//
//		// Output to console for testing
//		//StreamResult result = new StreamResult(System.out);
//
//		transformer.transform(source, result);
//
//		System.out.println("File saved!");
//	}
//	
//	public static void main(String[] args) throws Exception {
//		List<Contatto> contatti = getContattiFromFile("xml/rubrica.xml");
//		writeContattiInFile(contatti, "xml/rubrica-copia.xml");
//	}
//
//}
