package it.beije.cilacap.esercizi;

import java.util.Scanner;


public class Morra {
	public static void main(String[] args) {
		String a;
		String b;
		boolean c=true;
		MetodiMorra metodi=new MetodiMorra();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Giocatore 1.\n"
				+ "Scegli la tua opzione tra SASSO, CARTA e FORBICE: ");
		a=scanner.nextLine();
		if (c!=a.equalsIgnoreCase("Sasso")&& (c!=a.equalsIgnoreCase("carta") && (c!=a.equalsIgnoreCase("forbice"))))
		{
			System.out.println("Seleziona una delle tre opzioni. Ricominciamo.\n");
		Morra.main(args);
		}
		System.out.println("Giocatore 2.\n"
				+"Scegli la tua opzione tra SASSO,CARTA e FORBICE: ");
		b=scanner.nextLine();
		if (c!=b.equalsIgnoreCase("Sasso")&& (c!=b.equalsIgnoreCase("carta") && (c!=b.equalsIgnoreCase("forbice"))))
		{
			System.out.println("Seleziona una delle tre opzioni. Ricominciamo.\n");
		Morra.main(args);
		}

		if(a.equalsIgnoreCase("Sasso")) {
			metodi.sasso(a,b);
		} else if(a.equalsIgnoreCase("Forbice")) {
			metodi.forbice(a,b);
		}else if(a.equalsIgnoreCase("Carta")) {
			metodi.carta(a,b);
		}

		System.out.println("Per rigiocare premi 1: ");
		int replay=0;
		replay=scanner.nextInt();
		if(replay==1) {
			Morra.main(args);
		}else {
			System.out.println("Ciao ciao");
		}
	}
}
		
		
		
		
		
	


