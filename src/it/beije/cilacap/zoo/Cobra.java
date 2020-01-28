package it.beije.cilacap.zoo;

public class Cobra extends Serpente{
	
	public Cobra(int age, int zampe, boolean isLetal) {
		super(age,zampe);
		super.setLetal(isLetal);
	}
	
	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 70;
	}
}
