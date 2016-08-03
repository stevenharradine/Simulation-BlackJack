public abstract class Table {
  protected Dealer   dealer;
	protected Shoe     shoe;
	protected Seat[]   seats;

  abstract void play (Integer number_of_hands);
  abstract void payout ();
  abstract void processTurns ();
  abstract void genericTurn (Seat seat);
  abstract void deal ();
  abstract void placeBets ();

	public Table (int number_of_seats, int number_of_decks_in_shoe) {
    shoe  = new Shoe (number_of_decks_in_shoe);
		seats = new Seat[number_of_seats];

    reset ();
	}

  public void addPlayer (Player player, int seatNumber) {
    seats[seatNumber].addPlayer (player);
  }

  protected void reset () {
    dealer = new Dealer ();

    for (int i = 0; i < seats.length; i++) {
      Seat seat = seats[i];
      
      if (seat == null) {
        seats[i] = new Seat ();
      } else {
        seat.reset();
      }
    }

    if (shoe.needsShuffle()) {
      shoe.shuffle ();
    }
  }
}