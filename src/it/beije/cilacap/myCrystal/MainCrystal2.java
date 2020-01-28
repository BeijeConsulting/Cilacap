package it.beije.cilacap.myCrystal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MainCrystal2 {

	public static void updateXmlWithNewFile(String xmlPath) throws IOException, ParserConfigurationException, TransformerException, SAXException {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlPath);
		Element root = document.getDocumentElement();

		File f = new File(xmlPath);
		List<TestData> newTestData = getOnlyNewTestData(f.getParent(), getOldFiles(xmlPath));

		for (TestData test : newTestData) {
			// server elements
			Element newTest = document.createElement("test");
			newTest.setAttribute("version", test.getVersion());
			newTest.setAttribute("os", test.getOs());
			newTest.setAttribute("type", test.getType());
			newTest.setAttribute("iterations", ""+test.getIterations());
			newTest.setAttribute("interval", ""+test.getInterval());
			newTest.setAttribute("date", test.getDate());
			newTest.setAttribute("id_computer", test.getIdComputer());

			// read
			Element read = document.createElement("read");
			newTest.appendChild(read);

			for(TestRow row : test.getRead()) {
				Element readRows = document.createElement(row.getType());
				readRows.setAttribute("q", ""+row.getQ());
				readRows.setAttribute("t", ""+row.getT());

				Element mbs = document.createElement("MBs");
				mbs.setTextContent(Double.toString(row.getMbs()));
				readRows.appendChild(mbs);

				Element iops = document.createElement("IOPS");
				iops.setTextContent(Double.toString(row.getIops()));
				readRows.appendChild(iops);

				Element us = document.createElement("us");
				us.setTextContent(Double.toString(row.getUs()));
				readRows.appendChild(us);

				read.appendChild(readRows);
			}

			// write
			Element write = document.createElement("write");
			newTest.appendChild(write);

			for(TestRow row : test.getWrite()) {
				Element writeRows = document.createElement(row.getType());
				writeRows.setAttribute("q", ""+row.getQ());
				writeRows.setAttribute("t", ""+row.getT());

				Element mbs = document.createElement("MBs");
				mbs.setTextContent(Double.toString(row.getMbs()));
				writeRows.appendChild(mbs);

				Element iops = document.createElement("IOPS");
				iops.setTextContent(Double.toString(row.getIops()));
				writeRows.appendChild(iops);

				Element us = document.createElement("us");
				us.setTextContent(Double.toString(row.getUs()));
				writeRows.appendChild(us);

				write.appendChild(writeRows);
			}

			root.appendChild(newTest);
			
		}
		

		System.out.println("Old: " + newTestData.size());

		DOMSource source = new DOMSource(document);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		StreamResult result = new StreamResult(xmlPath);
		transformer.transform(source, result);
	}


	private static List<TestData> getOnlyNewTestData(String rootPath, List<String> oldFiles) throws IOException, ParserConfigurationException, TransformerException {
		File folder = new File(rootPath);

		List<TestData> testData = new ArrayList<TestData>();

		for(File f : folder.listFiles()) {

			if(f.isDirectory()) {

				String newPath = rootPath + "\\" + f.getName();
				System.out.println(newPath);

				File ff = new File(newPath);

				for(File file : ff.listFiles()) {
					if(!file.isDirectory() && file.getName().contains(".txt") && !oldFiles.contains(file.getName().replace("CDM_", "").replace(".txt", ""))) {
						testData.add(MainCristal.addContentToList(MainCristal.fileContent(file.getPath()), f.getName().toString()));
					}
				}
			}
		}
		return testData;
	}

	public static List<String> getOldFiles(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
		List<String> oldFileName = new ArrayList<String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse(xmlPath);
		Element element = document.getDocumentElement();       

		NodeList tests = element.getElementsByTagName("test");

		for (int i = 0; i < tests.getLength(); i++) {
			Element test = (Element) tests.item(i);
			oldFileName.add(test.getAttribute("date").replace("/", "").replace(" ", "").replace(":", ""));
		}
		System.out.println(oldFileName);
		return oldFileName;
	}
	

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException {
		updateXmlWithNewFile("crystal/allTests.xml");
		System.out.println("Update completato con successo!!!");
	}
}
