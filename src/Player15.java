import java.util.ArrayList;

public class Player15 extends Player {
  public Player15 (Float chips) {
    super (chips, "Player 15");
  }

  public int getBet () {
    int bet = 5;

    chips -= bet;

    return bet;
  }

  public String play_logic (Seat seat) {
    int total = seat.getPocketCount();

    if (total < 15) {
      return "hit";
    } else {
      return "stand";
    }
  }
}