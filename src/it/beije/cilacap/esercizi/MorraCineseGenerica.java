package it.beije.cilacap.esercizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MorraCineseGenerica {
	
	List<String> carte;
	
	public MorraCineseGenerica() {
		carte = new ArrayList<String>();
		for(int i = 0; i <= 13; i++) {
			if(i == 11) {
				carte.add(i, "J");
			} else if(i == 12) {
				carte.add(i, "Q");
			} else if(i == 13) {
				carte.add(i, "K");
			} else {
				carte.add(new String(""+i));
			}
		}		
	}
	
	@SuppressWarnings("rawtypes")
	public void morraCinese(int index1, int index2, List lista) {
		if( (index1 == 1 && index2 == lista.size()-1) || 
		    (index2 == 1 && index1 == lista.size()-1) ) {
			rePerdeConAsso(index1, index2, lista);
		} else {
			regolaBase(index1, index2);
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void rePerdeConAsso(int i1, int i2, List lista) {
		if(i1 == 1) {
			System.out.println("Giocatore 1 vince contro Giocatore 2");
		} else if(i2 == 1) {
			System.out.println("Giocatore 1 perde contro Giocatore 2");
		}
	}
	
	private void regolaBase(int i1, int i2) {
		if(i1 > i2) {
			System.out.println("Giocatore 1 vince contro Giocatore 2");
		} else if(i1 < i2) {
			System.out.println("Giocatore 1 perde contro Giocatore 2");
		} else {
			System.out.println("Pareggio");
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {		
		Scanner scan = new Scanner(System.in);
		String s = "";
		MorraCineseGenerica mcg = new MorraCineseGenerica();
		
		while(!s.equals("exit")) {
			System.out.println("Per giocare inserire un il numero della carta\nPer le carte con le figure inserisi uno dei seguenti simboli: J, Q o K\n");
			
			String s1 = new String();;
			while(!mcg.carte.contains(s1)) {
				System.out.println("Giocatore 1:");
				s1 = scan.next().toUpperCase();
			}
			
			String s2 = new String();
			while(!mcg.carte.contains(s2)) {
				System.out.println("Giocatore 2:");
				s2 = scan.nextLine().toUpperCase();
			}
			
			mcg.morraCinese(mcg.carte.indexOf(s1) , mcg.carte.indexOf(s2), mcg.carte);
			
			System.out.println("\nDigita \"exit\" per terminare o premi \"invio\" per continuare a giocare");
			s = scan.nextLine();
			if(s.equalsIgnoreCase("exit")) {
				break;
			}
			
		}
		System.out.println("Grazie per aver giocato!");
	}

}
