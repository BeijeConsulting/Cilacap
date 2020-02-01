package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class Utility {
	
	@SuppressWarnings("resource")
	public static String choosePath(boolean csv_xml) { // false:csvFile, true:xmlFile estensione
		System.out.println();
		System.out.println("scegli il nome del file  -- !!digita solo il nome del file!!");
		Scanner infoPath = new Scanner(System.in);
		String nameFile = infoPath.nextLine();
		if (!csv_xml) {
			return ("csv/" + nameFile + ".csv");
		} else {
			return ("xml/" + nameFile + ".xml");
		}
	}

	public static List<Contatto> caricaContattiDaCSV(String filePath) throws IOException {
		File file = new File(filePath);
		return caricaContattiDaCSV(file);
	}

	public static List<Contatto> caricaContattiDaCSV(File file) throws IOException {
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			Contatto c = new Contatto();
			String[] array = row.split(";");
			c.setNome(array[0]);
			c.setCognome(array[1]);
			c.setTelefono(array[2]);
			c.setEmail(array[3]);
			listaContatti.add(c);
		} // fine while
		reader.close();
		return listaContatti;
	}// fine metodo

	public static List<Contatto> caricaContattiDaXML(String filePath) throws Exception {
		File file = new File(filePath);
		return caricaContattiDaXML(file);
	}

	public static List<Contatto> caricaContattiDaXML(File file) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		List<Contatto> listaContatti = new ArrayList<Contatto>();
		// Load the input XML document, parse it and return an instance of the
		// Document class.
		Document document = builder.parse(file);
		Element element = document.getDocumentElement();

		// System.out.println(element.getChildNodes().getLength());
		NodeList contatti = element.getElementsByTagName("contatto");

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

	public static void esportaRubricaInCSV(String filePath, List<Contatto> listaContatti) throws Exception {
		File file = new File(filePath);
		esportaRubricaInCSV(file, listaContatti);
	}

	public static void esportaRubricaInCSV(File file, List<Contatto> listaContatti) throws Exception {
		FileWriter fileWriter = new FileWriter(file, true); // true nell'append
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		for (Contatto c : listaContatti) {
			bWriter.append(c.getNome()).append(";").append(c.getCognome()).append(";").append(c.getTelefono())
					.append(";").append(c.getEmail()).append(";").append("\n");
		}
		System.out.println("file esportato con successo ! ! !");
		bWriter.flush();
		bWriter.close();
		
	}// fine metodo
	
	public static void esportaRubricaInXML(String filePath, List<Contatto> listaContatti) throws Exception {
		File file = new File(filePath);
		esportaRubricaInXML(file, listaContatti);
	}

	public static void esportaRubricaInXML(File file, List<Contatto> listaContatti) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("rubrica");
		document.appendChild(docElement);

		for (Contatto c : listaContatti) {
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
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("file esportato con successo!");
	}

	@SuppressWarnings("resource")
	public static Contatto inserisciContatto() { // riempie Bean da dare in pasto ai metodi
		Scanner scan = new Scanner(System.in);
		String fieldContatto = "campiDiContatto";
		Contatto c = new Contatto();
		System.out.println("inserisci un contatto:");
		System.out.println("............................");
		System.out.print("digita il nome:");
		fieldContatto = scan.nextLine();
		c.setNome(fieldContatto);
		System.out.print("\ndigita il cognome:");
		fieldContatto = scan.nextLine();
		c.setCognome(fieldContatto);
		System.out.print("\ndigita il telefono:");
		fieldContatto = scan.nextLine();
		c.setTelefono(fieldContatto);
		System.out.print("\ndigita la mail:");
		fieldContatto = scan.nextLine();
		c.setEmail(fieldContatto);
		System.out.println("............................");
		return c;

	}// fine metodo

	
	
	
	
	
}
