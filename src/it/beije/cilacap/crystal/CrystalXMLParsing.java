package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class CrystalXMLParsing {

	public static void main(String[] args) throws Exception {

//		TestRow testRowSequential = new TestRow();
//		TestRow testRowSequential2 = new TestRow();
//		TestRow testRowRandom = new TestRow();
//		testRowSequential.setType("sequential");
//		testRowSequential.setMbs(2.6);
//		testRowSequential.setIops(2.6);
//		testRowSequential.setQ(3);
//		testRowSequential.setT(4);
//		testRowSequential.setUs(2.2);
//		testRowSequential2.setType("sequential");
//		testRowSequential2.setMbs(2.6);
//		testRowSequential2.setIops(2.6);
//		testRowSequential2.setQ(3);
//		testRowSequential2.setT(4);
//		testRowSequential2.setUs(2.2);
//
//		testRowRandom.setType("random");
//		testRowRandom.setMbs(2.2);
//		testRowRandom.setIops(2.2);
//		testRowRandom.setQ(1);
//		testRowRandom.setT(9);
//		testRowRandom.setUs(2.2);
//
//		List<TestRow> listaRowsRead = new ArrayList<TestRow>();
//		List<TestRow> listaRowsWrite = new ArrayList<TestRow>();
//
//		listaRowsRead.add(testRowSequential);
//		listaRowsRead.add(testRowRandom);
//		TestData testData = new TestData();
//		testData.setIdComputer("1");
//		testData.setVersion("5");
//		testData.setOs("x86");
//		testData.setType("tipo36");
//		testData.setIterations(5);
//		testData.setInterval("4");
//		testData.setDate("oggi");
//		testData.setRead(listaRowsRead);
//		testData.setWrite(listaRowsWrite);
//		List<TestData> raccoltaDati = new ArrayList<TestData>();
//		raccoltaDati.add(testData);
//		esportaRubricaInXML(raccoltaDati, "xml/testParsing.xml");
		
//		File file = new File("crystal/01/CDM_20200102131948.txt");
//		List<TestData> raccoltaDati = importData(file);
	}

	@SuppressWarnings("unused")
	private static void esportaRubricaInXML(List<TestData> raccoltaDati, String filePath) throws Exception {
		File file = new File(filePath);
		esportaRubricaInXML(raccoltaDati, file);
	}

	private static void esportaRubricaInXML(List<TestData> raccoltaDati, File file) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("CrystalDiskMark"); // root elem
		document.appendChild(docElement);

		for (int i = 0; i < raccoltaDati.size(); i++) {
			//
			Element test = document.createElement("test");
			test.setAttribute("id_computer", raccoltaDati.get(i).getIdComputer());
			test.setAttribute("version", raccoltaDati.get(i).getVersion());
			test.setAttribute("os", raccoltaDati.get(i).getOs());
			test.setAttribute("type", raccoltaDati.get(i).getType());
			test.setAttribute("iterations", Integer.toString(raccoltaDati.get(i).getIterations()));
			test.setAttribute("interval", raccoltaDati.get(i).getInterval());
			test.setAttribute("date", raccoltaDati.get(i).getDate());
			Element read = document.createElement("read");
			Element sequential_1MiB_read = document.createElement("Sequential_1MiB");
			Element random_4KiB_read = document.createElement("Random_4KiB");
			Element mbsSeq_read = document.createElement("MBs");
			Element iopsSeq_read = document.createElement("IOPS");
			Element usSeq_read = document.createElement("us");
			Element mbsRan_read = document.createElement("Mbs");
			Element iopsRan_read = document.createElement("IOPS");
			Element usRan_read = document.createElement("us");

			Element write = document.createElement("write");
			Element sequential_1MiB_write = document.createElement("Sequential_1MiB");
			Element random_4KiB_write = document.createElement("Random_4KiB");
			Element mbsSeq_write = document.createElement("MBs");
			Element iopsSeq_write = document.createElement("IOPS");
			Element usSeq_write = document.createElement("us");
			Element mbsRan_write = document.createElement("Mbs");
			Element iopsRan_write = document.createElement("IOPS");
			Element usRan_write = document.createElement("us");

			for (int j = 0; j < raccoltaDati.get(i).getRead().size(); j++) {

				if (raccoltaDati.get(i).getRead().get(j).getType().contentEquals("sequential")) {
					sequential_1MiB_read.setAttribute("q",
							Integer.toString(raccoltaDati.get(i).getRead().get(j).getQ()));
					sequential_1MiB_read.setAttribute("t",
							Integer.toString(raccoltaDati.get(i).getRead().get(j).getT()));
					mbsSeq_read.setTextContent(Double.toString(raccoltaDati.get(i).getRead().get(j).getMbs()));
					iopsSeq_read.setTextContent(Double.toString(raccoltaDati.get(i).getRead().get(j).getIops()));
					usSeq_read.setTextContent(Double.toString(raccoltaDati.get(i).getRead().get(j).getUs()));
				}
				if (raccoltaDati.get(i).getRead().get(j).getType().contentEquals("random")) {
					random_4KiB_read.setAttribute("q", Integer.toString(raccoltaDati.get(i).getRead().get(j).getQ()));
					random_4KiB_read.setAttribute("t", Integer.toString(raccoltaDati.get(i).getRead().get(j).getT()));
					mbsRan_read.setTextContent(Double.toString(raccoltaDati.get(i).getRead().get(j).getMbs()));
					iopsRan_read.setTextContent(Double.toString(raccoltaDati.get(i).getRead().get(j).getIops()));
					usRan_read.setTextContent(Double.toString(raccoltaDati.get(i).getRead().get(j).getUs()));
				}

			}
			for (int k = 0; k < raccoltaDati.get(i).getWrite().size(); k++) {

				if (raccoltaDati.get(i).getWrite().get(k).getType().contentEquals("sequential")) {
					sequential_1MiB_write.setAttribute("q",
							Integer.toString(raccoltaDati.get(i).getWrite().get(k).getQ()));
					sequential_1MiB_write.setAttribute("t",
							Integer.toString(raccoltaDati.get(i).getWrite().get(k).getT()));
					mbsSeq_write.setTextContent(Double.toString(raccoltaDati.get(i).getWrite().get(k).getMbs()));
					iopsSeq_write.setTextContent(Double.toString(raccoltaDati.get(i).getWrite().get(k).getIops()));
					usSeq_write.setTextContent(Double.toString(raccoltaDati.get(i).getWrite().get(k).getUs()));
				}
				if (raccoltaDati.get(i).getWrite().get(k).getType().contentEquals("random")) {

					random_4KiB_write.setAttribute("q", Integer.toString(raccoltaDati.get(i).getWrite().get(k).getQ()));
					random_4KiB_write.setAttribute("t", Integer.toString(raccoltaDati.get(i).getWrite().get(k).getT()));
					mbsRan_write.setTextContent(Double.toString(raccoltaDati.get(i).getWrite().get(k).getMbs()));
					iopsRan_write.setTextContent(Double.toString(raccoltaDati.get(i).getWrite().get(k).getIops()));
					usRan_write.setTextContent(Double.toString(raccoltaDati.get(i).getWrite().get(k).getUs()));
				}

			}
			test.appendChild(read);
			test.appendChild(write);
			read.appendChild(sequential_1MiB_read);
			write.appendChild(sequential_1MiB_write);

			sequential_1MiB_read.appendChild(mbsSeq_read);
			sequential_1MiB_read.appendChild(iopsSeq_read);
			sequential_1MiB_read.appendChild(usSeq_read);

			sequential_1MiB_write.appendChild(mbsSeq_write);
			sequential_1MiB_write.appendChild(iopsSeq_write);
			sequential_1MiB_write.appendChild(usSeq_write);

			read.appendChild(random_4KiB_read);
			write.appendChild(random_4KiB_write);

			random_4KiB_read.appendChild(mbsRan_read);
			random_4KiB_read.appendChild(iopsRan_read);
			random_4KiB_read.appendChild(usRan_read);

			random_4KiB_write.appendChild(mbsRan_write);
			random_4KiB_write.appendChild(iopsRan_write);
			random_4KiB_write.appendChild(usRan_write);

			docElement.appendChild(test);
		}
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(file);

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);

		System.out.println("file esportato con successo!");

	}

	@SuppressWarnings("unused")
	private static TestRow matchSection(String readSection, File file) throws Exception {
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while((row = reader.readLine()) != null) {
			TestRow sequential1 = new TestRow();
			TestRow sequential2 = new TestRow();
			TestRow random1 = new TestRow();
			TestRow random2 = new TestRow();
			String[] array = row.split(" ");
			
			
		}
		reader.close();
		return null;
	}

}
