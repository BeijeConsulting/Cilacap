package it.beije.cilacap.crystal;

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

		@SuppressWarnings("unused")
		TestRow testRow = null;
		List<TestRow> listaRead = new ArrayList<TestRow>();

		Element read = (Element) test.getElementsByTagName("read").item(0);
		Element write = (Element) test.getElementsByTagName("write").item(0);

//       System.out.println( read.getElementsByTagName("*").item(0));

		for (int i = 0; i < read.getElementsByTagName("*").getLength(); i++) {

			Element row = (Element) read.getElementsByTagName("*").item(i);
			System.out.println(i + " " + row);

		}


		listaRead=getListRow(testData, write);

		testData.setRead(listaRead);

		List<TestRow> listaWrite = new ArrayList<TestRow>();


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

	@SuppressWarnings("unused")
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

//			if (r.getModeType()== null) {
//				continue CICLO;
//			}
			if (r.getModeType().equalsIgnoreCase("Sequential_1MIB")) {
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
			if (r.getModeType().equalsIgnoreCase("Random_4Kib")) {
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

		 for (TestRow r : datiWrite) {

//    		System.out.println(r.getType());
//    		System.out.println(r.getType()=="Sequential_1MIb");

//    		if(r.getType()==null){
//    			continue CICLO ;
//    		}
			if (r.getModeType().equalsIgnoreCase("Sequential_1MIB")) {
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
			if (r.getModeType().equalsIgnoreCase("Random_4Kib")) {
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
