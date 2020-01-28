package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Insetto;
import it.beije.cilacap.es_zoo.extenders.Pianta;
import it.beije.cilacap.es_zoo.extenders.Uccello;
import it.beije.cilacap.es_zoo.extenders.camminatore;
import it.beije.cilacap.es_zoo.extenders.erbivoro;
import it.beije.cilacap.es_zoo.extenders.insettivoro;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class Gallina extends Uccello implements erbivoro, insettivoro, camminatore {

	public Gallina(int age) {
		this(age, 1);
		// TODO Auto-generated constructor stub
	}
	
	public Gallina(int age, double aperturaAlare) {
		super(age, aperturaAlare);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mangioVegetali() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMaxSpeedWalk() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int numZampe() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void mangioInsetti() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mangio(vivente a) {
		if(a instanceof Pianta) return true;
		if(a instanceof Insetto) return true;
		return false;
	}

	@Override
	public String toString() {
		String s = (getAge()<5) ? "depone uova" : "fa buon brodo";
		return "Gallina di anni "+getAge()+" e "+ s;
	}

}
