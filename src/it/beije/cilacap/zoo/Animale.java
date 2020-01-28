package it.beije.cilacap.zoo;

public abstract class Animale {

	private int age;
	private String sesso;
	private int peso;

//	public Animale(int age) {
//		this.age = age;
//	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	

}
