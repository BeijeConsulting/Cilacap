package it.beije.cilacap.esercizi;

public class MazzoCarte
{
	public static void main(String[] args)
	{
		String player1 = ("7");
		String player2 = ("A");
		boolean result;
		String deck = new String();
		deck = inizializzazione();
		result = gioco(deck, player1, player2);
		System.out.println("Il giocatore 1 vince: " + result);
		
	}
	
	public static String inizializzazione ()
	{
		String carte = ("A2345678910JQK");
		return carte;
	}

	public static boolean gioco (String mazzo, String carta1, String carta2)
	{
		boolean risultato = false;
		if (mazzo.indexOf(carta1)>mazzo.indexOf(carta2)) risultato = true;
		if (mazzo.indexOf(carta1) == 0 && mazzo.indexOf(carta2) == 13) risultato = true;
		if (mazzo.indexOf(carta2) == 0 && mazzo.indexOf(carta1) == 13) risultato = false;
		return risultato;
	}
}
