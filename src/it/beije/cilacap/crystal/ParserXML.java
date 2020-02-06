package it.beije.cilacap.crystal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParserXML {

	public static TestData getTestDataFromFileXML(String pathfile) throws Exception {
		File file = new File(pathfile);

		return getTestDataFromFileXML(file);
	}

	public static TestData getTestDataFromFileXML(File file)
			throws ParserConfigurationException, SAXException, IOException {
		TestData testData = new TestData();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load the input XML document, parse it and return an instance of the
		// Document class.
		Document document = builder.parse(file);
		Element element = document.getDocumentElement();
		System.out.println(element.getTagName());

		// System.out.println(element.getChildNodes().getLength());

		Element test = (Element) element.getElementsByTagName("test").item(0);

		testData.setDate(test.getAttribute("date"));
		testData.setIdComputer(test.getAttribute("id_computer"));
		testData.setIntervalInSeconds(Integer.parseInt(String.valueOf(test.getAttribute("interval").charAt(0))));
		testData.setIterations(Integer.parseInt(test.getAttribute("iterations")));
		testData.setOs(test.getAttribute("type"));
		testData.setType(test.getAttribute("type"));
		testData.setVersion(test.getAttribute("version"));

		TestRow testRow = null;
		List<TestRow> listaRead = new ArrayList<TestRow>();

		Element read = (Element) test.getElementsByTagName("read").item(0);
		Element write = (Element) test.getElementsByTagName("write").item(0);

//       System.out.println( read.getElementsByTagName("*").item(0));

		for (int i = 0; i < read.getElementsByTagName("*").getLength(); i++) {

			Element row = (Element) read.getElementsByTagName("*").item(i);
			System.out.println(i + " " + row);

		}
//
//		CICLO: for (int i = 0; i < read.getElementsByTagName("*").getLength(); i++) {
//			testRow = new TestRow();
//			Element row = (Element) read.getElementsByTagName("*").item(i);
//
//			if (row.getTagName().equalsIgnoreCase("Sequential_1MiB"))
//				testRow.setType("Sequential_1MiB");
//			else if (row.getTagName().equalsIgnoreCase("Random_4KiB"))
//				testRow.setType("Random_4KiB");
//			else
//				continue CICLO;
//
//			System.out.println(read.getElementsByTagName("*").item(i));
//
////    	   testRow.setQ(Integer.parseInt(row.getAttribute("q")));
////    	   testRow.setT(Integer.parseInt(row.getAttribute("t")));
//
//			Element mbs = (Element) row.getElementsByTagName("MBs").item(0);
//			testRow.setMbs(Double.parseDouble(mbs.getTextContent()));
//			System.out.println(i + " " + mbs);
////    	   System.out.println(row.getElementsByTagName("*").getLength());
//
//			Element iops = (Element) row.getElementsByTagName("IOPS").item(0);
//			System.out.println(i + " " + iops);
//			testRow.setIops(Double.parseDouble(iops.getTextContent()));
////    	   System.out.println(iops.getTextContent());
//
//			Element us = (Element) row.getElementsByTagName("us").item(0);
//			System.out.println(i + " " + us);
//			testRow.setUs(Double.parseDouble(us.getTextContent()));
//
//			listaRead.add(testRow);
//
//			System.out.println("OK");
//		}

		listaRead=getListRow(testData, write);

		testData.setRead(listaRead);

		List<TestRow> listaWrite = new ArrayList<TestRow>();

//		CICLO: for (int i = 0; i < write.getElementsByTagName("*").getLength(); i++) {
//			testRow = new TestRow();
//			Element row = (Element) write.getElementsByTagName("*").item(i);
//
//			if (row.getTagName().equalsIgnoreCase("Sequential_1MiB"))
//				testRow.setType("Sequential_1MiB");
//			else if (row.getTagName().equalsIgnoreCase("Random_4KiB"))
//				testRow.setType("Random_4KiB");
//			else
//				continue CICLO;
//
//			System.out.println(read.getElementsByTagName("*").item(i));
//
////    	   testRow.setQ(Integer.parseInt(row.getAttribute("q")));
////    	   testRow.setT(Integer.parseInt(row.getAttribute("t")));
//
//			Element mbs = (Element) row.getElementsByTagName("MBs").item(0);
//			testRow.setMbs(Double.parseDouble(mbs.getTextContent()));
//			System.out.println(i + " " + mbs);
////    	   System.out.println(row.getElementsByTagName("*").getLength());
//
//			Element iops = (Element) row.getElementsByTagName("IOPS").item(0);
//			System.out.println(i + " " + iops);
//			testRow.setIops(Double.parseDouble(iops.getTextContent()));
////    	   System.out.println(iops.getTextContent());
//
//			Element us = (Element) row.getElementsByTagName("us").item(0);
//			System.out.println(i + " " + us);
//			testRow.setUs(Double.parseDouble(us.getTextContent()));
//
//			listaWrite.add(testRow);
//
//			System.out.println("OK");
//
//		}
		listaWrite=getListRow(testData, write);

		testData.setWrite(listaWrite);

		for (int i = 0; i < listaWrite.size(); i++)
			System.out.println(listaWrite.get(i).getType() + " " + listaWrite.get(i).getMbs());

		return testData;

	}

	public static List<TestRow> getListRow(TestData testData,Element padre) {

		List<TestRow> list = new ArrayList<TestRow>();

		TestRow testRow = null;
		CICLO: for (int i = 0; i < padre.getElementsByTagName("*").getLength(); i++) {
			testRow = new TestRow();
			Element row = (Element) padre.getElementsByTagName("*").item(i);

			if (row.getTagName().equalsIgnoreCase("Sequential_1MiB"))
				testRow.setType("Sequential_1MiB");
			else if (row.getTagName().equalsIgnoreCase("Random_4KiB"))
				testRow.setType("Random_4KiB");
			else
				continue CICLO;

			System.out.println(padre.getElementsByTagName("*").item(i));

//	    	   testRow.setQ(Integer.parseInt(row.getAttribute("q")));
//	    	   testRow.setT(Integer.parseInt(row.getAttribute("t")));

			Element mbs = (Element) row.getElementsByTagName("MBs").item(0);
			testRow.setMbs(Double.parseDouble(mbs.getTextContent()));
			System.out.println(i + " " + mbs);
//	    	   System.out.println(row.getElementsByTagName("*").getLength());

			Element iops = (Element) row.getElementsByTagName("IOPS").item(0);
			System.out.println(i + " " + iops);
			testRow.setIops(Double.parseDouble(iops.getTextContent()));
//	    	   System.out.println(iops.getTextContent());

			Element us = (Element) row.getElementsByTagName("us").item(0);
			System.out.println(i + " " + us);
			testRow.setUs(Double.parseDouble(us.getTextContent()));

			list.add(testRow);

			System.out.println("OK");
		}

		return list;

	}

}

