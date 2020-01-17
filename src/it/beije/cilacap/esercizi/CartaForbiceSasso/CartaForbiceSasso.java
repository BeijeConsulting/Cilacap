package it.beije.cilacap.esercizi.CartaForbiceSasso;

import java.util.*;

public class CartaForbiceSasso {
	
	private String player1;
	private String player2;
	private String playerCom;
	
	public CartaForbiceSasso(String a, String b) {
		player1= a.trim().toUpperCase();
		player2= b.trim().toUpperCase();
		
		System.out.println("Scelta Player 1 : " + player1);
		System.out.println("Scelta Player 2 : " + player2);
		
		String switchVar = player1 + player2;
		String winner = "";
		
		switch(switchVar) {
			
			case "SASSOSASSO": 
				winner = null;
				break;
			case "SASSOCARTA":
				winner = "com";
				break;
			case "SASSOFORBICE":
				winner = "p1";
				break;
			case "CARTASASSO":
				winner = "p1";
				break;
			case "CARTAFORBICE":
				winner = "com";
				break;
			case "CARTACARTA":
				winner = null;
				break;
			case "FORBICESASSO":
				winner = "com";
				break;
			case "FORBICECARTA":
				winner = "p1";
				break;
			case "FORBICEFORBICE":
				winner = null;
				break;
		}
		System.out.println("Vince il " + ((winner != "p1") ? "PLAYER 2" : "PLAYER 1"));
	}
	public CartaForbiceSasso(String a) {
		player1= a.trim().toUpperCase();
		Random random = new Random();
		int nRandom = (int) random.nextInt(3);
				
		playerCom = (nRandom != 0) ? (nRandom == 1) ? "SASSO" : "CARTA" : "FORBICE" ;
		System.out.println("Scelta Player1 : " + player1);
		System.out.println("Scelta Computer : " + playerCom);
		
		String switchVar = player1 + playerCom;
		String winner = "";
		
		switch(switchVar) {
			
			case "SASSOSASSO": 
				winner = null;
				break;
			case "SASSOCARTA":
				winner = "com";
				break;
			case "SASSOFORBICE":
				winner = "p1";
				break;
			case "CARTASASSO":
				winner = "p1";
				break;
			case "CARTAFORBICE":
				winner = "com";
				break;
			case "CARTACARTA":
				winner = null;
				break;
			case "FORBICESASSO":
				winner = "com";
				break;
			case "FORBICECARTA":
				winner = "p1";
				break;
			case "FORBICEFORBICE":
				winner = null;
				break;
		}
		System.out.println("Vince il " + ((winner != "p1") ? "COMPUTER" : "PLAYER 1"));
	}
}
