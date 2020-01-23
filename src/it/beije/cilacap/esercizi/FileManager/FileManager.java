package it.beije.cilacap.esercizi.FileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileManager {

	public FileManager() throws IOException {
		
		File f = new File("Pippo.txt");
		
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		
		FileReader fileReader = new FileReader(f);
		char c;
//		while ((c = (char)fileReader.read()) > -1) {
//			System.out.println((char)c);
//		}
		
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while ((row= reader.readLine()) != null)
			System.out.println(row);
			String [] array = row.split(";");
			StringTokenizer tokenizer = new StringTokenizer(row, ";");
	}
}
