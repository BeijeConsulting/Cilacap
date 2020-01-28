package it.beije.cilacap.es_zoo.extenders;

public abstract class Anfibio extends Animale implements nuotatore, camminatore {

	private double lengthTongue;
	
	public Anfibio(int age, double lengthTongue) {
		super(age);
		this.lengthTongue = lengthTongue;
	}

	public double getLengthTongue() {
		return lengthTongue;
	}
	
}
