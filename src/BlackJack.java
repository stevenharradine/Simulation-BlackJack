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


 		Integer number_of_hands_to_simulate  = 1000000;
 		int     number_of_seats_at_the_table = 7;
 		int     number_of_decks_in_shoe      = 6;
 		float   playerChips                  = 100;

 		Table table = new Table (
 			number_of_seats_at_the_table,
 			number_of_decks_in_shoe
 		);

 		table.addPlayer (new Player13 (playerChips), 0);
 		table.addPlayer (new Player14 (playerChips), 1);
 		table.addPlayer (new Player15 (playerChips), 2);
 		table.addPlayer (new Player16 (playerChips), 3);
 		table.addPlayer (new Player17 (playerChips), 4);
 		table.addPlayer (new Player18 (playerChips), 5);

 		table.play(number_of_hands_to_simulate);
 	}
 }
