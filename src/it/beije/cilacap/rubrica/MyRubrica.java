package it.beije.cilacap.rubrica;

import java.io.*;
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

public class MyRubrica {

	private static boolean exit = false;
	private static List<Contatto> listaContatti = new ArrayList<Contatto>();

	public static void main(String[] args) throws Exception {

		while (!exit) {
			onMainMenu(listaContatti);
		}
		System.out.println("BYE");
	}

	@SuppressWarnings("resource")
	public static void onMainMenu(List<Contatto> listaContatti) throws Exception {
		System.out.println();
		System.out.println(".....................................");
		System.out.println("1--Inserisci Contatto----------------");// inserisci Bean
		System.out.println("2--Visualizza Rubrica----------------");// printRubrica
		System.out.println("3--Caricare Contatti da CSV----------");// da CSV file prendo Bean e lo metto in rubrica
		System.out.println("4--Caricare Contatti da XML----------");// da XML file prendo Bean e lo metto in rubrica
		System.out.println("5--Esporta file in CSV---------------");// esporta Bean in csv
		System.out.println("6--Esporta file in XML---------------");// esporta Bean in XML
		System.out.println("7--Esci dall'applicazione------------");// exit = true;
		System.out.println(".....................................");
		System.out.println();

		Scanner info = new Scanner(System.in);
		int choose = info.nextInt();
		switch (choose) {
		case 1:
			inserisciContatto(listaContatti);
			break;
		case 2:
			visualizzaRubrica();
			break;
		case 3:
			caricaContattiDaCSV(choosePath(false)); // false = csv, true = xml
			break;
		case 4:
			caricaContattiDaXML(choosePath(true)); // true = xml
			break;
		case 5:
			esportaRubricaInCSV(choosePath(false)); // false = csv, true = xml
			break;
		case 6:
			esportaRubricaInXML(choosePath(true));
			break;
		case 7:
			exit = true;
		}

	}

	public static void inserisciContatto(List<Contatto> listaContatti) {
		boolean exitFromLoop = false;
		Scanner scan = null;
		String fieldContatto = "campiDiContatto";
		while (!exitFromLoop) {
			scan = new Scanner(System.in);
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
			listaContatti.add(c);
			fieldContatto = "";
			String choose = "decisioneMenuUscita";
			while (true) {
				System.out.println("vuoi inserire altri contatti ? s/n");
				choose = scan.next();
				if (choose.equalsIgnoreCase("n")) {
					exitFromLoop = true;
					break;
				} else if (choose.equalsIgnoreCase("s")) { // esco dal while
					break;
				} else {
					System.out.println("immetti un valore valido (s/n)");
				}
			}
		} // fine while
		System.out.println("vuoi tornare al menù principale? s/n");
		fieldContatto = scan.nextLine();
		if (fieldContatto.equalsIgnoreCase("n")) {
			exit = true;
		}

	}// fine metodo

	private static void visualizzaRubrica() {
		if (listaContatti.size() > 0) {
			for (int i = 0; i < listaContatti.size(); i++) {
				if (i == 0)
					System.out.println("..........................................");
				System.out.println("contatto numero " + (i + 1));
				System.out.println("nome: " + listaContatti.get(i).getNome());
				System.out.println("cognome: " + listaContatti.get(i).getCognome());
				System.out.println("telefono: " + listaContatti.get(i).getTelefono());
				System.out.println("email: " + listaContatti.get(i).getEmail());
				System.out.println("..........................................");
				System.out.println();
			} // fine for
		} // fine if
	}// fine metodo

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

	private static void caricaContattiDaCSV(String filePath) throws IOException {
		File file = new File(filePath);
		caricaContattiDaCSV(file);
	}

	private static void caricaContattiDaCSV(File file) throws IOException {
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
	}// fine metodo

	private static void caricaContattiDaXML(String filePath) throws Exception {
		File file = new File(filePath);
		caricaContattiDaXML(file);
	}

	private static void caricaContattiDaXML(File file) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

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

	}

	public static void esportaRubricaInCSV(String filePath) throws Exception {
		File file = new File(filePath);
		esportaRubricaInCSV(file);
	}

	public static void esportaRubricaInCSV(File file) throws Exception {
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

	private static void esportaRubricaInXML(String filePath) throws Exception {
		File file = new File(filePath);
		esportaRubricaInXML(file);
	}

	private static void esportaRubricaInXML(File file) throws Exception {

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
}
