package it.beije.cilacap.esercizi.CartaAltaVince;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p1,p2;
		int gameMod;
		Scanner sc = new Scanner(System.in);
		System.out.println("Modalità di gioco:\n1- MultiPlayer in locale\n2- Player vs Computer");
		gameMod = sc.nextInt();
		
		if (gameMod != 1) {
			System.out.println("Selezione player1:\n1- Asso\n2- Due\n3- Tre\n4- Quattro\n5- Cinque\n6- Sei\n7- Sette\n8- Jack\n9- Donna\n10- Re");
			CartaAltaVince game = new CartaAltaVince(sc.nextInt());
		}else {
			System.out.println("Selezione player1:\n1- Asso\n2- Due\n3- Tre\n4- Quattro\n5- Cinque\n6- Sei\n7- Sette\n8- Jack\n9- Donna\n10- Re");
			p1 = sc.nextInt();
			
			System.out.println("Selezione player1:\n1- Asso\n2- Due\n3- Tre\n4- Quattro\n5- Cinque\n6- Sei\n7- Sette\n8- Jack\n9- Donna\n10- Re");
			p2 = sc.nextInt();
			CartaAltaVince game1vs1 = new CartaAltaVince(p1,p2);
		}
	}

}
