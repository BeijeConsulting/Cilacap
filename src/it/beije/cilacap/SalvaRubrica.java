package it.beije.cilacap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import it.beije.cilacap.rubrica.Contatto;
import it.beije.cilacap.rubrica.ParserXML;

//da scanner caricare Lista contatti e poi salvare nel file CSV
//caricare Lista contatti da Rubrica.CSV
//scrivere Lista contatti in file CSV
//programma trasferimento rubrica.csv in xml
//programma trasferimento rubrica.xml in csv

public class SalvaRubrica {

	static ArrayList<Contatto> contatti = new ArrayList<Contatto>();

	public static void readContatti() {
		String verifica = "-1";
		Scanner sc = new Scanner(System.in);
		System.out.println("inserisci contatti nella Lista");
		System.out.println();

		while (!verifica.equalsIgnoreCase("N")) {
			Contatto contatto = new Contatto();
			String nome = new String();
			String cognome = new String();
			String telefono = new String();
			String email = new String();

			while (nome.equals("")) {
				System.out.println("inserisci nome");
				nome = sc.nextLine();
				contatto.setNome(nome);
			}
			while (cognome.equals("")) {
				System.out.println("inserisci cognome");
				cognome = sc.nextLine();
				contatto.setCognome(cognome);
			}
			while (telefono.equals("")) {
				System.out.println("inserisci telefono");
				telefono = sc.nextLine();
				contatto.setTelefono(telefono);
			}
			while (email.equals("")) {
				System.out.println("inserisci email");
				email = sc.nextLine();
				contatto.setEmail(email);
			}
			contatti.add(contatto);
			System.out.println("aggiungere contatti, S/N");
			verifica = sc.nextLine();
		}
	}

	public static void writeFileContent(List<Contatto> contatti, File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.append("NOME;").append("COGNOME;").append("TELEFONO;").append("EMAIL;").append('\n');
		for (Contatto row : contatti) {
			bufferedWriter.append(row.getNome() + ";");
			bufferedWriter.append(row.getCognome() + ";");
			bufferedWriter.append(row.getTelefono() + ";");
			bufferedWriter.append(row.getEmail() + ";").append('\n');
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}

	public static List<String> readFileRows(File file) throws IOException {

		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		StringBuilder builder = new StringBuilder();
		String row;
		List<String> rows = new ArrayList<String>();

		while ((row = reader.readLine()) != null) {
			builder.append(row).append('\n');
		}
		rows.add(builder.toString());
		return rows;
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

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathfile));

		transformer.transform(source, result);

		System.out.println("File saved!");
	}
	
	static public void createCsvDaXml() throws Exception {
		ParserXML xml =  new ParserXML();
		List<Contatto> contat = new ArrayList<Contatto>();
		contat= xml.getContattiFromFile("xml/rubrica-copia.xml");
		writeFileContent(contat, new File("csv/rubrica.csv111"));
		
		
	}

	public static void main(String[] args) throws Exception {
		readContatti();
		writeFileContent(contatti, new File("csv/rubrica.csv"));
		System.out.println(readFileRows(new File("csv/rubrica.csv")));
		writeContattiInFile(contatti, "xml/rubrica-copia.xml");
		createCsvDaXml();
		
	}
}
