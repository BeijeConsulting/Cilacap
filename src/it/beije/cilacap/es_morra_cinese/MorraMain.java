package it.beije.cilacap.es_morra_cinese;

import java.util.Random;
import java.util.Scanner;

public class MorraMain {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int scegli = 0;
		while(true){
			System.out.println("premi 1 per 1vs1, 2 per 1vsCPU\n(0 per sasso, 1 per carta, 2 per forbice)");
			 scegli = sc.nextInt();
			 if(scegli==1) partita1vs1();
			 if(scegli==2) partita1vsCPU();
		}
	}
	
	private static void partita1vsCPU() {
		System.out.println("Giocatore:");
		int a = sc.nextInt();
		Random r = new Random();
		int cpu = r.nextInt()%3;
		partitaComp(a, cpu);
	}
	
	private static void partita1vs1() {
		System.out.println("Giocatore 1:");
		int a = sc.nextInt();
		System.out.println("Giocatore 2:");
		int b = sc.nextInt();
		partita(a, b);
	}
	
	private static void partita(int a, int b) {
		int c = vincitore(a,b);
		if (a%3>b%3) System.out.println("Vince giocatore 1!");
		else if (a%3<b%3) System.out.println("Vince giocatore 2!");
		else System.out.println("Pareggio!");
	}
	
	private static void partitaComp(int a, int b) {
		int c = vincitore(a,b);
		if (c==1) System.out.println("Vince giocatore 1 con "+getType(a)+" su "+getType(b));
		else if (c==2) System.out.println("Vince giocatore 2 con "+getType(b)+" su "+getType(a));
		else if (c==0) System.out.println("Pareggio con "+getType(a));
	}
	
	private static String getType(int a) {
		switch(a%3) {
		case 0: return "Sasso";
		case 1: return "Carta";
		case 2: return "Forbice";
		default: return "";
		}
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
			default:
				return -1;
				
		}
	}
}
