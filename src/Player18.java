import java.util.ArrayList;

public class Player18 extends Player {
  public Player18 (Float chips) {
    super (chips, "Player 18");
  }

  public int getBet () {
    int bet = 5;

    chips -= bet;

    return bet;
  }

  public String play_logic (Seat seat) {
    int total = seat.getPocketCount();

    if (total < 18) {
      return "hit";
    } else {
      return "stand";
    }
  }
}