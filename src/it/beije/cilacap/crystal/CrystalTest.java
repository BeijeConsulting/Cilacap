package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrystalTest {

	public static void main(String[] args) throws Exception {

//		File file = new File("crystal/01/CDM_20200102150612.txt");
//		List<TestData> raccoltaDati = importData(file);
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


			String a = listaRighe.get(0);
			a = a.substring((a.indexOf("=")+1), (a.indexOf("=")+2));
			List<String> datiDaPrendere = new ArrayList<String>();
			datiDaPrendere.add("sequential1 Q:");
			datiDaPrendere.add(a);
//			System.out.println(a);
			


		
	}

}
