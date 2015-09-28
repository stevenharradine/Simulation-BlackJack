public class Dealer {
  private Seat seat;

	public Dealer () {
    seat = new Seat ();
    Player player = new Player17 (null);
    seat.addPlayer (player);
	}

  public Seat getSeat () {
    return seat;
  }
}