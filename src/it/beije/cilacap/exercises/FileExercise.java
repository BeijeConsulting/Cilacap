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
		String otherRows;
		
		//Separating the first line of the list
		
		firstRow = reader.readLine();
		String[] fields = firstRow.split(";");
		for(int i = 0; i <=fields.length-1; i++) {
			
			System.out.println(fields[i]);
		}
		
		System.out.println("");
		
		//Separating the rest of the lines
	
		while ((otherRows = reader.readLine()) != null) {
			
			String[] array = otherRows.split(";");
			
			for(int i = 0; i <=array.length-1; i++) {
				System.out.println(array[i]);
			}
		}
		
	}
			
}
				
			




