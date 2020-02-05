package it.beije.cilacap.esercizi.CSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSVesempi {

	public static void main(String[] args) throws IOException {
		File f = new File("C:/temp/prova.txt");
		System.out.println("f.exixst()? " + f.exists());
		System.out.println("f.getAbsolutePath()? " + f.getAbsolutePath());
		
		FileReader fileReader = new FileReader(f);
//		int c;
//		while((c=fileReader.read())>-1) {
//			System.out.print((char)c);
//		int numeroRiga =0;
//		int c= fileReader.read();
//		StringBuilder riga= new StringBuilder();
//		while(c>-1) {
//			riga.append((char)c);
//			if(((char)c)=='\n') {
//			System.out.print(numeroRiga++ + ":" + riga.toString());
//			riga=new StringBuilder();
//		}
//			c=fileReader.read();
//			}
		
		
//		BufferedReader reader= new BufferedReader(fileReader);
//		String row =reader.readLine();
//		while(row!=null) {
//			System.out.println(row);
//			row=reader.readLine();
//			String[] array = row.split(";");
			
//		}
		
		BufferedReader reader= new BufferedReader(fileReader);
		String row =reader.readLine();
	
		while(row!=null) {
			String[] array = row.split(";");
			System.out.println("nome: " + array[0]);
			System.out.println("cognome: " + array[1]);
			System.out.println("telefono: " + array[2]);
			System.out.println("email: " + array[3]);
			System.out.println('\n');
			}
			
			
			
//			StringTokenizer tokenizer = new StringTokenizer(row,";");
//			System.out.println("nome :" + tokenizer.nextToken());
//			System.out.println("cognome : " + tokenizer.nextToken());
//			System.out.println("telefono : " + tokenizer.nextToken());
//			System.out.println("email : " + tokenizer.nextToken());
//			System.out.println('\n');
		
		
		
		
		reader.close();
		
		

	}
}
