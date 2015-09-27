public class Player {
  private int chips;

  public Player (int chips) {
    this.chips = chips;
  }

  public int getBet () {
    int bet = 5;

    this.chips -= bet;

    return bet;
  }
}