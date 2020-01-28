package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Insetto;
import it.beije.cilacap.es_zoo.extenders.Uccello;
import it.beije.cilacap.es_zoo.extenders.camminatore;
import it.beije.cilacap.es_zoo.extenders.insettivoro;
import it.beije.cilacap.es_zoo.extenders.vivente;
import it.beije.cilacap.es_zoo.extenders.volatore;

public class Piccione extends Uccello implements insettivoro, volatore, camminatore {

	public Piccione(int age) {
		this(age, 1);
	}
	
	public Piccione(int age, double aperturaAlare) {
		super(age, aperturaAlare);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMaxSpeedWalk() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numZampe() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getMaxSpeedFlight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean mangio(vivente a) {
		if(a instanceof Insetto) return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Piccione";
	}

	@Override
	public void mangioInsetti() {
		// TODO Auto-generated method stub
		
	}

}
