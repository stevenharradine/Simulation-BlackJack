public abstract class Player {
  abstract String play (Seat seat);
  abstract int getBet ();
  abstract Float getChips ();
  abstract void addChips (Float chips);
}