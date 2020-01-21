package it.beije.cilacap.exercises;

import java.lang.Math;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		
		double challenger = Math.floor((Math.random() * 3));
		int player = 0;
		String choice = "";
		String yourchoice = "Paper";
		System.out.println(challenger);
		
		if (challenger == 0) {
			choice = "Rock";
		}
		else if (challenger == 1) {
			choice = "Paper";
		}
		else {
			choice = "Scissors";
		}
		System.out.println(choice);
		
		if (yourchoice == "Rock") {
			player = 0;
		}
		else if (yourchoice == "Paper") {
			player = 1;
		}
		else if (yourchoice == "Scissors") {
			player = 2;
		}
		
		if (player == challenger) {
			System.out.println("It's a tie! Both players played " + choice);
		}
		else if (player - challenger == 1 || player - challenger == -2) {
			System.out.println("You won! You played " + yourchoice + " and your opponent played " +choice);
		}
		else {
			System.out.println("You lost! You played " + yourchoice + " and your opponent played " +choice);
		}
	}
	
	

}
