package it.beije.cilacap.zoo;

public class Maiale extends Mammifero implements Onnivoro {

	public Maiale(int age) {
		super(age);
	}

	@Override
	public String getNome() {
		return "Maiale";
	}

	public void mangioCarne() {
		System.out.println("\tMangia Carne ma non solo");
		
	}

	public void mangioVegetali() {
		System.out.println("\tMangia anche vegetali");
		
	}

	public void mangiaTutto() {
		System.out.println("\tMangia tutto");
		
	}
	
	public static void main(String[] args) {
		Maiale maiale = new Maiale(4);
		System.out.println(maiale.getNome());
		maiale.eat();
		maiale.mangiaTutto();
		maiale.mangioCarne();
		maiale.mangioVegetali();
		
		Mucca mucca = new Mucca(10);
		System.out.println(mucca.getAge());
		System.out.println(mucca.getNome());
		mucca.eat();
	}

}
