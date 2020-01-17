package it.beije.cilacap.exercises;

import java.util.ArrayList;


public class FibonacciAL {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Integer> numbers2 = new ArrayList<>();
		
		int n = 10;
		int store;
		int store2;
		
		
		
		for (int k = 0; k <= n; k++) {
			if (k == 0 || k == 1) {
				numbers.add(1);
				//System.out.print(numbers + " " + numbers2);
				//System.out.println(" ");
			}
			else {
				store = numbers.get(k-1) + numbers.get(k-2);
				numbers.add(store);
				
				//System.out.print(numbers + " " + numbers2);
				//System.out.println(" ");
			}
		}
			
		for (int p = n; p >=0; p-- ) {
			store2 = numbers.get(p);
			numbers2.add(store2);
			
		}
		
		//System.out.print(numbers2 + " ");
		
			
		for (int k=0; k<=n; k++) {
			int count = 0;
			int f = k;
			int count2 = n - k;
			
			
			while (count <= k) {
			System.out.print(numbers.get(count) + " ");
			count++;
			}
			
			System.out.print(" ");
			
			while (count2 >= 0) {
			System.out.print(numbers2.get(f) + " ");
			count2--;
			f++;
			}
			 
			System.out.println(" ");
			
		}
		

	}

}
