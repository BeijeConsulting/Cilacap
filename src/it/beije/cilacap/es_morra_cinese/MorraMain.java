package it.beije.cilacap.es_morra_cinese;

import java.util.Random;
import java.util.Scanner;

public class MorraMain {
	private static Scanner sc = new Scanner(System.in);
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
		if (a%3>b%3) System.out.println("Vince giocatore 1!");
		else if (a%3<b%3) System.out.println("Vince giocatore 2!");
		else System.out.println("Pareggio!");
	}
	
	private static void partitaComp(int a, int b) {
		if (a%3>b%3) System.out.println("Vince giocatore 1 con "+getType(a)+" su "+getType(b));
		else if (a%3<b%3) System.out.println("Vince giocatore 2 con "+getType(b)+" su "+getType(a));
		else System.out.println("Pareggio con "+getType(a));
	}
	
	private static String getType(int a) {
		switch(a%3) {
		case 0: return "Forbice";
		case 1: return "Sasso";
		case 2: return "Carta";
		default: return "";
		}
	}
}
