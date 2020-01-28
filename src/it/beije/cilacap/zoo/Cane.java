package it.beije.cilacap.zoo;

public class Cane extends Canide {
	
	public Cane(int age, int zampe) {
		super(age,zampe);
	}
	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 50;
	}
	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		System.out.println("Mangia carne");
	}
	@Override
	public void mangioVegetali() {
		// TODO Auto-generated method stub
		System.out.println("Mangia vegetali");
	}
}
