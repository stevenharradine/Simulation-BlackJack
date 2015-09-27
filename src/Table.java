public class Table {
  private Dealer   dealer;
	private Shoe     shoe;
	private Seat[]   seats;

	public Table (int number_of_seats, int number_of_decks_in_shoe) {
		dealer = new Dealer ();
    shoe   = new Shoe (number_of_decks_in_shoe);
		seats  = new Seat[number_of_seats];
	}

  public void addPlayer (Player player, int seatNumber) {
    seats[seatNumber].addPlayer (player);
  }

  public void play () {
    placeBets ();
  }

  private void placeBets () {
    for (Seat seat : seats ) {
      if (seat.getPlayer() != null) {
        seat.placeBet ();
      }
    }
  }
}