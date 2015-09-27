/*
 *      author:  Steven J. Harradine
 *
 *    filename:  BlackJack.java
 *
 *     started:  20060305
 *    finished:  200603xx
 *
 * description:  This program will simulation the effectiveness of counting cards
 *               in black jack including: high / low count
 *
 *    features:  seating position
 *               number of decks
 *               number of players
 *
 */
 
 import java.util.*;
 
 public class BlackJack {
 	public static void main (String[] args) {
 		Scanner sc = new Scanner (System.in);	// input stream
 		
 		System.out.println ("\t\tBlack Jack Sim");
 		System.out.println ("\t\t~~~~~~~~~~~~~~");


 		int number_of_seats_at_the_table = 5;
 		int number_of_decks_in_shoe      = 6;

 		Table table = new Table (
 			number_of_seats_at_the_table,
 			number_of_decks_in_shoe
 		);

 		float    basicPlayerChips = 100;

 		table.addPlayer (new Player (basicPlayerChips), 0);
 		table.addPlayer (new Player (basicPlayerChips), 1);
 		table.addPlayer (new Player (basicPlayerChips), 2);

 		table.play();
 	}
 }
