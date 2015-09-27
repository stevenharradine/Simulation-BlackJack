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

  public void play () {
    shoe.shuffle ();

    do {
      placeBets ();

      deal ();
      deal ();

      processTurns ();

      payout ();

      reset ();
    } while (true);
  }

  private void reset () {
    dealer = new Dealer ();

    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == null) {
        seats[i] = new Seat ();
      } else {
        seats[i].reset();
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

          System.out.println ("BlackJack!!! Winner!");
        } else if (standardWin) {
          winnings_bet_multiplier = 2f;

          System.out.println ("You Win!");
        } else {
          System.out.println ("You Lose.");
        }

        seat.getPlayer().addChips (seat.getBet() * winnings_bet_multiplier);

        System.out.println (seat.getPlayer().getChips());
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