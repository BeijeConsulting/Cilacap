package it.beije.cilacap.esercizi.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsercizioRubrica4 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {

		BufferedReader readerRubrica4 = new BufferedReader(new FileReader(new File("csv/rubrica4.csv")));
		String rowRubrica4 = readerRubrica4.readLine();

//		[EMAIL, COGNOME, NOME, TELEFONO, INDIRIZZO]
		while ((rowRubrica4 = readerRubrica4.readLine()) != null) {

			String[] array = rowRubrica4.split(";");
			System.out.println("nome: " + array[2]);
			System.out.println("cognome: " + array[1]);
			System.out.println("email: " + array[0]);
			System.out.println("telefono: " + array[3]);
			System.out.println("indirizzo: " + array[4]);
			System.out.println(" ");
			System.out.println();

		}
	}

}
