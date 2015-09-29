public class Table {
  private Dealer   dealer;
	private Shoe     shoe;
	private Seat[]   seats;

	public Table (int number_of_seats, int number_of_decks_in_shoe) {
    shoe  = new Shoe (number_of_decks_in_shoe);
		seats = new Seat[number_of_seats];

    reset ();
	}

  public void addPlayer (Player player, int seatNumber) {
    seats[seatNumber].addPlayer (player);
  }

  public void play (Integer number_of_hands) {
    Integer hand_counter = 0;

    shoe.shuffle ();

    do {
      placeBets ();

      deal ();
      deal ();

      processTurns ();

      payout ();

      reset ();
      hand_counter++;
    } while (
      number_of_hands == null || 
      number_of_hands != null &&
      hand_counter <= number_of_hands
    );
  }

  private void reset () {
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

  private void payout () {
    for (Seat seat : seats ) {
      Player player = seat.getPlayer ();

      if (player != null) {
        boolean blackjack   = seat.getPocketCount() == 21 &&
                              seat.getPocket().size() == 2;
        boolean standardWin = seat.getPocketCount() <= 21 &&
                              seat.getPocketCount() > dealer.getSeat().getPocketCount() ||
                              seat.getPocketCount() <= 21 &&
                              dealer.getSeat().getPocketCount() > 21;
        Float winnings_bet_multiplier = 0f;

        if (blackjack) {
          winnings_bet_multiplier = 2.5f;
        } else if (standardWin) {
          winnings_bet_multiplier = 2f;
        }

        System.out.println (player);

        seat.getPlayer().addChips (seat.getBet() * winnings_bet_multiplier);
      }
    }
  }

  private void processTurns () {
    genericTurn (dealer.getSeat());
    for (Seat seat : seats ) {
      genericTurn (seat);
    }
  }

  private void genericTurn (Seat seat) {
    Player player = seat.getPlayer();

    if (player != null) {
      do {
        String playerOption = player.play (seat);

        switch (playerOption) {
          case "hit" : seat.addCard (shoe.dealCard());
                       break;
          default    : System.out.println ("--" + playerOption);
        }

        if (playerOption == "stand" || playerOption == "bust")
          break;
      } while (true);

      System.out.println (seat);
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