import java.util.ArrayList;

public class Player13 extends Player {
  public Player13 (Float chips) {
    super (chips, "Player 13");
  }

  public int getBet () {
    int bet = 5;

    super.removeChips ((float)bet);

    return bet;
  }

  public String play_logic (Seat seat) {
    int total = seat.getPocketCount();

    if (total < 13) {
      return "hit";
    } else {
      return "stand";
    }
  }
}