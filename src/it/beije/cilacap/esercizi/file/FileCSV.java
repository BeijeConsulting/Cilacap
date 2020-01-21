package it.beije.cilacap.esercizi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV {
	
	public static void main(String[] args) throws IOException {
		
		// è solo una rappresentazione di un file che potrebbe non esistere su disco
		File f = new File("C:\\Users\\Padawan04\\Desktop\\pippo.txt");
		//File f = new File("C:/User/Desktop/pippo.txt"); //path linux ora anche su windows
		
		//System.out.println(f.exists());
		//System.out.println(f.getAbsolutePath());
		
		FileReader fileReader = new FileReader(f);
		
//		int c;
//		while((c = fileReader.read()) > -1) { 
//			System.out.println((char)c);
//		}
		
		
		// OLD STYLE
//		int numeroRiga = 0;
//		int c = fileReader.read();
//		StringBuilder riga = new StringBuilder();
//		while(c > -1) {
//			riga.append((char)c);
//			if(((char)c) == '\n') {
//				System.out.print(numeroRiga++ + " : " + riga.toString());
//				riga = new StringBuilder();
//			} else {
//				riga.append((char)c);
//			}
//			c = fileReader.read();
//		}
		
		
		BufferedReader reader = new BufferedReader(fileReader);
		String row;
		while((row = reader.readLine()) != null) {
			//System.out.println(row);
			String[] array = row.split(";");
			System.out.println("Nome: " + array[0]);
			System.out.println("Cognome: " + array[1]);
			System.out.println("Numero: " + array[2]);
			System.out.println("Email: " + array[3]);
			System.out.println();
			System.out.println("***********************");
			

			StringTokenizer tokenizer = new StringTokenizer(row, ";");
			System.out.println("Nome: " + tokenizer.nextToken());
			System.out.println("Cognome: " + tokenizer.nextToken());
			System.out.println("Numero: " + tokenizer.nextToken());
			System.out.println("Email: " + tokenizer.nextToken());
			System.out.println();
			System.out.println("***********************");
		}
		
	}

}
