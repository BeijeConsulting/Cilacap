package it.beije.cilacap.esercizi;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV {

	public static void main(String[] args) throws IOException {
		
		File f = new File("csv/rubrica3.csv");
		
//		System.out.println("f.exists() ? " + f.exists());
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
		String row =reader.readLine();
		String [] intestazione= row.split(";");
		int nome=0,cognome=0,email=0,telefono=0,indirizzo=0;
		int lunghezza_intestazione= intestazione.length;
		
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
		while ((row = reader.readLine()) != null) {
			//System.out.println(row);
			String[] array = row.split(";");
			String[] contatto= new String[5];
			for (int i=0; i<contatto.length;i++) {
				contatto[i]="";
			}
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
			
//			
			System.out.println("nome : " + contatto[nome]);
			System.out.println("cognome : " + contatto[cognome]);
			System.out.println("telefono : " + contatto[telefono]);
			System.out.println("email : " + contatto[email]);
			System.out.println("indirizzo:"+ contatto[indirizzo]);
			System.out.println('\n'); 
		}
	}
}

			
// Da errore, i dati vengono "mischiati":			
//			
//			StringTokenizer tokenizer = new StringTokenizer(row, ";");
//			String[] contatto= new String [lunghezza_intestazione];
//			for(int i=0; i<lunghezza_intestazione; i++) {
//				contatto[i]="";
//			}
//			for(int i=0; i < contatto.length; i++){
//				if(tokenizer.hasMoreTokens()) {
//					if (i==nome) {
//						contatto[i]=tokenizer.nextToken();
//					}
//					else if (i==cognome) {
//						contatto[i]=tokenizer.nextToken();
//					} else if (i== telefono) {
//						contatto[i]=tokenizer.nextToken();
//					} else if (i==email) {
//						contatto[i]=tokenizer.nextToken();
//					} else if(i==indirizzo) {
//						contatto[i]=tokenizer.nextToken();
//					}
//				} else 
//								
//			}
//			System.out.println("nome : " + contatto[nome]);
//			System.out.println("cognome : " + contatto[cognome]);
//			System.out.println("telefono : " + contatto[telefono]);
//			System.out.println("email : " + contatto[email]);
//			System.out.println("indirizzo:"+ contatto[indirizzo]);
//			System.out.println('\n'); 
//			
//		}
//			
//			
			
//			System.out.println("nome : " + tokenizer.nextToken());
//			System.out.println("cognome : " + tokenizer.nextToken());
//			System.out.println("telefono : " + tokenizer.nextToken());
//			System.out.println("email : " + tokenizer.nextToken());
//			System.out.println('\n');			
		



