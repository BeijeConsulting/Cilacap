package it.beije.cilacap.zoo;

public class Fox extends Canine implements Carnivoro{
	
	public String getName() {
		return "Fox";
	}
	
	public boolean howlToTheMoon() {
		return false;
	}
	
	public void mangioCarne() {
		System.out.println("Is eating meat");
	}

	public static void main(String[] args) {
		
		Fox fox = new Fox();
		
		System.out.println(fox.getName());
		System.out.println(fox.howlToTheMoon());
		fox.mangioCarne();

	}

}
