package it.beije.cilacap.zooLuca;

public class Delfino extends Cetaceo implements Nuota, Onnivoro{
	public static void main(String[] args) {
		boolean peloso = true;
		
		Delfino delfino = new Delfino();
		delfino.Pelo(peloso);
		delfino.MangiaTutto();
		delfino.NuotaInAcqua();
	}
	
	public void Pelo(boolean peloso) {
		
		if(peloso) {
			System.out.println("Ha il pelo");
		} else {
			System.out.println("Non ha il pelo");
		}
		
	}
		
	public void MangiaTutto() {
		System.out.println("E' onnivoro");
	}
		
	public void NuotaInAcqua() {
		System.out.println("Nuota");
	}
	
}
