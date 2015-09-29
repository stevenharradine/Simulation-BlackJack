import java.util.ArrayList;

public class Player17 extends Player {
  public Player17 (Float chips) {
    super (chips, "Player 17");
  }

  public int getBet () {
    int bet = 5;

    chips -= bet;

    return bet;
  }

  public String play_logic (Seat seat) {
    int total = seat.getPocketCount();

    if (total < 17) {
      return "hit";
    } else {
      return "stand";
    }
  }
}