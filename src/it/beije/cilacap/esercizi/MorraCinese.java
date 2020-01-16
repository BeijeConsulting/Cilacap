package it.beije.cilacap.esercizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorraCinese {
	
	List<String> vittorie;
	List<String> sconfitte;

	public MorraCinese() {
		vittorie = new ArrayList<String>(3);
		vittorie.add("sassoforbice");
		vittorie.add("forbicecaarta");
		vittorie.add("cartasasso");
		
		sconfitte = new ArrayList<String>(3);
		sconfitte.add("forbicesasso");
		sconfitte.add("cartaforbice");
		sconfitte.add("sassocarta");
	}
	
	public void morraCinese(String g1, String g2) {
		String result = g1 + g2;
		result = result.toLowerCase();
		if(vittorie.contains(result)) {
			System.out.println("Giocatore 1 vince contro Giocatore 2\n(" + g1.toLowerCase() + " vince " + g2.toLowerCase() +")");
		} else if(sconfitte.contains(result)) {
			System.out.println("Giocatore 1 perde contro Giocatore 2\n(" + g1.toLowerCase() + " perde " + g2.toLowerCase() +")");
		} else {
			System.out.println("Pareggio!");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = new String();
		while(!s.equals("exit")) {
			System.out.println("Per giocare inserire una delle seguenti scelte:\n[sasso, carta o forbice]\n");
			String g1 = "";
			while(!g1.equalsIgnoreCase("sasso") && !g1.equalsIgnoreCase("carta") && !g1.equalsIgnoreCase("forbice")) {
				System.out.println("Giocatore 1:");
				g1 = scan.nextLine();
			}
			
			String g2 = "";
			while(!g2.equalsIgnoreCase("sasso") && !g2.equalsIgnoreCase("carta") && !g2.equalsIgnoreCase("forbice")) {
				System.out.println("Giocatore 2:");
				g2 = scan.nextLine();
			}
			
			MorraCinese mc = new MorraCinese();
			
			mc.morraCinese(g1, g2);
			
			System.out.println("\n\nDigita \"exit\" per terminare o premi \"invio\" per continuare");
			s = scan.nextLine();
			
		}
	}
	
}
