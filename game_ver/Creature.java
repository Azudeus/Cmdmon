/**
*@author Nathan James Runtuwene/13514083
*/
public abstract class Creature {
  /**
  *strength merupakan integer yang menunjukan kekuatan dari suatu creature. 
  *Kekuatan ini akan menentukan kelangsungan hidup dalam persaingan.
  *rowPosition merupakan integer yang menunjukan posisi baris dari creature pada dunia.
  *columnPosition merupakan integer yang menunjukan posisi kolom dari creature pada dunia.
  *actionInterval merupakan integer yang menunjukan jeda waktu antar aksi dari suatu creature.
  */
  private int strength;
  private int rowPosition;
  private int columnPosition;
  private int actionInterval;
  
  /**
  *Constructor dari kelas creature yang tidak melakukan apa - apa.
  */
  public Creature() {
    //do nothing
  }

  /**
  *Mengembalikan sebuah char yang merupakan penanda khusus dari suatu creature.
  *@return char, char yang dikembalikan merupakan karakter penanda yang ditampilkan di dunia.
  */
  public abstract char draw();

  /**
  *Melakukan suatu aksi yang berhubungan dengan kelas yang memanggil fungsi ini.
  */
  public abstract void doAction();


  /**
  *Mengubah rowPosition creature menjadi rowPosition pada parameter.
  *<br>Merupakan setter untuk mengubah posisi baris suatu mahluk.
  *@param rowPosition, integer yang menandakan posisi baris baru suatu creature di dunia.
  */
  public void setRowPosition(int rowPosition) {
    this.rowPosition = rowPosition;
  }

  /**
  *Mengubah columnPosition creature menjadi columnPosition pada parameter.
  *<br>Merupakan setter untuk mengubah posisi kolom suatu mahluk.
  *@param columnPosition, integer yang menandakan posisi kolom baru suatu creature di dunia.
  */
  public void setColumnPosition(int columnPosition) {
    this.columnPosition = columnPosition;
  }

  /**
  *Mengubah strength creature menjadi strength pada parameter.
  *<br>Merupakan setter untuk mengubah kekuatan suatu mahluk dalam persaingan.
  *@param strength, merupakan integer yang menandakan kekuatan suatu mahluk dalam persaingan.
  */
  public void setStrength(int strength) {
    this.strength = strength;
  }

  /**
  *Mengubah actionInterval creature menjadi actionInterval pada parameter.
  *<br>Merupakan setter untuk mengubah jeda waktu antar aksi dari suatu creature.
  *@param actionInterval, integer yang menandakan jeda waktu antar aksi dari suatu creature.
  */
  public void setActionInterval(int actionInterval) {
    this.actionInterval = actionInterval;
  }

  /**
  *Mengembalikan nilai rowPosition suatu creature.
  *@return int, integer dengan nilai rowPosition suatu creature.
  */
  public int getRowPosition() {
    return rowPosition;
  }

  /**
  *Mengembalikan nilai columnPosition suatu creature.
  *@return int, integer dengan nilai columnPosition suatu creature.
  */
  public int getColumnPosition() {
    return columnPosition;
  }

  /**
  *Mengembalikan nilai strength suatu creature.
  *@return int, integer dengan nilai strength suatu creature.
  */
  public int getStrength() {
    return strength;
  }

  /**
  *Mengembalikan nilai actionInterval suatu creature.
  *@return int, integer dengan nilai actionInterval suatu creature.
  */
  public int getActionInterval() {
    return actionInterval;
  }
}