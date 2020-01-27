package it.beije.cilacap.rubrica.oldExercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsercizioRubrica3 {

	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException {
		
//		[INDIRIZZO, TELEFONO, EMAIL, COGNOME, NOME]
		BufferedReader readerRubrica3 = new BufferedReader(new FileReader(new File("csv/rubrica3.csv")));
		String rowRubrica3 = readerRubrica3.readLine();
		
		while ((rowRubrica3 = readerRubrica3.readLine()) != null) {

			String[] array = rowRubrica3.split(";");
			System.out.println("nome: " + array[4]);
			System.out.println("cognome: " + array[3]);
			System.out.println("email: " + array[2]);
			System.out.println("telefono: " + array[1]);
			System.out.println("indirizzo: " + array[0]);
			System.out.println();

		}


	}

}
