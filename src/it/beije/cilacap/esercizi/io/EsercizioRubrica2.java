package it.beije.cilacap.esercizi.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsercizioRubrica2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		BufferedReader readerRubrica2 = new BufferedReader(new FileReader(new File("csv/rubrica2.csv")));
		String rowRubrica2 = readerRubrica2.readLine();
		rowRubrica2 = readerRubrica2.readLine();
//		{"COGNOME", "NOME", "EMAIL", "TELEFONO", "INDIRIZZO"};

		while ((rowRubrica2 = readerRubrica2.readLine()) != null) {

			String[] array = rowRubrica2.split(";");
			System.out.println("nome: " + array[1]);
			System.out.println("cognome: " + array[0]);
			System.out.println("email: " + array[2]);
			System.out.println("telefono: " + array[3]);
			System.out.println("indirizzo: " + array[4]);
			System.out.println();

		}

	}

}
