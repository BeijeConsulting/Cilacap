package it.beije.cilacap.zoo;

public abstract class Uccello extends Animale{
	
	public Uccello(int age, int zampe) {
		super.setAge(age);
		super.setZampe(zampe);
	}
	
	public abstract void riproduzioneUccello();
}
