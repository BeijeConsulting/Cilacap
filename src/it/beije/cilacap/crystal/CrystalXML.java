package it.beije.cilacap.crystal;

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Attribute;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.cilacap.esercizi.rubrica.Contatto;
import it.beije.cilacap.crystal.GestoreReadCrystal;;

public class CrystalXML {

	public static void main(String[] args) throws Exception {

		File fileCrystal = new File("crystal/01/CDM_20200102131948.txt");
		System.out.println(fileCrystal.exists());
		List<String> contenutoCrystal = new ArrayList<String>();
		contenutoCrystal = GestoreReadCrystal.readFileRows(fileCrystal);
		System.out.println(contenutoCrystal.toString());
		TestData datiDiCrystal = GestoreReadCrystal.createListOfData(contenutoCrystal);
		datiDiCrystal.setIdComputer(fileCrystal.getPath().substring(15, fileCrystal.getPath().length() - 4));
//		System.out.println(datiDiCrystal.getType());
//		System.out.println(datiDiCrystal.getDate());
//		System.out.println(datiDiCrystal.getVersion());
//		System.out.println(datiDiCrystal.getIdComputer());
//		System.out.println(datiDiCrystal.getInterval());
//		System.out.println(datiDiCrystal.getIterations());
//		System.out.println(datiDiCrystal.getOs());
		createXML(datiDiCrystal);

	}

	public static void createXML(TestData datiDiCrystal) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element crystal = document.createElement("CrystalDiskMark");
		document.appendChild(crystal);

		Element test = document.createElement("test");
		test.setAttribute("id_computer", "01");
		test.setAttribute("version", datiDiCrystal.getVersion());
		test.setAttribute("os", datiDiCrystal.getOs());
		test.setAttribute("type", datiDiCrystal.getType());
		test.setAttribute("iterations", Integer.toString(datiDiCrystal.getIterations()));
		test.setAttribute("interval", String.valueOf(datiDiCrystal.getIntervalInSeconds()));
		test.setAttribute("date", datiDiCrystal.getDate());
		crystal.appendChild(test);

		Element read = document.createElement("read");
		test.appendChild(read);

//        TestRow[] datiRead=new TestRow[datiDiCrystal.getRead().size()];
//    	datiRead= datiDiCrystal.getRead().toArray(datiRead);
		List<TestRow> datiRead = datiDiCrystal.getRead();

		Element write = document.createElement("write");
		test.appendChild(write);

//        TestRow[] datiWrite=new TestRow[datiDiCrystal.getWrite().size()];
//    	datiWrite= datiDiCrystal.getWrite().toArray(datiWrite);
		List<TestRow> datiWrite = datiDiCrystal.getWrite();

//    	System.out.println(datiWrite[0].getType());

		CICLO: for (TestRow r : datiRead) {

//    		System.out.println(r.getType());
//    		System.out.println(r.getType()=="Sequential_1MIb");

			if (r.getType() == null) {
				continue CICLO;
			}
			if (r.getType().equalsIgnoreCase("Sequential_1MIB")) {
				Element sequential = document.createElement("Sequential_1MiB");
				sequential.setAttribute("q", Integer.toString(r.getQ()));
				sequential.setAttribute("t", Integer.toString(r.getT()));
				Element mbs = document.createElement("MBs");
				Element iops = document.createElement("IOPS");
				Element us = document.createElement("us");
				mbs.setTextContent(Double.toString(r.getMbs()));
				iops.setTextContent(Double.toString(r.getIops()));
				us.setTextContent(Double.toString(r.getUs()));

				sequential.appendChild(mbs);
				sequential.appendChild(iops);
				sequential.appendChild(us);

				read.appendChild(sequential);

			}
			if (r.getType().equalsIgnoreCase("Random_4Kib")) {
				Element random = document.createElement("Random_4KiB");
				random.setAttribute("q", Integer.toString(r.getQ()));
				random.setAttribute("t", Integer.toString(r.getT()));
				Element mbs = document.createElement("MBs");
				Element iops = document.createElement("IOPS");
				Element us = document.createElement("us");
				mbs.setTextContent(Double.toString(r.getMbs()));
				iops.setTextContent(Double.toString(r.getIops()));
				us.setTextContent(Double.toString(r.getUs()));

				random.appendChild(mbs);
				random.appendChild(iops);
				random.appendChild(us);

				read.appendChild(random);

			}

		}

		CICLO: for (TestRow r : datiWrite) {

//    		System.out.println(r.getType());
//    		System.out.println(r.getType()=="Sequential_1MIb");

//    		if(r.getType()==null){
//    			continue CICLO ;
//    		}
			if (r.getType().equalsIgnoreCase("Sequential_1MIB")) {
				Element sequential = document.createElement("Sequential_1MiB");
				sequential.setAttribute("q", Integer.toString(r.getQ()));
				sequential.setAttribute("t", Integer.toString(r.getT()));
				Element mbs = document.createElement("MBs");
				Element iops = document.createElement("IOPS");
				Element us = document.createElement("us");
				mbs.setTextContent(Double.toString(r.getMbs()));
				iops.setTextContent(Double.toString(r.getIops()));
				us.setTextContent(Double.toString(r.getUs()));

				sequential.appendChild(mbs);
				sequential.appendChild(iops);
				sequential.appendChild(us);

				write.appendChild(sequential);

			}
			if (r.getType().equalsIgnoreCase("Random_4Kib")) {
				Element random = document.createElement("Random_4KiB");
				random.setAttribute("q", Integer.toString(r.getQ()));
				random.setAttribute("t", Integer.toString(r.getT()));
				Element mbs = document.createElement("MBs");
				Element iops = document.createElement("IOPS");
				Element us = document.createElement("us");
				mbs.setTextContent(Double.toString(r.getMbs()));
				iops.setTextContent(Double.toString(r.getIops()));
				us.setTextContent(Double.toString(r.getUs()));

				random.appendChild(mbs);
				random.appendChild(iops);
				random.appendChild(us);

				write.appendChild(random);

			}

		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("crystal/xmltest.xml"));

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("File saved!");
	}

}