package it.beije.cilacap.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV {

	public static void main(String[] args) throws IOException {
		
		File f = new File("csv/rubrica1.csv");
		
		System.out.println("f.exists() ? " + f.exists());
		System.out.println("f.getAbsolutePath() : " + f.getAbsolutePath());

		FileReader fileReader = new FileReader(f);
		
//		int c;
//		while ((c = fileReader.read()) > -1) {
//			System.out.print((char)c);
//		}
		
//		int numeroRiga = 0;
//		StringBuilder riga = new StringBuilder();
//		int c = fileReader.read();
//		while (c > -1) {
//			char character = (char)c;
//			if (character == '\n') {
//				System.out.print(numeroRiga++ + " : " + riga.toString());
//				riga = new StringBuilder();
//			} else {
//				riga.append(character);
//			}
//			c = fileReader.read();
//		}
		
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
//			String[] array = row.split(";");
//			System.out.println("nome : " + array[0]);
//			System.out.println("cognome : " + array[1]);
//			System.out.println("telefono : " + array[2]);
//			System.out.println("email : " + array[3]);
//			System.out.println('\n');
			StringTokenizer tokenizer = new StringTokenizer(row, ";");
			System.out.println("nome : " + tokenizer.nextToken());
			System.out.println("cognome : " + tokenizer.nextToken());
			System.out.println("telefono : " + tokenizer.nextToken());
			System.out.println("email : " + tokenizer.nextToken());
			System.out.println('\n');			
		}
	}

}
