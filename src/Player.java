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

  public String play (ArrayList<Card> cards, int bet) {
    int total = 0;

    for (Card card : cards) {
      total += card.getFaceValue();
    }

    if (total < 17) {
      return "hit";
    } else {
      return "stand";
    }
  }
}