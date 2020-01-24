package it.beije.cilacap.exercises;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileExercise {

	public static void main(String[] args) throws IOException {
		
		File sheet = new File("csv/rubrica4.csv"); // import the file
		
		//System.out.println("sheet.exists() ? "+ sheet.exists());
		//System.out.println("sheet.getAbsolutePath() : "+ sheet.getAbsolutePath());
		
		FileReader fileReader = new FileReader(sheet); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line
		
		
		String row = reader.readLine();
		String[] fields = row.split(";");
		final int[] arrayIndex = new int[5];
  		int counterColumns;       // Variable to count number of columns in the first line
  		
		
		//Creating indexes for each column
		
		//row = reader.readLine();
	
		for(counterColumns = 0; counterColumns <= fields.length-1; counterColumns++) {
			
			if (fields[counterColumns].contentEquals("NOME")) {
				arrayIndex[0] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("COGNOME")) {
				arrayIndex[1] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("TELEFONO")) {
				arrayIndex[2] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("EMAIL")) {
				arrayIndex[3] = counterColumns;
			}
			if (fields[counterColumns].contentEquals("INDIRIZZO")) {
				arrayIndex[4] = counterColumns;
			}
			
		}
		
		row = reader.readLine();
		
		while (row != null) {
			
			fields = row.split(";");
				
				if (arrayIndex[0] < fields.length) {
					System.out.println("Nome: " + fields[arrayIndex[0]]);
				}
				if (arrayIndex[1] < fields.length) {
					System.out.println("Cognome: " + fields[arrayIndex[1]]);
				}
				if (arrayIndex[2] < fields.length) {
					System.out.println("Telefono: " + fields[arrayIndex[2]]);
				}
				if (arrayIndex[3] < fields.length) {
					System.out.println("Email: " + fields[arrayIndex[3]]);
				}
				if (arrayIndex[4] < fields.length) {
					System.out.println("Indirizzo: " + fields[arrayIndex[4]]);
				}
				
			row = reader.readLine();
			}
		
		reader.close();	
	}
		
}
				
			




