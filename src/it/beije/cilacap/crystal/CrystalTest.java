package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrystalTest {

	public static void main(String[] args) throws Exception {

		File file = new File("crystal/01/CDM_20200102150612.txt");

		TestData test = importData(file);
		System.out.println(test);
		// for (int i = 0; i < raccoltaDati.size(); i++) {
		// System.out.println(raccoltaDati.get(i));
		// }
	}

	@SuppressWarnings("unused")
	private static TestData importData(String filePath) throws Exception {
		File file = new File(filePath);
		return importData(file);
	}

	private static TestData importData(File file) throws Exception {

		// List<TestData> raccoltaDati = new ArrayList<TestData>(); // raccolta Dei Test
		List<String> listaRighe = fileDivisoPerRighe(file); // righe intero File
		List<TestRow> testRowListRead = new ArrayList<TestRow>(); // bean Row parte read.
		List<TestRow> testRowListWrite = new ArrayList<TestRow>(); // bean Row parte write
		TestData testData = new TestData(); // singolo test
		String row = ""; // riga attuale

		for (int i = 0; i < listaRighe.size(); i++) {
			row = listaRighe.get(i);
			// System.out.println(row);
			String temp;
			if (row.contains("DiskMark")) {
				temp = row;
				temp = temp.substring((row.indexOf("Mark") + 4), row.indexOf("(C"));
				testData.setVersion(temp);
				// System.out.println(testData.getVersion());
			}
			if (row.contains("Sequential1")
					&& (listaRighe.get(i - 1).contains("[Read]") || listaRighe.get(i - 2).contains("[Read]"))) {

				TestRow testRowSeq = new TestRow();
				testRowSeq.setType("Sequential 1MiB");
				testRowSeq = riempiRow(testRowSeq, row);
				testRowListRead.add(testRowSeq);
				// System.out.println(testRow.getUs());
			}
			if (row.contains("Random")
					&& (listaRighe.get(i - 1).contains("[Read]") || listaRighe.get(i - 2).contains("[Read]"))) {

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
					&& (listaRighe.get(i - 1).contains("[Write]") || listaRighe.get(i - 2).contains("[Write]"))) {

				TestRow testRowRan = new TestRow();
				testRowRan.setType("Random 4KiB");
				testRowRan = riempiRow(testRowRan, row);
				testRowListWrite.add(testRowRan);
			}
			// Test:1GiB(x5)[Interval:5sec]<DefaultAffinity=DISABLED>
			if (row.contains("Test")) {
				temp = row;
//				temp = temp.substring((temp.indexOf("t:")+2), (temp.indexOf("GiB")));
				temp = temp.substring((temp.indexOf("val:") + 4), (temp.indexOf("sec"))); // preso interval
				testData.setInterval(temp);
				temp = row;
				temp = temp.substring((temp.indexOf("(x") + 2), (temp.indexOf(")"))); // preso Itertion
				testData.setIterations(Integer.parseInt(temp));
			}
			// Date:2020/01/0213:19:48
			if (row.contains("Date:")) {
				temp = row;
				temp = temp.substring((temp.indexOf("e:") + 2), (temp.indexOf(":") - 2)); // preso Date
				testData.setDate(temp);
			}
			// OS:Windows10[10.0 Build18363](x64)
			if (row.contains("OS:")) {
				temp = row;
				temp = temp.substring(temp.indexOf("OS:") + 3, temp.indexOf("["));
				
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

	private static TestRow riempiRow(TestRow testRow, String row) {
		String temp = row;
		temp = temp.substring((temp.indexOf("Q") + 2), (temp.indexOf("Q") + 3)); // Q=..., Sequential1MiB Q
		testRow.setQ(Integer.parseInt(temp));
		// System.out.println(testRow.getQ());
		temp = row;
		temp = temp.substring((temp.indexOf("T") + 2), (temp.indexOf("T") + 3)); // T=...) Sequential1MiB T
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
