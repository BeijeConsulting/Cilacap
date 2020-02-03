package it.beije.cilacap.zoo;

public interface Erbivoro {
	
	public abstract void mangioVegetali();
	
	default void eat() {
		System.out.println("Erbivoro mangia vegetale");
	}

}
