package it.beije.cilacap.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyRubrica
{

	public static void main(String[] args) throws IOException
	{
		boolean continua = true; //Scrivi un file da zero o continua?
		boolean again = false; //ripetere inserimento?
		StringBuilder s = new StringBuilder(); //creo la struttura iniziale
		String append = new String(); //stringa di supporto per fare append
		if (continua == true)
		{
			List<String> righe = new ArrayList<String>(); //struttura iniziale per lettura
			File f = new File("csv\\MyRubrica.csv"); //importazione file
			righe = readContent(f); //lettura e memorizzazione in ArrayList
			setStringBuilder (s, righe);//metodo per fare append nello StringBuilder con i valori dell'ArrayList.
			
		}
		else
		{
			String stringa = primaRiga();//metodo per definire il contenuto della prima riga
			setNewValue(s, stringa); //inserisco la prima riga
		}
		do
		{
			append = insertNewValue(args); //Inserisco il contenuto delle righe
			setNewValue(s, append);
			again = askNewValue();//chiedo se l'utente vuole inseririe nuove righe
		}
		while (again);
		String content = convert(s);//metodo che mi converte il contenuto dello StringBuilder in stringa
		printContent(content);//metodo che mi memorizza il contenuto della stringa su un file CSV


	}
	
	public static String primaRiga()
	{
		String prima = "COGNOME;NOME;TELEFONO;EMAIL;INDIRIZZO";
		return prima;
	}
	
	public static void setNewValue(StringBuilder sb, String valore)
	{
		sb.append(valore);
		sb.append("\n");
	}
	
	public static String insertNewValue(String[] argomento)
	{
		StringBuilder sbInput = new StringBuilder(); //necessario per fare append() e restituire la stringa riga nel formato giusto
		
		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci il cognome:");
		String myInput = input.nextLine();
		sbInput.append(myInput);
		sbInput.append(";");
		
		System.out.println("Inserisci il nome:");
		myInput = input.nextLine();
		sbInput.append(myInput);
		sbInput.append(";");
		
		System.out.println("Inserisci il telefono:");
		myInput = input.nextLine();
		sbInput.append(myInput);
		sbInput.append(";");
		
		System.out.println("Inserisci il email:");
		myInput = input.nextLine();
		sbInput.append(myInput);
		sbInput.append(";");
		
		System.out.println("Inserisci il indirizzo:");
		myInput = input.nextLine();
		sbInput.append(myInput);
		sbInput.append(";");
		
		String contenuto = sbInput.toString();
		return contenuto;
	}
	
	public static boolean askNewValue()
	{
		boolean ancora = false; //scelta
		boolean chosen = false; //check scelta effettuata?
		while (chosen == false)
		{
			System.out.println("Vuoi inserire un nuovo campo? Y/N");
			Scanner input = new Scanner(System.in);
			String myInput = input.next();
			
			if (myInput.equalsIgnoreCase("Y"))
			{
				ancora = true;
				chosen = true;
			}
			else if (myInput.equalsIgnoreCase("N"))
			{
				ancora = false;
				chosen = true;
			}
			else
			{
				System.out.println("Scelta non valida. Riprova.");
			}

			
		}
		return ancora;	
	}
	
	public static String convert(StringBuilder sb)
	{
		String result = sb.toString();
		return result;
	}
	
	public static void printContent(String contenuto) throws IOException
	{
		FileWriter f = new FileWriter("csv\\MyRubrica.csv"); //creo un file tramite FileWriter
		f.write(contenuto); //Scrivo il contenuto di una stringa su un file
		System.out.println("File salvato.");

		f.close();
		
	}
	
	public static List<String> readContent(File file) throws IOException
	{
		List<String> rows = new ArrayList<String>(); //ciascuna riga viene memorizzata in una stringa dell'ArrayList
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		
		String row = reader.readLine();
		while (row != null)
		{
			rows.add(row);
			row = reader.readLine();
		}
		
		return rows;
	}
	
	public static void setStringBuilder (StringBuilder sb, List<String> lista)
	{
		for(int i=0; i<lista.size(); i++)
		{
			setNewValue(sb, lista.get(i));
		}
	}
}