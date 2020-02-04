package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Crystal {
	
	public static void readCSVFile(List<Contatto> contacts, String pathFile) throws Exception {
		
		File sheet = new File(pathFile); // import the file
		
		FileReader fileReader = new FileReader(sheet); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line

		
		String row = reader.readLine();
		String[] fields = row.split(" ");
		final int[] arrayIndex = new int[5];
  		int counterColumns;       // Variable to count number of columns in the first line
  		
		//Creating indexes for each column
		
		for(counterColumns = 0; counterColumns <= fields.length-1; counterColumns++) {
			
			if (fields[counterColumns].contentEquals("NOME")) {
				arrayIndex[0] = counterColumns;
		
			}
		}
	}

	public static void main(String[] args) {
		

	}

}
