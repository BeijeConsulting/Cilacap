package it.beije.cilacap;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	private ArrayList<Integer> array = new ArrayList<Integer>();

	public ArrayList<Integer> occorrenze(int occ, int numRighe) {
		int contaR = 0;
		int size = 0;
		int somma = 0;
		ArrayList<ArrayList<Integer>> occorrenze2 = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i < occ; i++) {
			
			if (size == 0) {
				array.add(1);
				size++;
				if (contaR < numRighe) {
					System.out.println(array);
					occorrenze2.add(array);
					contaR++;
				}
			}
			array=new ArrayList<Integer>(array);
			if (size > 1) {
				somma = array.get(i - 1) + array.get(i - 2);
				array.add(somma);
				size++;
				if (contaR < numRighe) {
					occorrenze2.add(array);
					System.out.println(array);
					contaR++;

				}

			} else if (size == 1) {

				array.add(1);
				size++;
				if (contaR < numRighe) {
					System.out.println(array);
					occorrenze2.add(array);
					contaR++;
				}
			}

		}
		if (occ != 0) {
			System.out.print("\n");
			System.out.println(array);

		}
		System.out.print("\n");
		int index=occorrenze2.size()-1;
		for(int i=0;i<occorrenze2.size();i++)
		{
			if(index >=0) {
			System.out.println(occorrenze2.get(i)+"  "+occorrenze2.get(index));
			index--;}
		}
		return array;

	}

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		Fibonacci f = new Fibonacci();
		f.occorrenze(10, 10);

	}

}
