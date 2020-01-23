package it.beije.cilacap.esercizi;

import java.io.BufferedReader;
import java.io.File;
import  java.io.FileReader;
import java.io.IOException;

public class EsercizioFileCSV {
	
	public static void main (String [] args) throws IOException {
		//inizio soluzione esercizio 
		File f = new File("csv/rubrica1.csv");
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		String row =reader.readLine();
		
		//Creazione array di stringhe solo dell'intestazione presente nel file
		String [] intestazione= row.split(";");
		
		//inizializzione indici per la ricerca della posizione dei campi
		int nome=0,cognome=0,email=0,telefono=0,indirizzo=0;
		
		int lunghezza_intestazione= intestazione.length;
		//ricerca della posizione dei campi
		for(int i=0; i<intestazione.length; i++){
			String campo= intestazione[i].toLowerCase();
			switch(campo) {
			case "nome": nome=i; break;
			case "cognome": cognome=i; break;
			case"email": email= i; break;
			case "telefono": telefono=i; break;
			case "indirizzo": indirizzo=i; break;
			default: break;
			}
		}
		//inizio stampa 
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
			
			//creazione array con i dati del contatto
			String[] array = row.split(";");
			
			//creazione array vuoto (d'appoggio) per inserimento dei dati da stampare, e evitare il OutOfBound Exception
			String[] contatto= new String[5];
			for (int i=0; i<contatto.length;i++) {
				contatto[i]="";
			}
			//trasferimento dei dati nell'array contatti
			for(int i=0; i<array.length; i++) {
				if (i==nome) {
						contatto[i]=array[i];
					}
					else if (i==cognome) {
						contatto[i]=array[i];
					} else if (i== telefono) {
						contatto[i]=array[i];
					} else if (i==email) {
						contatto[i]=array[i];
					} else if(i==indirizzo) {
						contatto[i]=array[i];
					}
					
				}
			
			//stampa dei dati del contatto
			System.out.println("nome : " + contatto[nome]);
			System.out.println("cognome : " + contatto[cognome]);
			System.out.println("telefono : " + contatto[telefono]);
			System.out.println("email : " + contatto[email]);
			System.out.println("indirizzo:"+ contatto[indirizzo]);
			System.out.println('\n'); 

		}
	}

}
