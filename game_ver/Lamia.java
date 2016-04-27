import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*@author Nathan James Runtuwene/13514083
*/
public class Lamia extends Animal {
  /**
  *Constructor dari kelas Lamia yang melakukan inisialisasi attribute.
  *<br>rowPosition akan diinisialisasi dengan row.
  *<br>columnPosition akan diinisialisasi dengan column.
  *<br>directionX akan diinisialisasi dengan directionX dari parameter.
  *<br>directionY akan diinisialisasi dengan directionY dari parameter.
  *<br>strength akan diinisialisasi dengan 10.  
  *<br>actionInterval akan diinisialisasi dengan 1200.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter.
  *@param row, integer yang menandakan posisi baris suatu creature di dunia.
  *@param column, integer yang menandakan posisi kolom suatu creature di dunia.
  *@param directionX, integer yang menandakan arah pergerakan Lamia pada sumbu X.
  *@param directionY, integer yang menandakan arah pergerakan Lamia pada sumbu Y.
  */
  public Lamia(final int row, final int column, final int directionX, final int directionY, final int multiplier) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(10 + 1 * multiplier / 3);
    setActionInterval(100);
    setHealth(30 + 3 * multiplier);
    setRange(30);
    setSize(20);
  }

  /**
  *{@inheritDoc}
  *<br>Animal dalam hal ini adalah Lamia dengan char karakter khusus L.
  *@return {@inheritDoc}
  *<br>Karakter tersebut adalah L.
  */
  public char draw() {
    return 'L';
  }

  public void draw(Graphics2D g2) {
    //return 'P';
  ImageIcon ic = new ImageIcon("Assets/Lamia.png");
  Image i = ic.getImage();
  g2.drawImage(i, getRowPosition(), getColumnPosition(), null);
  }

  /**
  *{@inheritDoc}
  *<br>Aksi yang dilakukan kelas Lamia adalah bergerak (memanggil method move).
  */
  public void doAction() {
    move();
  }
}