import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
  private int range;
  private int health;
  private int size;

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

  public abstract void draw(Graphics2D g2);
  
  /**
  *Melakukan suatu aksi yang berhubungan dengan kelas yang memanggil fungsi ini.
  */
  public abstract void doAction();


  /**
  *Mengubah rowPosition Creature menjadi rowPosition pada parameter.
  *<br>Merupakan setter untuk mengubah posisi baris suatu mahluk.
  *@param rowPosition, integer yang menandakan posisi baris baru suatu Creature di dunia.
  */
  public void setRowPosition(final int rowPosition) {
    this.rowPosition = rowPosition;
  }

  /**
  *Mengubah columnPosition Creature menjadi columnPosition pada parameter.
  *<br>Merupakan setter untuk mengubah posisi kolom suatu mahluk.
  *@param columnPosition, integer yang menandakan posisi kolom baru suatu Creature di dunia.
  */
  public void setColumnPosition(final int columnPosition) {
    this.columnPosition = columnPosition;
  }

  /**
  *Mengubah strength Creature menjadi strength pada parameter.
  *<br>Merupakan setter untuk mengubah kekuatan suatu mahluk dalam persaingan.
  *@param strength, merupakan integer yang menandakan kekuatan suatu mahluk
  */
  public void setStrength(final int strength) {
    this.strength = strength;
  }

  /**
  *Mengubah nyawa seseorang Creature.
  *@param health, menupakan integer yang menandakan nyawa Creature.
  */
  public void setHealth(final int health) {
    this.health = health;
  }


  /**
  *Mengubah ukuran
  *@param health, menupakan integer yang menandakan ukuran Creature.
  */
  public void setSize(final int size) {
    this.size = size;
  }
  
  /**
  *Mengubah actionInterval Creature menjadi actionInterval pada parameter.
  *<br>Merupakan setter untuk mengubah jeda waktu antar aksi dari suatu Creature.
  *@param actionInterval, integer yang menandakan jeda waktu antar aksi dari suatu Creature.
  */
  public void setActionInterval(final int actionInterval) {
    this.actionInterval = actionInterval;
  }

  /**
  *<br>Merupakan setter untuk mengubah jarak serang makhluk ini.
  *@param range, integer range teraru
  */
  public void setRange(final int range) {
    this.range = range;
  }

  /**
  *Mengembalikan nilai rowPosition suatu Creature.
  *@return int, integer dengan nilai rowPosition suatu Creature.
  */
  public final int getRowPosition() {
    return rowPosition;
  }

  /**
  *Mengembalikan nilai columnPosition suatu Creature.
  *@return int, integer dengan nilai columnPosition suatu Creature.
  */
  public final int getColumnPosition() {
    return columnPosition;
  }

  /**
  *Mengembalikan nilai strength suatu Creature.
  *@return int, integer dengan nilai strength suatu Creature.
  */
  public final int getStrength() {
    return strength;
  }

  /**
  *Mengembalikan nilai actionInterval suatu Creature.
  *@return int, integer dengan nilai actionInterval suatu Creature.
  */
  public final int getActionInterval() {
    return actionInterval;
  }
  
  /**
  *Mengembalikan nilai Rangge suatu Creature.
  *@return int, integer dengan nilai range suatu Creature.
  */
  public final int getRange() {
    return range;
  }

  /**
  *Mengembalikan nilai health suatu Creature.
  *@return int, integer dengan nilai health suatu Creature.
  */
  public final int getHealth() {
    return health;
  }

  /**
  *Mengembalikan nilai size suatu Creature.
  *@return int, integer dengan nilai size suatu Creature.
  */
  public final int getSize(){
    return size;
  }
}
