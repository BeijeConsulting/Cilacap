package it.beije.cilacap.es_salva_rubrica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SalvaRubricaMain {
	
	private static final String[] intestazioneDesiderata = {"cognome", "nome", "telefono", "email"};
	private static Scanner scan = new Scanner(System.in);
	private static final StringBuilder content = new StringBuilder();
	
	public static void main(String[] args) {
		
		File f = new File("Rubrica.txt");
		if(f.exists()) {
			System.out.println("file già esistente, sovrascrivere? (S/N)");
			if(scan.next().equalsIgnoreCase("N")) return;
		}
		for(String s : intestazioneDesiderata) {
			content.append(s+";");
		}
		content.append("\n");
		try {
			aggiungiContatto(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Si è verificato un errore");
		}
	}
	
	private static void aggiungiContatto(File f) throws IOException {
		for(String intestazione : intestazioneDesiderata) {
			System.out.println("inserisci i dati del campo "+intestazione);
			content.append(scan.next()+";");
		}
		content.append("\n");
		System.out.println("Vuoi aggiungere n altro campo?(S/N)");
		if(scan.next().equalsIgnoreCase("S")) aggiungiContatto(f);
		else {
			FileWriter fw = new FileWriter(f);
			fw.write(content.toString());
			scan.close();
			fw.close();
		}
	}

}
