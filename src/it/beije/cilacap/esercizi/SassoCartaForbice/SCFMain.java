package it.beije.cilacap.esercizi.SassoCartaForbice;
import it.beije.cilacap.esercizi.SassoCartaForbice.*;
import it.beije.cilacap.esercizi.SassoCartaForbice.SassoCartaForbice.Mosse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SCFMain {
	
	public static void main(String[] args) throws IOException {
		Giocatore1 p1 = new Giocatore1();
		Giocatore2 p2 = new Giocatore2();
		int esito;
		SassoCartaForbice game = new SassoCartaForbice();
		Computer pc = new Computer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Benvenuti al gioco della morra cinese");
		System.out.println("Preferite modalità singola vs PC oppure 2 giocatori? Selezionare 1 o 2");
		Integer i;
		i=Character.getNumericValue(br.read());
		Mosse x;
		Mosse y;
		if(i==1) {
			System.out.println("Avete scelto la modalità giocatore singolo");
			x=p1.scegliMossa();	
			y=pc.scegliMossaPc();
			esito=game.ComparaMosse(x, y);
			if (esito==0) 
				System.out.println(x+" vs "+y+" Pareggio!");
			else if(esito==1) 
				System.out.println(x+" vs "+y+" Vince il giocatore1");
			else 
				System.out.println(x+" vs "+y+" Vince il Computer");
				}
			else if(i==2) {
				System.out.println("Avete scelto la modalità 2 giocatori");
				x=p1.scegliMossa();
				y=p2.scegliMossa2();
				esito=game.ComparaMosse(x, y);
				if (esito==0) 
					System.out.println(x+" vs "+y+" Pareggio!");
				else if(esito==1) 
					System.out.println(x+" vs "+y+" Vince il giocatore1");
				else 
					System.out.println(x+" vs "+y+" Vince il giocatore2");
			
			
			}
	}
	}

		


