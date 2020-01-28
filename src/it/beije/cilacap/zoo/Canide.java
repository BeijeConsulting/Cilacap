package it.beije.cilacap.zoo;

public abstract class Canide extends Mammifero implements Camminatore, Carnivoro, Erbivoro{
	
	public Canide(int age, int zampe) {
		super(age,zampe);
	}
	
	public void riproduzioneMammifero(){
		System.out.println("Accoppiamento e gravidanza...");
	}
}
