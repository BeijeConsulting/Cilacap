package it.beije.cilacap.esercizi.SassoCartaForbice;
import java.util.Scanner;

import it.beije.cilacap.esercizi.SassoCartaForbice.SassoCartaForbice.Mosse;


public class Giocatore1 {
	
	 static Scanner sc = new Scanner(System.in);
	
		
	public Mosse scegliMossa() {
		System.out.println(" Giocatore 1, scegliere fra Sasso,Carta o Forbice...");
		String userInput= sc.nextLine();
			userInput= userInput.toUpperCase();		
			char firstLetter= userInput.charAt(0);
			if(firstLetter=='S'|| firstLetter=='C'|| firstLetter=='F') {
			switch(firstLetter) {
			case 'S':
				return Mosse.SASSO;
			case 'C':
				return Mosse.CARTA;
			case 'F':
				return Mosse.FORBICE;
			}
			}
				return scegliMossa();
			}
		
		
//		public static boolean GiocareAncora() {
//		System.out.println("Giocare ancora? Si/No..." );
//		String userInput=sc.nextLine();
//		userInput=userInput.toUpperCase();
//		return userInput.charAt(0)=='S';
//		}

	
}

