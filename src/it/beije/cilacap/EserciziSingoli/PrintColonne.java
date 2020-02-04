package it.beije.cilacap.EserciziSingoli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PrintColonne {

	public static void main(String[] args) throws IOException {
		File f = new File("csv/rubrica4.csv");
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		String row = reader.readLine();
		int cont = 0;
		int[] ordine = new int[5];
		while (row != null) {
			String[] array = row.split(";");

			for (int i = 0; i < array.length; i++) {

				if (array[i].equals("NOME")) {
					ordine[0] =i;

				} else if (array[i].equals("COGNOME")) {
					ordine[1] = i;

				} else if (array[i].equals("TELEFONO")) {
					ordine[2] = i;

				} else if (array[i].equals("EMAIL")) {
					ordine[3] = i;

				} else if (array[i].equals("INDIRIZZO")) {
					ordine[4] = i;

				}

			}

			if (cont >= 1) {
				if (ordine[0] < array.length)
					System.out.print(array[ordine[0]] + " ");
				if (ordine[1] < array.length)
					System.out.print(array[ordine[1]] + " " );
				if (ordine[2] < array.length)
					System.out.print(array[ordine[2]] +" ");
				if (ordine[3] < array.length)
					System.out.print(array[ordine[3]] + " " );
				if (ordine[4] < array.length) {
					System.out.print(array[ordine[4]]);
				}
				System.out.println();
			}
		    row = reader.readLine();
			cont++;
		}
		}
	
}
		
		
	

