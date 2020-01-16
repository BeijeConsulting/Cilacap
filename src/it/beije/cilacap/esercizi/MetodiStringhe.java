package it.beije.cilacap.esercizi;

public class MetodiStringhe
{
	
	public static void main(String[] args)
	{
		
		String s = "   La capra campa sopra la panca   ";
		
		int lunghezza; // variabile per la lunghezza della striga
		char charingresso; // variabile per il carattere in ingresso per verificare il contains
		
		lunghezza = s.length(); //inizializzazione
		charingresso = args[0].charAt(0);
		
		System.out.println("La lunghezza nella stringa è " + lunghezza); //lenght()
		
		boolean contains = false; // contains()
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == charingresso) contains = true;
		}
		System.out.println("La stringa contiene il carattere in ingresso? " + contains);
		
		contains(s, charingresso);
		
		boolean starts = false; // startsWith()
		if(s.charAt(0) == charingresso) starts = true;
		System.out.println("La stringa inizia per per il carattere in ingresso? " + starts);
		
		boolean ends = false; // endsWith()
		if(s.charAt(lunghezza-1) == charingresso) ends = true;
		System.out.println("La stringa finisce per il carattere in ingresso? " + ends);
		
		String trim = ""; // trim()
		int itrim=0; //variabile per determinare la prima posizione dove non c'è spazio
		int jtrim=lunghezza-1; //variabile per determinare l'ultima posizione senza spazi
		while (s.charAt(itrim) == ' ') itrim++;
		while (s.charAt(jtrim) == ' ') jtrim--;
		for ( ; itrim<jtrim+1; itrim++) //ciclo for che stampa su trim i valori
		{
			trim += s.charAt(itrim);
		}
		System.out.println("La frase senza spazi iniziali è la seguente:" + trim);
		
		
	}
	
	public static void contains(String s, char c)
	{
		boolean contains = false; // contains()
		for (int i=0; i<s.length(); i++)
		{
			if(s.charAt(i) == c) contains = true;
		}
		System.out.println("La stringa contiene il carattere in ingresso? " + contains);
	}
}