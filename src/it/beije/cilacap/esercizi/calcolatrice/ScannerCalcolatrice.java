package it.beije.cilacap.esercizi.calcolatrice;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerCalcolatrice {
	
	public static char[] ammessi = {'0','1','2','3','4','5','6','7','8','9','.','+','-','*','/','%','(',')','=','Q','q','c','C'};
	
	public static Double calcolatrice(String espressione) {
		Double d = 0.0;
		for(int i = 0; i < espressione.length(); i++) {
			
		}
		return d;
	}
	
	public static void main(String[] args) {
		System.out.println("Caratteri ammessi : " + Arrays.toString(ammessi));
		
		Scanner s = new Scanner(System.in);
		String st = s.next();
		while (!st.equalsIgnoreCase("Q")) {

			//// CALCOLATRICE
			calcolatrice(st);

			st = s.nextLine();
		}
		
		System.gc();
		System.out.println("BYE!!");
		s.close();

	}

}
