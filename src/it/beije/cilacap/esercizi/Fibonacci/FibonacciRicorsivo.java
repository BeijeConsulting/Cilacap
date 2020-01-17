package it.beije.cilacap.esercizi.Fibonacci;

public class FibonacciRicorsivo {
	
	public  long FiboRicorsivo(long x) {
		if(x==0) {
			return 0;
			}
		else if(x==1) {
			return 1;
			}
		else 
			
			return FiboRicorsivo(x-1)+FiboRicorsivo(x-2);
	}

}
