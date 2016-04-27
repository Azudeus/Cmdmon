package creature;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*@author Nathan James Runtuwene/13514083
*/
public abstract class Animal extends Creature {
  /**
  *directionX adalah arah pergerakan sumbu X dari Animal.
  *<br>1 menandakan pergerakan ke kanan dan -1 menandakan pergerakan ke kiri.
  *<br>directionY adalah arah pergerakan sumbu Y dari Animal.
  *<br>1 menandakan pergerakan ke atas dan -1 menandakan pergerakan ke bawah.
  */
  private int directionX;
  private int directionY;

  /**
  *Constructor dari kelas Animal yang tidak melakukan apa - apa.
  */
  public Animal() {
    //do nothing
  }

  /**
  *{@inheritDoc}
  *<br>Creature dalam kelas ini adalah Animal.
  */
  public abstract char draw();

  public abstract void draw(Graphics2D g);
  
  /**
  *{@inheritDoc}
  */
  public abstract void doAction();

  /**
  *Mengubah directionX Animal menjadi directionX pada parameter.
  *<br>Merupakan setter untuk mengubah arah pergerakan sumbu X.
  *@param directionX, integer yang menyatakan arah pergerakan sumbu X.
  */
  public void setDirectionX(int directionX) {
    this.directionX = directionX;
  }

  /**
  *Mengubah directionY Animal menjadi directionY pada parameter.
  *<br>Merupakan setter untuk mengubah arah pergerakan sumbu Y.
  *@param directionY, integer yang menyatakan arah pergerakan sumbu Y.
  */
  public void setDirectionY(int directionY) {
    this.directionY = directionY;
  }

  /**
  *Mengembalikan nilai directionX suatu Animal.
  *@return int, integer dengan nilai directionX suatu Animal.
  */
  public int getDirectionX() {
    return directionX;
  }

  /**
  *Mengembalikan nilai directionY suatu Animal.
  *@return int, integer dengan nilai directionY suatu Animal.
  */
  public int getDirectionY() {
    return directionY;
  }

  /**
  *Menggerakan animal sesuai dengan directionX dan directionY.
  *<br>rowPosition akan diubah menjadi rowPosition ditambah dengan directionX.
  *<br>columnPosition akan diubah menjadi columnPosition ditambah dengan directionY.
  *<br>Pengubahan ini dilakukan dengan menggunakan setRowPosition dan setColumnPosition.
  */
  protected void move() {
    setRowPosition(getRowPosition() + getDirectionX());
    setColumnPosition(getColumnPosition() + getDirectionY());
  }
}