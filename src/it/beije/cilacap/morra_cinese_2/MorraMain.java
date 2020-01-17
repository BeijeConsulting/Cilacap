package it.beije.cilacap.morra_cinese_2;

import java.util.Random;

public class MorraMain {

	private static java.util.Scanner sc = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		int scegli = 0;
		while(true){
			System.out.println("premi 1 per 1vs1, 2 per 1vsCPU");
			scegli = sc.nextInt();
			if(scegli==1) partita1vs1();
			if(scegli==2) partita1vsCPU();
		}
	}

	private static void partita1vs1() {
		System.out.println("Scrivi la mossa o digita 0 per sasso, 1 per carta, 2 per forbice");
		boolean ok=false;
		mossa move1=null;
		mossa move2=null;
		while(!ok)
			try {
				System.out.println("Giocatore 1:");
				String mossa1 = sc.next();
				move1 = mossaScelta(mossa1);
				ok=true;
			}catch(Exception e) {
				System.out.println("riprova");
			}
		ok=false;
		while(!ok)
			try {
				System.out.println("Giocatore 2:");
				String mossa2 = sc.next();
				move2 = mossaScelta(mossa2);
				ok=true;
			}catch(Exception e) {
				System.out.println("riprova");
			}
		partita(move1, move2);
	}
	

	private static void partita1vsCPU() {
		System.out.println("Scrivi la mossa o digita 0 per sasso, 1 per carta, 2 per forbice");
		boolean ok=false;
		mossa move1=null;
		mossa move2=null;
		while(!ok)
			try {
				System.out.println("Giocatore:");
				String mossa1 = sc.next();
				move1 = mossaScelta(mossa1);
				Random r = new Random();
				move2 = mossaScelta(r.nextInt(3)+"");
				ok=true;
			}catch(Exception e) {
				System.out.println("riprova");
			}
		partita(move1, move2);
	}
	
	private static mossa mossaScelta(String mossa) throws Exception{
		switch (mossa.toLowerCase()) {
		case Sasso.NAME:
			return new Sasso();
		case Carta.NAME:
			return new Carta();
		case Forbice.NAME:
			return new Forbice();
		default:
			int a=Integer.parseInt(mossa);
			switch (a) {
			case Sasso.ID:
				return new Sasso();
			case Carta.ID:
				return new Carta();
			case Forbice.ID:
				return new Forbice();
			}
		}
		return null;
	}
	
	private static void partita(mossa move1, mossa move2) {
		if(move1.vittoria(move2)) System.out.println(move1+" contro "+move2+"\nVince giocatore 1");
		else if(move2.vittoria(move1)) System.out.println(move1+" contro "+move2+"\nVince giocatore 2");
		else System.out.println(move1+" contro "+move2+"\nPareggio");
	}

}
