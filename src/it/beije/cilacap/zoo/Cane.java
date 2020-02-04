package it.beije.cilacap.zoo;

public class Cane extends Mammifero implements Onnivoro{
		
	
	public Cane(int age) {
		super(age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mangioCarne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mangioVegetali() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MangiaDiTutto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean SonoVivo() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		Cane poll = new Cane(6);
		poll.Gnam();
		
		
	}
}
