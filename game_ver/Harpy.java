import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*@author Nathan James Runtuwene/13514083
*/
public class Harpy extends Animal {
  /**
  *Constructor dari kelas Harpy yang melakukan inisialisasi attribute.
  *<br>rowPosition akan diinisialisasi dengan row.
  *<br>columnPosition akan diinisialisasi dengan column.
  *<br>directionX akan diinisialisasi dengan directionX dari parameter.
  *<br>directionY akan diinisialisasi dengan directionY dari parameter.
  *<br>strength akan diinisialisasi dengan 15.  
  *<br>actionInterval akan diinisialisasi dengan 1000.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter.
  *@param row, integer yang menandakan posisi baris suatu creature di dunia.
  *@param column, integer yang menandakan posisi kolom suatu creature di dunia.
  *@param directionX, integer yang menandakan arah pergerakan Harpy pada sumbu X.
  *@param directionY, integer yang menandakan arah pergerakan Harpy pada sumbu Y.
  */
  public Harpy(int row, int column, int directionX, int directionY,int multiplier) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(30 + 3 * multiplier);
    setActionInterval(80);
    setHealth(15 + 2 * multiplier);
    setRange(20);
    setSize(20);
  }

  /**
  *{@inheritDoc}
  *<br>Animal dalam hal ini adalah Harpy dengan char karakter khusus H.
  *@return {@inheritDoc}
  *<br>Karakter tersebut adalah H.
  */
  public char draw() {
    return 'H';
  }

  public void draw(Graphics2D g2) {
    //return 'P';
	ImageIcon ic = new ImageIcon("Assets/Harpy.png");
	Image i = ic.getImage();
	g2.drawImage(i, getRowPosition(), getColumnPosition(), null); 
  }
  
  /**
  *{@inheritDoc}
  *<br>Aksi yang dilakukan kelas Harpy adalah bergerak (memanggil method move).
  */
  public void doAction() {
    move();
  }
}