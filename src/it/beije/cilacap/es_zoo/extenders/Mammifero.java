package it.beije.cilacap.es_zoo.extenders;

public abstract class Mammifero extends Animale {
	
	private String skin;
	private double weight;
	
	public Mammifero(int age, String skin, double weight) {
		super(age);
		this.skin = skin;
		this.weight = weight;
	}

	public String getSkin() {
		return skin;
	}

	public double getWeight() {
		return weight;
	}
}
