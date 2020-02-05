package it.beije.cilacap.esercizi.SassoCartaForbice;
import java.util.Random;

import it.beije.cilacap.esercizi.SassoCartaForbice.SassoCartaForbice.Mosse;
public class Computer {
	
	public Mosse scegliMossaPc() {
		Mosse[] mossa=  Mosse.values();
		Random random = new Random();
		int i= random.nextInt(mossa.length);
		return mossa[i];
		}
		
	}


