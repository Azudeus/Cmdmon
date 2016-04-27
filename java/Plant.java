/**
*@author Nathan James Runtuwene/13514083
*{@inheritDoc}
*/
public class Plant extends Creature {
  /**
  *Constructor dari Plant yang melakukan inisialisasi attribute.
  *<br>rowPosition akan diinisialisasi dengan row.
  *<br>columnPosition akan diinisialisasi dengan column.
  *<br>strength akan diinisialisasi dengan 5.
  *<br>actionInterval akan diinisialisasi dengan 3000.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter.
  *@param row, integer yang menandakan posisi baris suatu creature di dunia.
  *@param column, integer yang menandakan posisi kolom suatu creature di dunia.
  */
  public Plant(int row, int column) {
    setRowPosition(row);
    setColumnPosition(column);
    setStrength(5);
    setActionInterval(3000);
  }

  /**
  *{@inheritDoc}
  *<br>Creature dalam hal ini adalah Plant dengan char karakter khusus T.
  *@return {@inheritDoc}
  *<br>Karakter tersebut adalah T.
  */
  public char draw() {
    return 'T';
  }

  /**
  *{@inheritDoc}
  *<br>Aksi yang dilakukan kelas Plant adalah menambahkan strength sebesar 1.
  */
  public void doAction() {
    setStrength(getStrength() + 1);
  }
}
