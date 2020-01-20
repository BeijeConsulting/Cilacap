package it.beije.cilacap.esercizi.games.morracinese;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MorraCinese{

	private boolean exitGameControlVariable = false;
	private String[] playersName = { "", "Computer" };
	private String nomeVincitore= "";
	private int timesMenuCalled = 0;

	@SuppressWarnings("resource")
	public void onMainMenu() {

		Scanner scan = new Scanner(System.in);
		timesMenuCalled++;
		if (timesMenuCalled <= 1)
			playersName[0] = askName();
		System.out.println();
		System.out.println(playersName[0] + " Iniziamo Subito a Giocare:");
		System.out.println("#################################################");
		System.out.println("Scegli La Modalità di Gioco Che Fa Per Te:");
		System.out.println("1 -- Player vs Computer");
		System.out.println("2 -- Player vs Player -- attualmente non disponibile");
		System.out.println("3 -- Esci Dal Gioco");
		System.out.println("#################################################");
		System.out.println();
		int choiceMenu = scan.nextInt();
		gameEngine(choiceMenu);

	}

	private String askName() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Ciao, Dimmi il tuo nome: ");
		playersName[0] = scan.next();
		return playersName[0];
	}

	
	public boolean exitGame() {
		return exitGameControlVariable;
	}

	
	public void choiceOneFlow() {
		System.out.println("Iniziamo, è il turno di " + playersName[0] + ".");
		System.out.println();
		int playerChoice = choiceScenarioPlayerVsCPU();
		int CPUChoice = ThreadLocalRandom.current().nextInt(1, 4); // da 1 (compreso) a 4 (escluso) 1-3
//		System.out.println(CPUChoice);
		conclusioneMatch(playerChoice, CPUChoice);
	}
	
	private void conclusioneMatch(int choicePlayer1, int choicePlayer2){
		
		Mossa mossaVincente = vinceLaMossa(choicePlayer1, choicePlayer2);
		
		if(mossaVincente == Mossa.UGUALE) {
			System.out.println("PAREGGIO");
		}
		else{
			System.out.println("vince con " + mossaVincente.toString() + " " + nomeVincitore);
			System.out.println("\n\n");
		}
	}

	public int choiceScenarioPlayerVsCPU() {

		int choicePlayer1 = onMoveMenu(playersName[0]);
		
		return choicePlayer1;
	}

	public int choiceScenarioPlayervsPlayer() {

		return 0;
	}

	public Mossa vinceLaMossa(int valueP1, int valueP2) {

		Mossa mossa1 = null;
		Mossa mossa2 = null;
		mossa1 = Mossa.prendiMossa(valueP1);  //prendo il valore intero e lo faccio diventare Mossa
		mossa2 = Mossa.prendiMossa(valueP2);
		Mossa mossaVincente = controllaVincente(mossa1, mossa2); //prendo le due mosse e tiro fuori la vincente
		nomeVincitore = controllaNomeVincente(mossa1, mossa2);
		return mossaVincente;  
	}
	
	public String controllaNomeVincente(Mossa mossa1, Mossa mossa2) {
		
		int toMatchName = mossa1.comparaMossa(mossa2);
		switch(toMatchName) {
		case 0: return "Nessuno Vincitore";
			
		case 1: return playersName[0];  //vince giocatore 1
			
		case -1: return playersName[1];		//vince giocatore 2
			
		}
		return "null";   //qua non arrivo.
	}
	
	
	public Mossa controllaVincente(Mossa mossa1, Mossa mossa2) {
		
		Mossa mossaUguale = Mossa.UGUALE;
		int toMatch = mossa1.comparaMossa(mossa2);
		switch(toMatch) {
		case 0: return mossaUguale;
			
		case 1: return mossa1;  //vince giocatore 1
			
		case -1: return mossa2;		//vince giocatore 2
			
		}
		return null; //qua non deve arrivare. 
	}

	@SuppressWarnings("resource")
	public int onMoveMenu(String nameP) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println(" scegli fra questi:");
		System.out.println("1 -- Sasso   --");
		System.out.println("2 -- Carta   --");
		System.out.println("3 -- Forbici --");		
		int choice = scan1.nextInt();		
		return choice;

	}

	
	public void gameEngine(int choiceMenu) {

		switch (choiceMenu) {
		case 1:
			choiceOneFlow();
			break;
		case 3:
			exitGameControlVariable = true;
			break;
		case 2:
			// choiceTwoFlow();
			break;
		default:
			System.out.println("immetti un valore valido per il momento sono valide le seguenti opzioni: 2 - 3");
		}
	}

	@SuppressWarnings({ "resource", "unused" })	
	public void choiceTwoFlow() {
		String nomePlayer2 ="";
		Scanner scan = new Scanner(System.in);
		System.out.println(playersName[0] + "è il tuo turno");
		int choicePlayer1 = onMoveMenu(playersName[0]);
		System.out.println("adesso è il turno dell'altro giocatore");
		int volte=1;
		if(volte!=2) { //solo la prima volta, dopo il nome l'ho già ottenuto.
			System.out.println("Inserisci il tuo nome: ");
			nomePlayer2 = scan.nextLine();
			playersName[1] = nomePlayer2;
			volte++;
		}
		int choicePlayer2 = onMoveMenu(playersName[1]);
		
		
	}

}
