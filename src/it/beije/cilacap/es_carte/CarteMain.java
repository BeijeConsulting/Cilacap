package it.beije.cilacap.es_carte;

import java.util.Random;
import java.util.Scanner;

public class CarteMain {
	
	private static final String[] lista = {};
	private static Scanner sc = new Scanner(System.in);
	private static int player1;
	private static int player2;
	
	public static void main(String[] args) {
		int scegli = 0;
		while(true){
			System.out.println("premi 1 per 1vs1, 2 per 1vsCPU");
			scegli = sc.nextInt();
			if(scegli==1) partita1vs1();
			if(scegli==2) partita1vsCPU();
		}	
	}
		
	private static void partita1vsCPU() {
		int a=-1;
		while(a<0) {
		System.out.println("Giocatore:");
		a = sceltaCarta(sc.next());
		}
		Random r = new Random();
		player2 = r.nextInt(lista.length);
		winner(partita());
	}

	private static void partita1vs1() {
		int a=-1, b=-1;
		while(a<0) {
		System.out.println("Giocatore 1:");
		a = sceltaCarta(sc.next());
		}
		player1 = a;
		while(b<0) {
		System.out.println("Giocatore 2:");
		b = sceltaCarta(sc.next());
		}
		player2 = b;
		winner(partita());
	}

	private static int sceltaCarta(String next) {
		for(int i=0; i<lista.length; i++) {
			if(lista[i].equalsIgnoreCase(next)) return i;
		}
		return -1;
	}
	
	//winner>0 vince player1, <0 vince player2, =0 pareggio;
	private static int partita() {
		int winner=player1-player2;
		if((player1==0 && player2==lista.length-1) || (player1==lista.length-1 && player2==0)) winner=-winner;
		return winner;	
	}
	
	private static void winner(int win) {
		if(win>0) System.out.println("Vince giocatore 1");
		else if(win<0) System.out.println("Vince giocatore 2");
		else System.out.println("Pareggio");
	}


}
