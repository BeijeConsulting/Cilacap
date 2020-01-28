package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Anfibio;
import it.beije.cilacap.es_zoo.extenders.Insetto;
import it.beije.cilacap.es_zoo.extenders.insettivoro;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class Rana extends Anfibio implements insettivoro{

	public Rana(int age) {
		this(age, 1);
		// TODO Auto-generated constructor stub
	}
	
	public Rana(int age, double lengthTongue) {
		super(age, lengthTongue);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String stile() {
		// TODO Auto-generated method stub
		return "Nuoto a rana";
	}

	@Override
	public double getMaxSpeedSwim() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public double getMaxSpeedWalk() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public int numZampe() {
		// TODO Auto-generated method stub
		return 4;
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
		return "Rana di anni "+getAge();
	}

}
