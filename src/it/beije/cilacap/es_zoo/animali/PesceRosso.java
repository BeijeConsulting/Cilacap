package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Pesce;
import it.beije.cilacap.es_zoo.extenders.nuotatore;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class PesceRosso extends Pesce implements nuotatore {

	public PesceRosso(int age) {
		this(age, 0.2);
		// TODO Auto-generated constructor stub
	}
	
	public PesceRosso(int age, double maxLength) {
		super(age, maxLength);
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
		return 8;
	}

	@Override
	public boolean mangio(vivente a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pesce rosso di anni: "+ getAge();
	}

}
