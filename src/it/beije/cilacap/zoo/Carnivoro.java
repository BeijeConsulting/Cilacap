package it.beije.cilacap.zoo;

public interface Carnivoro {
	
	void mangioCarne();
	
	default void eat() {
		System.out.println("carnivoro mangia carne");
	}

}
