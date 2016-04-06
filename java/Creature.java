/**
*@author Nathan James Runtuwene/13514083
*/
public abstract class Creature {
  /**
  *strength merupakan integer yang menunjukan kekuatan dari suatu Creature. 
  *Kekuatan ini akan menentukan kelangsungan hidup dalam persaingan.
  *rowPosition merupakan integer yang menunjukan posisi baris dari Creature pada dunia.
  *columnPosition merupakan integer yang menunjukan posisi kolom dari Creature pada dunia.
  *actionInterval merupakan integer yang menunjukan jeda waktu antar aksi dari suatu Creature.
  */
  private int strength;
  private int rowPosition;
  private int columnPosition;
  private int actionInterval;

  /**
  *Constructor dari kelas Creature yang tidak melakukan apa - apa.
  */
  public Creature() {
    //do nothing
  }

  /**
  *Mengembalikan sebuah char yang merupakan penanda khusus dari suatu Creature.
  *@return char, char yang dikembalikan merupakan karakter penanda yang ditampilkan di dunia.
  */
  public abstract char draw();

  /**
  *Melakukan suatu aksi yang berhubungan dengan kelas yang memanggil fungsi ini.
  */
  public abstract void doAction();


  /**
  *Mengubah rowPosition Creature menjadi rowPosition pada parameter.
  *<br>Merupakan setter untuk mengubah posisi baris suatu mahluk.
  *@param rowPosition, integer yang menandakan posisi baris baru suatu Creature di dunia.
  */
  public void setRowPosition(int rowPosition) {
    this.rowPosition = rowPosition;
  }

  /**
  *Mengubah columnPosition Creature menjadi columnPosition pada parameter.
  *<br>Merupakan setter untuk mengubah posisi kolom suatu mahluk.
  *@param columnPosition, integer yang menandakan posisi kolom baru suatu Creature di dunia.
  */
  public void setColumnPosition(int columnPosition) {
    this.columnPosition = columnPosition;
  }

  /**
  *Mengubah strength Creature menjadi strength pada parameter.
  *<br>Merupakan setter untuk mengubah kekuatan suatu mahluk dalam persaingan.
  *@param strength, merupakan integer yang menandakan kekuatan suatu mahluk dalam persaingan.
  */
  public void setStrength(int strength) {
    this.strength = strength;
  }

  /**
  *Mengubah actionInterval Creature menjadi actionInterval pada parameter.
  *<br>Merupakan setter untuk mengubah jeda waktu antar aksi dari suatu Creature.
  *@param actionInterval, integer yang menandakan jeda waktu antar aksi dari suatu Creature.
  */
  public void setActionInterval(int actionInterval) {
    this.actionInterval = actionInterval;
  }

  /**
  *Mengembalikan nilai rowPosition suatu Creature.
  *@return int, integer dengan nilai rowPosition suatu Creature.
  */
  public int getRowPosition() {
    return rowPosition;
  }

  /**
  *Mengembalikan nilai columnPosition suatu Creature.
  *@return int, integer dengan nilai columnPosition suatu Creature.
  */
  public int getColumnPosition() {
    return columnPosition;
  }

  /**
  *Mengembalikan nilai strength suatu Creature.
  *@return int, integer dengan nilai strength suatu Creature.
  */
  public int getStrength() {
    return strength;
  }

  /**
  *Mengembalikan nilai actionInterval suatu Creature.
  *@return int, integer dengan nilai actionInterval suatu Creature.
  */
  public int getActionInterval() {
    return actionInterval;
  }
}