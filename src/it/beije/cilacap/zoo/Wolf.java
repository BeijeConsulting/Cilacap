package it.beije.cilacap.zoo;

public class Wolf extends Canine implements Carnivoro{
	
	public String getName() {
		return "Wolf";
	}
	
	public boolean howlToTheMoon() {
		return true;
	}
	
	public void mangioCarne() {
		System.out.println("Is eating meat");
	}

	public static void main(String[] args) {
		
		Wolf wolf = new Wolf();
		System.out.println(wolf.getName());
		System.out.println(wolf.howlToTheMoon());
		wolf.mangioCarne();
	}

}
