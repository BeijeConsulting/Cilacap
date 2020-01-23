package it.beije.cilacap.es_salva_rubrica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SalvaRubricaMain {
	
	private static final String[] intestazioneDesiderata = {"cognome", "nome", "telefono", "email"};
	private static Scanner scan = new Scanner(System.in);
	private static StringBuilder content;
	
	public static void main(String[] args) throws IOException {
		File f = new File("Rubrica.txt");
		if(f.exists()) {
			System.out.println("file già esistente, aggiungere i contatti alla rubrica esistente? (S/N)");
			if(scan.next().equalsIgnoreCase("s")) {
				aggiungiContattoEsistente(f);
				return;
			}
		}
		content = new StringBuilder();
		for(String s : intestazioneDesiderata) {
			content.append(s+";");
		}
		content.append("\n");
		aggiungiContatto(f);
	}
	
	private static void aggiungiContattoEsistente(File f) throws IOException {
		content = new StringBuilder();
		FileReader fileReader = new FileReader(f);
		int c;
		while((c=fileReader.read())>-1) content.append((char) c);
		fileReader.close();
		for(String intestazione : intestazioneDesiderata) {
			System.out.println("inserisci i dati del campo "+intestazione);
			content.append(scan.next()+";");
		}
		content.append("\n");
		System.out.println("Vuoi aggiungere un altro campo?(S/N)");
		if(scan.next().equalsIgnoreCase("S")) aggiungiContattoEsistente(f);
		else {
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(content.toString());
			bw.flush();
			bw.close();
			scan.close();
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
