package it.beije.cilacap.zoo;

public interface Onnivoro extends Carnivoro, Erbivoro{

	void mangiaTutto();

	@Override
	default void eat() {
		System.out.println("Onnivoro mangia tutto");
	}
	
}
