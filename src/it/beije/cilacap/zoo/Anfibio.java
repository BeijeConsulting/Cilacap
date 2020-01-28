package it.beije.cilacap.zoo;

public abstract class Anfibio extends Rettile{
	
	public Anfibio(int age, int zampe) {
		super(age, zampe);
	}
	
	public abstract void respirazione();
}
