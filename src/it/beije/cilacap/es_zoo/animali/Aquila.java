package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Mammifero;
import it.beije.cilacap.es_zoo.extenders.Uccello;
import it.beije.cilacap.es_zoo.extenders.Pesce;
import it.beije.cilacap.es_zoo.extenders.camminatore;
import it.beije.cilacap.es_zoo.extenders.carnivoro;
import it.beije.cilacap.es_zoo.extenders.vivente;
import it.beije.cilacap.es_zoo.extenders.volatore;

public class Aquila extends Uccello implements carnivoro, volatore, camminatore {

	public Aquila(int age) {
		this(age, 2.3);
	}

	public Aquila(int age, double aperturaAlare) {
		super(age, aperturaAlare);
	}
	
	@Override
	public void mangioCarne() {
		System.out.println("");
	}

	@Override
	public double getMaxSpeedFlight() {
		// TODO Auto-generated method stub
		return 320;
	}

	@Override
	public double getMaxSpeedWalk() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int numZampe() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public boolean mangio(vivente a) {
		if (a instanceof Mammifero && ((Mammifero) a).getWeight()<5) return true;
		if (a instanceof Pesce && ((Pesce) a).getMaxLength()<2) return true;
		if (a instanceof Uccello && ((Uccello) a).getAperturaAlare()<getAperturaAlare()) return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aquila di anni "+getAge()+",con un'apertura alare di: "+getAperturaAlare()+"m";
	}

}
