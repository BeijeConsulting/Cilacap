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

import rubrica.Contatto;

public class Crystal {

	public static void main(String[] args) throws IOException
	{
		metodo();
		
	}
	public static List<String> metodo() throws IOException
	{
		TestData data = new TestData();
		
		
		File f = new File("C:\\Users\\Padawan06\\git\\Cilacap\\crystal\\06\\CDM_20200102151422.txt");
		List<String> listaStringa = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		listaStringa.addAll(readFileRows(f));
		for(int i=0;i<listaStringa.size();i++)
		{
			for(int j=0;j<listaStringa.get(i).length();j++)
			{
				if(listaStringa.get(i).charAt(j) < 32 )
				{
					builder.append(listaStringa.get(i));
					builder.replace(listaStringa.get(i).charAt(j), listaStringa.get(i).charAt(j), "");
				}
			}
		}
		//s=readFileContent(f);
		//System.out.println(listaStringa.get(10));
	    //data.setDate(listaStringa.get(42).substring(listaStringa.get(42).substring(listaStringa.get(42).indexOf("Date:")+2)));
		System.out.println(listaStringa.size());
		data.setDate(listaStringa.get(21).trim().substring(10));
		
		data.setIntervalInSeconds((int)(listaStringa.get(20).charAt(listaStringa.get(20).indexOf("[")+9)));
		System.out.println(listaStringa.get(20).charAt(listaStringa.get(20).indexOf("[")+12));
		System.out.println(data.getDate());
		System.out.println(data.getIntervalInSeconds());
		
		return listaStringa;
	}
	
	

	public static void writeContattiInFile(List<TestData> dati, String pathfile) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document document = builder.newDocument();
        Element docElement = document.createElement("CrystalDiskMark");
        document.appendChild(docElement);
        
        for (TestData d : dati) {
        	Element testDate = document.createElement("testdata");
        	testDate.setAttribute("test date", metodo().get(metodo().indexOf("Date")));
        	Element nome = document.createElement("nome");
        	Element cognome = document.createElement("cognome");
        	Element telefono = document.createElement("telefono");
        	Element email = document.createElement("email");
        	
        	nome.setTextContent(d.getNome());
        	cognome.setTextContent(d.getCognome());
        	telefono.setTextContent(d.getTelefono());
        	email.setTextContent(d.getEmail());
        	
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
		StreamResult result = new StreamResult(new File(pathfile));

		// Output to console for testing
		//StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}
	
//	public static void main(String[] args) throws Exception {
//		List<Contatto> contatti = getContattiFromFile("xml/rubrica.xml");
//		writeContattiInFile(contatti, "xml/rubrica-copia.xml");
//	}






	public static String readFileContent(File file) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		FileReader fileReader = new FileReader(file);
	
		int c;
		while ((c = fileReader.read()) > -1) {
			//System.out.print((char)c);
			builder.append((char)c);
		}
		
		fileReader.close();
		
		//IM 20200122 : approccio alternativo, utilizzo il metodo readFileRows e unisco nuovamente le righe
	//	List<String> rows = readFileRows(file);
	//	for (int r = 0; r < rows.size(); r++) {
	//		builder.append(rows.get(r));
	//		if (r < rows.size()-1) builder.append('\n');
	//	}
		
		return builder.toString();
	}
	
	public static List<String> readFileRows(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileRows(file);
	}
	
	public static String trim(String s)
	{
		char c=(char)0;
		s=s.replace(c, ' ');
		return s;
		
	}
	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
		
				rows.add(row);
		}
		
		System.out.println("rows size : " + rows.size());
		return rows;
	}
}