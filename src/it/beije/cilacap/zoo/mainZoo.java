package it.beije.cilacap.zoo;

public class mainZoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cane cane = new Cane(10,4);
		System.out.println("Cane");
		cane.mangioCarne();
		cane.mangioVegetali();
		cane.riproduzioneMammifero();
		System.out.println("Max Speed: " + cane.getMaxSpeed());
		System.out.println("\n");
		
		Gatto gatto = new Gatto(5,4);
		
		Pipistrello pipistrello = new Pipistrello(5, 2);
		System.out.println("Pipistrello");
		System.out.println("Max Speed camminando: " +pipistrello.getMaxSpeedCamminando());
		System.out.println("Max Speed volando: " +pipistrello.getMaxSpeedVolando());
		pipistrello.riproduzioneMammifero();
		System.out.println("\n");
		
		Falco falco = new Falco(7,2);
		Gallina gallina = new Gallina(5,2);
		
		Cobra cobra = new Cobra(4,0,true);
		System.out.println("Cobra");
		System.out.println("Max Speed strinsciando: " +cobra.getMaxSpeed());
		System.out.println("Letale: " +cobra.getLetal());
		cobra.riproduzioneRettile();
		System.out.println("\n");
		
		
		Rana rana = new Rana(2,4);
		System.out.println("Rana");
		rana.respirazione();
		System.out.println("\n");
		
		
		
	}

}
