package it.beije.cilacap.esercizi.games.morracinese;

public class MorraCineseMain {

	public static void main(String[] args) {

		MorraCinese game = new MorraCinese();
		
		do {
			game.onMainMenu(); //schermata principale

		} while (!game.exitGame());  //uscita dal gioco.
		
		System.err.print("SEI USCITO DAL GIOCO");

	}

}
