package it.beije.cilacap.zoo;

public class Rana extends Anfibio implements Camminatore, Carnivoro{
	
	public Rana(int age, int zampe) {
		super(age,zampe);
	}
	
	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 35;
	}
	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		System.out.println("Solo insetti");
	}
	@Override
	public void respirazione() {
		// TODO Auto-generated method stub
		System.out.println("Polmonare e cutanea");
	}
}
