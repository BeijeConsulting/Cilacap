package it.beije.cilacap.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Rubrica
{

	private static BufferedReader reader;

	public static void main(String[] args) throws IOException
	{
		File f = new File("csv\\rubrica4.csv"); //importazione file
		
		FileReader fileReader = new FileReader(f); //lettura file
		BufferedReader reader = new BufferedReader(fileReader); //lettura riga per riga
		
		String row = reader.readLine();
		
		String[] array = row.split(";");
		final int[] indice = new int[5];
		for (int i=0; i<array.length; i++)
		{
			if ("COGNOME".equalsIgnoreCase(array[i])) indice[0] = i;
			if ("NOME".equalsIgnoreCase(array[i])) indice[1] = i;
			if ("TELEFONO".equalsIgnoreCase(array[i])) indice[2] = i;
			if ("EMAIL".equalsIgnoreCase(array[i])) indice[3] = i;
			if ("INDIRIZZO".equalsIgnoreCase(array[i])) indice[4] = i;
		}
		row = reader.readLine();
		
		while (row != null)
		{
			array = row.split(";");
			if (indice[0] < array.length) System.out.println("Cognome: "+ array[indice[0]]);
			if (indice[1] < array.length) System.out.println("Nome: " + array[indice[1]]);
			if (indice[2] < array.length) System.out.println("Telefono: " + array[indice[2]]);
			if (indice[3] < array.length) System.out.println("Email: " + array[indice[3]]);
			if (indice[4] < array.length) System.out.println("Indirizzo: " + array[indice[4]]);
			System.out.println('\n');
			
			row = reader.readLine();
		}

	}

}
