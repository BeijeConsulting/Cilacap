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
		writeInXML(data, "xml\\MyCrystal.xml");
		
		
	}
	
	public static void readContent(List<String> righe, File file) throws IOException
	{
		FileReader fileReader = new FileReader(file); //ciascuna riga viene memorizzata in una stringa dell'ArrayList
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row = reader.readLine();
		while (row != null)
		{
			row = row.replace("\0", "");
			righe.add(row);
			row = reader.readLine();
		}
		
		reader.close();
	}
	
	public static void setData(List<String> righe, List<TestData> dati)
	{
		TestData dato = new TestData();
		
		dato.setIdComputer("1");
		
		for(int i=0; i<righe.size(); i++)
		{
			if(righe.get(i).contains("CrystalDiskMark"))
			{
				dato.setVersion(righe.get(i).substring(righe.get(i).indexOf("Mark")+5, righe.get(i).indexOf("(C)")));
			}
		}
		
//		dato.setOs(righe.get(44).substring(19, 38).trim());
//		dato.setType(righe.get(40).substring(19, 29).trim());
//		dato.setIterations(righe.get(40).substring(righe.get(40).indexOf('x')+2, righe.get(40).indexOf(')')).trim());
//		dato.setInterval(righe.get(40).substring(righe.get(40).indexOf('[')+22, righe.get(40).indexOf(']')-6).trim());
//		dato.setDate();
		
		dati.add(dato);
	}
	
	public static void writeInXML(List<TestData> dati, String pathfile) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument(); //creazione nuovo documento XML
        Element docElement = document.createElement("CrystalDiskMark"); //creazione elemento radice CrystalDiskMark
        document.appendChild(docElement); //appendo l'elemento radice al documento XML
        
        for (TestData c : dati) { //aggiungo i seguenti tag per ciascun tag di tipo Contatto
        	Element test = document.createElement("test");
        	
//        	test.setAttribute("date", c.getDate()); //aggiungo attributi utilizzando i metodi get
//        	test.setAttribute("interval", c.getInterval());
//        	test.setAttribute("iterations", c.getIterations());
//        	test.setAttribute("type", c.getType());
//        	test.setAttribute("os", c.getOs());
        	test.setAttribute("version", c.getVersion());
        	test.setAttribute("id_computer", c.getIdComputer());
        	
        	
        	docElement.appendChild(test); //infine appendo test all'elemento radice
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