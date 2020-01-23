package it.beije.cilacap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV {

	public static void main(String[] args) throws IOException {

		File f = new File("C:\\work\\pippo.txt");
		// System.out.println("f.exists() ? " + f.exists()); //mi dice se il file
		// esiste già
		// System.out.println("f.getAbsolutePath() : " + f.getAbsolutePath()); //
		// ritorna il path(percorso dov'è il file) anche se non ce(ritorna quello di
		// base).

		FileReader fileReader = new FileReader(f);

//		int carattere = fileReader.read();
//		while (carattere > -1) {  //legge carattere per carattere finchè non arriva alla fine
//			System.out.println((char) carattere);
//			carattere = fileReader.read();
//
//		}

		BufferedReader reader = new BufferedReader(fileReader); // ormai si legge con BufferReader
		String row = reader.readLine();
		while (row != null) {
			System.out.println(row);
			row = reader.readLine();
			String[] array = row.split(";");
			System.out.println("nome : " + array[0]);
			System.out.println("cognome : " + array[1]);
			System.out.println("telefono : " + array[2]);
			System.out.println("email : " + array[3]);
			System.out.println("\n");
			// StringTokenizer tokenizer = new StringTokenizer(row, ";"); //stesso dello split
			
		}

	}
}
