package it.beije.cilacap.esercizi;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerCalcolatrice {

	public static char[] ammessi = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '+', '-', '*', '/', '%',
			'(', ')', '=', 'Q', 'q' };

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("Caratteri ammessi : " + Arrays.toString(ammessi));

		Scanner s = new Scanner(System.in);
		String espressione = s.next();
		Calcolatore calcolatrice = new Calcolatore();
//		calcolatrice.parsingEspressione(espressione);
		

		while (!espressione.equalsIgnoreCase("Q")) {

			System.out.println(espressione);
			//// CALCOLATRICE TODO output del risultato calcola(String espressione)

			espressione = s.nextLine();
		}

		System.gc();
		System.out.println("BYE!!");
		s.close();

	}

	


}
