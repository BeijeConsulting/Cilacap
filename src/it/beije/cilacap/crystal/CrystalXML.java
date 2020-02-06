package it.beije.cilacap.crystal;


import java.io.File;

import java.util.ArrayList;
import java.util.List;


import it.beije.cilacap.crystal.ReadCrystal;;

public class CrystalXML {

	public static void main(String[] args) throws Exception {

		File fileCrystal = new File("crystal/01/CDM_20200102131948.txt");
		System.out.println(fileCrystal.exists());

		List<String> contenutoCrystal = new ArrayList<String>();
		contenutoCrystal = ReadCrystal.readFileRows(fileCrystal);
		System.out.println(contenutoCrystal.toString());

		TestData datiDiCrystal = ReadCrystal.getTestData(contenutoCrystal);
		datiDiCrystal.setIdComputer(fileCrystal.getPath().substring(15, fileCrystal.getPath().length() - 4));

		ParserXML.createXML(datiDiCrystal);

	}

}