//	public static void writeContattiInFile(List<Contatto> contatti, String pathfile) throws Exception {
//
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//
//        Document document = builder.newDocument();
//        Element docElement = document.createElement("rubrica");
//        document.appendChild(docElement);
//        
//        for (Contatto c : contatti) {
//        	Element contatto = document.createElement("contatto");
//        	Element nome = document.createElement("nome");
//        	Element cognome = document.createElement("cognome");
//        	Element telefono = document.createElement("telefono");
//        	Element email = document.createElement("email");
//        	
//        	nome.setTextContent(c.getNome());
//        	cognome.setTextContent(c.getCognome());
//        	telefono.setTextContent(c.getTelefono());
//        	email.setTextContent(c.getEmail());
//        	
//        	contatto.appendChild(nome);
//        	contatto.appendChild(cognome);
//        	contatto.appendChild(telefono);
//        	contatto.appendChild(email);
//
//        	docElement.appendChild(contatto);
//        }
//
//		// write the content into xml file
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(document);
//		StreamResult result = new StreamResult(new File(pathfile));
//
//		// Output to console for testing
//		//StreamResult result = new StreamResult(System.out);
//
//		transformer.transform(source, result);
//
//		System.out.println("File saved!");
//	}
//	
//	public static void main(String[] args) throws Exception {
//		List<Contatto> contatti = getContattiFromFile("xml/rubrica.xml");
//		writeContattiInFile(contatti, "xml/rubrica-copia.xml");
//	}
//
//}
