package it.beije.cilacap.exercises;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;



public class FileExercise {

	public static void main(String[] args) throws IOException {
		
		File sheet = new File("csv/rubrica1.csv");
		
		//System.out.println("sheet.exists() ? "+ sheet.exists());
		//System.out.println("sheet.getAbsolutePath() : "+ sheet.getAbsolutePath());
		
		FileReader fileReader = new FileReader(sheet);
		
		BufferedReader reader = new BufferedReader(fileReader);
		String firstRow;
		String secondRow;
		String otherRows;
		int[] arrayIndex = new int[5];
		
  		int counterColumns;
  		int counterData;
		int j;
		
		//Separating the first line of the list and creating indexes for each column
		
		firstRow = reader.readLine();
		String[] fields = firstRow.split(";");
		for(counterColumns = 0; counterColumns <= fields.length-1; counterColumns++) {
			if (fields[counterColumns].contentEquals("NOME")) {
				arrayIndex[counterColumns] = 0;
			}
			if (fields[counterColumns].contentEquals("COGNOME")) {
				arrayIndex[counterColumns] = 1;
			}
			if (fields[counterColumns].contentEquals("TELEFONO")) {
				arrayIndex[counterColumns] = 2;
			}
			if (fields[counterColumns].contentEquals("EMAIL")) {
				arrayIndex[counterColumns] = 3;
			}
			if (fields[counterColumns].contentEquals("INDIRIZZO")) {
				arrayIndex[counterColumns] = 4;
			}
			System.out.println(fields[counterColumns]);
		}
		
		// Count number of data entrances
		
		secondRow = reader.readLine();
		String[] data = secondRow.split(";");
		for(counterData = 0; counterData <= data.length - 1; counterData++) {
			
		}
		System.out.println("");
		
		System.out.println(counterData);
		
		System.out.println("");
		
		//Separating the rest of the lines
		
		while ((otherRows = reader.readLine()) != null) {
			
			String[] arrayData = otherRows.split(";");
			
			for(j = 0; j <=arrayData.length-1; j++) {
				
				if (j <= counterColumns) {
				//arrayData[j] =  ;
				System.out.println(arrayData[j]);
				}
				
				/*
				for(j = 0; j <=arrayData.length-1; j++) {
			
				if (fields[counter].equals("NOME") {
					System.out.println("NOME: " + array[0]);
				}
				if (fields[counter].equals("COGNOME") {
					System.out.println("COGNOME: " + array[0]);
				}
				if (fields[counter].equals("TELEFONO") {
					System.out.println("TELEFONO: " + array[0]);
				}
				if (fields[counter].equals("EMAIL") {
					System.out.println("EMAIL: " + array[0]);
				}
				if (fields[counter].equals("INDIRIZZO") {
					System.out.println("INDIRIZZO: " + array[0]);
				}
				} */	
			}
			
		}
		
		/*
		
		if (array[0].equals("")) {}
		
		System.out.println("NOME: " + array[0]);
		System.out.println("COGNOME: " + array[1]);
		System.out.println("TELEFONO: " + array[2]);
		System.out.println("EMAIL: " + array[3]);
		System.out.println("INDIRIZZO: " + array[4]);
		*/
		reader.close();	
	}
		
}
				
			




