import java.io.*;

/**
*@author Andri Hardono Hutama/13514031
*/
public abstract class Universe{
  /**
  *amountOfRows merupakan integer menyatakan jumlah baris yang terdapat pada dunia.
  *<br>amountOfColumns merupakan integer menyatakan jumlah kolom yang terdapat pada dunia.
  */
  private int amountOfRows;
  private int amountOfColumns;

  /**
  *Constructor dari Universe yang melakukan inisialisasi.
  *<br>amountOfRows diinisialisasi dengan 0.
  *<br>amountOfColumns diinisialisasi dengan 0.
  */
  public Universe(){
    amountOfRows = 0;
    amountOfColumns = 0;
  }
  
  /**
  *Constructor dengan parameter dari Universe yang melakukan inisialisasi.
  *<br>amountOfRows diinisialisasi dengan rows.
  *<br>amountOfColumns diinisialisasi dengan columns.
  *@param rows, integer yang akan menyatakan jumlah baris dari dunia.
  *@param columns, integer yang akan menyatakan jumlah kolom dari dunia.
  */
  public Universe(int rows,int columns){
    amountOfRows = rows;
    amountOfColumns = columns;
  }

  /**
  *Mengembalikan nilai amountOfRows dari Universe.
  *@return int, integer dengan nilai amountOfRows dari Universe.
  */
  public int getAmountOfRows(){
    return amountOfRows;
  }
  
  /**
  *Mengembalikan nilai amountOfColumns dari Universe.
  *@return int, integer dengan nilai amountOfColumns dari Universe.
  */
  public int getAmountOfColumns(){
    return amountOfColumns;
  }

  /**
  *Mengubah amountOfRows Universe menjadi rows.
  *<br>Merupakan setter untuk mengubah jumlah baris dunia.
  *@param rows, integer yang jumlah baris dari dunia.
  */
  void setAmountOfRows(int rows){
    amountOfRows = rows;
  }

  /**
  *Mengubah amountOfColumns Universe menjadi columns.
  *<br>Merupakan setter untuk mengubah jumlah kolom dunia.
  *@param columns, integer yang jumlah kolom dari dunia.
  */
  void setAmountOfColumns(int columns){
    amountOfColumns = columns;
  }

  /**
  *Membunuh sebuah Creature (hilang dari dunia).
  *@param C, Creature yang akan dibunuh.
  **/
  abstract void killCreature(Creature C);

  /**
  *Menambahkan sebuah Creature ke dunia.
  *@param C, Creature yang akan dimasukan ke dalam dunia.
  **/
  abstract void addCreature(Creature C);

  /**
  *Menambahkan Creature acak pada posisi acak ke dunia sejumlah parameter masukan fungsi ini.
  *@param amount, integer yang menyatakan jumlah mahluk yang ingin ditambahkan.
  **/
  abstract void addRandomCreature(int amount);

  /**
  *Memeriksa apakah dunia kosong (tidak memiliki Creature).
  *<br> Mengembalikan true jika dunia kosong dan sebaliknya.
  *@return boolean, boolean yang menyatkan apakah dunia kosong atau tidak.
  **/
  abstract boolean isWorldEmpty();

  /**
  *Memeriksa kasus tabrakan antar dua mahluk dan juga mahluk yang pergi ke luar batas.
  *<br>Jika mahluk pergi ke luar batas ukuran dunia, maka mahluk akan dibunuh.
  *<br>Jika terjadi tabrakan antar dua mahluk akan terjai persaingan.
  *<br>Persaingan ini menentukan mahluk mana yang akan dibunuh berdasarkan strength mereka.
  **/
  abstract void checkForCollisions();


  /**
  *Membuat semua mahluk di dunia untuk melakukan aksi satu kali.
  **/
  abstract void moveAllCreaturesOnce();

  /**
  *Menuliskan status dunia saat ini ke dalam sautu file.
  *<br>Status ini menggambarkan posisi mahluk yang ada di dalam dunia.
  *@param str, String yang menunjukan nama file.
  *@throws IOException IOException akan di-throw jika terjadi masalah dengan file yang ditulis.
  **/
  abstract void printFile(String str) throws IOException;
  
  /**
  *Menuliskan status dunia saat ini ke System.out (layar).
  *<br>Status ini menggambarkan posisi mahluk yang ada di dalam dunia.
  **/
  abstract void print();
}