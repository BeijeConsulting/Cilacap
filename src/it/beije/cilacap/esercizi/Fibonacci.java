package it.beije.cilacap.esercizi;

public class Fibonacci
{
	public static void main(String[] args)
	{
		int dim = 100; //dimensione array
		int nocc = 10; //numero occorrenze
		int righe = 20;
		int[] fibonacci = new int[dim];
		fibonacci = calcolo(dim);
		occorrenze(fibonacci, nocc);
		
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
	
}
