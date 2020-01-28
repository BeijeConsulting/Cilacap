package it.beije.cilacap.es_zoo.extenders;

public abstract class Animale implements vivente {

	private int age;
	
	public Animale(int age) {
		this.age = age;
	}
	
	public abstract boolean mangio(vivente a);
	
	public abstract String toString();

	public int getAge() {
		return age;
	}
}
