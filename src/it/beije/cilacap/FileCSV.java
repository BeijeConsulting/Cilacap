package it.beije.cilacap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV {

	public static void main(String[] args) throws IOException {

		File f = new File("csv/rubrica4.csv");
		//File f = new File("C:/User/Desktop/pippo.txt"); //Path linux
		
		FileReader filereader = new FileReader(f);
		BufferedReader reader = new BufferedReader(filereader);
		int nome=0,cognome=0,mail=0,telefono=0,indirizzo=0;
		
	
		
//		while(row!=null) {
//			System.out.println(row);
//			row = reader.readLine();
//			String [] array = row.split(";");
//		}
		String row = reader.readLine();
		String [] array = row.split(";");
		
		for(int i=0;i<array.length;i++) {
			if(array[i].equals("NOME")) {
				nome = i;
			}
			if(array[i].equals("COGNOME")) {
				cognome = i;
			}
			if(array[i].equals("EMAIL")) {
				mail = i;
			}
			if(array[i].equals("INDIRIZZO")) {
				indirizzo = i;
			}
			if(array[i].equals("TELEFONO")) {
				telefono = i;
			}
		}
		while(row!=null) {
			row = reader.readLine();
			if(row!=null) {
			String [] array2 = row.split(";");
			String [] appoggio = new String[5];
		for(int i=0;i<array2.length;i++) {
			if(i==nome) {
				appoggio[0]=array2[i];
			}
			if(i==cognome) {
				appoggio[1]=array2[i];
			}
			if(i==telefono) {
				appoggio[2]=array2[i];
			}
			if(i==mail) {
				appoggio[3]=array2[i];
			}
			if(i==indirizzo) {
				appoggio[4]=array2[i];
			}
			
		}
		for(int i=0;i<appoggio.length;i++) {
			if(appoggio[i]!=null)
			System.out.println(appoggio[i]);
		}
		System.out.println();
}
		}
	}

	
}
