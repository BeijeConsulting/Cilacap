package it.beije.cilacap.zoo;

public class Giraffa extends Mammifero implements Erbivoro, Camminatore{

	public Giraffa(int age) {
		super(age);
	}

	public static void main(String[] args) {
		int eta = 3;
		double velocitaMax = 7.0;
		int foglie = 5;
		new Giraffa(eta);
	}

	@Override
	public double getMaxSpeed() {
		return 0;
	}

	@Override
	public void mangioVegetali() {
		
	}

}
