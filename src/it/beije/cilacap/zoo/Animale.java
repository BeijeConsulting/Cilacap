package it.beije.cilacap.zoo;

public abstract class Animale {

	private int age;
	private int zampe;

//	public Animale(int age) {
//		this.age = age;
//	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getZampe() {
		return zampe;
	}

	public void setZampe(int zampe) {
		this.zampe = zampe;
	}
}
