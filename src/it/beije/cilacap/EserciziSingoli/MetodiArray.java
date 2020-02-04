package it.beije.cilacap.EserciziSingoli;

import java.util.ArrayList;

public class MetodiArray {
	static int mySearching(int array[], int e) {
		array = new int[10];
		System.out.println("Stampo Array");
		for (int i = 0; i < array.length; i++) {
			int x = (int) (Math.random() * 10);
			array[i] = x;
			System.out.print(array[i] + " ");
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == e) {

				i = array.length;
				System.out.println("numero trovato ");

			} else if (array.length - 1 == i) {
				System.out.println("Mi spiace ma non ho trovato nessun numero presente nell'array");

			}

		}
		return e;
	}

	public static void main(String[] args) {
		int array[] = new int[10];
		System.out.println(mySearching(array, 2));
		ArrayList<Integer> intero=new ArrayList<>(10);
		for(int i=0;i<intero.size();i++) {
			
		}

	}

}
