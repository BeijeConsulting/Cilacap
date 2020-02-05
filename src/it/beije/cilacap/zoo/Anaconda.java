package it.beije.cilacap.zoo;

public class Anaconda extends Rettile implements Serpente {

	public Anaconda(int age) {
		super(age);
	}

	@Override
	public double getLunghezza() {
		return 4.6;
	}

	@Override
	public void getNome() {
		System.out.println("Snake");

	}

}
