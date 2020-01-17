package it.beije.cilacap.exercises;

import java.util.ArrayList;

public class Cards {

	public static void main(String[] args) {
		
		ArrayList<String> challengerfigure = new ArrayList<>();
		ArrayList<String> playerfigure = new ArrayList<>();
		double challenger = Math.floor((Math.random() * 14));
		int player = 3;
		
		
		if (challenger == 0.0) {
			challengerfigure.add("Ace");
		}
		else if (challenger == 11.0) {
			challengerfigure.add("Jack");
		}
		else if (challenger == 12.0) {
			challengerfigure.add("Queen");
		}
		else if (challenger == 13.0) {
			challengerfigure.add("King");
		}
		
		if (player == 0) {
			playerfigure.add("Ace");
		}
		else if (player == 11) {
			playerfigure.add("Jack");
		}
		else if (player == 12) {
			playerfigure.add("Queen");
		}
		else if (player == 13) {
			playerfigure.add("King");
		}
		
		System.out.println(player + " VS " + challenger);
		
		if (player == challenger) {
			if (challenger == 0 || challenger == 11 | challenger == 12 |challenger == 13) {
				System.out.println("It's a tie! Both players played " + challengerfigure.get(0) );
			}
			else {
				System.out.println("It's a tie! Both players played " + challenger);
			}
		}
 		else if (player - challenger > 0 || player - challenger == -13) {
 			if (challenger == 0.0 || challenger == 11.0 | challenger == 12.0 |challenger == 13.0) {
 				System.out.println("You win! You played a " + player + " and your opponent played a " + challengerfigure.get(0));
 			}
 			else {
 				System.out.println("You win! You played a " + player + " and your opponent played a " + challenger);
 			}
		}
		else {
			System.out.println("You lose! You played a " + player + " and your opponent played a " + challenger);
		}
		

	}

}
