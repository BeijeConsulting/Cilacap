package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrystalTest {
	

	public static void main(String[] args) throws Exception {

		File file = new File("crystal/01/CDM_20200102145818.txt");
		List<TestData> raccoltaDati = importData(file);
		System.out.println(raccoltaDati);

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
		reader.readLine(); // ignoro prima riga
		row = reader.readLine();
		row = reader.readLine();		
		rigaSplittata = row.split(" ");
		dato.setVersion(rigaSplittata[1].concat(rigaSplittata[2])); //preso version 7.0.0 x 64
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
		row = reader.readLine();
//		System.out.println(row);
		rigaSplittata = row.split(" ");
//		System.out.println(rigaSplittata[4]);
		rigaSplittata = rigaSplittata[4].split(",");
		rigaSplittata[0] = rigaSplittata[0].trim();		
		System.out.println(Integer.parseInt(rigaSplittata[0]));
//		for(int i = 0; i<rigaSplittata.length; i++) {
//			
//			
//			System.out.println(rigaSplittata[i] + " riga:"+i);
//			
//		}

		reader.close();

		return raccoltaDati;
	}

}
