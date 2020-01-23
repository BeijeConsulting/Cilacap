package it.beije.cilacap.esercizi.CartaAltaVince;

import java.util.*;

public class CartaAltaVince {
	
	private int player1;
	private int player2;
	
	
	public CartaAltaVince(int a, int b, String... strGame) {

		if (a - (strGame.length -1) == 0 || b - (strGame.length -1) == 0) {
			strGame[strGame.length-1] = strGame[0];
		}
		
	
		System.out.println("Scelta Player1 : " + strGame[a-1]);
		System.out.println("Scelta Player2 : " + strGame[b-1]);
		
		for(int i = 0; i < strGame.length; i++) {
			if (strGame[a-1].equals(strGame[i].intern())) {
				player1 = i;
			}
		}
		
		for(int i = 0; i < strGame.length; i++) {
			if (strGame[b-1].equals(strGame[i].intern())) {
				player2 = i;
			}
		}
		if (player1 > player2)
			System.out.println(strGame[a-1] + " batte " + strGame[b-1] + "\nVince il Player 1");
		else if (player1 < player2)
			System.out.println(strGame[b-1] + " batte " + strGame[a-1] + "\nVince il Player 2");
		else
			System.out.println("Pareggio");
	}
	public CartaAltaVince(int a, String... strGame) {
		//player1= a.trim().toUpperCase();
		Random random = new Random();
		int nRandom = (int) random.nextInt(10);
				
		if (a - (strGame.length -1) == 0 || nRandom - (strGame.length -1) == 0) {
			strGame[strGame.length-1] = strGame[0];
		}
		
	
		System.out.println("Scelta Player1 : " + strGame[a-1]);
		System.out.println("Scelta Player2 : " + strGame[nRandom]);
		
		for(int i = 0; i < strGame.length; i++) {
			if (strGame[a-1].equals(strGame[i].intern())) {
				player1 = i;
				
			}
		}
		
		for(int i = 0; i < strGame.length; i++) {
			if (strGame[nRandom].equals(strGame[i].intern())) {
				player2 = i;
				
			}
		}
		if (player1 > player2)
			System.out.println(strGame[a-1] + " batte " + strGame[nRandom] + "\nVince il Player 1");
		else if (player1 < player2)
			System.out.println(strGame[nRandom] + " batte " + strGame[a-1] + "\nVince il Player 2");
		else
			System.out.println("Pareggio");
	}
}
