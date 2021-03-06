package creature;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*@author Nathan James Runtuwene/13514083
*/
public class Centaur extends Animal {
  /**
  *Constructor dari kelas Centaur yang melakukan inisialisasi attribute.
  *<br>rowPosition akan diinisialisasi dengan row.
  *<br>columnPosition akan diinisialisasi dengan column.
  *<br>directionX akan diinisialisasi dengan directionX dari parameter.
  *<br>directionY akan diinisialisasi dengan directionY dari parameter.
  *<br>strength akan diinisialisasi dengan 25.
  *<br>actionInterval akan diinisialisasi dengan 800.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter.
  *@param row, integer yang menandakan posisi baris suatu creature di dunia.
  *@param column, integer yang menandakan posisi kolom suatu creature di dunia.
  *@param directionX, integer yang menandakan arah pergerakan Centaur pada sumbu X.
  *@param directionY, integer yang menandakan arah pergerakan Centaur pada sumbu Y.
  */
  public Centaur(final int row, final int column, final int directionX, final int directionY, final int multiplier) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(20 + 1 * multiplier);
    setActionInterval(50);
    setHealth(50 + 5 * multiplier);
    setRange(12);
    setSize(20);
  }

  /**
  *{@inheritDoc}
  *<br>Animal dalam hal ini adalah Centaur dengan char karakter khusus C.
  *@return {@inheritDoc}
  *<br>Karakter tersebut adalah C.
  */
  public char draw() {
    return 'C';
  }

  /**
  *{@inheritDoc}}
  */
  public void draw(Graphics2D g2) {
    //return 'P';
  ImageIcon ic = new ImageIcon("Assets/Centaur.png");
  Image i = ic.getImage();
  g2.drawImage(i, getRowPosition(), getColumnPosition(), null);
  }

  /**
  *{@inheritDoc}
  *<br>Aksi yang dilakukan kelas Centaur adalah bergerak (memanggil method move).
  */
  public void doAction() {
    move();
  }
}