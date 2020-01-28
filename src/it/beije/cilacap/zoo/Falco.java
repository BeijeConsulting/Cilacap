package it.beije.cilacap.zoo;

public class Falco extends Uccello implements Volatile, Carnivoro {
	
	public Falco(int age, int zampe) {
		super(age,zampe);
	}
	
	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return 100;
	}
	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		System.out.println("Insetti e roditori di piccole/medie dimensioni");
	}
	@Override
	public void riproduzioneUccello() {
		// TODO Auto-generated method stub
		System.out.println("Accopiamento e deposizione uova...");
	}
}
