import java.util.ArrayList;

public class Player16 extends Player {
  public Player16 (Float chips) {
    super (chips, "Player 16");
  }

  public int getBet () {
    int bet = 5;

    chips -= bet;

    return bet;
  }

  public String play_logic (Seat seat) {
    int total = seat.getPocketCount();

    if (total < 16) {
      return "hit";
    } else {
      return "stand";
    }
  }
}