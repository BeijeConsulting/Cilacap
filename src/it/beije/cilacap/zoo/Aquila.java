package it.beije.cilacap.zoo;

public class Aquila extends Animale implements Volatile,Carnivoro {

	@Override
	public double getMaxSpeed() {
		return 300;
	}

	@Override
	public void mangioCarne() {
		System.out.println("l'aquila rapisce la preda e la mangia");
		
	}

	@Override
	public void getNome() {
		System.out.println("Eagle");
		
	}

}
