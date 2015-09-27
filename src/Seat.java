public class Seat {
  private Player player;
  private int    bet;

	public Seat () {
    this.player = null;
         bet    = 0;
	}

  public void placeBet () {
    this.bet = this.player.getBet ();
  }

  public void addPlayer (Player player) {
    this.player = player;
  }
  public Player getPlayer () {
    return player;
  }
  public void removePlayer () {
    this.player = null;
  }

  public void setBet (int bet) {
    this.bet = bet;
  }
  public int getBet () {
    return this.bet;
  }

  public void addCard (Card card) {

  }
}