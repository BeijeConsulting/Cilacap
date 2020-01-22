package it.beije.cilacap.esercizi.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyRubrica {

	Scanner info = new Scanner(System.in);
	private static boolean exit;

	public static void main(String[] args) throws IOException {

		//		TextFileManager rubrica = new TextFileManager();
		//		File file = new File("csv/myrubrica.csv");
		//		FileWriter fileWriter = new FileWriter(file, true);
		//		BufferedWriter writer = new BufferedWriter(fileWriter);
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("csv/myrubrica.csv"), true)); //true per l'append del file

		ArrayList<String> contentRows; // [NOME, COGNOME, TELEFONO, EMAIL]

		//		writer.append(" NOME | COGNOME | TELFONO | EMAIL |").append("\n"); // intestazione file
		while (!exit) {

			contentRows = inputValues();

			for (int i = 0; i < contentRows.size(); i++) {
				writer.append(contentRows.get(i)).append(";");
			}
			writer.append("\n");
		}
		writer.flush();
		writer.close();

		//		while (!exit) {
		//			
		//			rubrica.writeFileContent(contatti, file);
		//			rubrica.writeFileContent(rubrica.readFileContent(file), file);
		//		}

		//		rubrica.readFileContent("csv/myrubrica.txt");

	}

	public static ArrayList<String> inputValues() {
		ArrayList<String> listaContatti = new ArrayList<String>();
		Scanner info = new MyRubrica().info;
		System.out.println("inserisci un contatto:");
		System.out.print("digita il nome:");
		String contatto = info.nextLine();
		listaContatti.add(contatto);
		System.out.print("\ndigita il cognome:");
		contatto = info.nextLine();
		listaContatti.add(contatto);
		System.out.print("\ndigita il telefono:");
		contatto = info.nextLine();
		listaContatti.add(contatto);
		System.out.print("\ndigita la mail:");
		contatto = info.nextLine();
		listaContatti.add(contatto);
		System.out.println("vuoi inserire altri contatti ? s/n");
		String choose = info.next();
		if (choose.equalsIgnoreCase("n")) {
			exit = true;
			return listaContatti;

		}
		return listaContatti;

	}

}
