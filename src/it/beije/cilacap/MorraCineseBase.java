package it.beije.cilacap;

import java.util.Scanner;

public class MorraCineseBase {
	static String random() {
		String s = " ";
		String copia = " ";
		int random = (int) (Math.random() * 3);
		while (random == 0) {
			random = (int) (Math.random() * 3);
		}
		switch (random) {
		case 1:
			s = "s";
			copia = s;
			System.out.println("Esce sasso");
			break;
		case (2):
			s = "c";
			copia = s;
			System.out.println("Esce carta");
			break;
		case (3):
			s = "f";
			copia = s;
			System.out.println("Esce forbice");
			break;
		}
		return copia;

	}

	static void UnovsUno() {
		int player1 = 1;
		int player2 = 2;
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"player " + player1 + " scegli tra Carto Sassa Forbice con i seguenti comandi:\n S \n C \n F \n");
		String out1 = sc.next();
		System.out.println(
				"player " + player2 + " scegli tra Carto Sassa Forbice con i seguenti comandi:\n S \n C \n F \n");
		String out2 = sc.next();
		if (out1.equals(out2))
			System.out.println("Pareggio!");
		else if (out1.equals("s") && out2.equals("f") || out1.equals("c") && out2.equals("s")
				|| out1.equals("f") && out2.equals("c"))
			System.out.println("Ha vinto il primo giocatore!");
		else
			System.out.println("Ha vinto il secondo giocatore");

	}

	static void UnovsPc() {
		int player1 = 1;
		int player2 = 2;
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"player " + player1 + " scegli tra Carto Sassa Forbice con i seguenti comandi:\n S \n C \n F \n");
		String out1 = sc.next();
		System.out.println(
				"player " + player2 + " scegli tra Carto Sassa Forbice con i seguenti comandi:\n S \n C \n F \n");

		String out2 = random();
		if (out1.equals(out2))
			System.out.println("Pareggio!");
		else if (out1.equals("s") && out2.equals("f") || out1.equals("c") && out2.equals("s")
				|| out1.equals("f") && out2.equals("c"))
			System.out.println("Ha vinto il primo giocatore!");
		else
			System.out.println("Ha vinto il secondo giocatore");
	}

	public static void main(String[] args) {
		UnovsPc();

	}

}
