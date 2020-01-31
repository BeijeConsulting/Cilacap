package it.beije.cilacap;

import java.util.*;

public class EsScritturaFile {
	
	static String[] Credenziali = {"Nome", "Cognome", "Telefono", "Email", "Indirizzo"};
	static String[] CredenzialiLette = new String[5];
	static Scanner input = new Scanner (System.in);
	static 	boolean scriviAncora = true;
	
	public static void main(String[] args) {
	int count = 0;
	
	while(scriviAncora) {
		if(count == 0) {
			LeggiDaConsole();
			ScritturaCredenziali();
			ScritturaCredenzialiLette();
			ScriviAncora();
			count++;
		} else if (scriviAncora == true){
			LeggiDaConsole();
			ScritturaCredenzialiLette();
			ScriviAncora();
		}
	}
}
	
	public static void LeggiDaConsole() {
		
		for(int i = 0; i < Credenziali.length; i++) {
		System.out.println("Inserisci " + Credenziali[i]);
		CredenzialiLette[i] = input.nextLine();
		}
	}
	
	public static void ScritturaCredenziali() {
		
		for(int i = 0; i < Credenziali.length; i++) {
			
			if(i == (Credenziali.length - 1)) {
				System.out.println(Credenziali[i].toUpperCase());
			} else {
				System.out.print(Credenziali[i].toUpperCase() + ";");
			}
		}
	}
	
	public static void ScritturaCredenzialiLette() {
		
		for(int i = 0; i < Credenziali.length; i++) {
			
			if(i == (Credenziali.length - 1)) {
				System.out.println(CredenzialiLette[i]);
			} else {
				System.out.print(CredenzialiLette[i] + ";");
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
}
