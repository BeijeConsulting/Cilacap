package it.beije.cilacap.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Rubrica1
{

	public static void main(String[] args) throws IOException
	{
		File f = new File("csv\\rubrica2.csv");
		
		FileReader fileReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row = reader.readLine();
		while (row != null)
		{
			String[] array = row.split(";");
			System.out.println("Nome: "+ array[1]);
			System.out.println("Cognome: " + array[0]);
			System.out.println("Telefono: " + array[3]);
			System.out.println("Email: " + array[2]);
			System.out.println("Indirizzo: " + array[4]);
			System.out.println('\n');
			
			row = reader.readLine();
		}

	}

}
