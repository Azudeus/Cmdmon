package universe;

import creature.*;
import java.io.*;
import java.util.Random;
import java.util.Vector;
import java.util.Collections;


/**
*@author Yeksadiningrat Al Valentino/13514055
*/
public class UniverseUsingSTL extends Universe {
  /**
  *creatureList merupakan Vector of Creature yang mencatat semua mahluk yang ada pada dunia.
  */
  private Vector<Creature> creatureList;
  
  /**
  *player adalah Player yang akan dikendalikan oleh pemain
  */
  private Player player;
  
  /**
  *isGameOVer adalah boolean yang menyatakan apakah game sudah berakhir atau belum.
  *<br>isGameOver akan bernilai true apabila player mati.
  */
  private boolean isGameOver;

  /**
  *Turn menunjukan sudah urutan ke berapa sejak objek ini dibangun.
  */
  private int turn;

  /**
  *turnInterval adalah durasi detik dimana turn bertambah.
  */
  private int turnInterval;

  /**
  *Constructor dari UniverseUsingSTL yang melakukan inisialisasi attribute.
  *<br>amountOfRows akan diinisialisasi dengan amountOfRows dari parameter.
  *<br>amountOfColumns akan diinisialisasi dengan amountOfColumns dari parameter.
  *<br>creatureList akan diisi dengan object Vector of Creature baru.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter kecuali untuk creatureList.
  *@param amountOfRows, integer yang menyatakan jumlah baris dari dunia.
  *@param amountOfColumns, integer yang menyatakan jumlah kolom dari dunia.
  */
  public UniverseUsingSTL(final int amountOfRows, final int amountOfColumns) {
    this.setAmountOfRows(amountOfRows);
    this.setAmountOfColumns(amountOfColumns);
  Random generator = new Random();
  int row = (generator.nextInt(getAmountOfRows()));
    int column = (generator.nextInt(getAmountOfColumns()));
  player = new Player(row,column);
  isGameOver = false;
    creatureList = new Vector<Creature>();
    turnInterval = 3000;
  }

  /**
  *{@inheritDoc}
  *<br>Creature dibunuh dengan cara dihilangkan dari creatureList.
  *<br>creature akan pertama dicari pada creatureList.
  *@param creature, Creature yang akan dibunuh.
  */
  public void killCreature(Creature creature) {
    boolean found = false;
    int index = 0;
    while ((!found) && (index < creatureList.size())) {
      if (creatureList.get(index) == creature) {
        found = true;
        Collections.swap(creatureList, index, creatureList.size() - 1);
      }
      index++;
    }
  if(found) {
    creatureList.remove(creatureList.size() - 1);
    }
  }
  
  /**
  *<br> Getter dari atribut creatureList.
  *@return Vector<Creature> yaitu creatureList
  */
  public final Vector<Creature> getCreatureList() {
    return creatureList;
  } 
  
  /**
  *<br> Getter dari atribut player.
  *@return Player, objek player
  */
  public final Player getPlayer() {
    return player;
  }

  /**
  *<br> Getter dari atribut creatureList.
  *@return boolean, true jika game over, false jika belum
  */
  public final boolean getIsGameOver() {
    return isGameOver;
  }
  
  /**
  *Method yang digunakan untuk mengincrement Turn.
  */
  public void addTurn() {
    turn++;
  }
  
  /**
  *<br> Getter dari atribut turnInterval.
  *@return int, durasi sebelum turn bertambah
  */
  public final int getTurnInterval() {
    return turnInterval;
  }

  /**
  *<br> Getter dari atribut Turn.
  *@return int, menunjukkan sekarang turn ke berapa
  */
  public final int getTurn() {
    return turn;
  }

  /**
  *<br> Mengembalikan jarak beruba integer dari 2 titik tengah Creature.
  *@param c1, creature pertama
  *@param c2, creature kedua
  *@return int, manhattan distance antara kedua creature
  */
  public int Distance(Creature c1, Creature c2) {
   return (Math.abs(c1.getColumnPosition() - c2.getColumnPosition()) + Math.abs(c1.getRowPosition() - c2.getRowPosition()));
  }
  
