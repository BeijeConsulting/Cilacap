package it.beije.cilacap.myCrystal;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.cilacap.esercizi.myRubrica.Contatto;

public class CrystalDBUtil {
	
	public static int readFileCrystalWriteDb(String path) throws IOException, ParserConfigurationException, TransformerException, ClassNotFoundException, SQLException {
		List<TestData> listTestData = putFileContentIntoArrayList(path);
		
		// scrivo in db
		for(TestData testData : listTestData) {
			
			// verifico se non è già presente
			if(CrystalDBtools.checkInDB(testData)) {
				CrystalDBtools.insertTestData(testData);
			}
		}
		
		return listTestData.size();
		
	}
	
	
	private static List<TestData> putFileContentIntoArrayList(String path) throws IOException, ParserConfigurationException, TransformerException {
		List<TestData> listaTestData = new ArrayList<TestData>();
		
		listaTestData = MainCristal.getAllFiles(path);
		
		return listaTestData;
	}
	
	// da XML a DB
	public static void fromXmlToDB(String xmlPath) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException {
		List<TestData> lista = caricaArrayListDiTestDataFromXML(xmlPath);
		System.out.println(lista.size());
		for(TestData testData : lista) {
			CrystalDBtools.insertTestData(testData);
		}
	}

	// da DB a XML
	public static void fromDbToXml(String xmlPath, String path) throws ParserConfigurationException, TransformerException, IOException, ClassNotFoundException, SQLException {
		List<TestData> list = CrystalDBtools.readCrystalFromDB();
		MainCristal.writeXmlFromTestDataList(xmlPath, list);
	}
	
	
	public static List<TestData> caricaArrayListDiTestDataFromXML(String pathXML) throws ParserConfigurationException, SAXException, IOException {

		List<TestData> listaTestData = new ArrayList<TestData>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		File fileXML = new File(pathXML);

		if(fileXML.length() != 0) {

			Document document = builder.parse(fileXML);
			Element element = document.getDocumentElement();

			NodeList crystal = element.getElementsByTagName("test");
			
			System.out.println(crystal.getLength());

			for (int i = 0; i < crystal.getLength(); i++) {
				Element test = (Element)crystal.item(i);
				
				TestData testData = new TestData();
				
				testData.setVersion(test.getAttribute("version"));
				testData.setDate(test.getAttribute("date"));
				testData.setIdComputer(test.getAttribute("id_computer"));
				testData.setIntervalInSeconds(Integer.parseInt(test.getAttribute("interval")));
				testData.setIterations(Integer.parseInt(test.getAttribute("iterations")));
				testData.setOs(test.getAttribute("os"));
				testData.setType(test.getAttribute("type"));
				
				NodeList read = test.getElementsByTagName("read");
				Element readEl = (Element)read.item(0);
				
				// Read
				NodeList seqRead = readEl.getElementsByTagName("Sequential_1Mib");
				List<TestRow> listTestRowRead = new ArrayList<TestRow>();
				for(int r = 0; r < seqRead.getLength(); r++) {
					Element seq = (Element)seqRead.item(i);
					TestRow testRow = new TestRow();
					testRow.setQ(Integer.parseInt(seq.getAttribute("q")));
					testRow.setT(Integer.parseInt(seq.getAttribute("t")));
					
					testRow.setMbs(Double.parseDouble(((Element)seq.getElementsByTagName("MBs").item(0)).getTextContent()));
					testRow.setIops(((Double.parseDouble(((Element)seq.getElementsByTagName("IOPS").item(0)).getTextContent()))));
					testRow.setUs(Double.parseDouble(((Element)seq.getElementsByTagName("us").item(0)).getTextContent()));
					
					listTestRowRead.add(testRow);
				}
				
				NodeList randRead = readEl.getElementsByTagName("Random_4KiB");
				for(int r = 0; r < seqRead.getLength(); r++) {
					Element seq = (Element)randRead.item(i);
					TestRow testRow = new TestRow();
					testRow.setQ(Integer.parseInt(seq.getAttribute("q")));
					testRow.setT(Integer.parseInt(seq.getAttribute("t")));
					
					testRow.setMbs(Double.parseDouble(((Element)seq.getElementsByTagName("MBs").item(0)).getTextContent()));
					testRow.setIops(((Double.parseDouble(((Element)seq.getElementsByTagName("IOPS").item(0)).getTextContent()))));
					testRow.setUs(Double.parseDouble(((Element)seq.getElementsByTagName("us").item(0)).getTextContent()));
					
					listTestRowRead.add(testRow);
				}
				
				testData.setRead(listTestRowRead);
				
				
				// Write
				NodeList seqWrite = readEl.getElementsByTagName("Sequential_1Mib");
				List<TestRow> listTestRowWrite = new ArrayList<TestRow>();
				for(int r = 0; r < seqWrite.getLength(); r++) {
					Element seq = (Element)seqRead.item(i);
					TestRow testRow = new TestRow();
					testRow.setQ(Integer.parseInt(seq.getAttribute("q")));
					testRow.setT(Integer.parseInt(seq.getAttribute("t")));
					
					testRow.setMbs(Double.parseDouble(((Element)seq.getElementsByTagName("MBs").item(0)).getTextContent()));
					testRow.setIops(((Double.parseDouble(((Element)seq.getElementsByTagName("IOPS").item(0)).getTextContent()))));
					testRow.setUs(Double.parseDouble(((Element)seq.getElementsByTagName("us").item(0)).getTextContent()));
					
					listTestRowWrite.add(testRow);
				}
				
				NodeList randWrite = readEl.getElementsByTagName("Sequential_1Mib");
				for(int r = 0; r < seqWrite.getLength(); r++) {
					Element seq = (Element)randWrite.item(i);
					TestRow testRow = new TestRow();
					testRow.setQ(Integer.parseInt(seq.getAttribute("q")));
					testRow.setT(Integer.parseInt(seq.getAttribute("t")));
					
					testRow.setMbs(Double.parseDouble(((Element)seq.getElementsByTagName("MBs").item(0)).getTextContent()));
					testRow.setIops(((Double.parseDouble(((Element)seq.getElementsByTagName("IOPS").item(0)).getTextContent()))));
					testRow.setUs(Double.parseDouble(((Element)seq.getElementsByTagName("us").item(0)).getTextContent()));
					
					listTestRowWrite.add(testRow);
				}
				
				testData.setWrite(listTestRowWrite);
				
				
				listaTestData.add(testData);
				
			}
		}

		return listaTestData;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, ParserConfigurationException, TransformerException, SQLException, SAXException {
		String path = "crystal/";
		
		// read from DB and write XML
		CrystalDBUtil.fromDbToXml("C:\\Users\\Padawan04\\Desktop\\fromCrystalToDB.xml", path);
		
		// read from XML and write in DB
		fromXmlToDB("C:\\Users\\Padawan04\\Desktop\\fromCrystalToDB.xml");
	}

}
