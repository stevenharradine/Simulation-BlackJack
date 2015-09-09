/*
 *      author:  Steven J. Harradine
 *
 *    filename:  Hand.java
 *
 *     started:  20060305
 *    finished:  200603xx
 *
 * description:  This class will hold all data assosated with a black jack hand
 *
 */
 
class Hand {
	private static int count = 0;	// the high / low count
	
	private Card[] hand;
	private int numberOfCards;
	private int cash;
	private int bet;
	
	public Hand () {
		hand = new Card[10];
		numberOfCards = 0;
	}
	
	public Hand (int newCash) {
		hand = new Card[10];
		numberOfCards = 0;
		
		cash = newCash;
	}
	
	public void addCard (Card card) {
		hand[numberOfCards] = card;
		numberOfCards++;
		
		// modify the count
		if (card.getFaceValue() >= 10)
			count++;
		else if (card.getFaceValue() <= 6)
			count--;
	}
	
	public void bet (int newBet) {
		this.bet = newBet;
		
		cash -= newBet;
	}
	
	public Card getLastCard () {
		if (numberOfCards > 0)
			return hand[numberOfCards - 1];
		else
			return null;
	}
	
	public int getHandValue () {
		int handValue = 0;
		for (int i = 0; i < numberOfCards; i++)
			handValue += hand[i].getFaceValue();
			
		return handValue;
	}
	
	public int getCount () {
		return count;
	}

	public void resetCount () {
		count = 0;
	}
	
	public int getCash () {
		return cash;
	}
	
	public boolean isWinner (Hand dealerHand) {
		// TODO: use an enum here to include ties (a push)
		boolean didWin = false;	// is the user a winner
		
		// if you bust
		if (getHandValue() > 21)
			didWin = false;
		// if dealer busts
		else if (dealerHand.getHandValue() > 21)
			didWin = true;
		// if neither bust and you beat the dealer
		else if (getHandValue() > dealerHand.getHandValue())
			didWin = true;
		// tie
		else{}
		
		if (didWin == true)
			cash += 2 * bet;
		
		return didWin;
	}
	
	public void reset () {
		bet = 0;
		numberOfCards = 0;
	}
}