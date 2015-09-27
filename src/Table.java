public class Table {
  private Dealer   dealer;
	private Shoe     shoe;
	private Player[] seats;

	public Table (int number_of_seats, int number_of_decks_in_shoe) {
		dealer = new Dealer ();
    shoe   = new Shoe (number_of_decks_in_shoe);
		seats  = new Player[number_of_seats];
	}

  public void addPlayer (Player player, int seatNumber) {
    seats[seatNumber] = player;
  }

  public void play () {
    placeBets ();
  }

  private void placeBets () {
    
  }
}