package it.beije.cilacap;

import java.util.Scanner;

public class Metodi {
	public static void printString(String a) {
		System.out.println(a + 1 + 2);

	}

	public static void printAll(String a) {
		System.out.println(1 + 2 + a);
	}

	public static void StartsWith(String s) {
		char[] lettere = s.toCharArray();
		char lettera = 'a';
		boolean vero = true;
		if (lettere[0] == lettera) {
			System.out.println("La parola inizia con " + lettera);
			vero = true;
		} else
			System.out.println("la parola non inizia con la" + lettera);
		vero = false;

	}
	public static void contain(String s) {
		String a="alex";
		boolean tr=false;
		if(s.indexOf(a)==-1) {
			System.out.println("parola non trovata");
			tr=false;
		}else {
			System.out.println("Parola trovata");
			tr=true;
		}
		
			
		}
		
		
	

	public static void EndWith(String s) {
		char[] lettere = s.toCharArray();
		char lettera = 'e';
		boolean vero = true;
		if (lettere[s.length() - 1] == lettera) {
			System.out.println("La parola finisce con " + lettera);
			vero = true;
		} else
			System.out.println("la parola non finisce con la" + lettera);
		vero = false;

	}

	public static void equals(String s) {
		String copia = "ciao";
		boolean vero = true;
		int count = 0;
		if (copia.length() == s.length()) {
			for (int i = 0; i < copia.length(); i++) {
				if (copia.charAt(i) != s.charAt(i)) {
					System.out.println("Le parole non corrispondono");
					vero = false;
					i = copia.length();
				} else {
					count++;
					if (count == copia.length()) {
						System.out.println("Le parole sono uguali!");
						i = copia.length();
					}
				}
			}

		} else {

			System.out.println("Le parole non sono uguali");
		}

	}

	public static void myreplace(char old, char newchar, String s) {
		System.out.println(s);
		char[] word = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (word[i] == old) {
				System.out.print(newchar);
			} else
				System.out.print(s.charAt(i));
		}

	}

	public static void substring(int start, int end) {
		System.out.println("");
		String stringa = "ciao come stai tutto bene te";
		char[] dividi = stringa.toCharArray();
		if (start < stringa.length() && end < stringa.length())
			for (int i = start; i < end; i++) {
				System.out.print(dividi[i]);
			}
		else {
			System.out.println("Non posso eseguire questa operazione");
		}

	}

	public static void main(String[] args) {

		String name = "Alex";
		String nome = new String("Alessandro");
		printString(name);
		printAll(nome) ;
		String animal = "animale";
		System.out.println("la lunghezza di " + animal + " è " + animal.length());
		for (int i = 0; i < animal.length() - 1; i++) {
			System.out.println("Alla posizione " + i + " troviamo " + animal.charAt(i));
		}
		StartsWith("alessandro");
		EndWith("ene");
		myreplace('c', 'e', "xicceouycfxxccccccccccccccc");
		System.out.println("");
		equals("yiao");
		substring(0, 12);
		System.out.println("");
		
		contain("alessandro");
		

	}

}
