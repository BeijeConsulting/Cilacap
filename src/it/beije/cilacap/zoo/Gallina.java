package it.beije.cilacap.zoo;

public class Gallina extends Uccello implements Camminatore, Carnivoro, Erbivoro{
	
	public Gallina(int age, int zampe) {
		super(age,zampe);
	}
	
	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 15;
	}
	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		System.out.println("Vermi e altri insetti");
	}
	@Override
	public void mangioVegetali() {
		// TODO Auto-generated method stub
		System.out.println("Spezzato di grano e altri sementi");
	}
	@Override
	public void riproduzioneUccello() {
		// TODO Auto-generated method stub
		System.out.println("Accoppiamento e deposizione uova...");
	}
}
