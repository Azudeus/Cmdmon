import java.io.*;
import java.util.Random;
import java.util.Vector;
import java.util.Collections;


/**
*@author Yeksadiningrat Al Valentino/13514055
*/
public class UniverseUsingSTL extends Universe {
  /**
  *CreatureList merupakan Vector of Creature yang mencatat semua mahluk yang ada pada dunia.
  */

  Vector<Creature> CreatureList;
  /**
  *P adalah Player yang akan dikendalikan oleh pemain
  */
  Player P;
  /**
  *isGameOVer adalah boolean yang menyatakan apakah game sudah berakhir atau belum.
  *<br>isGameOver akan bernilai true apabila P mati.
  */

  private boolean isGameOver; 
  /**
  *Turn menunjukan sudah urutan ke berapa sejak objek ini dibangun.
  */
  private int Turn;
  /**
  *turnInterval adalah durasi detik dimana turn bertambah.
  */
  private int turnInterval;
  // private int MAX_CREATURE = 30;

  /**
  *Constructor dari UniverseUsingSTL yang melakukan inisialisasi attribute.
  *<br>amountOfRows akan diinisialisasi dengan amountOfRows dari parameter.
  *<br>amountOfColumns akan diinisialisasi dengan amountOfColumns dari parameter.
  *<br>CreatureList akan diisi dengan object Vector of Creature baru.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter kecuali untuk CreatureList.
  *@param amountOfRows, integer yang menyatakan jumlah baris dari dunia.
  *@param amountOfColumns, integer yang menyatakan jumlah kolom dari dunia.
  */
  public UniverseUsingSTL(final int amountOfRows, final int amountOfColumns) {
    this.setAmountOfRows(amountOfRows);
    this.setAmountOfColumns(amountOfColumns);
  Random generator = new Random();
  int row = (generator.nextInt(getAmountOfRows()));
    int column = (generator.nextInt(getAmountOfColumns()));
  P = new Player(row,column);
  isGameOver = false;
    CreatureList = new Vector<Creature>();
    turnInterval = 3000;
  }

  /**
  *{@inheritDoc}
  *<br>Creature dibunuh dengan cara dihilangkan dari CreatureList.
  *<br>creature akan pertama dicari pada CreatureList.
  *@param creature, Creature yang akan dibunuh.
  */
  public void killCreature(Creature creature) {
    boolean found = false;
    int size = CreatureList.size();
    int index = 0;
    while ((!found) && (index < CreatureList.size())) {
      if (CreatureList.get(index) == creature) {
        found = true;
        Collections.swap(CreatureList, index, CreatureList.size() - 1);
      }
      index++;
    }
  if(found) {
    CreatureList.remove(CreatureList.size() - 1);
    }
  }
  
  /**
  *(@inheritDoc)
  *<br> Getter dari atribut CreatureList.
  */
  public final Vector<Creature> getCreatureList() {
    return CreatureList;
  } 
  
  /**
  *(@inheritDoc)
  *<br> Getter dari atribut P.
  */
  public final Player getPlayer() {
    return P;
  }

  /**
  *(@inheritDoc)
  *<br> Getter dari atribut CreatureList.
  */
  public final boolean getIsGameOver() {
    return isGameOver;
  }
  
  /**
  *(@inheritDoc)
  *Method yang digunakan untuk mengincrement Turn.
  */
  public void addTurn() {
    Turn++;
  }
  
  /**
  *(@inheritDoc)
  *<br> Getter dari atribut turnInterval.
  */
  public final int getTurnInterval() {
  return turnInterval;
  }

  /**
  *(@inheritDoc)
  *<br> Getter dari atribut Turn.
  */
  public final int getTurn() {
    return Turn;
  }

  /**
  *(@inheritDoc)
  *<br> Mengembalikan jarak beruba integer dari 2 titik tengah Creature.
  */
  public int Distance(Creature c1, Creature c2) {
   return (Math.abs(c1.getColumnPosition() - c2.getColumnPosition()) + Math.abs(c1.getRowPosition() - c2.getRowPosition()));
  }
  
  /**
  *(@inheritDoc)
  *<br> Method pemain menyerang musuh yang berada dalam range pemain.
  *<br> Direalisasikan dengan cara menyelusuri seluruh Creature di dalam list dan apabila masuk ke dalam range player
  *kurangi HP creature tersebut dan apabila sudah HPnya sudah 0 atau kurang maka Creature tersebut akan dihapus.
  */
  public void attackPlayer() {
  int size = CreatureList.size();
  int i = 0;
    while(i < size) {
    if(Distance(P, CreatureList.get(i)) <= (P.getRange() + P.getSize() + CreatureList.get(i).getSize())) {
      System.out.println("Player attack creature around him by " + P.getStrength() + " damage");
      CreatureList.get(i).setHealth(CreatureList.get(i).getHealth() - P.getStrength());
      if (CreatureList.get(i).getHealth() <= 0) {
        killCreature(CreatureList.get(i));
        P.setHealth(P.getHealth() + 20);
        size--;
        i--;
      }
    }
    i++;
  }
  }

  /**
  *(@inheritDoc)
  *<br> Mengecek apakah pemain dalam range serang c apabila iya kurangi darah pemain/
  *<br> Apabila darah pemain sudah 0 atau kurang maka hentikan permainan.
  *@param c, creature yang dicek.
  */
  public void attackCreature(Creature c) {
  //System.out.println(Distance(P,c) + " " + (P.getSize() + c.getRange() + c.getSize()));
  if (Distance(P, c) <= (c.getRange() + c.getSize() + P.getSize())) {
    System.out.println("Creature attack Player by " + c.getStrength() + " damage");
    P.setHealth(P.getHealth() - c.getStrength());
    if (P.getHealth() <= 0) {
      isGameOver = true;
      System.out.println("Player killed by ranged attack");
    }
  }

  }

