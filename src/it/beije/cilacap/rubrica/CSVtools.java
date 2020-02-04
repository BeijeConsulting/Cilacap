package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVtools {
	
	public static List<Contatto> readCSVFile(String pathFile) throws Exception {
		
		File sheet = new File(pathFile); // import the file
		
		FileReader fileReader = new FileReader(sheet); // read the file
		
		BufferedReader reader = new BufferedReader(fileReader); // 	read the file line per line

		
		List<Contatto> contacts = new ArrayList<Contatto>();
		String row = reader.readLine();
		String[] fields = row.split(";");
		final int[] arrayIndex = new int[5];
  		int counterColumns;       // Variable to count number of columns in the first line
  		
		//Creating indexes for each column
		
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
		
		// Organization of the data according to the columns
		
		row = reader.readLine();
		
		while (row != null) {
			
			Contatto data = new Contatto();
			
			fields = row.split(";"); //Divide row 
				
			if (arrayIndex[0] < fields.length) {
				data.setNome(fields[arrayIndex[0]]);
				
			}
			if (arrayIndex[1] < fields.length) {
				data.setCognome(fields[arrayIndex[1]]);
			}
			if (arrayIndex[2] < fields.length) {
				data.setTelefono(fields[arrayIndex[2]]);
			}
			if (arrayIndex[3] < fields.length) {
				data.setEmail(fields[arrayIndex[3]]);
			}
			
			contacts.add(data);
				
			row = reader.readLine();
		}
		
		reader.close();	
		
		return contacts;
	}

	public static void writeCSVFile(List<Contatto> listaContatti, String pathFile) throws IOException {
		
		File file = new File(pathFile);
		FileWriter fileWriter = new FileWriter(file);
		
		fileWriter.write("NOME;COGNOME;TELEFONO;EMAIL;\n");
		
		for (Contatto contacts : listaContatti) {		
			fileWriter.write(contacts.getNome() + ";");
			fileWriter.write(contacts.getCognome() + ";");
			fileWriter.write(contacts.getTelefono() + ";");
			fileWriter.write(contacts.getEmail() + ";");
			fileWriter.write("\n");
		}

		fileWriter.flush();
		fileWriter.close();
		
		System.out.println("File Saved");
	}
}
