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
	public static void fromXmlToDB() {
		
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
				
//				Element nome = (Element)utente.getElementsByTagName("nome").item(0);
//				Element cognome = (Element)utente.getElementsByTagName("cognome").item(0);
//				Element telefono = (Element)utente.getElementsByTagName("telefono").item(0);
//				Element email = (Element)utente.getElementsByTagName("email").item(0);
//
//				Contatto contatto = new Contatto();
//				contatto.setNome(nome.getTextContent());
//				contatto.setCognome(cognome.getTextContent());
//				contatto.setTelefono(telefono.getTextContent());
//				contatto.setEmail(email.getTextContent());
//
//				listaContatti.add(contatto);
			}
		}

		return listaTestData;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, ParserConfigurationException, TransformerException, SQLException, SAXException {
		String path = "crystal/";
		// System.out.println(readFileCrystalWriteDb(path));
//		CrystalDBUtil.fromDbToXml("C:\\Users\\Padawan04\\Desktop\\fromCrystalToDB.xml", path);
		
		caricaArrayListDiTestDataFromXML("C:\\Users\\Padawan04\\Desktop\\fromCrystalToDB.xml");
	}

}
