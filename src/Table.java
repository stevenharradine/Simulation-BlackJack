public class Table {
  private Dealer   dealer;
	private Shoe     shoe;
	private Seat[]   seats;

	public Table (int number_of_seats, int number_of_decks_in_shoe) {
		dealer = new Dealer ();
    shoe   = new Shoe (number_of_decks_in_shoe);
		seats  = new Seat[number_of_seats];

    for (int i = 0; i < seats.length; i++) {
      seats[i] = new Seat();
    }
	}

  public void addPlayer (Player player, int seatNumber) {
    seats[seatNumber].addPlayer (player);
  }

  public void play () {
    placeBets ();

    deal ();
  }

  private void deal () {
    for (Seat seat : seats ) {
      Player player = seat.getPlayer ();

      if (player != null) {
        seat.addCard (this.shoe.dealCard());
      }
    }

    dealer.getSeat().addCard (this.shoe.dealCard());
  }

  private void placeBets () {
    for (Seat seat : seats ) {
      if (seat.getPlayer() != null) {
        seat.placeBet ();
      }
    }
  }
}