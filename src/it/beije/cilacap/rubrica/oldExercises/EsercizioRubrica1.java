package it.beije.cilacap.rubrica.oldExercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EsercizioRubrica1 {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) throws IOException {

//	File file = new File("/csv/rubrica1.csv");
//	FileReader fileReader = new FileReader(file);
//	BufferedReader reader = new BufferedReader(fileReader);
		BufferedReader readerRubrica1 = new BufferedReader(new FileReader(new File("csv/rubrica1.csv")));

		String rowRubrica1 = readerRubrica1.readLine();
		
		while ((rowRubrica1 = readerRubrica1.readLine()) != null) {

			System.out.println(rowRubrica1);
			String[] array = rowRubrica1.split(";");
			System.out.println("nome : " + array[0]);
			System.out.println("cognome : " + array[1]);
			System.out.println("telefono : " + array[2]);
			System.out.println("email : " + array[3]);
			System.out.println('\n');

		}

		
	}
}
