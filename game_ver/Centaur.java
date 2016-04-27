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
  public Centaur(int row, int column, int directionX, int directionY, int multiplier) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(30 + 3 * multiplier);
    setActionInterval(50);
    setHealth(30 + 3 * multiplier);
    setRange(10);
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
  *{@inheritDoc}
  *<br>Aksi yang dilakukan kelas Centaur adalah bergerak (memanggil method move).
  */
  public void doAction() {
    move();
  }
}