package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Insetto;
import it.beije.cilacap.es_zoo.extenders.camminatore;
import it.beije.cilacap.es_zoo.extenders.insettivoro;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class Ragno extends Insetto implements insettivoro, camminatore {

	public Ragno(int age) {
		super(age, "sono silenzioso");
		// TODO Auto-generated constructor stub
	}
	
	public Ragno(int age, String noise) {
		super(age, noise);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getMaxSpeedWalk() {
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public int numZampe() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public void mangioInsetti() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean mangio(vivente a) {
		if(a instanceof Insetto) return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ragno di anni "+getAge();
	}

}
