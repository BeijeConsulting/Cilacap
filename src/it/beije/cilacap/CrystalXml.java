package it.beije.cilacap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.sun.accessibility.internal.resources.accessibility;

import it.beije.cilacap.crystal.TestData;
import it.beije.cilacap.crystal.TestRow;
import it.beije.cilacap.rubrica.Contatto;

public class CrystalXml {

	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		String temp;
		while ((row = reader.readLine()) != null) {

			temp = row.replace((char) 0, " ".charAt(0)).replace(" ", "");
			temp = temp.trim();
			rows.add(temp);
		}
		return rows;
	}

	public static List<TestData> writeTest(List<String> array) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		Element docElement = document.createElement("CrystalDiskMark");
		document.appendChild(docElement);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		// StreamResult result = new StreamResult(new File(pathfile));

		List<TestRow> listRow = new ArrayList<TestRow>();
		List<TestData> listData = new ArrayList<TestData>();
		// transformer.transform(source, result);

		TestData testD = new TestData();
		String temp;
		for (String i : array) {
			// CrystalDiskMark7.0.0x64(C)2007-2019hiyohiyo
			if (i.contains("Mark")) {
				temp = i;
				temp = temp.substring(temp.indexOf("Mark") + 4, temp.indexOf("(C"));
				testD.setVersion(temp);
			}
//<test id_computer="01" version="7.0.0 x64" os="Windows 10" type="1 GiB" iterations="5" interval="5 sec" date="2020/01/02 13:19:48">
			if (i.contains("Windows")) {
				// OS: Windows 10 [10.0 Build 18363] (x64)
				temp = i;
				temp = temp.substring(temp.indexOf("Windows") + 7, temp.indexOf("["));
				testD.setOs(temp);

			}
			if (i.contains("Test:")) {
				// Test: 1 GiB (x5) [Interval: 5 sec] <DefaultAffinity=DISABLED>
				temp = i;
				temp = temp.substring(temp.indexOf("Test:") + 5, temp.indexOf("(x"));
				testD.setType(temp);

			}

			if (i.contains("GiB(x")) {
				// Test: 1 GiB (x5) [Interval: 5 sec] <DefaultAffinity=DISABLED>
				temp = i;
				temp = temp.substring(temp.indexOf("GiB(x") + 5, temp.indexOf(")"));
				testD.setIterations(Integer.parseInt(temp));
			}
			if (i.contains("[Interval:")) {
				// Test: 1 GiB (x5) [Interval: 5 sec] <DefaultAffinity=DISABLED>
				temp = i;
				temp = temp.substring(temp.indexOf("[Interval:") + 10, temp.indexOf("sec"));
				testD.setIntervalInSeconds(Integer.parseInt(temp));
			}

			if (i.contains("Date:")) {
				// Date: 2020/01/03 10:40:02
				temp = i;
				temp = temp.substring(temp.indexOf("Date:") + 5, temp.indexOf(":02") + 3);
				testD.setDate((temp));
				System.out.println(temp);
			}
			if (i.contains("(Q=")) {
				// Sequential 1MiB (Q=  8, T= 1):   554.465 MB/s [    528.8 IOPS] < 15098.25 us>
				temp = i;
				temp = temp.substring(temp.indexOf("(Q=") + 3, temp.indexOf(",T=1") );
				testD.setDate((temp));
				System.out.println(temp);
			}

		}

		testD.setRead(listRow);
		listData.add(testD);

		return null;

	}

	public static void main(String[] args) throws Exception {
		File f = new File("crystal/02/CDM_20200103104002.txt");
		List<String> array = readFileRows(f);
		// writeContattiInFile(array,"CDM_20200103104002.xml");
		writeTest(array);
	}
}
