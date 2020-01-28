package it.beije.cilacap.es_zoo.extenders;

public abstract class Uccello extends Animale {
	
	private double aperturaAlare;
	
	public Uccello(int age, double aperturaAlare) {
		super(age);
		this.aperturaAlare = aperturaAlare;
	}

	public double getAperturaAlare() {
		return aperturaAlare;
	}
	public void setAperturaAlare(double aperturaAlare) {
		this.aperturaAlare = aperturaAlare;
	}

}
