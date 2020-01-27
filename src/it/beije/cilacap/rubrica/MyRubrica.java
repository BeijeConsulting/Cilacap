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
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyRubrica {

	private static boolean exit;

	public static void main(String[] args) throws Exception {

		System.out.println("################### RUBRICA v0.1.0 ###################");
		File fileCSV = new File("csv/myRubricaBean.csv"); //punto al file
		File fileXML = new File("xml/test.xml"); //punto al file
		while (!exit) {
			onMainMenu(fileCSV, fileXML);
		}

	}

	public static void onMainMenu(String filePathCSV, String filePathXML) throws Exception {
		File fileCSV = new File(filePathCSV);
		File fileXML = new File(filePathXML);
		onMainMenu(fileCSV, fileXML);
	}

	@SuppressWarnings("resource")
	public static void onMainMenu(File fileCSV, File fileXML) throws Exception {
		System.out.println("-------------------------------------");
		System.out.println("1--Inserisci Contatto----------------");//inserisci Bean
		System.out.println("2--Visualizza Rubrica----------------");//printRubrica
		System.out.println("3--Caricare Contatti da CSV----------");//da CSV file prendo Bean e lo metto in rubrica
		System.out.println("4--Caricare Contatti da XML----------");//da XML file prendo Bean e lo metto in rubrica
		System.out.println("5--Esporta file in CSV---------------");//esporta Bean in csv
		System.out.println("6--Esporta file in XML---------------");//esporta Bean in XML
		System.out.println("7--Esci dall'applicazione------------");
		Scanner info = new Scanner(System.in);
		int choose = info.nextInt();
		List<Contatto> listaContatti = popolaBeanContattiFromCSV(fileCSV); //popola il bean da un CSV
		List<Contatto> listaContatti2 = listaContatti;//popola il bean da un XML
		
		
		switch (choose) {
		case 1:
			listaContatti = inserisciContatti();
			writeContattiCSV(listaContatti, fileCSV);
			writeContattiXML(listaContatti2, fileXML);
			break;
		case 2:
			printRubrica(listaContatti);
			lastChoice();
			break;
		case 3:
			exportFileCSVMenu(listaContatti);
			break;

		}

	}

	public static List<Contatto> popolaBeanContattiFromXML(File fileXML)
			throws SAXException, IOException, ParserConfigurationException {
		List<Contatto> listaContatti = new ArrayList<Contatto>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(fileXML);
		Element element = document.getDocumentElement();  //prendo il tag rubrica

		NodeList contatti = element.getElementsByTagName("contatto");  //da rubrica creo una Node list di contatti

		for (int i = 0; i < contatti.getLength(); i++) {
			Element utente = (Element) contatti.item(i); // l'elemento zero è contatto stesso
			Element nome = (Element) utente.getElementsByTagName("nome").item(0); //prendo l'elemento nome
			Element cognome = (Element) utente.getElementsByTagName("cognome").item(0); //prendo l'elemento cognome
			Element telefono = (Element) utente.getElementsByTagName("telefono").item(0); // prendo l'elemento telefono
			Element email = (Element) utente.getElementsByTagName("email").item(0); //prendo l'elemento email
			Contatto contatto = new Contatto();  //creo Bean vuoto da riempire
			contatto.setNome(nome.getTextContent()); //setto nome del contatto
			contatto.setCognome(cognome.getTextContent());// setto cognome del contatto
			contatto.setTelefono(telefono.getTextContent());
			contatto.setEmail(email.getTextContent());
			listaContatti.add(contatto);
		}

		return listaContatti;

	}

	@SuppressWarnings("resource")
	public static File decidiOutput() {
		System.out.println("digita il path in cui generare il file:");
		Scanner info = new Scanner(System.in);
		String path = info.nextLine();
		File file = new File(path);
		return file;
	}

	public static void writeContattiXML(List<Contatto> listaContatti, String filePath) throws Exception {
		File file = new File(filePath);
		writeContattiXML(listaContatti, file);
	}

	public static void writeContattiXML(List<Contatto> listaContatti, File file) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("rubrica"); // root
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
	}

	@SuppressWarnings("resource")
	public static void exportFileCSVMenu(List<Contatto> listaContatti) throws Exception {
		System.out.println();
		System.out.println("inserisci il path di destionazione:");
		Scanner info = new Scanner(System.in);
		String path = info.nextLine();
		exportFileCSV(path, listaContatti);
		
	}

	public static void exportFileCSV(String filePathDestination, List<Contatto> listaContatti) throws Exception {
		File file = new File(filePathDestination);
		exportFileCSV(file, listaContatti);
	}

	public static void exportFileCSV(File file, List<Contatto> listaContatti) throws Exception {
		writeContattiCSV(listaContatti, file);
	}

	@SuppressWarnings("resource")
	public static void lastChoice() {
		System.out.println("vuoi tornare al menu principale? s/n");
		Scanner info = new Scanner(System.in);
		String choose = info.next();
		if (choose.equalsIgnoreCase("n")) {
			exit = true;
		}
	}

	@SuppressWarnings("resource")
	public static List<Contatto> inserisciContatti() {
		boolean exitFromLoop = false;
		List<Contatto> contatti = new ArrayList<Contatto>();
		while (!exitFromLoop) {
			Contatto c = new Contatto();
			Scanner info = new Scanner(System.in);
			System.out.println("inserisci un contatto:");
			System.out.print("digita il nome:");
			String iesimoContatto = info.nextLine();
			c.setNome(iesimoContatto);
			System.out.print("\ndigita il cognome:");
			iesimoContatto = info.nextLine();
			c.setCognome(iesimoContatto);
			System.out.print("\ndigita il telefono:");
			iesimoContatto = info.nextLine();
			c.setTelefono(iesimoContatto);
			System.out.print("\ndigita la mail:");
			iesimoContatto = info.nextLine();
			c.setEmail(iesimoContatto);
			contatti.add(c);
			String choose = "decisioneMenuUscita";
			System.out.println("vuoi inserire altri contatti ? s/n");
			choose = info.next();
			if (choose.equalsIgnoreCase("n")) {
				exitFromLoop = true;
			}

		}

		return contatti; // dopo while

	}

	public static int readContatti(String filePath) throws IOException {
		File file = new File(filePath);
		return readContatti(file);
	}

	public static int readContatti(File file) throws IOException {
		Scanner info = new Scanner(System.in);
		System.out.println("vuoi visualizzare la lista contatti ? s/n");
		String choose = info.next();
		if (choose.equalsIgnoreCase("n")) {
			info.close();
			return -1;
		}
		popolaBeanContattiFromCSV(file);
		info.close();
		return 1;
	}

	public static void writeContattiCSV(List<Contatto> listaContatti, String filePath) throws IOException {
		File file = new File(filePath);
		writeContattiCSV(listaContatti, file);
	}

	public static void writeContattiCSV(List<Contatto> listaContatti, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file, true); // true nell'append
		BufferedWriter bWriter = new BufferedWriter(fileWriter);
		for (Contatto c : listaContatti) {
			bWriter.append(c.getNome()).append(";").append(c.getCognome()).append(";").append(c.getTelefono())
					.append(";").append(c.getEmail()).append(";").append("\n");
		}
		bWriter.flush();
		bWriter.close();
	}

	public static List<Contatto> popolaBeanContattiFromCSV(String filePath) throws IOException {
		File file = new File(filePath);
		return popolaBeanContattiFromCSV(file);
	}

	/*
	 * prelevo dal file CSV tutti i contatti
	 */
	public static List<Contatto> popolaBeanContattiFromCSV(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		List<Contatto> listaContatti = new ArrayList<Contatto>();
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

	}

	public static void printRubrica(List<Contatto> listaContatti) throws IOException {
		if (listaContatti.size() > 0) {
			for (int i = 0; i < listaContatti.size(); i++) {
				System.out.println("contatto numero " + (i + 1));
				System.out.println("nome: " + listaContatti.get(i).getNome());
				System.out.println("cognome: " + listaContatti.get(i).getCognome());
				System.out.println("telefono: " + listaContatti.get(i).getTelefono());
				System.out.println("email: " + listaContatti.get(i).getEmail());
				System.out.println("\n");
			}
		}

	}// fine metodo

}
