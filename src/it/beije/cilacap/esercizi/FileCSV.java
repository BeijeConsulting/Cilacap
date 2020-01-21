package it.beije.cilacap.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCSV
{

	public static void main(String[] args) throws IOException
	{
		File f = new File("C:\\work\\Pippo.txt");
		System.out.println(f.exists());

		FileReader fileReader = new FileReader(f); //Mi mette a disposizione una serie di metodi per leggere il file
		
		BufferedReader reader = new BufferedReader(fileReader); //Metodi più utili in questo caso per la lettura della riga
		String row = reader.readLine();
		while (row != null)
		{
//			System.out.println(row);
//			row = reader.readLine(); //Probabilmente metodo migliore perché posso riusare l'array
//			String[] array = row.split(";");
//			System.out.println("nome:" + array[0]);
//			System.out.println("cognome:" + array[1]);
//			System.out.println("telefono:" + array[2]);
//			System.out.println("email:" + array[3]);

			StringTokenizer tokenizer = new StringTokenizer(row, ";");
			String[] array = row.split(";");
			System.out.println("nome:" + tokenizer.nextToken());
			System.out.println("cognome:" + tokenizer.nextToken());
			System.out.println("telefono:" + tokenizer.nextToken());
			System.out.println("email:" + tokenizer.nextToken());
			System.out.println('\n');

		}
	}

}
