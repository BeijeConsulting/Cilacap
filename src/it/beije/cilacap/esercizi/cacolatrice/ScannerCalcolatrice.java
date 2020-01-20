package it.beije.cilacap.esercizi.cacolatrice;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerCalcolatrice {
	
	public static char[] ammessi = {'0','1','2','3','4','5','6','7','8','9','.','+','-','*','/','%','(',')','Q','q'};

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("Caratteri ammessi : " + Arrays.toString(ammessi));
		
		Scanner s = new Scanner(System.in);
		String st = s.nextLine();
		Calcolatrice calc = new Calcolatrice();
		while (!st.equalsIgnoreCase("Q")) {

			//System.out.println(st);
			//// CALCOLATRICE
			st = s.nextLine();
		}
		
		System.gc();
		System.out.println("BYE!!");
		s.close();

	}

}
