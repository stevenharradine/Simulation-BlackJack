import java.util.ArrayList;

public class Player17 extends Player {
  private Float chips;

  public Player17 (Float chips) {
    this.chips = chips;
  }

  public int getBet () {
    int bet = 5;

    chips -= bet;

    return bet;
  }

  public Float getChips () {
    return chips;
  }
  public void addChips (Float chips) {
    this.chips += chips;
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