  /**
  *<br> Method pemain menyerang musuh yang berada dalam range pemain.
  *<br> Direalisasikan dengan cara menyelusuri seluruh Creature di dalam list dan apabila masuk ke dalam range player
  *kurangi HP creature tersebut dan apabila sudah HPnya sudah 0 atau kurang maka Creature tersebut akan dihapus.
  */
  public void attackPlayer() {
  int size = creatureList.size();
  int i = 0;
    while(i < size) {
    if(Distance(player, creatureList.get(i)) <= (player.getRange() + player.getSize() + creatureList.get(i).getSize())) {
      System.out.println("Player attack creature around him by " + player.getStrength() + " damage");
      creatureList.get(i).setHealth(creatureList.get(i).getHealth() - player.getStrength());
      if (creatureList.get(i).getHealth() <= 0) {
        killCreature(creatureList.get(i));
        player.setHealth(player.getHealth() + 20);
        size--;
        i--;
      }
    }
    i++;
  }
  }

  /**
  *<br> Mengecek apakah pemain dalam range serang c apabila iya kurangi darah pemain/
  *<br> Apabila darah pemain sudah 0 atau kurang maka hentikan permainan.
  *@param c, creature yang dicek.
  */
  public void attackCreature(Creature c) {
  //System.out.println(Distance(player,c) + " " + (player.getSize() + c.getRange() + c.getSize()));
  if (Distance(player, c) <= (c.getRange() + c.getSize() + player.getSize())) {
    System.out.println("Creature attack Player by " + c.getStrength() + " damage");
    player.setHealth(player.getHealth() - c.getStrength());
    if (player.getHealth() <= 0) {
      isGameOver = true;
      System.out.println("Player killed by ranged attack");
    }
  }

  }

  /**
  *{@inheritDoc}
  *<br>Penambahan dilakukan dengan menambahkan creature ke dalam creatureList.
  *@param creature, Creature yang akan dimasukan ke dalam dunia.
  */
  public void addCreature(Creature creature) {
    creatureList.add(creature);
  }

  /**
  *{@inheritDoc}
  *Menambahkan amount Creature ke dalam list.
  *Setiap Creature yang ditambahkan dijamin sudah memiliki jarak yng cukup dengan Creature yg sudah ada.
  *@param amount, merupakan jumlah Creature yg ingin ditambah
  **/
  public void addRandomCreature(int amount) {
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
        int sz = creatureList.size();
        int index = 0;

        if ((Math.abs(player.getRowPosition() - row) + Math.abs(player.getColumnPosition() - column)) <= (player.getSize() + creatureSize + 3 * player.getRange())) {
          found = true;
        }
        while ((index < sz) && (!found) && (counter < maxCreature)) {
          counter++;
          if ((Math.abs(creatureList.get(index).getRowPosition() - row) + Math.abs(creatureList.get(index).getColumnPosition() - column))
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
  *<br>Pemeriksaan dunia kosong dilakukan dengan memeriksa size dari creatureList.
  *<br>Jika size sama dengan 0 maka dikembalikan true.
  */
  public boolean isWorldEmpty() {
    return (creatureList.size() == 0);
  }

  /**
  *{@inheritDoc}
  *<br>Mengecek apakah ada Creature yang bertabrakan dengan pemain apabila iya hentikan permainan.
  *<br>Mengecek juga apakah ada Creature yang keluar Unviverse jika ada maka hapus, jika yang keluar pemain, hentikan permainan.
  */
  public void checkForCollisions() {
    int sz = creatureList.size();
    int index = 0;
    //Kill Out Of Bounds
    while (index < sz) {
      if ((creatureList.get(index).getRowPosition() < 0)
            || (creatureList.get(index).getColumnPosition() < 0)
            || (creatureList.get(index).getRowPosition() >= getAmountOfRows())
            || (creatureList.get(index).getColumnPosition() >= getAmountOfColumns())) {
          killCreature(creatureList.get(index));
          index--;
          //sz--;
      }
      index++;
    sz = creatureList.size();
    }
  //is Player Out Of Bounds

    if ((player.getRowPosition() < 0)
      || (player.getColumnPosition() < 0)
      || (player.getRowPosition() >= getAmountOfRows())
      || (player.getColumnPosition() >= getAmountOfColumns())) {
        isGameOver = true;
      player.setHealth(0);
      System.out.println("Player out of bound");
    }

    //Kill Player if Collision
    index = 0;
    while ((!isGameOver) && (index < sz)) {
      if (Distance(player, creatureList.get(index)) <= (player.getSize() + creatureList.get(index).getSize())) {
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
    while ((i < creatureList.size()) && (!isGameOver)) {
      creatureList.get(i).doAction();
    attackCreature(creatureList.get(i));
      i++;
    }
    checkForCollisions();
  }
}
