import java.util.ArrayList;

public class Seat {
  private Player          player;
  private int             bet;
  private ArrayList<Card> pocket;

	public Seat () {
    player = null;
    bet    = 0;
    pocket = new ArrayList<>();
	}

  public void placeBet () {
    this.bet = this.player.getBet ();
  }

  public int getPocketCount () {
    int total = 0;

    for (Card card : pocket) {
      total += card.getFaceValue();
    }

    return total;
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

  public ArrayList<Card> getPocket () {
    return pocket;
  }

  public void addCard (Card card) {
    pocket.add (card);
  }
}