package it.beije.cilacap.esercizi;

import java.util.ArrayList;
import java.util.List;

public class MyFibonacci {

	public List<Integer> fibonacci(int n) {
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		for(int i = 2; i <= n; i++) {
			fib.add(fib.get(i-1)+fib.get(i-2));
		}
		return fib;
	}
	
	public void printOccorrenze(int o) {
		List<Integer> occFibonacci = this.fibonacci(o);
		if(o == 0) {
			System.out.println(0);
		} else if(o == 1) {
			System.out.print("0 1");
		} else {
			for(int f = 0; f < o; f++) {
				System.out.print(occFibonacci.get(f) + " ");
			}
		}
	}
	
	public void printRighe(int r) {
		List<Integer> occFibonacci = this.fibonacci(r);
		for(int f = 0; f < r; f++) {
			for(int i = 0; i <= f; i++) {
				System.out.print(occFibonacci.get(i) + " ");
			}
			System.out.println();
		}
	}
	
	public void printReverse(int n) {
		
		List<Integer> lista = this.fibonacci(n);
		
		for(int i = 0; i <= n; i++) {

			for(int j = 0; j <= i ; j++) {
				System.out.print(lista.get(j) + " ");
			}
			
			System.out.print("   ");
			
			for(int c = n - i; c >= 0; c--) {
				System.out.print(lista.get(c)+ " ");
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		MyFibonacci myFib = new MyFibonacci();
		
		System.out.println("Le prime " + args[0] + " occorrenze di Fibonacci");
		
		myFib.printOccorrenze(Integer.parseUnsignedInt(args[0]));
		
		System.out.println();
		System.out.println();
		
		myFib.printRighe(Integer.parseInt(args[0]));
		
		System.out.println();
		System.out.println();
		
		myFib.printReverse(Integer.parseInt(args[0]));
	}
	
}
