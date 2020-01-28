package it.beije.cilacap.zoo;

public abstract class Felino extends Mammifero implements Camminatore, Carnivoro, Erbivoro{
	
	public Felino(int age, int zampe) {
		super(age,zampe);
	}
	
	public void riproduzioneMammifero(){
		System.out.println("Accoppiamento e gravidanza...");
	}
}
