package it.beije.cilacap.esercizi;

public class MetodiStringBuilder
{
	public static void main (String args[])
	{
		String ingresso = "La capra campa 1"; //memorizza l'ingresso in una stringa
		char charingresso = args[0].charAt(0); //carattere in ingresso per le verifiche dei vari metodi
		
		String s; //memorizza il valore di ritorno del metodo reverse()
		boolean c; //memorizza il valore di ritorno del metodo contains()
		boolean start; //memorizza il valore di ritorno del metodo startsWith()
		boolean end; //memeorizza il valore di ritorno del metodo endsWith()
		String trimmed; //memorizza il valore di ritorno del metodo trim()
		boolean v; //memorizza il valore di ritorno del metodo equals()
		String verifica = "La capra campa 0"; //stringa necessaria per la verifica di equals()
		
		s = reverse(ingresso);
		System.out.println(s);
		
		c = contains(ingresso, charingresso);
		System.out.println(c);
		
		start = starsWith(ingresso, charingresso);
		System.out.println(start);
		
		end = endsWith(ingresso, charingresso);
		System.out.println(end);
		
		trimmed = trim(ingresso);
		System.out.println(trimmed);
		
		v = myEquals(ingresso, verifica);
		System.out.println(v);
	
	}
	
	public static String reverse(String stringa) //metodo reverse() che restituisce una String con il contenuto invertito.
	{
		String sout; //stringa trasmessa in uscita
		StringBuilder stringainversa = new StringBuilder();
		for (int i=stringa.length()-1; i>-1; i--)
		{
			stringainversa.append(stringa.charAt(i));
		}
		sout = stringainversa.toString();
		return sout;
	}
	
	public static boolean contains(String stringa, char carattere) //metodo contains()
	{
		boolean contains = false;
		for (int i=0; i<stringa.length(); i++)
		{
			if(stringa.charAt(i) == carattere) contains = true;
		}
		return contains;
	}
	
	public static boolean starsWith(String stringa, char carattere) //metodo starsWith()
	{
		boolean starts = false;
		if(stringa.charAt(0) == carattere) starts = true;
		return starts;
	}
	
	public static boolean endsWith(String stringa, char carattere) //metodo endsWith()
	{
		boolean ends = false;
		if(stringa.length()-1 == carattere) ends = true;
		return ends;
	}
	
	public static String trim(String stringa)
	{
		String trim = "";
		StringBuilder trimmedstring = new StringBuilder();
		int itrim=0; //variabile per determinare la prima posizione dove non ci sono spazi
		int jtrim=stringa.length()-1; //variabile per determinare l'ultima posizione senza spazi
		while (stringa.charAt(itrim) == ' ') itrim++;
		while (stringa.charAt(jtrim) == ' ') jtrim--;
		for ( ; itrim<jtrim+1; itrim++) //ciclo for che stampa su trim i valori
		{
			trimmedstring.append(stringa.charAt(itrim));
		}
		trim = trimmedstring.toString();
		return trim;
	}
	
	public static boolean myEquals(String stringa, String verificare)
	{
		boolean verificato = false;
		if (stringa.length() == verificare.length())
		{
			verificato = true;
			for(int i=0; i<stringa.length(); i++)
			{
				if (stringa.charAt(i) != verificare.charAt(i)) verificato = false;
			}
		}
		return verificato;
	}

}
