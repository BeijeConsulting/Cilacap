package it.beije.cilacap.zoo;

public class Pappagallo extends Uccello {

	@Override
	public void vola() {
		System.out.println("\tvola!!!!!");
		
	}

	@Override
	public String getNome() {
		return "Pappagallo";
	}

}
