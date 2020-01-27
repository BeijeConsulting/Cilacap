package it.beije.cilacap.rubrica.oldExercises;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.cilacap.rubrica.Contatto;

public class MainTest {

	public static void main(String[] args) throws Exception{

		File file = new File("xml/test.xml");
		List<Contatto> contatti;
		contatti = popolaBeanContattiFromXML(file);
		System.out.println(contatti.get(0).toString());
		System.out.println(contatti.get(1).toString());
	}

	public static List<Contatto> popolaBeanContattiFromXML(File fileXML)
			throws SAXException, IOException, ParserConfigurationException {
		List<Contatto> listaContatti = new ArrayList<Contatto>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load the input XML document, parse it and return an instance of the
		// Document class.
		Document document = builder.parse(fileXML);
		Element element = document.getDocumentElement();
//		System.out.println(element.getTagName());

		// System.out.println(element.getChildNodes().getLength());
		NodeList contatti = element.getElementsByTagName("contatto");
		// System.out.println("contatti : " + contatti.getLength());

		for (int i = 0; i < contatti.getLength(); i++) {
			
			Element utente = (Element) contatti.item(i);
			Element nome = (Element) utente.getElementsByTagName("nome").item(0);
			Element cognome = (Element) utente.getElementsByTagName("cognome").item(0);
			Element telefono = (Element) utente.getElementsByTagName("telefono").item(0);
			Element email = (Element) utente.getElementsByTagName("email").item(0);
			Contatto contatto = new Contatto();
			contatto.setNome(nome.getTextContent());
			contatto.setCognome(cognome.getTextContent());
			contatto.setTelefono(telefono.getTextContent());
			contatto.setEmail(email.getTextContent());
			listaContatti.add(contatto);
		}

		return listaContatti;

	}

}
