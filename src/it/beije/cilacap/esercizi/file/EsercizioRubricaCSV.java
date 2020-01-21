package it.beije.cilacap.esercizi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsercizioRubricaCSV {

	File f;
	FileReader fileReader;
	String [] correctOrder = {"NOME", "COGNOME", "TELEFONO", "EMAIL", "INDIRIZZO"};

	public EsercizioRubricaCSV(String fileName) throws IOException {
		f = new File(fileName);
		fileReader = new FileReader(f);
	}
	
	public void metodo() throws IOException {
		
		BufferedReader reader = new BufferedReader(fileReader);
		
		String intestazione = reader.readLine();
		String [] intestazioneSplit = intestazione.split(";"); 
	
		int [] fileOrder = new int[intestazioneSplit.length];
		
		String intestazioneCorretta = new String();
		
		for(int i = 0; i < correctOrder.length; i++) {
			for(int j = 0; j < intestazioneSplit.length; j++) {
				if(correctOrder[i].equalsIgnoreCase(intestazioneSplit[j])) {
					fileOrder[i] = j;
					
				}
			}
			intestazioneCorretta += correctOrder[i];
			if(i != correctOrder.length - 1) {
				intestazioneCorretta += ";";
			}
		}
		
		String row;
		System.out.println(intestazioneCorretta);
		// sulle righe
		while((row = reader.readLine()) != null) {
			String [] array = row.split(";");
			// sui campi
			for(int i = 0; i < correctOrder.length; i++) {
				if(fileOrder[i] < array.length) {
					System.out.print(array[fileOrder[i]]);
					if(i != correctOrder.length-1) {
						System.out.print(";");
					}
				} else {
					if(i != correctOrder.length-1) {
						System.out.print(";");
					}
				}
				
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println("*********** Rubrica 1 ********");
		EsercizioRubricaCSV myfcsv1 = new EsercizioRubricaCSV("C:\\Users\\Padawan04\\git\\Cilacap\\csv\\rubrica1.csv");
		myfcsv1.metodo();
		System.out.println("\n\n");
		
		System.out.println("*********** Rubrica 2 ********");
		EsercizioRubricaCSV myfcsv2 = new EsercizioRubricaCSV("C:\\Users\\Padawan04\\git\\Cilacap\\csv\\rubrica2.csv");
		myfcsv2.metodo();
		System.out.println("\n\n");
		
		System.out.println("*********** Rubrica 3 ********");
		EsercizioRubricaCSV myfcsv3 = new EsercizioRubricaCSV("C:\\Users\\Padawan04\\git\\Cilacap\\csv\\rubrica3.csv");
		myfcsv3.metodo();
		System.out.println("\n\n");
		
		System.out.println("*********** Rubrica 4 ********");
		EsercizioRubricaCSV myfcsv4 = new EsercizioRubricaCSV("C:\\Users\\Padawan04\\git\\Cilacap\\csv\\rubrica4.csv");
		myfcsv4.metodo();
		System.out.println("\n\n");
	}
	
}
