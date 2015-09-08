import java.util.Random;
import java.util.ArrayList;

public class Shoe {
	private ArrayList<Card> shoe = new ArrayList<Card>();
	private int currentCard;
	private Random randomNumbers;

	// constructor fills deck of Cards
	public Shoe(int number_of_decks) {
		// create n decks and put them into the shoe
		for (int i = 0; i < number_of_decks; i++) {
			DeckOfCards deck = new DeckOfCards();

			while (deck.hasMore ()) {
				shoe.add (deck.dealCard());
			}
		}

		currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
		randomNumbers = new Random(); // create random number generator
	}

	// shuffle deck of Cards with one-pass algorithm
	public void shuffle() {
		// after shuffling, dealing should start at deck[ 0 ] again
		currentCard = 0; // reinitialize currentCard

		// for each Card, pick another random Card and swap them
		for ( int first = 0; first < shoe.size(); first++ ) {
			// select a random number between 0 and 51 
			int second =  randomNumbers.nextInt( shoe.size() );
			// swap current Card with randomly selected Card
			Card temp = shoe.get(first);     
			shoe.set (first, shoe.get (second) );
			shoe.set (second, temp);
		}
	}

	// deal one Card
	public Card dealCard() {
		if ( currentCard < shoe.size() )
			return shoe.get (currentCard++);
		else        
			return null; // return null to indicate that all Cards were dealt
	}

	public boolean hasMore () {
		return currentCard < shoe.size();
	}
}