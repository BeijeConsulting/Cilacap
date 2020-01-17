package it.beije.cilacap.esercizi;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fibonacci
{
	public static void main(String[] args)
	{
		int dim = 100; //dimensione array
		int nocc = 1; //numero occorrenze
		int nocc2 = 5; //numero occorrenze al contrario
		int riga = 1; //indica la riga di cui voglio l'occorrenza
		int[] fibonacci = new int[dim];
		fibonacci = calcolo(dim);
		//occorrenze(fibonacci, nocc);
		occorrenzedoppie(fibonacci, nocc2); //Non va
		//righe(fibonacci, riga);
		
	}
	
	public static int[] calcolo (int dimensione)
	{
		int array[] = new int[dimensione];
		array[0] = 1;
		array[1] = 1;
		for(int i=2; i<dimensione; i++) //eseguo fibonacci e salvo i valori in un array di int
		{
			array[i] = array[i-2] + array[i-1];
		}		
		return array;
	}

	public static void occorrenze(int[] array, int volte)
	{
		for (int i=0; i<volte; i++)
		{
			int cont = 0;
			while (cont < i+1)
				{
				System.out.print(array[cont] + " ");
				cont++;
				}
			System.out.println();
		}
	}
	
	public static void righe (int[] array, int numriga)
	{
		for(int i=0; i<numriga+1; i++)
		{
			System.out.print(array[i] + " ");
		}
		
	}
	
	public static void occorrenzedoppie(int[] array, int volte)
	{
		for (int i=0; i<volte; i++)
		{
			int cont = 0;
			int cont2 = i+1;
			while (cont < i+1)
			{
				System.out.print(array[cont] + " ");
				cont++;
			}
			System.out.println();
		}
	}
}
