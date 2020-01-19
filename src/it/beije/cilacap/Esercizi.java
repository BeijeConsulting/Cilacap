package it.beije.cilacap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Esercizi {
	static String[] parole = { "ciao", "acqua", "mare", "borsa" };
	static ArrayList<String> words = new ArrayList<String>();
	static ArrayList<String> words2 = new ArrayList<String>();
	static int[] numeri = { 1, 5, 2, 9, 9, 3 };

	//// Array
	int mySearching(String[] parole, String e) {
		int pos = 0;
		for (int i = 0; i < parole.length; i++) {
			if (parole[i] == e) {
				pos = i;
				break;
			}
		}
		return pos;

	}

	void mySorting(int[] numeri, String e) {
		if (e == "ASC") {
			for (int i = 0; i < numeri.length; i++) {
				for (int j = 0; j < numeri.length; j++) {
					if (i != j) {
						if (numeri[i] < numeri[j]) {
							int temp = numeri[j];
							numeri[j] = numeri[i];
							numeri[i] = temp;
						}
					}
				}

			}
		}

		else if (e == "DESC") {
			for (int i = 0; i < numeri.length; i++) {
				for (int j = 0; j < numeri.length; j++) {
					if (i != j) {
						if (numeri[i] > numeri[j]) {
							int temp = numeri[j];
							numeri[j] = numeri[i];
							numeri[i] = temp;
						}
					}
				}

			}
		}

		else
			System.out.println("parametro errato");

		for (int i = 0; i < numeri.length; i++) {
			System.out.print(numeri[i] + " ");
		}
		System.out.println();
	}

	// ArrayList

	
	void myClear(ArrayList<String> words) {
		for (int i = 0; i < words.size(); i++) {
			words.add(null);
		}
	}

	List reverse(ArrayList<String> words) {
		ArrayList<String> array = new ArrayList<String>();
		for (int i = words.size() - 1; i >= 0; i--) {
			array.add(words.get(i));
		}
		return array;
	}

	boolean myEquals(ArrayList<String> words, ArrayList<String> words2) {
		if (words.size() != words2.size()) {
			System.out.println("diversi");
			return false;
		}
		for (int i = 0; i < words.size(); i++) {
			if (!words.get(i).equals(words2.get(i))) {
				System.out.println("diversi");
				return false;
			}
		}
		System.out.println("uguali");
		return true;
	}

	public static void main(String[] args) {

		Esercizi e = new Esercizi();
		//// Array
		if (e.mySearching(parole, "borsa") > 0) {
			System.out.print("trovato in posizione ");
			System.out.println(e.mySearching(parole, "borsa"));
		} else
			System.out.println("non trovato");

		e.mySorting(numeri, "DESC");

		//// ArrayList
		words.add("zio");
		words.add("nonno");
		words.add("papà");
		words.add("fratello");
		words.add("mamma");
		
		words2.add("zio");
		words2.add("nonno");
		words2.add("pa");
		words2.add("fratello");
		words2.add("mamma");

		e.myEquals(words, words2);
		// e.myClear(words);

		System.out.println(e.reverse(words));
	}

}
