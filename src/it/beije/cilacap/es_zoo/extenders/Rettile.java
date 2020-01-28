package it.beije.cilacap.es_zoo.extenders;

public abstract class Rettile extends Animale {
	
	private double maxLength;
	
	public Rettile(int age, double maxLength) {
		super(age);
		this.maxLength = maxLength;
	}

	public double getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(double maxLength) {
		this.maxLength = maxLength;
	}

}
