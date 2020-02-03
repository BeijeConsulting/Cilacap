package it.beije.cilacap;

import java.util.*;
import java.io.*;

public class EsScritturaFile{
	
	static String[] Credenziali = {"Nome", "Cognome", "Telefono", "Email", "Indirizzo"};
	static String[] CredenzialiLette = new String[5];
	static Scanner input = new Scanner (System.in);
	static 	boolean scriviAncora = true;
	static String path = null;
	
	public static void main(String[] args) throws IOException {
	int count = 0;
	CreaFile();
	File file = new File(path);
	FileWriter fw = new FileWriter(file);
	BufferedWriter bw = new BufferedWriter(fw);
	
	while(scriviAncora) {
		if(count == 0) {
			LeggiDaConsole();
			ScritturaCredenziali(bw);
			ScritturaCredenzialiLette(bw);
			ScriviAncora();
			count++;
		} else if (scriviAncora == true){
			LeggiDaConsole();
			ScritturaCredenzialiLette(bw);
			ScriviAncora();
		}
	}
	bw.flush();
	bw.close();
}
	
	public static void LeggiDaConsole() {
		
		for(int i = 0; i < Credenziali.length; i++) {
		System.out.println("Inserisci " + Credenziali[i]);
		CredenzialiLette[i] = input.nextLine();
		}
	}
	
	public static void ScritturaCredenziali(BufferedWriter bw) throws IOException {
		
		for(int i = 0; i < Credenziali.length; i++) {
			
			if(i == (Credenziali.length - 1)) {
				System.out.println(Credenziali[i].toUpperCase());
			    bw.write(Credenziali[i].toUpperCase() + "\n");

			} else {
				System.out.print(Credenziali[i].toUpperCase() + ";");
				bw.write(Credenziali[i].toUpperCase() + ";");
			}
		}
}
	
	
	public static void ScritturaCredenzialiLette(BufferedWriter bw) throws IOException {
		
		for(int i = 0; i < Credenziali.length; i++) {
			
			if(i == (Credenziali.length - 1)) {
				System.out.println(CredenzialiLette[i]);
				bw.write(CredenzialiLette[i] + "\n");
			} else {
				System.out.print(CredenzialiLette[i] + ";");
				bw.write(CredenzialiLette[i] + ";");
			}
		}
	}
	
	public static void ScriviAncora() {
		
		boolean rimani = true;
		
		do {
			
			System.out.println("Vuoi Scrivere ancora?\tSi\tNo");
			String risposta = input.nextLine();
			
			if (risposta.equalsIgnoreCase("Si")) {
			scriviAncora = true;
			rimani = false;

			} else if (risposta.equalsIgnoreCase("No")) {
			scriviAncora = false;
			rimani = false;
			
			} else {
			rimani = true;
			}
			
		} while(rimani);
	}
	
	public static void CreaFile() {
		boolean rimani = true;

		System.out.println("Inserisci percorso file");
		path = input.nextLine();
		try {
		File file = new File(path);

		if (file.exists()) {
		System.out.println("Il file " + path + " esiste,");
		System.out.println("Vuoi sovrascrivere?\tSi\tNo");
		String risposta = input.nextLine();
		
			do {
				if(risposta.equalsIgnoreCase("Si")) {
					file.createNewFile();
					System.out.println("Il file " + path + " è stato sovrascritto correttamente");
					rimani = false;
				} else if(risposta.equalsIgnoreCase("No")) {
					rimani = false;
				} else {
					rimani = true;
				}
			} while(rimani);
			
		} else if (file.createNewFile()) {
		System.out.println("Il file " + path + " è stato creato");
		} else {
		System.out.println("Il file " + path + " non può essere creato");
		}
		
		}catch (IOException e) {
		e.printStackTrace();
		}			
	}
}
