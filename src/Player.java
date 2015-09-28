public abstract class Player {
  protected String name;

  abstract String play     (Seat seat);
  abstract int    getBet   ();
  abstract Float  getChips ();
  abstract void   addChips (Float chips);
  
  public String toString () {
    return name + "\n\tChips: " + getChips();
  }
}