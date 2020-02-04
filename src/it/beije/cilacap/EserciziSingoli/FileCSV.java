package it.beije.cilacap.EserciziSingoli;

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV {
	//nome,cognome,telefono,email,indirizzo
	

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\work\\pippo.txt");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.exists());

		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row= reader.readLine()) != null) {
			//System.out.println(row);
			//String []s= row.split(";");
			//System.out.println("nome"+s[0]);
			StringTokenizer tokenizer = new StringTokenizer(row,";");
			System.out.println(tokenizer.nextToken());
			
		}

	}

}
