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
 
 		int userCount;	// the value of all the users hand
 		int dealCount;	// the value of all the dealers hand
 		 		
 		Hand userCards = new Hand(100);	// all cards delt to the user
 		Hand dealCards = new Hand();	// all cards delt to the dealer
 		
 		int number_of_decks_in_shoe = 5;
 		Shoe shoe = new Shoe (number_of_decks_in_shoe);
 		
 		System.out.println ("\t\tBlack Jack Sim");
 		System.out.println ("\t\t~~~~~~~~~~~~~~");
 		
 		shoe.shuffle();	// shuffle the deck
 		
 		// print table header
 		System.out.println ("My Hand\t\tDealers Hand");
 		System.out.println ("~~~~~~~\t\t~~~~~~~~~~~~");
 		System.out.println ("");

		// hide the first card in the deck
		shoe.dealCard();
		
		for (int a = 0; a < number_of_decks_in_shoe * 5; a++) {
				// place bet
				if (userCards.getCount() > 10)
					userCards.bet (15);
				else if (userCards.getCount() > 0)
					userCards.bet (10);
				else
					userCards.bet (5);
				
				
				// deal user and dealer 1 card
		 		userCards.addCard(shoe.dealCard());
		 		dealCards.addCard(shoe.dealCard());
		 		
		 		// display table entry
				System.out.println (userCards.getLastCard() + "\t" + dealCards.getLastCard());
				
				// deal user cards
				do {
					userCards.addCard (shoe.dealCard());
					System.out.println (userCards.getLastCard());
				} while (userCards.getHandValue() < 17);

				// deal dealer cards
				do {
					dealCards.addCard (shoe.dealCard());
					System.out.println ("\t\t" + dealCards.getLastCard());
				} while (dealCards.getHandValue() < 17);

				// display footer
		 		System.out.println ("");
				System.out.println ("User: " + userCards.getHandValue() + "\tDealer: " + dealCards.getHandValue());
				System.out.println ("Cash: " + userCards.getCash());
				System.out.println ("\tCount: " + userCards.getCount());
				System.out.println ("");
				
				// fix bets
				System.out.println (userCards.isWinner (dealCards));
				
				// resets for new round
				userCards.reset();
				dealCards.reset();
		}
 	}
 }