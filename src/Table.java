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
    shoe.shuffle ();

    placeBets ();

    deal ();
    deal ();

    playersTurn ();
    dealersTurn ();
  }

  private void dealersTurn () {
    do {
      dealer.getSeat().getPlayer().play(dealer.getSeat());

      String playerOption = dealer.getSeat().getPlayer().play (dealer.getSeat());

      switch (playerOption) {
        case "hit" : dealer.getSeat().addCard (shoe.dealCard());
                     break;
        default    : System.out.println ("--" + playerOption);
      }

      if (playerOption == "stand" || playerOption == "bust")
        break;
    } while (true);

    System.out.println (dealer.getSeat());
  }

  private void playersTurn () {
    for (Seat seat : seats ) {
      Player player = seat.getPlayer ();

      if (player != null) {
        do {
          String playerOption = player.play (seat);

          switch (playerOption) {
            case "hit"  : seat.addCard (shoe.dealCard());
                          break;
            default     : System.out.println ("--" + playerOption);
          }

          if (playerOption == "stand" || playerOption == "bust")
            break;
        } while (true);

        System.out.println (seat);
      }
    }
  }

  private void deal () {
    for (Seat seat : seats ) {
      Player player = seat.getPlayer ();

      if (player != null) {
        seat.addCard (shoe.dealCard());
      }
    }

    dealer.getSeat().addCard (shoe.dealCard());
  }

  private void placeBets () {
    for (Seat seat : seats ) {
      if (seat.getPlayer() != null) {
        seat.placeBet ();
      }
    }
  }
}