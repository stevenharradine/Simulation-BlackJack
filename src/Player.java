import java.util.ArrayList;

public class Player {
  private Integer chips;

  public Player (Integer chips) {
    this.chips = chips;
  }

  public int getBet () {
    int bet = 5;

    this.chips -= bet;

    return bet;
  }

  public String play (Seat seat) {
    int total = seat.getPocketCount();
    
    if (total < 17) {
      return "hit";
    } else if (total > 21) {
      return "bust";
    } else {
      return "stand";
    }
  }
}