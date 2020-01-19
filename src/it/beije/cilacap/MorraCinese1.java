package it.beije.cilacap;

import java.util.Random;
import java.util.Scanner;

public class MorraCinese1 {
	public static void main(String[] args) {
		String p1 = null;
		String p2 = null;
		String[] scelta = { "sasso", "carta", "forbice" };
		Random rand = new Random();
		int casuale = rand.nextInt(scelta.length);
		Scanner s = new Scanner(System.in);
		if (casuale == 0) {
			System.out.println("scelta pc : sasso");
			p2 = new String("sasso");
		} else if (casuale == 1) {
			System.out.println("scelta pc : carta");
			p2 = new String("carta");
		} else {
			System.out.println("scelta pc : forbice");
			p2 = new String("forbice");
		}

		p1 = s.next();
		System.out.println("scelta Player1 :" + p1);

		if (p1.equals("sasso") && p2.equals("carta")) {
			System.out.println("\nPC vince");
		} else if (p1.equals("carta") && p2.equals("sasso"))
			System.out.println("\nPlayer vince");

		if (p1.equals("forbice") && p2.equals("sasso")) {
			System.out.println("\nPC vince");
		} else if (p1.equals("sasso") && p2.equals("forbice"))
			System.out.println("\nPlayer 1 vince");

		if (p1.equals("forbice") && p2.equals("carta")) {
			System.out.println("\nPlayer 1 vince");
		} else if (p1.equals("carta") && p2.equals("forbice"))
			System.out.println("\nPC vince");

		if (p1.equals(p2))
			System.out.println("\npareggio");

	}

}
