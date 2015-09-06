// Fig. 7.9: Card.java
// Card class represents a playing card.

public class Card  {
	private String face; // face of card ("Ace", "Two", ...)
	private String suit; // suit of card ("Hearts", "Diamonds", ...)
	
	// two-argument constructor initializes card's face and suit
	public Card( String cardFace, String cardSuit ) {
		face = cardFace; // initialize face of card
		suit = cardSuit; // initialize suit of card
	} // end two-argument Card constructor
	
	// return String representation of Card
	public String toString() {                                      
		return face + " of " + suit;        
	} // end method toString               
	
	//----------------------------------------------------------------------------
	//----------------------------------MY MODS-----------------------------------
	//----------------------------------------------------------------------------
	
	// returns what the face of the current card is
	public String getFace () {
		return face;
	}
	
	// returns what the suit of the current card is
	public String getSuit () {
		return suit;
	}
	
	// returns a numerical value of the face of the card
	public int getFaceValue() {
			if (face == "Two")
				return 2;
			else if (face == "Three")
				return 3;
			else if (face == "Four")
				return 4;
			else if (face == "Five")
				return 5;
			else if (face == "Six")
				return 6;
			else if (face == "Seven")
				return 7;
			else if (face == "Eight")
				return 8;
			else if (face == "Nine")
				return 9;
			else if (face == "Ten")
				return 10;
			else if (face == "Jack")
				return 10;
			else if (face == "Queen")
				return 10;
			else if (face == "King")
				return 10;
			else if (face == "Ace")
				return 11;
		
		return -1;
	}
} // end class Card

