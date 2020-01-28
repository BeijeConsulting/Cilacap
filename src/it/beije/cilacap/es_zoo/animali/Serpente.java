package it.beije.cilacap.es_zoo.animali;

import it.beije.cilacap.es_zoo.extenders.Mammifero;
import it.beije.cilacap.es_zoo.extenders.Rettile;
import it.beije.cilacap.es_zoo.extenders.Uccello;
import it.beije.cilacap.es_zoo.extenders.carnivoro;
import it.beije.cilacap.es_zoo.extenders.strisciatore;
import it.beije.cilacap.es_zoo.extenders.vivente;

public class Serpente extends Rettile implements strisciatore, carnivoro {

	public Serpente(int age) {
		super(age, 2);
		// TODO Auto-generated constructor stub
	}
	
	public Serpente(int age, double maxLength) {
		super(age, maxLength);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub

	}

	@Override
	public double getMaxSpeedSerp() {
		// TODO Auto-generated method stub
		return 15;
	}

	@Override
	public boolean mangio(vivente a) {
		if(a instanceof Mammifero && ((Mammifero) a).getWeight()<3) return true;
		if(a instanceof Uccello && ((Uccello) a).getAperturaAlare()<1.5) return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
	}

}
