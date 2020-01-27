package it.beije.cilacap.crystal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CrystalTest {

	public static void main(String[] args) throws Exception {

		File file = new File("crystal/01/CDM_20200102131948.txt");
		List<TestData> raccoltaDati = importData(file);
		System.out.println(raccoltaDati);

	}

	private static List<TestData> importData(String filePath) throws Exception {
		File file = new File(filePath);
		return importData(file);
	}

	@SuppressWarnings("unused")
	private static List<TestData> importData(File file) throws Exception {

		List<TestData> raccoltaDati = new ArrayList<TestData>();
		TestData dato = new TestData();
		TestRow testRowSequential = new TestRow();
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row = "";
		StringBuilder builder = new StringBuilder();				

		row = leggiRighe(3, reader);
		String array[] = row.split(" ");
//		builder.append(array[1]).append(array[2]);
		String needBean = array[1].concat(array[2]);
		dato.setVersion(needBean); 							//preso Version		
		row = leggiRighe(14, reader);						//sezione [Read]
		System.out.println(row);
		array = row.split(" ");
		System.out.println(array.length);
	
//		builder.append(array[0]);
//		System.out.println(builder);
		
		reader.close();

		return raccoltaDati;
	}

	
	private static String leggiRighe(int times, BufferedReader reader) throws Exception {
		String row = "";
		for (int i = 0; i < times; i++) {
			row = reader.readLine();
		}
		return row;
	}

}
