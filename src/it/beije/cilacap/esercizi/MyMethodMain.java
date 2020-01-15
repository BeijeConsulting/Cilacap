package it.beije.cilacap.esercizi;
import it.beije.cilacap.esercizi.Metodi;
public class MyMethodMain {

	public static void main(String[] args) {
		String a="stringa di prova";
		String b="nga";
	    Character c='s';
		Character d='a';
		Metodi m = new Metodi();
		
		//METODO MYCONTAINS
		if (m.myContains(a, b))
			System.out.println("La stringa cercata è presente nella stringa iniziale");
		else 
			System.out.println("La stringa cercata non è presente nella stringa iniziale");
		
		// METODO MYSTARTSWITH
		if(m.myStartsWith(a, c))
			System.out.println("La stringa inizia con la lettera "+ c);
		else 
			System.out.println("La stringa non inizia con la lettera"+ c);
		
		//METODO MYENDSWITH
		
		if(m.myEndsWith(a, d))
			System.out.println("La stringa finisce con la lettera "+d);
		else 
			System.out.println(("La stringa non finisce con la lettera "+d));
		
		//METODO MYTRIM
		
		System.out.println("La srtinga senza eventuali spazi all'inizio e alla fine è:  "+ m.myTrim(a));
		
		
	

	}
}
