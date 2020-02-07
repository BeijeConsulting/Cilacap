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

import org.apache.commons.logging.impl.Log4JLogger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.istack.logging.Logger;

import it.beije.cilacap.crystal.TestData;
import it.beije.cilacap.rubrica.Contatto;

public class MyCrystal
{

	public static void main(String[] args) throws Exception
	{
		TestData data = new TestData();//creazione struttura principale per i data
		List<TestRow> row = new ArrayList<TestRow>();//creazione struttura principale per i row
		File f = new File("crystal\\01\\CDM_20200102131948.txt"); //importazione file
		List<String> contenuto = new ArrayList<String>(); //struttura ArrayList di stringhe
		
		readContent(contenuto, f); //lettura e salvataggio del file .txt in ArrayList di stringhe contenuto
		setData(contenuto, data); //Metodo che utilizza i metodi di TestData e popola il bean
		setRow(contenuto, row); //Metodo che utilizza i metodi di TestRow e popola il bean
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
	
	public static void setData(List<String> contenuto, TestData dati)
	{
		dati.setIdComputer("01");
		
		for(int i=0; i<contenuto.size(); i++)
		{
			if(contenuto.get(i).contains("CrystalDiskMark"))
			{
				dati.setVersion(contenuto.get(i).substring(contenuto.get(i).indexOf("Mark")+5, contenuto.get(i).indexOf("(C)")-1));
			}
			
			if(contenuto.get(i).contains("OS"))
			{
				dati.setOs(contenuto.get(i).substring(contenuto.get(i).indexOf("OS:")+4, contenuto.get(i).indexOf("[")-1));
			}
			
			if(contenuto.get(i).contains("Test"))
			{
				dati.setType(contenuto.get(i).substring(contenuto.get(i).indexOf("Test")+6, contenuto.get(i).indexOf("GiB")+3));
			}
			
			if(contenuto.get(i).contains("Test"))
			{
				dati.setIterations(contenuto.get(i).substring(contenuto.get(i).indexOf("(x")+2, contenuto.get(i).indexOf(")")));
			}
			
			if(contenuto.get(i).contains("Test"))
			{
				dati.setInterval(contenuto.get(i).substring(contenuto.get(i).indexOf("[")+11, contenuto.get(i).indexOf("sec")-1));
			}
			
			if(contenuto.get(i).contains("Date"))
			{
				dati.setDate(contenuto.get(i).substring(contenuto.get(i).indexOf("Date")+6));
			}
		}
	}
	
	public static void setRow(List<String> contenuto, List<TestRow> row)
	{int j = -1;
		for(int i=0; i<contenuto.size(); i++)
		{
			if (contenuto.get(i).contains("Read") || contenuto.get(i).contains("Write"))
			{
				TestRow riga = new TestRow();
				if (contenuto.get(i).contains("Read")) riga.setType("Read");
				else riga.setType("Write");
				do
				{
					if(contenuto.get(i).contains("Sequential") || contenuto.get(i).contains("Random"))
					{
						String s;
						
						s = contenuto.get(i).substring(contenuto.get(i).indexOf("(Q")+4, contenuto.get(i).indexOf(","));
						s = s.replace(" ", "");
						riga.setQ(Integer.parseInt(s));
						
						s = contenuto.get(i).substring(contenuto.get(i).indexOf("T")+3, contenuto.get(i).indexOf(")"));
						s = s.replace(" ", "");
						riga.setT(Integer.parseInt(s));

						s = contenuto.get(i).substring(contenuto.get(i).indexOf(":")+4, contenuto.get(i).indexOf("MB"));
						s = s.replace(" ", "");
						riga.setMbs(Double.parseDouble(s));
						
						s = contenuto.get(i).substring(contenuto.get(i).indexOf("[")+1, contenuto.get(i).indexOf("IOPS"));
						s = s.replace(" ", "");
						riga.setIops(Double.parseDouble(s));
						
						s = contenuto.get(i).substring(contenuto.get(i).indexOf("<")+1, contenuto.get(i).indexOf("us"));
						s = s.replace(" ", "");
						System.out.println(s);
						riga.setUs(Double.parseDouble(s));
						
					}
					
					i++;
					j++;
					row.add(riga);
					
				}
				while((!contenuto.get(i).contains("Read") || !contenuto.get(i).contains("Write")) && !contenuto.get(i).contains("Profile"));
			}
		}
	}
	
	public static void writeInXML(TestData dati, String pathfile) throws Exception
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument(); //creazione nuovo documento XML
        Element docElement = document.createElement("CrystalDiskMark"); //creazione elemento radice CrystalDiskMark
        document.appendChild(docElement); //appendo l'elemento radice al documento XML
        
        Element test = document.createElement("test");
        
    	//aggiungo attributi utilizzando i metodi get
    	test.setAttribute("id_computer", dati.getIdComputer());
    	test.setAttribute("version", dati.getVersion());
    	test.setAttribute("os", dati.getOs());
    	test.setAttribute("type", dati.getType());
    	test.setAttribute("iterations", dati.getIterations());
    	test.setAttribute("interval", dati.getInterval());
    	test.setAttribute("date", dati.getDate());
    	
    	Element read = document.createElement("read");
    	
    	
    	docElement.appendChild(test); //infine appendo test all'elemento radice
    	test.appendChild(read);

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