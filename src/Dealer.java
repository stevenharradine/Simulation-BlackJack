public class Dealer {
  private Seat seat;

	public Dealer () {
    seat = new Seat ();
    seat.addPlayer (new Player (null));
	}

  public Seat getSeat () {
    return seat;
  }
}