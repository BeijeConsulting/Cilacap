package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrystalTest {

	public static void main(String[] args) throws Exception {

		// File file = new File("crystal/01/CDM_20200102150612.txt");
		// List<TestData> raccoltaDati = importData(file);
		List<String> listaRighe = new ArrayList<String>();
		String riga = "Sequential1MiB(Q=8,T=1):113.448MB/s[108.2IOPS]<73386.86us>";
		listaRighe.add(riga);
		datiFinitiDaPrelevare(listaRighe);

	}

	@SuppressWarnings("unused")
	private static List<TestData> importData(String filePath) throws Exception {
		File file = new File(filePath);
		return importData(file);
	}

	private static List<TestData> importData(File file) throws Exception {

		List<TestData> raccoltaDati = new ArrayList<TestData>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String row = "";
		String[] rigaSplittata;
		String[] temporanea;
		// inizializzazione
		TestData dato = new TestData();
		TestRow testRowSequential1 = new TestRow();
		TestRow testRowSequential2 = new TestRow();
		TestRow testRowRandom1 = new TestRow();
		TestRow testRowRandom2 = new TestRow();

		testRowSequential1.setType("sequential");
		testRowSequential2.setType("sequential");
		testRowRandom1.setType("random");
		testRowRandom2.setType("random");

		// Parsing
		List<String> righeDelFile = fileDivisoPerRighe(file);
		for (int i = 0; i < righeDelFile.size(); i++) {
			System.out.println(righeDelFile.get(i));
		}
		reader.close();

		return raccoltaDati;
	}

	private static List<String> fileDivisoPerRighe(File file) throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> listaRighe = new ArrayList<String>();
		String row = "";
		while ((row = reader.readLine()) != null) {
			row = row.replace((char) 0, " ".charAt(0));
			row = row.replace(" ", "");
			listaRighe.add(row);
		}
		reader.close();
		return listaRighe;
	}

	public static void datiFinitiDaPrelevare(List<String> listaRighe) {

		String row = "";
		List<TestRow> testRowList = new ArrayList<TestRow>();
		TestData testData = new TestData();
		
		// Sequential1MiB(Q=8,T=1):113.448MB/s[108.2IOPS]<73386.86us>
		for (int i = 0; i < listaRighe.size(); i++) {
			row = listaRighe.get(i);
			if (row.contains("Sequential1")) {
				TestRow testRow = new TestRow();
				testRow.setType("sequential");
				String temp = row;
				temp = temp.substring((temp.indexOf("Q") + 2), (temp.indexOf("Q") + 3)); // Q=..., Sequential1MiB Q
				testRow.setQ(Integer.parseInt(temp));
//				System.out.println(testRow.getQ());
				temp = row;
				temp = temp.substring((temp.indexOf("T")+2), (temp.indexOf("T")+3)); // T=...) Sequential1MiB T
				testRow.setT(Integer.parseInt(temp));
//				System.out.println(testRow.getT());
				temp = row;
				temp = temp.substring((temp.indexOf(":")+1), (temp.indexOf("MB/s"))); // MB/s
				testRow.setMbs(Double.parseDouble(temp));
//				System.out.println(testRow.getMbs());
				temp = row;
				temp = temp.substring((temp.indexOf("[")+1), (temp.indexOf("IOPS"))); // IOPS
				testRow.setIops(Double.parseDouble(temp));
//				System.out.println(testRow.getIops());
				temp = row;
				temp = temp.substring((temp.indexOf("<")+1), (temp.indexOf("us"))); //us
				testRow.setUs(Double.parseDouble(temp));
//				System.out.println(testRow.getUs());
			}
		}//fine for
		
		
		

	}

}
