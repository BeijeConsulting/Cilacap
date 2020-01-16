package it.beije.cilacap.esercizi;
import it.beije.cilacap.esercizi.Metodi;
import java.util.Scanner;
public class MyMethodMain {

	public static void main(String[] args) {
		String a="stringa di prova";
		String b="nga";
	    Character c='s';
		Character d='a';
		int inizIndex,finIndex;
		try (Scanner keyboard = new Scanner(System.in)) {
			char dasost;
			char sost;
			String hlp1= new String();
			String hlp2= new String();
			String input=new String();
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
			
			System.out.println("La stringa senza eventuali spazi all'inizio e alla fine è:"+ m.myTrim(a));
			
			//METODO MYREPLACE
			System.out.println("Inserisci il carattere da sostituire all'interno della stringa:  ");
			hlp1= keyboard.nextLine();
			dasost=hlp1.charAt(0);
			System.out.println("Inserire il carattere che sostituisce");
			hlp2=keyboard.nextLine();
			sost=hlp2.charAt(0);
			System.out.println("La stringa risultante è: "+ m.myReplace(a, dasost, sost));
			
			//METODO MYEQUALS
			System.out.println("Inserire la stringa da comparare  ");
			input=keyboard.nextLine();
			if(m.myEquals(a, input)) 
				System.out.println("Le due stringhe sono uguali");
			else 
				System.out.println("Le due stringhe non sono uguali");
				
			//METODO MYREVERSE
			System.out.println("La stringa rovesciata è: " + m.myReverse(a));
			
			//METODO MYSUBSTRING
			
			System.out.println("Inserisci la posizione di inizio della sottostringa");
			inizIndex=keyboard.nextInt();
			System.out.println("Inserisci la posizione di fine della sottostringa");
			finIndex=keyboard.nextInt();
			System.out.println("La sottostringa è:"+ m.mySubstring(a, inizIndex, finIndex));
			
			
				
		}
	}
}


		
		
	



