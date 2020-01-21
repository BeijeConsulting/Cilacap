package it.beije.cilacap.exercises;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class FileExercise {

	public static void main(String[] args) throws IOException {
		
		File sheet = new File("csv\rubrica1.csv");
		
		System.out.println("sheet.exists() ? "+ sheet.exists());
		System.out.println("sheet.getAbsolutePath() : "+ sheet.getAbsolutePath());
		
		FileReader fileReader = new FileReader(sheet);
		
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		
		while ((row = reader.readLine()) != null) {
			//String[] information = row.split(;);
			System.out.println(row);
		}

	}

}
