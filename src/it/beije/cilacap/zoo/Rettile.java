package it.beije.cilacap.zoo;

public abstract class Rettile extends Animale{
	
	public Rettile(int age, int zampe) {
		super.setAge(age);
		super.setZampe(zampe);
	}
	
	public void riproduzioneRettile() {
		// TODO Auto-generated method stub
		System.out.println("Accoppiamento e deposizione uova...");
	}
}
