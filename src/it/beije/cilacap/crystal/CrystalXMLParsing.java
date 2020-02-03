package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

import it.beije.cilacap.rubrica.Utility;

public class CrystalXMLParsing {

	public static void main(String[] args) throws Exception {

		File file = new File("crystal/01/CDM_20200102145818.txt");
		TestData test = importData(file);
		File file2 = new File("crystal/01/CDM_20200102151619.txt");
		TestData test2 = importData(file2);
		List<TestData> tests = new ArrayList<TestData>();
		tests.add(test);
		tests.add(test2);
//		String filePathExport = "xml/newTest_1220.xml";
		esportaRubricaInXML(tests, Utility.choosePath(true));
	}

	private static void esportaRubricaInXML(List<TestData> tests, String filePath) throws Exception {
		File file = new File(filePath);
		esportaRubricaInXML(tests, file);
	}

	private static void esportaRubricaInXML(List<TestData> tests, File file) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("CrystalDiskMark"); // root elem
		document.appendChild(docElement);

		for (int i = 0; i < tests.size(); i++) {

			Element test = document.createElement("test");
			test.setAttribute("id_computer", tests.get(i).getIdComputer());
			test.setAttribute("version", tests.get(i).getVersion());
			test.setAttribute("os", tests.get(i).getOs());
			test.setAttribute("type", tests.get(i).getType());
			test.setAttribute("iterations", Integer.toString(tests.get(i).getIterations()));
			test.setAttribute("interval", tests.get(i).getInterval());
			test.setAttribute("date", tests.get(i).getDate());

			Element read = document.createElement("read");
			Element write = document.createElement("write");

			for (int j = 0; j < tests.get(i).getRead().size(); j++) {

				if (tests.get(i).getRead().get(j).getType().contentEquals("Sequential 1MiB")) {

					Element sequential_1MiB = document.createElement("Sequential_1MiB");
					Element mbsSeq_read = document.createElement("MBs");
					Element iopsSeq_read = document.createElement("IOPS");
					Element usSeq_read = document.createElement("us");

					sequential_1MiB.setAttribute("q", Integer.toString(tests.get(i).getRead().get(j).getQ()));
					sequential_1MiB.setAttribute("t", Integer.toString(tests.get(i).getRead().get(j).getT()));
					mbsSeq_read.setTextContent(Double.toString(tests.get(i).getRead().get(j).getMbs()));
					iopsSeq_read.setTextContent(Double.toString(tests.get(i).getRead().get(j).getIops()));
					usSeq_read.setTextContent(Double.toString(tests.get(i).getRead().get(j).getUs()));

					read.appendChild(sequential_1MiB);
					sequential_1MiB.appendChild(mbsSeq_read);
					sequential_1MiB.appendChild(iopsSeq_read);
					sequential_1MiB.appendChild(usSeq_read);

				}
				if (tests.get(i).getRead().get(j).getType().contentEquals("Random 4KiB")) {

					Element random_4KiB = document.createElement("Random_4KiB");
					Element mbsRan_read = document.createElement("Mbs");
					Element iopsRan_read = document.createElement("IOPS");
					Element usRan_read = document.createElement("us");

					random_4KiB.setAttribute("q", Integer.toString(tests.get(i).getRead().get(j).getQ()));
					random_4KiB.setAttribute("t", Integer.toString(tests.get(i).getRead().get(j).getT()));
					mbsRan_read.setTextContent(Double.toString(tests.get(i).getRead().get(j).getMbs()));
					iopsRan_read.setTextContent(Double.toString(tests.get(i).getRead().get(j).getIops()));
					usRan_read.setTextContent(Double.toString(tests.get(i).getRead().get(j).getUs()));

					read.appendChild(random_4KiB);
					random_4KiB.appendChild(mbsRan_read);
					random_4KiB.appendChild(iopsRan_read);
					random_4KiB.appendChild(usRan_read);
				}

			}
			for (int k = 0; k < tests.get(i).getWrite().size(); k++) {

				if (tests.get(i).getWrite().get(k).getType().contentEquals("Sequential 1MiB")) {

					Element sequential_1MiB = document.createElement("Sequential_1MiB");
					Element mbsSeq_write = document.createElement("MBs");
					Element iopsSeq_write = document.createElement("IOPS");
					Element usSeq_write = document.createElement("us");

					sequential_1MiB.setAttribute("q", Integer.toString(tests.get(i).getWrite().get(k).getQ()));
					sequential_1MiB.setAttribute("t", Integer.toString(tests.get(i).getWrite().get(k).getT()));
					mbsSeq_write.setTextContent(Double.toString(tests.get(i).getWrite().get(k).getMbs()));
					iopsSeq_write.setTextContent(Double.toString(tests.get(i).getWrite().get(k).getIops()));
					usSeq_write.setTextContent(Double.toString(tests.get(i).getWrite().get(k).getUs()));

					write.appendChild(sequential_1MiB);
					sequential_1MiB.appendChild(mbsSeq_write);
					sequential_1MiB.appendChild(iopsSeq_write);
					sequential_1MiB.appendChild(usSeq_write);
				}
				if (tests.get(i).getWrite().get(k).getType().contentEquals("Random 4KiB")) {

					Element random_4KiB_write = document.createElement("Random_4KiB");
					Element mbsRan_write = document.createElement("Mbs");
					Element iopsRan_write = document.createElement("IOPS");
					Element usRan_write = document.createElement("us");

					random_4KiB_write.setAttribute("q", Integer.toString(tests.get(i).getWrite().get(k).getQ()));
					random_4KiB_write.setAttribute("t", Integer.toString(tests.get(i).getWrite().get(k).getT()));
					mbsRan_write.setTextContent(Double.toString(tests.get(i).getWrite().get(k).getMbs()));
					iopsRan_write.setTextContent(Double.toString(tests.get(i).getWrite().get(k).getIops()));
					usRan_write.setTextContent(Double.toString(tests.get(i).getWrite().get(k).getUs()));

					write.appendChild(random_4KiB_write);
					random_4KiB_write.appendChild(mbsRan_write);
					random_4KiB_write.appendChild(iopsRan_write);
					random_4KiB_write.appendChild(usRan_write);

				}

			}
			test.appendChild(read);
			test.appendChild(write);
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
	private static TestData importData(String filePath) throws Exception {
		File file = new File(filePath);
		return importData(file);
	}

	private static TestData importData(File file) throws Exception {

		List<String> listaRighe = fileDivisoPerRighe(file); // metodo che restituisce tutte le righe dell'intero File
		List<TestRow> testRowListRead = new ArrayList<TestRow>(); // bean Row parte read -- lista di testRow
		List<TestRow> testRowListWrite = new ArrayList<TestRow>(); // bean Row parte write -- lista di testRow
		TestData testData = new TestData(); // singolo test
		String row = ""; // riga attuale

		for (int i = 0; i < listaRighe.size(); i++) {

			row = listaRighe.get(i);
			String temp;
			// qui prendo Version dal File
			if (row.contains("DiskMark")) {
				temp = row;
				temp = temp.substring((row.indexOf("Mark") + 4), row.indexOf("(C"));
				testData.setVersion(temp);
				// System.out.println(testData.getVersion());
			}
			// qui prendo Sequential dal file e i primi due del file sono Read Sequential
			// perciò li aggiungo nella lista Read
			if (row.contains("Sequential1")
					&& (listaRighe.get(i - 1).contains("[Read]") || listaRighe.get(i - 2).contains("[Read]"))) {

				TestRow testRowSeq = new TestRow(); // testRow singolo
				testRowSeq.setType("Sequential 1MiB"); // setto il tipo a Sequential
				testRowSeq = riempiRow(testRowSeq, row); // setto q e t e tutto il bean del TestRow relativo.
				testRowListRead.add(testRowSeq); // aggiungo alla lista il TestRow relativo
				// System.out.println(testRow.getUs());
			}
			if (row.contains("Random")
					&& (listaRighe.get(i - 3).contains("[Read]") || listaRighe.get(i - 4).contains("[Read]"))) {

				TestRow testRowRan = new TestRow();
				testRowRan.setType("Random 4KiB");
				testRowRan = riempiRow(testRowRan, row);
				testRowListRead.add(testRowRan);
			}
			if (row.contains("Sequential1")
					&& (listaRighe.get(i - 1).contains("[Write]") || listaRighe.get(i - 2).contains("[Write]"))) {

				TestRow testRow = new TestRow();
				testRow.setType("Sequential 1MiB");
				testRow = riempiRow(testRow, row);
				testRowListWrite.add(testRow);
			}
			if (row.contains("Random")
					&& (listaRighe.get(i - 3).contains("[Write]") || listaRighe.get(i - 4).contains("[Write]"))) {

				TestRow testRowRan = new TestRow();
				testRowRan.setType("Random 4KiB");
				testRowRan = riempiRow(testRowRan, row);
				testRowListWrite.add(testRowRan);
			}
			// Test:1GiB(x5)[Interval:5sec]<DefaultAffinity=DISABLED>
			if (row.contains("Test")) {
				temp = row;
				temp = temp.substring((temp.indexOf("t:") + 2), (temp.indexOf("(x")));
				testData.setType(temp);
				temp = row;
				temp = temp.substring((temp.indexOf("val:") + 4), (temp.indexOf("sec"))); // preso interval
				testData.setInterval(temp);
				temp = row;
				temp = temp.substring((temp.indexOf("(x") + 2), (temp.indexOf(")"))); // preso Itertion
				testData.setIterations(Integer.parseInt(temp));
			}
			// 20200102131948
			if (row.contains("Date:")) {
				temp = row;
				temp = temp.substring((temp.indexOf("e:") + 2), (temp.indexOf("Date:") + 15)); // preso Date
				testData.setDate(temp);
				temp = row;
				temp = temp.substring(temp.indexOf("e:") + 2);
				temp = temp.replace("/", "").replace(":", "");
				testData.setIdComputer(temp);
			}
			// OS:Windows10[10.0 Build18363](x64)
			if (row.contains("OS:")) {
				temp = row;
				temp = temp.substring(temp.indexOf("OS:") + 3, temp.indexOf("["));
				String appoggio = temp;
				temp = row;
				temp = temp.substring(temp.indexOf("("), temp.indexOf(")") + 1);
				temp = appoggio.concat(temp);
				testData.setOs(temp);
			}

		} // fine for
		testData.setRead(testRowListRead);
		testData.setWrite(testRowListWrite);

		return testData;
	} // fine metodo

	private static List<String> fileDivisoPerRighe(File file) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> listaRighe = new ArrayList<String>();
		String row = "";
		while ((row = reader.readLine()) != null) {
			if (row.length() != 1) {
				row = row.replace((char) 0, " ".charAt(0));
				row = row.replace(" ", "");
				listaRighe.add(row);
			}
		}
		reader.close();
		return listaRighe;
	}

