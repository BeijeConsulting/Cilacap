package it.beije.cilacap.zoo;

public interface Carnivoro {
	
	void mangioCarne();
	default void Gnam() {
		System.out.println("GnamGnam");
	}

}
