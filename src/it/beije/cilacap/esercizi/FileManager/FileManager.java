package it.beije.cilacap.esercizi.FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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





public class FileManager {
	public ArrayList<Contatto> getContattiFromFile(String pathfile) throws Exception {
		File file = new File(pathfile);
		
		return getContattiFromFile(file);
	}

	public ArrayList<Contatto> getContattiFromFile(File file) throws Exception {
		ArrayList<Contatto> listaContatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the input XML document, parse it and return an instance of the
        // Document class.
        Document document = builder.parse(file);
        Element element = document.getDocumentElement();       
        System.out.println(element.getTagName());
        
        //System.out.println(element.getChildNodes().getLength());
        NodeList contatti = element.getElementsByTagName("contatto");
        System.out.println("contatti : " + contatti.getLength());

        for (int i = 0; i < contatti.getLength(); i++) {
        	Element utente = (Element)contatti.item(i);
        	System.out.println(utente.getTagName() + " " + i);
        	System.out.println("\tanni = " + utente.getAttribute("anni"));
 
        	Element nome = (Element)utente.getElementsByTagName("nome").item(0);
        	Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
        	Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
        	Element email = (Element)utente.getElementsByTagName("email").item(0);
        	
        	Contatto contatto = new Contatto();
        	contatto.setNome(nome.getTextContent());
        	contatto.setCognome(cognome.getTextContent());
        	contatto.setTelefono(telefono.getTextContent());
        	contatto.setEmail(email.getTextContent());
        	
        	System.out.println("\tnome = " + contatto.getNome());
        	System.out.println("\tcognome = " + contatto.getCognome());
        	System.out.println("\ttelefono = " + contatto.getTelefono());
        	System.out.println("\temail = " + contatto.getEmail());
        	
        	listaContatti.add(contatto);
        }
        
        return listaContatti;
	}
	
	Scanner scn = new Scanner(System.in);
 
	public ArrayList<Contatto> readRubricaCSV(String pathFile) throws Exception  {
		File f = new File(pathFile);
		
		ArrayList<Contatto> contatti = new ArrayList<>();
		String[] arrayElementi = null;
		
		try {
			FileReader fileReader = new FileReader(f);		
			BufferedReader reader = new BufferedReader(fileReader);
			
			String row;
			int indexWhile = 0;
			
			while ((row = reader.readLine()) != null) {
				arrayElementi = row.split(";");
				
				contatti.add(new Contatto());
				contatti.get(indexWhile).setNome(arrayElementi[0]);
				contatti.get(indexWhile).setCognome(arrayElementi[1]);
				contatti.get(indexWhile).setTelefono(arrayElementi[2]);
				contatti.get(indexWhile).setEmail(arrayElementi[3]);
				
				indexWhile++;
			}
		
			
		} catch(Exception exception) {
			throw exception;
		}
		return contatti;
	}
	
	public ArrayList<Contatto> readRubricaXML(String pathFile){
		ArrayList<Contatto> contatti = new ArrayList<>();
		
		return contatti;
	}
	
	public void writeRubrica(ArrayList<Contatto> contatti, String pathFile) throws IOException {
		
		String[] contattiCsv = writeRubricaCSV(contatti);
		
		
		FileWriter fileWriter = new FileWriter(pathFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		for (String row : contattiCsv) {
			bufferedWriter.append(row).append('\n');
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	
	public String[] writeRubricaCSV(ArrayList<Contatto> contatti) throws IOException {
		String [] contattiCsv = new String[contatti.size()];
		
		for (int i = 0; i < contattiCsv.length; i++) {
			contattiCsv[i]= "";
			contattiCsv[i] += contatti.get(i).getNome() + ";";
			contattiCsv[i] += contatti.get(i).getCognome() + ";";
			contattiCsv[i] += contatti.get(i).getTelefono() + ";";
			contattiCsv[i] += contatti.get(i).getEmail() + ";";
		}
		
		return contattiCsv;
	}	
	
	public void writeRubricaXML(ArrayList<Contatto> contatti, String pathFile) throws Exception {
		try {
			
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
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(pathFile));

			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			System.out.println("CONTATTI SALVATI .XML CON SUCCESSO");
			
		}catch (Exception exception) {
			throw exception;
		}
		
	}
	
	public void printRubrica(ArrayList <Contatto> contatti) {
		if (contatti.size() != 0) {
			for (int i = 0; i < contatti.size(); i++) {
				System.out.println("Contatto n°" + (i+1));
				System.out.println("Nome: " + contatti.get(i).getNome());
				System.out.println("Cognome: " + contatti.get(i).getCognome());
				System.out.println("Telefono: " + contatti.get(i).getTelefono());
				System.out.println("Email: " + contatti.get(i).getEmail());
				System.out.println("\n");
			}
		}else {
			System.out.println("Nessun contatto registrato...");
		}
	}
	
	public ArrayList <Contatto> addContatti(ArrayList <Contatto> contatti) {
		boolean finish= false;
		String finishString = "";
	
		while (!finish) {
			contatti.add(new Contatto());
			System.out.println("Inserire nome...\n");
			contatti.get(contatti.size()-1).setNome(scn.nextLine());
			System.out.println("Inserire cognome...\n");
			contatti.get(contatti.size()-1).setCognome(scn.nextLine());
			System.out.println("Inserire telefono...\n");
			contatti.get(contatti.size()-1).setTelefono(scn.nextLine());
			System.out.println("Inserire email...\n");
			contatti.get(contatti.size()-1).setEmail(scn.nextLine());
			
			System.out.println("Vuoi inserire un altro numero?\ts/n\n");
			finishString = scn.nextLine();
			
			if (finishString.contentEquals("n")) {
				finish = true;
			}
			
		}
		System.out.println("CONTATTI SALVATI .CSV CON SUCCESSO");
		return contatti;
	}
	
		
}

