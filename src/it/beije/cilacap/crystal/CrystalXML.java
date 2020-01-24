package it.beije.cilacap.crystal;

import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrystalXML {
	
	public static List<String> readFileRows(String filePath) throws IOException {
		File file = new File(filePath);
		
		return readFileRows(file);
	}

	public static List<String> readFileRows(File file) throws IOException {
		List<String> rows = new ArrayList<String>();
		
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
			rows.add(row);
		}
		
		System.out.println("rows size : " + rows.size());
		return rows;
	}
	
	static int i;

	public static void  createListOfData(List <String> contenuto) {
		TestData info= new TestData();
		String[] dati= new String[contenuto.size()];
		dati=contenuto.toArray(dati).sp;
	
		for(; i<dati.length;i++) {
			System.out.println("nel for di createdListOfData");
			String [] riga= dati[i].split("\n");
			
			for(int j=0; j<riga.length; j++) {
				System.out.println("nel for di createdList colonna");
				System.out.println(riga[j]);
				String colonna= riga[j].trim();
				System.out.println(colonna);
				switch(colonna) {
				case "Profile:": 
					takeProfileFieldData(info,j, dati);
					break;
				case "[Read]":
					takeReadFieldData(info,j, dati);
					break;
				case "[Write]":
					takeWriteFieldData(info, j, dati);
					break;	
				default:break;
				}
			}
		}
	}
	
	//CE 20200124: metodo per estrapolare i dati nel campo profile default
	public static void takeProfileFieldData(TestData info, int col, String [] dati) {
		for (;i<dati.length;i++) {
			System.out.println("nel for di takeprofile field");
			String [] riga= dati[i].split(" ");
			for(;col<riga.length;col++) {
				String colonna= riga[col].trim();
				switch(colonna) {
				case "Test:": 
					info.setType(riga[col+1]+riga[col+2]);
					System.out.println(info.getType());
					break;
				case "Date:": break;
				case "OS:": break;
				}
			}
		}
		
	}
	public static void takeReadFieldData(TestData info, int colonna, String[] data) {
		
	}
	
	public static void takeWriteFieldData(TestData info,  int colonna, String[] data) {
			
		}
	public static void main (String [] args) throws Exception {
			
			File fileCrystal= new File("crystal/01/CDM_20200102131948.txt");
			System.out.println(fileCrystal.exists());
			List <String> contenutoCrystal = new ArrayList<String>();
			contenutoCrystal=readFileRows(fileCrystal);
			System.out.println(contenutoCrystal.toString());
			createListOfData(contenutoCrystal);
	}

}
