package it.beije.cilacap.zoo;

public class Zebra extends Mammifero implements Erbivoro,Camminatore {

	public Zebra(int age) {
		super(age);
	}
	@Override
	public void mangioVegetali() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getNome() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getMaxSpeed() {
		return 30;
	}

}
