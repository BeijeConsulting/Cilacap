package it.beije.cilacap.esercizi.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class FileCSVMio {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
//		File newFile = new File("C:\\temp\\pippo.txt"); 
//		File newFile1 = new File("C:/temp/pippo.txt");
//		System.out.println(newFile.exists()); //false
//		System.out.println(newFile1.exists()); //false
//		System.out.println(newFile.getAbsolutePath()); //dove si trova il file
//		System.out.println(newFile.getAbsolutePath());

		// leggere i File
		File f = new File("C:\\temp\\prova.txt");
		FileReader fr = new FileReader(f);
//		int numeroRiga = 0;
//		int c = fr.read();
//		StringBuilder riga = new StringBuilder();

//		while (c > -1) {
//			char character = (char) c;
//			
//			if (character == '\n') {
//				System.out.println(++numeroRiga + " : " + riga.toString());
//				riga = new StringBuilder();
//			} else {
//				riga.append(character);
//			}
//			c = fr.read();
//		}
//		METODO MIGLIORE pr leggere un file di testo

//		MODO 1
//		BufferedReader bf = new BufferedReader(fr); // la cosa comosa è che ci da readLine
//		String row = bf.readLine();
//		while (row != null) {
//			System.out.println(row);
//			row = bf.readLine();
//		}
//		MODO 2
//		BufferedReader bf = new BufferedReader(fr); // la cosa comosa è che ci da readLine
//		String row;
//		while ((row = bf.readLine())!= null) {
//			System.out.println(row);
//		}
		// metodi da studiare split e tokenizer

		// SPLIT
//		BufferedReader bf1 = new BufferedReader(fr); // la cosa comoda è che ci da readLine
//		String rowSplit;
//		while ((rowSplit = bf1.readLine())!= null) {
//			System.out.println(rowSplit);
//			String[] array = rowSplit.split(";"); 
//			System.out.println("nome : " + array[0]);
//			System.out.println("cognome: " + array[1]);
//			System.out.println("telefono: " + array[2]);
//			System.out.println("email: " + array[3]);
//			System.out.println("\n");

//		}
		// TOKENIZER
		BufferedReader bf2 = new BufferedReader(fr);
		String rowToken;
		while ((rowToken = bf2.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(rowToken, ";");
			System.out.println("nome : " + tokenizer.nextToken());
			System.out.println("cognome: " + tokenizer.nextToken());
			System.out.println("telefono: " + tokenizer.nextToken());
			System.out.println("email: " + tokenizer.nextToken());
			System.out.println("\n");
		}
	}
}
