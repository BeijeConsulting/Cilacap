package it.beije.cilacap;

import java.util.Scanner;

public class MorraCinese2 {
	public static void main(String[] args) {
		String p1 = new String();
		String p2 = new String();
		Scanner s = new Scanner(System.in);
		p1 = s.nextLine();
		
		System.out.println("giocatore 1: " + p1);
		p2 = s.next();

		System.out.println("giocatore 2: " + p2);

		if (p1.equals(p2))
			System.out.println("pareggio");
		else if (p1.equals("carta") && p2.equals("sasso"))
			System.out.println("Ha vinto il primo giocatore!");
		else if (p1.equals("forbice") && p2.equals("carta"))
			System.out.println("Ha vinto il primo giocatore!");
		else if (p1.equals("sasso") && p2.equals("forbice"))
			System.out.println("Ha vinto il primo giocatore!");
		else
			System.out.println("Ha vinto il secondo giocatore!");

	}
}
