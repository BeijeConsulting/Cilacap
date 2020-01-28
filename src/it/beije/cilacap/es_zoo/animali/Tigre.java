package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Mammifero;
import it.beije.cilacap.es_zoo.extenders.camminatore;
import it.beije.cilacap.es_zoo.extenders.carnivoro;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class Tigre extends Mammifero implements carnivoro, camminatore {

	public Tigre(int age) {
		this(age, 60);
		// TODO Auto-generated constructor stub
	}
	
	public Tigre(int age, double weight) {
		super(age, "Pelo striato nero e arancione", weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMaxSpeedWalk() {
		// TODO Auto-generated method stub
		return 60;
	}

	@Override
	public int numZampe() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public boolean mangio(vivente a) {
		if(a instanceof Mammifero && !(a instanceof Tigre)) return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tigre di anni "+getAge();
	}

}
