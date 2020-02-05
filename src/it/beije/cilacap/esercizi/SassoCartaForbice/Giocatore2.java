package it.beije.cilacap.esercizi.SassoCartaForbice;
import java.util.Scanner;

import it.beije.cilacap.esercizi.SassoCartaForbice.SassoCartaForbice.Mosse;
public class Giocatore2 {
	
	 Scanner sc = new Scanner(System.in);
	
	
	public Mosse scegliMossa2() {
		System.out.println("Giocatore2, scegliere fra Sasso,Carta o Forbice...");
		String userInput= sc.nextLine();
			sc.close();
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
				return scegliMossa2();
			}
		}
		

	


