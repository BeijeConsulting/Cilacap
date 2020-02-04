package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

public class ConvInXml {

	public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, ClassNotFoundException {
		File file = new File("C:\\Users\\Padawan03\\Desktop\\03\\CDM_20200107153224.txt");
		TestData testData = new TestData();
		TestRow test2 = new TestRow();
		ArrayList<String> RigaPerRiga = new ArrayList<>(); 
		RigaPerRiga = RiuoviCarattereStrano(file);
		testData=testData.Popola(RigaPerRiga);
		testData.InserisciInDB(testData);
		testData.InserisciReadWrite(testData);
		//CreaXml(testData);
		
//		File file = new File("C:\\Users\\Padawan03\\git\\Cilacap\\crystal");
//	    File[] files = file.listFiles(); 
//	    
//        System.out.println("Files are:"); 
//
//        // Display the names of the files 
//        for (int i = 0; i < files.length; i++) { 
//            System.out.println(files[i].getName()); 
//            if(files[i].isDirectory()) {
//            	File ff = new File("C:\\Users\\Padawan03\\git\\Cilacap\\crystal\\"+files[i].getName());
//            	for(File ff2: ff.listFiles())
//            		System.out.println(ff2.getName());
//            }
//        } 
		
		
	}
	
	public static ArrayList<String> RiuoviCarattereStrano(File f) throws IOException{
		
		FileReader filereader = new FileReader(f);
		BufferedReader reader = new BufferedReader(filereader);
		String row = reader.readLine();
		 row = reader.readLine();
		 row = reader.readLine();
		 ArrayList<String> prova = new ArrayList<>(); 
		 while(row!= null) {
			 String appoggio= new String();
			 for(int i=0;i<row.length();i++) {
				 if(row.charAt(i)>=32) {
					 appoggio += row.charAt(i);
				 }
			 }
			 prova.add(appoggio);
			 row = reader.readLine();
		 }
		return PulisciVuote(prova);
	}
	public static ArrayList<String> PulisciVuote(ArrayList<String> Array){
		for(int i=0;i<Array.size();i++) {
			if(Array.get(i).isEmpty()) {
				Array.remove(i);
			}
		}
		return Array;
	}
	
	
	
	public static void CreaXml(TestData testData) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document document = builder.newDocument();
        Element docElement = document.createElement("CrystalDiskMark");
        document.appendChild(docElement);
        
        Element test = document.createElement("test");
        test.setAttribute("date", testData.getDate());
        test.setAttribute("interval", testData.getInterval());
        test.setAttribute("iterations", ""+testData.getIterations());
        test.setAttribute("type", testData.getType());
        test.setAttribute("os", testData.getOs());
        test.setAttribute("version", testData.getVersion());
        test.setAttribute("id_computer", testData.getIdComputer());
        
        Element read = document.createElement("read");
        for(int i=0;i<testData.getRead().size();i++) {
        	Element type = document.createElement(testData.getRead().get(i).getType());
        	read.appendChild(type);
        	type.setAttribute("t", ""+testData.getRead().get(i).getT());
        	type.setAttribute("q", ""+testData.getRead().get(i).getQ());
        	Element MBs = document.createElement("MBs");
        	type.appendChild(MBs);
        	MBs.setTextContent(""+testData.getRead().get(i).getMbs());
        	Element IOPS = document.createElement("IOPS");
        	type.appendChild(IOPS);
        	IOPS.setTextContent(""+testData.getRead().get(i).getIops());
        	Element us = document.createElement("us");
        	type.appendChild(us);
        	us.setTextContent(""+testData.getRead().get(i).getUs());
        }
        Element write = document.createElement("write");
        for(int i=0;i<testData.getWrite().size();i++) {
        	Element type = document.createElement(testData.getWrite().get(i).getType());
        	write.appendChild(type);
        	type.setAttribute("t", ""+testData.getWrite().get(i).getT());
        	type.setAttribute("q", ""+testData.getWrite().get(i).getQ());
        	Element MBs = document.createElement("MBs");
        	type.appendChild(MBs);
        	MBs.setTextContent(""+testData.getWrite().get(i).getMbs());
        	Element IOPS = document.createElement("IOPS");
        	type.appendChild(IOPS);
        	IOPS.setTextContent(""+testData.getWrite().get(i).getIops());
        	Element us = document.createElement("us");
        	type.appendChild(us);
        	us.setTextContent(""+testData.getWrite().get(i).getUs());
        }
        
        test.appendChild(read);
        test.appendChild(write);
        docElement.appendChild(test);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("C:\\Users\\Padawan03\\Desktop\\03\\CDM_20200107153224.xml"));
		
		transformer.transform(source, result);

		System.out.println("File saved!");
        
		
	}

}
