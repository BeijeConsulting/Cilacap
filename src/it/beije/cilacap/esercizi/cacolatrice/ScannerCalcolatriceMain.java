package it.beije.cilacap.esercizi.cacolatrice;

import java.util.Arrays;

public class ScannerCalcolatriceMain {

	public static char[] ammessi = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '+', '-', '*', '/', '%',
			'(', ')', 'Q', 'q' };

	public static void main(String[] args) {

		System.out.println("Ricordati che i Caratteri ammessi sono i seguenti: " + Arrays.toString(ammessi));
		ScannerCalcolatrice calcolatore = new ScannerCalcolatrice();

//		chooseOperation(operation.charAt(0));
		char operazione;
		String operazioneFromChar = "";
		while (!operazioneFromChar.equalsIgnoreCase("Q")) {
			//// CALCOLATRICE
			operazione = calcolatore.onMainMenu();
			operazioneFromChar = Character.toString(operazione);
			calcolatore.doOperation(operazioneFromChar);

		}

		System.gc();
		System.out.println("BYE!!");

	}

}
