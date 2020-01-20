package it.beije.cilacap.esercizi.CartaAltaVince;

import java.util.*;

public class CartaAltaVince {
	
	private int player1;
	private int player2;
	private final String[] strWin = {"A","2","3","4","5","6","7","J","Q","K",""};
	
	public CartaAltaVince(int a, int b) {

		if (a - (strWin.length -1) == 0 || b - (strWin.length -1) == 0) {
			strWin[strWin.length-1] = strWin[0];
		}
		
	
		System.out.println("Scelta Player1 : " + strWin[a-1]);
		System.out.println("Scelta Player2 : " + strWin[b-1]);
		
		for(int i = 0; i < strWin.length; i++) {
			if (strWin[a-1].equals(strWin[i].intern())) {
				player1 = i;
				System.out.println(i);
				
			}
		}
		
		for(int i = 0; i < strWin.length; i++) {
			if (strWin[b-1].equals(strWin[i].intern())) {
				player2 = i;
				System.out.println(i);
				
			}
		}
		if (player1 > player2)
			System.out.println(strWin[a-1] + " batte " + strWin[b-1] + "\nVince il Player 1");
		else if (player1 < player2)
			System.out.println(strWin[b-1] + " batte " + strWin[a-1] + "\nVince il Player 2");
		else
			System.out.println("Pareggio");
	}
	public CartaAltaVince(int a) {
		//player1= a.trim().toUpperCase();
		Random random = new Random();
		int nRandom = (int) random.nextInt(10);
				
		if (a - (strWin.length -1) == 0 || nRandom - (strWin.length -1) == 0) {
			strWin[strWin.length-1] = strWin[0];
		}
		
	
		System.out.println("Scelta Player1 : " + strWin[a-1]);
		System.out.println("Scelta Player2 : " + strWin[nRandom]);
		
		for(int i = 0; i < strWin.length; i++) {
			if (strWin[a-1].equals(strWin[i].intern())) {
				player1 = i;
				
			}
		}
		
		for(int i = 0; i < strWin.length; i++) {
			if (strWin[nRandom].equals(strWin[i].intern())) {
				player2 = i;
				
			}
		}
		if (player1 > player2)
			System.out.println(strWin[a-1] + " batte " + strWin[nRandom] + "\nVince il Player 1");
		else if (player1 < player2)
			System.out.println(strWin[nRandom] + " batte " + strWin[a-1] + "\nVince il Player 2");
		else
			System.out.println("Pareggio");
	}
}
