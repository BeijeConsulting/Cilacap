package it.beije.cilacap.exercises;

import java.util.ArrayList;


public class FibonacciAL {
	
	
	static void Fibo(int lines) {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Integer> numbers2 = new ArrayList<>();
		
		int n = lines;
		int store;        //Variable to store values in the first ArrayList
		int store2;       //Variable to store values in the second ArrayList
			
		for (int k = 0; k <= n; k++) {
			if (k == 0 || k == 1) {
				numbers.add(1);
			}
			else {
				store = numbers.get(k-1) + numbers.get(k-2);
				numbers.add(store);
			}
		}
			
		for (int p = n; p >=0; p-- ) {
			store2 = numbers.get(p);
			numbers2.add(store2);
		}
		
		for (int k=0; k<=n; k++) {
			int count = 0;
			int index = k;
			int count2 = n - k;
			
			while (count <= k) {
				System.out.print(numbers.get(count) + " ");
				count++;
			}
			
			System.out.print(" ");
			
			while (count2 >= 0) {
				System.out.print(numbers2.get(index) + " ");
				count2--;
				index++;
			}
			
			System.out.println(" ");
			
		}
	}


	public static void main(String[] args) {
		Fibo(5);
	}	
}
