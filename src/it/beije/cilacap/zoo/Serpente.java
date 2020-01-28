package it.beije.cilacap.zoo;

public abstract class Serpente extends Rettile implements Strisciante, Carnivoro {
	
	private boolean isLetal;
	
	public Serpente(int age, int zampe) {
		super(age,zampe);
	}
	
	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		System.out.println("Mangia carne");
	}
	
	public boolean getLetal() {
		return isLetal;
	}

	public void setLetal(boolean isLetal) {
		this.isLetal = isLetal;
	}
	
}
