import java.util.ArrayList;

public class Player14 extends Player {
  public Player14 (Float chips) {
    super (chips, "Player 14");
  }

  public int getBet () {
    int bet = 5;

    chips -= bet;

    return bet;
  }

  public String play_logic (Seat seat) {
    int total = seat.getPocketCount();

    if (total < 14) {
      return "hit";
    } else {
      return "stand";
    }
  }
}