	private static TestRow riempiRow(TestRow testRow, String row) { // metodo che prende sia Sequential che Random nella
		// parte Read and Write
		String temp = row;
		// Sequential1MiB(Q=8,T=1):98.981MB/s[94.4 IOPS]<83783.98us>
		temp = temp.substring((temp.indexOf("Q") + 2), (temp.indexOf(","))); // Q=..., Sequential1MiB Q
		testRow.setQ(Integer.parseInt(temp));
		// System.out.println(testRow.getQ());
		temp = row;
		temp = temp.substring((temp.indexOf("T") + 2), (temp.indexOf(")"))); // T=...) Sequential1MiB T
		testRow.setT(Integer.parseInt(temp));
		// System.out.println(testRow.getT());
		temp = row;
		temp = temp.substring((temp.indexOf(":") + 1), (temp.indexOf("MB/s"))); // MB/s
		testRow.setMbs(Double.parseDouble(temp));
		// System.out.println(testRow.getMbs());
		temp = row;
		temp = temp.substring((temp.indexOf("[") + 1), (temp.indexOf("IOPS"))); // IOPS
		testRow.setIops(Double.parseDouble(temp));
		// System.out.println(testRow.getIops());
		temp = row;
		temp = temp.substring((temp.indexOf("<") + 1), (temp.indexOf("us"))); // us
		testRow.setUs(Double.parseDouble(temp));
		return testRow;
	}

}
