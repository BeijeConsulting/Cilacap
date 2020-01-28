package it.beije.cilacap.zoo;

public class Orso extends Mammifero implements Onnivero, Camminatore {

	public Orso(int age) {
		super(age);
	}

	@Override
	public void mangioCarne() {

	}

	@Override
	public void mangioVegetali() {

	}

	@Override
	public double getMaxSpeed() {
		return 0;
	}

}
