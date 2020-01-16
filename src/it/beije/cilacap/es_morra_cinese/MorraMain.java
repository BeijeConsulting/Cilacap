package it.beije.cilacap.es_morra_cinese;

import java.util.Random;
import java.util.Scanner;

public class MorraMain {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int scegli = 0;
		while(true){
			System.out.println("premi 1 per 1vs1, 2 per 1vsCPU\n0 per sasso, 1 per carta, 2 per forbice (se numero>2 verrà effettuato il modulo)");
			scegli = sc.nextInt();
			if(scegli==1) partita1vs1();
			if(scegli==2) partita1vsCPU();
		}
	}
	
	private static void partita1vsCPU() {
		System.out.println("Giocatore:");
		int a = sc.nextInt();
		a=a%3;
		Random r = new Random();
		int cpu = r.nextInt(4);
		partita(a, cpu);
	}
	private static void partita1vs1() {
		System.out.println("Giocatore 1:");
		int a = sc.nextInt()%3;
		System.out.println("Giocatore 2:");
		int b = sc.nextInt()%3;
		partita(a, b);
	}
	
	private static void partita(int a, int b) {
		switch(vincitore(a,b)) {
			case 0:
				System.out.println("Pareggio con "+getType(a));
				break;
			case 1:
				System.out.println("Vince giocatore 1 con "+getType(a)+" su "+getType(b));
				break;
			case 2: 
				System.out.println("Vince giocatore 2 con "+getType(b)+" su "+getType(a));
				break;
			default:
				System.out.println("errore");
		}
	}
	
	private static String getType(int a) {
		switch(a) {
		case 0: return "Sasso";
		case 1: return "Carta";
		case 2: return "Forbice";
		}
		return "";
	}
	
	private static int vincitore(int a, int b) {
		if(a==b) return 0;
		switch (a) {
			case 2: 
				if(b==1) return 1;
				else return 2;
			case 1: 
				if(b==0) return 1;
				else return 2;
			case 0:
				if(b==2) return 1;
				else return 2;				
		}
		return -1;
	}
}
