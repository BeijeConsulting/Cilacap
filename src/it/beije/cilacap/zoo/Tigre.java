package it.beije.cilacap.zoo;

public class Tigre extends Mammifero implements Carnivoro, DiTerra {




	public Tigre(int age, int numOssa) {
		super(age, numOssa);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tigre miaTigre=new Tigre(12,35);
		miaTigre.mangioCarne();
		
		
	}

	public boolean setHabitat(boolean v) {
		// TODO Auto-generated method stub
		System.out.println("La tigre vive sulla terraferma?\n");
		v=true;
		return v;
		
	}

	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		System.out.println("La tigre mangia la carne");
	}





}
