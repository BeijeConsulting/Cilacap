package it.beije.cilacap;

public class RockPaperScissors {
	public static void main(String[] args) {
	RPS("Carta");
	}
	
	public static void RPS(String scelta) {
		int sceltaPlayer1 = 10;
		if (scelta == "Sasso") {
			sceltaPlayer1 = 0;
		}
		else if (scelta == "Carta") {
			sceltaPlayer1 = 1;
		}
		else if (scelta == "Forbice") {
			sceltaPlayer1 = 2;
		}
		
		String[] opzioni = {"Sasso", "Carta", "Forbice"};
		
		int sceltaPlayer2 = (int)(Math.random() * 3);
		
		if(sceltaPlayer1 > sceltaPlayer2) {
			
				if(sceltaPlayer1 == 2 && sceltaPlayer2 == 0) {
					System.out.println(opzioni[sceltaPlayer1] + " Perde su " + opzioni[sceltaPlayer2]);
				} else {
					System.out.println(opzioni[sceltaPlayer1] + " Vince su " + opzioni[sceltaPlayer2]);
				}
				
		} else if (sceltaPlayer1 == sceltaPlayer2) {
			System.out.println(opzioni[sceltaPlayer1] + " Pareggia con " + opzioni[sceltaPlayer2]);
			
		} else if(sceltaPlayer1 < sceltaPlayer2) {

				if(sceltaPlayer1 == 0 && sceltaPlayer2 == 2) {
					System.out.println(opzioni[sceltaPlayer1] + " Vince su " + opzioni[sceltaPlayer2]);
				} else {
					System.out.println(opzioni[sceltaPlayer1] + " Perde su " + opzioni[sceltaPlayer2]);
				}
		} 
	}
}
