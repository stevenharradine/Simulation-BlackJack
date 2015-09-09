public class Table {
	private Dealer dealer;
	private Seat   seats;

	public Table (int number_of_seats) {
		dealer = new Dealer ();
		seats  = new Seat[number_of_seats];

		for (Seat seat : seats) {
			seat = new Seat ();
		}
	}
}