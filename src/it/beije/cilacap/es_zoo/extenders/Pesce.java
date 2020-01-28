package it.beije.cilacap.es_zoo.extenders;

public abstract class Pesce extends Animale {
	
	private double maxLength;
	
	public Pesce(int age, double maxLength) {
		super(age);
		this.maxLength = maxLength;
	}

	public double getMaxLength() {
		return maxLength;
	}
}
