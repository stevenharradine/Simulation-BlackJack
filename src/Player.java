public abstract class Player {
  protected String name;
  protected Float  chips;

  abstract String play_logic (Seat seat);
  abstract int    getBet     ();

  public Player (Float chips, String name) {
    this.chips = chips;
    this.name  = name;
  }

  public String play (Seat seat) {
    int total = seat.getPocketCount();

    if (total > 21) {           // protect the bust outcome from player deception
      return "bust";
    } else {
      return play_logic (seat); // hand off the the player for logic
    }
  }

  public Float getChips () {
    return chips;
  }
  public void addChips (Float chips) {
    this.chips += chips;
  }
  public void removeChips (Float chips) {
    this.chips -= chips;
  }

  public String toString () {
    return name + "\n\tChips: " + getChips();
  }
}