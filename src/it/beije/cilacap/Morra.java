package it.beije.cilacap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Morra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Morra prova = new Morra();
		String G1,G2;
		Scanner sc = new Scanner(System.in);
		System.out.println("G1: scegli uno tra carta forbice e sasso sotto forma di S,C o F");
		G1 = sc.nextLine();
		System.out.println("G2: scegli uno tra carta forbice e sasso sotto forma di S,C o F");
		G2 = sc.nextLine();
		prova.risultato(G1, G2);
		
			
	}
	public void risultato(String G1,String G2) {
		String insieme = new String(G1+G2);
		insieme= insieme.toUpperCase();
		if(insieme.equals("SF")||insieme.equals("FC")||insieme.equals("CS")||insieme.equals("SC")||insieme.equals("CF")||insieme.equals("FS")){
			switch(insieme) {
			case "SF":System.out.println("Vince giocatore 1:");
					  System.out.println("Sasso batte forbice");
					  break;
			case "FC":System.out.println("Vince giocatore 1:");
					  System.out.println("Forbice batte carta");
					  break;
			case "CS":System.out.println("Vince giocatore 1:");
					  System.out.println("carta batte sasso");
					  break;
			case "SC":System.out.println("Vince giocatore 2:");
					  System.out.println("sasso perde contro carta ");
					  break;
			case "CF":System.out.println("Vince giocatore 2:");
					  System.out.println("carta perde contro forbice");
					  break;
			case "FS":System.out.println("Vince giocatore 2:");
					  System.out.println("Forbice perde contro sasso");
					  break;
			default: System.out.println("Pareggio");
				
			}
		}else {
			System.out.println("Caratteri o carattere non consentiti");
		}
		
	}

}
