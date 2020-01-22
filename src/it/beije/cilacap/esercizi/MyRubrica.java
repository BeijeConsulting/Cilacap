package it.beije.cilacap.esercizi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyRubrica
{

	public static void main(String[] args) throws IOException
	{
//		FileWriter f = new FileWriter("csv\\MyRubrica.csv"); //creo un file tramite FileWriter
//		String s = "Pippo";
//		f.write(s); //Scrivo il contenuto di una stringa su un file
//
//		f.close();
		
		StringBuilder s = new StringBuilder(); //creo la struttura iniziale
		String stringa = primaRiga();
		setNewValue(s, stringa); //inserisco la prima riga
		insertNewValue(args);
		
		
	}
	
	public static String primaRiga()
	{
		String prima = "COGNOME;NOME;TELEFONO;EMAIL";
		return prima;
	}
	
	public static void setNewValue(StringBuilder sb, String valore)
	{
		sb.append(valore);
		sb.append("/n");
	}
	
	public static String insertNewValue(String[] argomento)
	{
		StringBuilder sbInput = new StringBuilder(); //necessario per fare append() e restituire la stringa riga nel formato giusto
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci il cognome:");
		String myInput = input.next();
		sbInput.append(myInput);
		sbInput.append(";");
		
		System.out.println("Inserisci il nome:");
		myInput = input.next();
		sbInput.append(myInput);
		sbInput.append(";");
		
		System.out.println(sbInput);
		return myInput;
	}
}
