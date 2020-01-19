package it.beije.cilacap;

import java.util.Scanner;

public class MorraCinese2 {
	public static void main(String[] args) {
		String p1 = null;
		String p2 = null;
		Scanner s = new Scanner(System.in);

		p1 = s.next();
		System.out.println("Scelta 1: " + p1);
		p2 = s.next();
		System.out.println("Scelta 2: " + p2);

		if (p1.equals("sasso") && p2.equals("carta")) {
			System.out.println("\nScelta 2 vince");
		} else if (p1.equals("carta") && p2.equals("sasso"))
			System.out.println("\nscelta 1 vince");

		if (p1.equals("forbice") && p2.equals("sasso")) {
			System.out.println("\nScelta 2 vince");
		} else if (p1.equals("sasso") && p2.equals("forbice"))
			System.out.println("\nscelta 1 vince");

		if (p1.equals("forbice") && p2.equals("carta")) {
			System.out.println("\nScelta 1 vince");
		} else if (p1.equals("carta") && p2.equals("forbice"))
			System.out.println("\nscelta 2 vince");

		if (p1.equals(p2))
			System.out.println("\npareggio");
	}

}
