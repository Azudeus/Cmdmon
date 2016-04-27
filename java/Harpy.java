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
  public Harpy(int row, int column, int directionX, int directionY) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(15);
    setActionInterval(1000);
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

  /**
  *{@inheritDoc}
  *<br>Aksi yang dilakukan kelas Harpy adalah bergerak (memanggil method move).
  */
  public void doAction() {
    move();
  }
}
