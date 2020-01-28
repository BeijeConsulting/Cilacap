package it.beije.cilacap.zoo;

public class Arara implements Omnivorous {

	//@Override
	public void mangioCarne() {
		System.out.println("Is eating meat");
		
	}

	//@Override
	public void mangioVegetali() {
		// TODO Auto-generated method stub

	}

	//@Override
	/*public void eatEverything() {
		System.out.println("Is eating everything");

	}*/

	public static void main(String[] args) {
		
		Arara arara = new Arara();
		
		//arara.eatEverything();
		arara.mangioCarne();
	}

}
