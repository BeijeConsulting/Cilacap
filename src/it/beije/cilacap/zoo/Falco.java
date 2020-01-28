package it.beije.cilacap.zoo;

public class Falco extends Animale implements Volatile, Erbivoro, Camminatore{

	@Override
	public double getMaxSpeed() {
		System.out.println("vado al massimo !");
		return 2.5;
	}

	@Override
	public void mangioVegetali() {
		System.out.println("Mangio vegetali");
		
	}

}
