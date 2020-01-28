package it.beije.cilacap.zoo;

public class Lion extends Feline implements Carnivoro {

	public String getName() {
		return "Lion";
	}
	
	public boolean striped() {
		return false;
	}
	
	public void mangioCarne() {
		System.out.println("Is eating meat");
	}
	
	public static void main(String[] args) {
		
		Lion lion  = new Lion();
		System.out.println(lion.getName());
		System.out.println(lion.striped());
		lion.mangioCarne();
	}

}


