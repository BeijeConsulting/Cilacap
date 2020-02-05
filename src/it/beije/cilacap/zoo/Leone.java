package it.beije.cilacap.zoo;

public class Leone extends Mammifero implements Carnivoro,Camminatore{

    
	public Leone(int age) {
		super(age);
		
	}

	@Override
	public void mangioCarne() {
		System.out.println("il leone uccide la preda e la mangia");
		
	}

	@Override
	public void getNome() {
		System.out.println("Lion");
	}

	@Override
	public double getMaxSpeed() {
		return 80;
	}


	

}
