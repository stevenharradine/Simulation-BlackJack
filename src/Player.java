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
}