package it.beije.cilacap.zoo;

public abstract class Mammifero extends Animale {
		
	public Mammifero(int age, int zampe) {
		super.setAge(age);
		super.setZampe(zampe);
	}
	
	public abstract void riproduzioneMammifero();
}
