package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Mammifero;
import it.beije.cilacap.es_zoo.extenders.Pesce;
import it.beije.cilacap.es_zoo.extenders.nuotatore;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class Balena extends Mammifero implements nuotatore {
	
	private double length = 25;

	public Balena(int age) {
		this(age, 150000);
		// TODO Auto-generated constructor stub
	}
	
	public Balena(int age, double weight) {
		super(age, "Pelle grassa colonizzata da batteri", weight);
		// TODO Auto-generated constructor stub
	}
	
	public Balena(int age, double weight, double length) {
		this(age, weight);
		this.length = length;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String stile() {
		// TODO Auto-generated method stub
		return "Muovo le pinne";
	}

	@Override
	public double getMaxSpeedSwim() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public boolean mangio(vivente a) {
		if(a instanceof Pesce && ((Pesce) a).getMaxLength()<1) return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Balena di anni "+getAge()+",di peso: "+getWeight()+"kg e lunghezza: "+length;
	}

}
