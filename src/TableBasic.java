/*
 * Basic game of blackjack.  No splitting, no insurance, keeps it simple.
 */
public class TableBasic extends Table {
	public TableBasic (int number_of_seats, int number_of_decks_in_shoe) {
    super (number_of_seats, number_of_decks_in_shoe);
	}

  protected void payout () {
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

  protected void processTurns () {
    genericTurn (dealer.getSeat());
    for (Seat seat : seats ) {
      genericTurn (seat);
    }
  }

  protected void genericTurn (Seat seat) {
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

  protected void deal () {
    for (Seat seat : seats ) {
      Player player = seat.getPlayer ();

      if (player != null) {
        seat.addCard (shoe.dealCard());
      }
    }

    dealer.getSeat().addCard (shoe.dealCard());
  }

  protected void placeBets () {
    for (Seat seat : seats ) {
      if (seat.getPlayer() != null) {
        seat.placeBet ();
      }
    }
  }
}