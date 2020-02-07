package it.beije.cilacap.crystal;

import java.io.File;
import java.util.List;

import it.beije.cilacap.rubrica.Utility;


public class CrystalParsingRunner {

	public static void main(String[] args) throws Exception {
		//-- [esporta più test in un singolo file XML] --
		//		File file = new File("crystal/01/CDM_20200102145818.txt");
		//		TestData test = Utility.importTestDataFromFile(file);
		//		File file2 = new File("crystal/01/CDM_20200102151619.txt");
		//		TestData test2 = Utility.importTestDataFromFile(file2);
		//		List<TestData> tests = new ArrayList<TestData>();
		//		tests.add(test);
		//		tests.add(test2);
		//		Utility.esportaTestDataInXML(tests, Utility.choosePath(true));
		
		//-- [importa i test presenti in xml e preleva il Bean TestData.] --
		File file = new File("crystal/crystaldata.xml");
		List<TestData> listaTests = Utility.importaTestDaXML(file);
		System.out.println(listaTests);
		
		
	}


}
