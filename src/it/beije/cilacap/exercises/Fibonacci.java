package it.beije.cilacap.exercises;

public class Fibonacci {
	
	public static void main(String[] args) {

		int n = 5;
		int[] numbers = new int[10];
		numbers[0] = 1;
		numbers[1] = 1;
	
		for (int i = 2; i <= n; i++) {
		
			numbers[i] = numbers[i-1] + numbers[i-2];
		
		}
		
		
	
		for (int j = 0; j < n; j++) {
	
			//System.out.print(numbers[j] + " ");
			
		}
		
		System.out.println(" ");
		System.out.println(numbers[0]);
		System.out.println(numbers[0] + " " + numbers[1]);
		
		for (int k = 2; k <= n ; k++) {
			//for (int m = 2; m <= k ; m++) {
			int m = 2;
			System.out.print(numbers[0] + " " + numbers[1] + " ");
			while (m<=k) {
			System.out.print(numbers[m] + " ");
			m++;
			}
			System.out.println(" ");
			
		}
	
	} 

}
