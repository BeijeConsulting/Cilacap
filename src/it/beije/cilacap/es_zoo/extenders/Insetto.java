package it.beije.cilacap.es_zoo.extenders;

public abstract class Insetto extends Animale {

	private String noise;
	
	public Insetto(int age, String noise) {
		super(age);
		this.noise = noise;
	}

	public String getNoise() {
		return noise;
	}

}
