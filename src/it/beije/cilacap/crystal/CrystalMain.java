package it.beije.cilacap.crystal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class CrystalMain {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserisci il percorso");
		String path = "C:\\Users\\Padawan09\\git\\Cilacap\\crystal";
		ArrayList<File> files = gestisciDirectory(path);
		for(File file : files) {
			try {
				TestData test = new TestData(file);
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document document = builder.newDocument();
		        document.appendChild(test.toXML(document));
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(test.getPathFile());
				transformer.transform(source, result);
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Errore nel file");
			} catch (ParserConfigurationException | TransformerException e) {
				e.printStackTrace();
				System.out.println("Impossibile creare file XML");
			} 
		}
		System.out.println("File convertito correttamente");
        scan.close();
	}
	
	private static ArrayList<File> gestisciDirectory(String directory) {
		ArrayList<File> files = new ArrayList<>();
		File f = new File(directory);
		if(f.isFile()) files.add(f);
		else if(f.isDirectory()) 
			for(String s : f.list()) {
				files.addAll(gestisciDirectory(directory+"\\"+s));
			}
		return files;
	}

}
