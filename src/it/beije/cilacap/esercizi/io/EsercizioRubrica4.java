package it.beije.cilacap.esercizi.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsercizioRubrica4 {

	public static void main(String[] args) throws IOException {

		BufferedReader readerRubrica4 = new BufferedReader(new FileReader(new File("csv/rubrica4.csv")));
		String rowRubrica4 = readerRubrica4.readLine(); // per ignorare l'intestazione dal parsing tiro fuori la prima
														// riga
		
//		[EMAIL, COGNOME, NOME, TELEFONO, INDIRIZZO]
		while ((rowRubrica4 = readerRubrica4.readLine()) != null) {

			String[] rowContact = rowRubrica4.split(";", 5);
			if (rowContact.length != 5)
				break; // se l'array creato non ha 5 campi allora esco (praticamente il break avviene
						// quando la tringa letta non rispetta lo split)
			System.out.println("nome: " + rowContact[2]);
			System.out.println("cognome: " + rowContact[1]);
			System.out.println("email: " + rowContact[0]);
			System.out.println("telefono: " + rowContact[3]);
			System.out.println("indirizzo: " + rowContact[4]);
			System.out.println();

		}
		readerRubrica4.close();
	}

}
