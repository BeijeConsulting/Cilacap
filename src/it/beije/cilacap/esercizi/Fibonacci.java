package it.beije.cilacap.esercizi;

import java.util.ArrayList;

public class Fibonacci {

	public ArrayList<Integer> algorithm(int dimension) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		Integer element = new Integer(0);
		for (int i = 2; i < dimension; i++) {
			element = list.get(i - 2) + list.get(i - 1);
			list.add(i, element);
		}
		return list;

	}

	public void occorrenza(ArrayList<Integer> list, int dimension) {

		for (int i = 0; i < dimension; i++) {

			System.out.print(list.get(i) + " ");
		}

	}

	private void occorrenzaInversa(ArrayList<Integer> list, int dimension) {

		for (int i = dimension - 1; i >= 0; i--) {

			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}

	public void stringa(ArrayList<Integer> list, int dimension) {
		int i = 1, j = 0;
		while (i <= dimension) {
			this.occorrenza(list, i);
			System.out.print("   ");
			this.occorrenzaInversa(list, dimension - j);
			i++;
			j++;
		}

	}



	/*
	 * 1 3 2 1 1 1 1 2 1 1 1 1 2 1 1 1 1 2 3 1
	 */

}
