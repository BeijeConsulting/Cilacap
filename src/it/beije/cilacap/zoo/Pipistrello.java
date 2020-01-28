package it.beije.cilacap.zoo;

public class Pipistrello extends Mammifero implements CamminatoreVolante {
	
	public Pipistrello(int age, int zampe) {
		super(age,zampe);
	}
	
	public void riproduzioneMammifero(){
		System.out.println("Accoppiamento e gravidanza...");
	}
	@Override
	public double getMaxSpeedCamminando() {
		// TODO Auto-generated method stub
		return 10;
	}
	@Override
	public double getMaxSpeedVolando() {
		// TODO Auto-generated method stub
		return 65;
	}
}
