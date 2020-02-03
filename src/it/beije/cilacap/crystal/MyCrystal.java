package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.cilacap.crystal.TestData;
import it.beije.cilacap.rubrica.Contatto;

public class MyCrystal
{

	public static void main(String[] args) throws Exception
	{
		List<TestData> data = new ArrayList<TestData>();//creazione struttura principale per i data
		List<TestRow> row = new ArrayList<TestRow>();//creazione struttura principale per i row
		File f = new File("crystal\\01\\CDM_20200102131948.txt"); //importazione file
		List<String> contenuto = new ArrayList<String>(); //struttura ArrayList di stringhe
		
		readContent(contenuto, f); //lettura e salvataggio del file .txt in ArrayList di stringhe contenuto
		setData(contenuto, data); //Metodo che utilizza i metodi di TestData e popola il bean
		writeInXML(data, "xml\\Crystal.xml");
		
		
	}
	
	public static void readContent(List<String> righe, File file) throws IOException
	{
		FileReader fileReader = new FileReader(file); //ciascuna riga viene memorizzata in una stringa dell'ArrayList
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row = reader.readLine();
		while (row != null)
		{
			righe.add(row);
			row = reader.readLine();
		}
		
		reader.close();
	}
	
	public static void setData(List<String> righe, List<TestData> dati)
	{
		TestData dato = new TestData();
		
		System.out.println();
		
		dato.setIdComputer("1");
		dato.setVersion(righe.get(2).substring(33, 51));
		dato.setOs(righe.get(44).substring(19, 38));
		dato.setType(righe.get(40).substring(19, 29));
		dato.setIterations(righe.get(40).substring(righe.get(40).indexOf('x')+2, righe.get(40).indexOf(')')));
		dato.setInterval(righe.get(40).substring(righe.get(40).indexOf('[')+22, righe.get(40).indexOf(']')-6));
		dato.setDate(righe.get(42).substring(19, 50));
		
		dati.add(dato);
	}
	
	public static void writeInXML(List<TestData> dati, String pathfile) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument(); //creazione nuovo documento XML
        Element docElement = document.createElement("CrystalDiskMark"); //creazione elemento radice rubrica
        document.appendChild(docElement); //appendo l'elemento radice al documento XML
        
        for (TestData c : dati) { //aggiungo i seguenti tag per ciascun tag di tipo Contatto
        	Element info = document.createElement("test");
        	
        	//info.setTextContent(c.getDate()); //popolo i Contatto utilizando i metodi get
        	
        	//info.appendChild(info); //appendo gli Element a contatto

        	docElement.appendChild(info); //infine appendo contatto all'elemento radice
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
