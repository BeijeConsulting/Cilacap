package it.beije.cilacap.zoo;

public class Maiale extends Mammifero implements Onnivero,Camminatore{

	public Maiale(int age) {
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
