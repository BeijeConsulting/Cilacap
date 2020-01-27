package it.beije.cilacap.esercizi.cacolatrice;

import java.util.Scanner;

@SuppressWarnings("resource")
public class ScannerCalcolatrice {

	public double somma(double value1, double value2) {
		return value1 + value2;
	}

	public double moltiplicazione(double value1, double value2) {
		return value1 * value2;
	}

	public Double divisione(double value1, double value2) {

		if (value2 == 0) {
			System.out.println("Operazione NULLA, divisione per zero! ! !");
			return 0.0;
		} else {
			return value1 / value2;
		}
	}

	private double modulo(double value1, double value2) {
		return value1 % value2;
	}

	public char onMainMenu() { // menu di scelta principale.

		System.out.println("##################################################################");
		System.out.println("Calcolatrice v0.0.1");
		System.out.println("Decidi L'operazione da svolgere (digitare il carattere corrispondente all'operazione):");
		System.out.println("--           Somma: '+'");
		System.out.println("-- Moltiplicazione: '*'");
		System.out.println("--       Divisione: '/'");
		System.out.println("--          Modulo: '%'");
		System.out.println("--            Exit: 'q/Q'");
		System.out.println("##################################################################");
		Scanner in = new Scanner(System.in);
		char operation = in.next().charAt(0);
		return operation;
	}

	public void doOperation(String operation) {  //parte il metodo corrispetivo all'operazione selezionata
		switch (operation.charAt(0)) {
		case '+':
			eseguiSomma();
			break;
		case '*':
			eseguiMoltiplicazion();
			break;
		case '/':
			eseguiDivisione();
			break;
		case '%':
			eseguiModulo();
			break;
		}

	}

	private void eseguiModulo() {

		Scanner inputValues = new Scanner(System.in);
		System.out.println("Digita il valore a cui applicare il modulo:");
		double value1 = inputValues.nextDouble();
		System.out.println("Digita il Divisore:");
		double value2 = inputValues.nextDouble();
		double result = modulo(value1, value2);
		System.out.println("##################################################################");
		System.out.println("modulo:" + value1 + " % " + value2 + " = " + result);
		System.out.println("##################################################################");
	}

	private void eseguiDivisione() {
		Scanner inputValues = new Scanner(System.in);
		System.out.println("Digita il Dividendo:");
		double value1 = inputValues.nextDouble();
		System.out.println("Digita il Divisore:");
		double value2 = inputValues.nextDouble();
		double result = divisione(value1, value2);
		System.out.println("##################################################################");
		System.out.println("divisione: " + value1 + " / " + value2 + " = " + result);
		System.out.println("##################################################################");
	}

	private void eseguiMoltiplicazion() {
		Scanner inputValues = new Scanner(System.in);
		System.out.println("Digita il Moltiplicando:");
		double value1 = inputValues.nextDouble();
		System.out.println("Digita il Moltiplicatore:");
		double value2 = inputValues.nextDouble();
		double result = moltiplicazione(value1, value2);
		System.out.println("##################################################################");
		System.out.println("moltiplicazione: " + value1 + " * " + value2 + " = " + result);
		System.out.println("##################################################################");
		
	}

	private void eseguiSomma() {
		Scanner inputValues = new Scanner(System.in);
		System.out.println("Digita il primo addendo:");
		double value1 = inputValues.nextDouble();
		System.out.println("Digita il secondo addendo:");
		double value2 = inputValues.nextDouble();
		double result = somma(value1, value2);
		System.out.println("##################################################################");
		System.out.println("somma: " + value1 + " + " + value2 + " = " + result);
		System.out.println("##################################################################");
		
	}
}
