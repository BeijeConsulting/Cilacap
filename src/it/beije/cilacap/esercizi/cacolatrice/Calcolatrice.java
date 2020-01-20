package it.beije.cilacap.esercizi.cacolatrice;

public class Calcolatrice {

	public double somma(double value1, double value2) {
		return value1 + value2;
	}

	public double moltiplicazione(double value1, double value2) {
		return value1 * value2;
	}
	
	public double divisione( double value1, double value2) {
		
		if(value2==0) {
			return 0.0;
		}
		else {
			return value1/value2;
		}
	}
}
