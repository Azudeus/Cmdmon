/**
*@author Nathan James Runtuwene/13514083
*/

public class CreatureFactory {

  /**
  *createCreature mengembalikan Creature yang ingin dibuat.
  *@param what, String yang menunjukan apa yang ingin dibuat.
  *@param row, posisi baris dari Creature
  *@param column, posisi baris dari Creature
  *@param directionX, arah pergerakan sumbu X dari Creature
  *@param directionY, arah pergerakan sumbu Y dari Creature
  *@param multiplier, damage multiplier dari Creature
  */
  public static Creature createCreature(final String what, final int row, final int column, final int directionX, final int directionY, final int multiplier) {
    if (what.equals("Harpy")) {
      return new Harpy(row, column, directionX, directionY, multiplier);
    } else if (what.equals("Lamia")) {
      return new Lamia(row, column, directionX, directionY, multiplier);
    } else if (what.equals("Centaur")) {
      return new Centaur(row, column, directionX, directionY, multiplier);
    } else {
      return new Plant(row, column, multiplier);
    }
  }
}
