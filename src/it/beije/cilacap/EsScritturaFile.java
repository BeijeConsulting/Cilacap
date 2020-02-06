package it.beije.cilacap;

import java.util.*;
import java.io.*;

public class EsScritturaFile {

	static String[] Credenziali = { "Nome", "Cognome", "Telefono", "Email", "Indirizzo" };
	static String[] CredenzialiLette = new String[Credenziali.length];
	static ArrayList<String> CredenzialiSalvate = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	static String path = null;
	static boolean scriviAncora = true;
	static boolean skip = true;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		File file = PrendiPercorsoFile();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		GestioneFile(file, br);

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		while (scriviAncora) {
			if (count == 0) {
				LeggiDaConsole();
				ScritturaCredenziali(bw);
				ScritturaCredenzialiLette(br, bw);
				ScriviAncora();
				count++;
			} else if (scriviAncora == true) {
				LeggiDaConsole();
				ScritturaCredenzialiLette(br, bw);
				ScriviAncora();
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void LeggiDaConsole() {

		for (int i = 0; i < Credenziali.length; i++) {
			System.out.println("Inserisci " + Credenziali[i]);
			CredenzialiLette[i] = input.nextLine();
		}
	}

	public static void ScritturaCredenziali(BufferedWriter bw) throws IOException {

		for (int i = 0; i < Credenziali.length; i++) {

			if (i == (Credenziali.length - 1)) {
				System.out.println(Credenziali[i].toUpperCase());
				bw.write(Credenziali[i].toUpperCase() + "\n");

			} else {
				System.out.print(Credenziali[i].toUpperCase() + ";");
				bw.write(Credenziali[i].toUpperCase() + ";");
			}
		}
	}

	public static void ScritturaCredenzialiLette(BufferedReader br, BufferedWriter bw) throws IOException {

		if (CredenzialiSalvate.isEmpty()) {

		} else {
			for (String cursore : CredenzialiSalvate) {
				bw.write(cursore + "\n");
				System.out.println(cursore);
			}
		}

		for (int i = 0; i < Credenziali.length; i++) {

			if (i == (Credenziali.length - 1)) {
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

		} while (rimani);
	}

	public static File PrendiPercorsoFile() throws IOException {

		System.out.println("Inserisci percorso file");
		path = input.nextLine();
		File file = new File(path);

		if (file.exists()) {
			System.out.println("Il file " + path + " esiste,");
			skip = false;
		} else if (file.createNewFile()) {
			System.out.println("Il file " + path + " è stato creato");
		} else {
			System.out.println("Il file " + path + " non può essere creato");
		}

		return file;
	}

	public static void GestioneFile(File file, BufferedReader br) throws IOException {
		boolean rimani = true;

		if (skip == false) {
			if (file.exists()) {

				do {
					System.out.println("Vuoi:");
					System.out.println("1. Continuare su questo file");
					System.out.println("2. Sovrascrivere");
					String risposta = input.nextLine();

					if (risposta.equals("1")) {
						String row = br.readLine();
						count++;
						while (row != null) {
							System.out.println(row);
							CredenzialiSalvate.add(row);
							row = br.readLine();
						}

						if (CredenzialiSalvate.isEmpty()) {
							System.out.println("Stai continuando un file vuoto");
							rimani = true;
						} else {
							rimani = false;
						}

					} else if (risposta.equals("2")) {
						System.out.println("Il file " + path + " è stato sovrascritto correttamente");
						file.createNewFile();
						count = 0;
						rimani = false;
					} else {
						rimani = true;
					}
				} while (rimani);
			}
		}
	}
}
