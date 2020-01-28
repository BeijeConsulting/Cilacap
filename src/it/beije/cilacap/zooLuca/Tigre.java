package it.beije.cilacap.zooLuca;

public class Tigre extends Felino implements Carnivoro, Cammina{
	public static void main(String[] args) {
		boolean peloso = true;
		int zampe = 4;
		
		Tigre tigre = new Tigre();
		tigre.Pelo(peloso);
		tigre.NumeroDiZampe(zampe);
		tigre.MangiaCarne();
	}


	public void Pelo(boolean peloso) {
		
		if(peloso) {
			System.out.println("Ha il pelo");
		} else {
			System.out.println("Non ha il pelo");
		}
	
	}
	
	public void NumeroDiZampe(int zampe) {
		System.out.println("Ha " + zampe + " Zampe");
	}
	
	public void MangiaCarne() {
		System.out.println("E' carnivoro");
	}
}
