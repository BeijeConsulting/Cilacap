package it.beije.cilacap.zoo;

public class Mucca extends Mammifero implements Erbivoro {

	public Mucca(int age) {
		super(age);
	}

	@Override
	public void mangioVegetali() {
		System.out.println("Sono mucca e mangio vegetale");
	}

	@Override
	public String getNome() {
		return "Mucca";
	}

}
