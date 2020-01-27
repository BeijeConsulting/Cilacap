package it.beije.cilacap.myCrystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class MainCristal {
	
	private static String getCaratteriAmmessi() {
		StringBuilder caratteriAmmessi = new StringBuilder();
		for(int c = 32; c < 126; c++) {
			caratteriAmmessi.append((char)c);
		}
		return caratteriAmmessi.toString();
	}

	@SuppressWarnings("resource")
	public static String fileContent(String file) throws IOException {
		
		String charAmmessi = getCaratteriAmmessi();
		StringBuilder rows = new StringBuilder();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row;
		
		while ((row = reader.readLine()) != null) {
			rows.append(row);
		}
		
		StringBuilder stringOk = new StringBuilder();
		
		for(int i = 0; i < rows.length(); i++) {
			if(charAmmessi.indexOf(rows.charAt(i)) != -1) {
				stringOk.append(rows.charAt(i));
			}
		}
		
		return stringOk.toString();
		
	}
	
	
	public static TestData addContentToList(String s, String idComputer) {
		
		List<TestRow> listRead = new ArrayList<TestRow>();
		List<TestRow> listWrite = new ArrayList<TestRow>();
		
		TestData testData = new TestData();
		testData.setIdComputer(idComputer);
		testData.setVersion(CrystalUtil.getTest(s)[0]);
		testData.setOs(CrystalUtil.getTest(s)[1]);
		testData.setType(CrystalUtil.getTest(s)[2]);
		testData.setIterations(Integer.parseInt(CrystalUtil.getTest(s)[3]));
		testData.setInterval(CrystalUtil.getTest(s)[4]);
		testData.setDate(CrystalUtil.getTest(s)[5]);
		
		for(int i = 0; i < CrystalUtil.getMBsRead(s).length; i++) {
			
			TestRow testRowRead = new TestRow();
			
			if(i < 2) {
				testRowRead.setType("Sequential_1MiB");
			} else {
				testRowRead.setType("Random_4KiB");
			}
			
			testRowRead.setQ(Integer.parseInt(CrystalUtil.getQRead(s)[i]));
			testRowRead.setT(Integer.parseInt(CrystalUtil.getTRead(s)[i]));
			testRowRead.setMbs(Double.parseDouble(CrystalUtil.getMBsRead(s)[i]));
			testRowRead.setIops(Double.parseDouble(CrystalUtil.getIOPSRead(s)[i]));
			testRowRead.setUs(Double.parseDouble(CrystalUtil.getUsRead(s)[i]));
			
			listRead.add(testRowRead);
		}
		
		for(int i = 0; i < CrystalUtil.getMBsWrite(s).length; i++) {
			
			TestRow testRowWrite = new TestRow();
			
			if(i < 2) {
				testRowWrite.setType("Sequential_1MiB");
			} else {
				testRowWrite.setType("Random_4KiB");
			}
			
			testRowWrite.setQ(Integer.parseInt(CrystalUtil.getQWrite(s)[i]));
			testRowWrite.setT(Integer.parseInt(CrystalUtil.getTWrite(s)[i]));
			testRowWrite.setMbs(Double.parseDouble(CrystalUtil.getMBsWrite(s)[i]));
			testRowWrite.setIops(Double.parseDouble(CrystalUtil.getIOPSWrite(s)[i]));
			testRowWrite.setUs(Double.parseDouble(CrystalUtil.getUsWrite(s)[i]));
			
			listWrite.add(testRowWrite);
		}
		
		testData.setRead(listRead);
		testData.setWrite(listWrite);
		
		return testData;
	}
	
	public static void getFiles(String rootPath) throws IOException, ParserConfigurationException, TransformerException {
		File folder = new File(rootPath);
		for(File f : folder.listFiles()) {
			
			if(f.isDirectory()) {
				
				String newPath = rootPath + f.getName();
				
				File ff = new File(newPath);
				
				String pathXML = ff.getParent() + "\\" + f.getName() + "\\" + f.getName() + ".xml";
				
				List<TestData> testData = new ArrayList<TestData>();
				
				for(File file : ff.listFiles()) {
					if(!file.isDirectory() && file.getName().contains("txt")) {
						testData.add(addContentToList(fileContent(file.getPath()), f.getName().toString()));
					}
				}
				
				writeXML(pathXML, testData);
			}
		}
	}
	
	public static void writeXML(String pathXML, List<TestData> listTestData) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element docElement = document.createElement("CrystalDiskMark");
        document.appendChild(docElement);
        
        for(TestData testData : listTestData) {
        	Element test = document.createElement("test");
        	test.setAttribute("id_computer", testData.getIdComputer());
        	test.setAttribute("version", testData.getVersion());
        	test.setAttribute("os", testData.getOs());
        	test.setAttribute("type", testData.getType());
        	test.setAttribute("iterations", "" + testData.getIterations());
        	test.setAttribute("interval", testData.getInterval());
        	test.setAttribute("date", testData.getDate());
        	
        	// read
        	Element read = document.createElement("read");
        	test.appendChild(read);
        	for(TestRow row : testData.getRead()) {
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
        	       	
        	docElement.appendChild(test);
        }
        
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File(pathXML));

		transformer.transform(source, result);
		
	}
	

	
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
		String path = "crystal/";
		getFiles(path);
		System.out.println("Esecuzione terminata!");
	}

}