  /**
  *{@inheritDoc}
  *<br>Penambahan dilakukan dengan menambahkan creature ke dalam CreatureList.
  *@param creature, Creature yang akan dimasukan ke dalam dunia.
  */
  public void addCreature(Creature creature) {
    CreatureList.add(creature);
  }

  /**
  *{@inheritDoc}
  *Menambahkan amount Creature ke dalam list.
  *Setiap Creature yang ditambahkan dijamin sudah memiliki jarak yng cukup dengan Creature yg sudah ada.
  *@param amount, merupakan jumlah Creature yg ingin ditambah
  **/
  public void addRandomCreature(int amount) {
    Creature temp;
    Random generator = new Random();
    //randomly create creature
    for (int i = 0; i < amount; i++) {
      int rand = generator.nextInt(4);
      int row = (generator.nextInt(getAmountOfRows()));
      int column = (generator.nextInt(getAmountOfColumns()));
      int directionX = (generator.nextInt(3));
      directionX = directionX - 1;
      int directionY = (generator.nextInt(3));
      directionY = directionY - 1;
      int maxCreature = 30;
      int creatureSize = 20;
      boolean found = true;
      int counter = 0;

      //cari apakah sudah ada
      while ((counter < maxCreature) && (found)) {
        found = false;
        counter = 0;
        int sz = CreatureList.size();
        int index = 0;

        if ((Math.abs(P.getRowPosition() - row) + Math.abs(P.getColumnPosition() - column)) <= (P.getSize() + creatureSize + 3 * P.getRange())) {
          found = true;
        }
        while ((index < sz) && (!found) && (counter < maxCreature)) {
          counter++;
          if ((Math.abs(CreatureList.get(index).getRowPosition() - row) + Math.abs(CreatureList.get(index).getColumnPosition() - column))
             <= (2 * creatureSize)) {
            found = true;
          }
          index++;
        }
        if (found) {
          column++;
          if (column == getAmountOfColumns()) {
            column = 0;
            row++;
          }
          if (row == getAmountOfRows()) {
            column = 0;
            row = 0;
          }
        }
    //System.out.println(counter);
      }

      if (!found) {
        if (rand == 0) {
          // temp = new Plant(row, column, getTurn()/3);
          // addCreature(temp);
          addCreature(CreatureFactory.createCreature("Plant", row, column, 0, 0, getTurn() / 5));
        } else if (rand == 1) {
          // temp = new Lamia(row, column, directionX, directionY, getTurn()/3);
          // addCreature((temp));
          addCreature(CreatureFactory.createCreature("Lamia", row, column, directionX, directionY, getTurn() / 5));
        } else if (rand == 2) {
          // temp = new Centaur(row, column, directionX, directionY, getTurn()/3);
          // addCreature((temp));
          addCreature(CreatureFactory.createCreature("Centaur", row, column, directionX, directionY, getTurn() / 5));
        } else {
          // temp = new Harpy(row, column, directionX, directionY, getTurn()/3);
          // addCreature((temp));
          addCreature(CreatureFactory.createCreature("Harpy", row, column, directionX, directionY, getTurn() / 5));
        }
      }
    }
  }

  /**
  *{@inheritDoc}
  *<br>Pemeriksaan dunia kosong dilakukan dengan memeriksa size dari CreatureList.
  *<br>Jika size sama dengan 0 maka dikembalikan true.
  */
  public boolean isWorldEmpty() {
    return (CreatureList.size() == 0);
  }

  /**
  *{@inheritDoc}
  *<br>Mengecek apakah ada Creature yang bertabrakan dengan pemain apabila iya hentikan permainan.
  *<br>Mengecek juga apakah ada Creature yang keluar Unviverse jika ada maka hapus, jika yang keluar pemain, hentikan permainan.
  */
  public void checkForCollisions() {
    int sz = CreatureList.size();
    int index = 0;
    //Kill Out Of Bounds
    while (index < sz) {
      if ((CreatureList.get(index).getRowPosition() < 0)
            || (CreatureList.get(index).getColumnPosition() < 0)
            || (CreatureList.get(index).getRowPosition() >= getAmountOfRows())
            || (CreatureList.get(index).getColumnPosition() >= getAmountOfColumns())) {
          killCreature(CreatureList.get(index));
          index--;
          //sz--;
      }
      index++;
    sz = CreatureList.size();
    }
  //is Player Out Of Bounds

    if ((P.getRowPosition() < 0)
      || (P.getColumnPosition() < 0)
      || (P.getRowPosition() >= getAmountOfRows())
      || (P.getColumnPosition() >= getAmountOfColumns())) {
        isGameOver = true;
      P.setHealth(0);
      System.out.println("Player out of bound");
    }

    //Kill Player if Collision
    index = 0;
    while ((!isGameOver) && (index < sz)) {
      if (Distance(P, CreatureList.get(index)) <= (P.getSize() + CreatureList.get(index).getSize())) {
        System.out.println("Player collide with monster");
        isGameOver = true;
      }
      index++;
    }
  }

  /**
  *{@inheritDoc}
  *<br>Melakukan traversal pada list dan memanggil doAction untuk setiap mahluk.
  */
  public void moveAllCreaturesOnce() {
    int i = 0;
    while ((i < CreatureList.size()) && (!isGameOver)) {
      CreatureList.get(i).doAction();
    attackCreature(CreatureList.get(i));
      i++;
    }
    checkForCollisions();
  };
}
