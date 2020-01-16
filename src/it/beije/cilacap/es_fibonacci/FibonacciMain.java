package it.beije.cilacap.es_fibonacci;

public class FibonacciMain {
	
	public static void main(String... args) {
		int a = Integer.parseInt(args[0])+1;
		stampaFibo(a);
		System.out.println();
		stampaFiboTab(a);
		
	}
	
	public static void stampaFibo(int a) {
		for(int i=0; i<a; i++) {
			for(int j=0; j<i; j++) {
			System.out.print(fibonacci(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static void stampaFiboTab(int a) {
		for(int i=1; i<a; i++) {
			for(int j=0; j<i; j++) {
			System.out.format("%4d", fibonacci(j));
			}
			System.out.format("      ");
			for(int j=a-i-1; j>=0; j--) {
				System.out.format("%4d", fibonacci(j));
			}
			System.out.println();
		}
	}
	
	private static int fibonacci(int n) {
		if(n<2) {
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
