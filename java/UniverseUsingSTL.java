import java.io.*;
import java.util.Random;
import java.util.Vector;
import java.util.Collections;


/**
*@author Davin Prasetya/13514003
*/
public class UniverseUsingSTL extends Universe {
  /**
  *CreatureList merupakan Vector of Creature yang mencatat semua mahluk yang ada pada dunia.
  */
  private Vector<Creature> CreatureList;

  /**
  *Constructor dari UniverseUsingSTL yang melakukan inisialisasi attribute.
  *<br>amountOfRows akan diinisialisasi dengan amountOfRows dari parameter.
  *<br>amountOfColumns akan diinisialisasi dengan amountOfColumns dari parameter.
  *<br>CreatureList akan diisi dengan object Vector of Creature baru.
  *<br>Inisialisasi ini dilakukan dengan memanggil setter kecuali untuk CreatureList.
  *@param amountOfRows, integer yang menyatakan jumlah baris dari dunia.
  *@param amountOfColumns, integer yang menyatakan jumlah kolom dari dunia.
  */
  public UniverseUsingSTL(int amountOfRows, int amountOfColumns) {
    this.setAmountOfRows(amountOfRows);
    this.setAmountOfColumns(amountOfColumns);
    CreatureList = new Vector<Creature>();
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
    while ((!found) && (index < size)) {
      if (CreatureList.get(index) == creature) {
        found = true;
        Collections.swap(CreatureList, index, CreatureList.size() - 1);
      }
      index++;
    }
    CreatureList.remove(CreatureList.size() - 1);
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
      boolean found = true;
      int counter = 0;

      //cari apakah sudah ada
      while ((counter < (getAmountOfColumns() * getAmountOfRows())) && (found)) {
        found = false;
        counter = 0;
        int sz = CreatureList.size();
        int index = 0;
        while ((index < sz) && (!found) && (counter < (getAmountOfColumns()
            * getAmountOfRows())) ) {
          counter++;
          if ((CreatureList.get(index).getRowPosition() == row)
              && (CreatureList.get(index).getColumnPosition() == column)) {
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
      }
      if (counter < (getAmountOfColumns() * getAmountOfRows())) {
        if (rand == 0) {
<<<<<<< HEAD
//          temp = new Plant(row, column);
 //         addCreature((temp));

        } else if (rand == 1) {
          temp = new Lamia(row, column, directionX, directionY);
          addCreature((temp));
        } else if (rand == 2) {
          temp = new Centaur(row, column, directionX, directionY);
          addCreature((temp));
        } else {
          temp = new Harpy(row, column, directionX, directionY);
          addCreature((temp));
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
        sz--;
      }
      index++;
    }

    //Kill Collisions
    sz = CreatureList.size();
    for (int i = 0; i < getAmountOfRows(); i++) {
      for (int j = 0; j < getAmountOfColumns(); j++) {
        int minimumStrength = 999; //UNDEF
        int minimumIndex = -1;
        int counter = 0;
        for (int k = 0; k < sz; k++) {
          if (((CreatureList.get(k)).getRowPosition() == i)
                && ((CreatureList.get(k)).getColumnPosition() == j)) {
            if (minimumStrength > CreatureList.get(k).getStrength()) {
              minimumStrength = CreatureList.get(k).getStrength();
              minimumIndex = k;
            }
            counter++;
          }
        }
        if (counter > 1) {
          killCreature(CreatureList.get(minimumIndex));
          sz--;
        }
      }
    }
  }

  /**
  *{@inheritDoc}
  *<br>Melakukan traversal pada list dan memanggil doAction untuk setiap mahluk.
  */
  public void moveAllCreaturesOnce() {
    for (int i = 0; i < CreatureList.size(); i++) {
      CreatureList.get(i).doAction();
    }
    checkForCollisions();
  }

  /**
  *{@inheritDoc}
  *<br>Dilakukan dengan membuat matrix secara local yang kemudian diisikan.
  *<br>Isi dari matrix adalah . jika tidak ada mahluk atau karakterk penanda khusus jika ada.
  *<br>Matrix kemudian dicetak ke layar.
  */
  public void print() {
    char[][] board = new char[getAmountOfRows()][getAmountOfColumns()];
    for (int i = 0; i < getAmountOfRows(); i++) {
      for (int j = 0; j < getAmountOfColumns(); j++) {
        board[i][j] = '.';
      }
    }
    for (int i = 0; i < CreatureList.size(); i++) {
      Creature currentCreature = (CreatureList.get(i));
      board[currentCreature.getRowPosition()][currentCreature.getColumnPosition()] =
          currentCreature.draw();
    }

    for (int i = 0; i < getAmountOfRows(); i++) {
      for (int j = 0; j < getAmountOfColumns(); j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  /**
  *{@inheritDoc}
  *<br>Dilakukan dengan membuat matrix secara local yang kemudian diisikan.
  *<br>Isi dari matrix adalah . jika tidak ada mahluk atau karakterk penanda khusus jika ada.
  *<br>Matrix kemudian dicetak ke file yang sudah dibuka.
  */
  public void printFile(String str) throws IOException {
    try {
      BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(str)));
      char[][] board = new char[getAmountOfRows()][getAmountOfColumns()];
      for (int i = 0; i < getAmountOfRows(); i++) {
        for (int j = 0; j < getAmountOfColumns(); j++) {
          board[i][j] = '.';
        }
      }

      for (int i = 0; i < CreatureList.size(); i++) {
        Creature currentCreature = (CreatureList.get(i));
        board[currentCreature.getRowPosition()][currentCreature.getColumnPosition()] =
        currentCreature.draw();
      }

      for (int i = 0; i < getAmountOfRows(); i++) {
        for (int j = 0; j < getAmountOfColumns(); j++) {
          outputWriter.write(board[i][j]);
        }
        outputWriter.newLine();
      }
		outputWriter.flush();
    } catch (FileNotFoundException exception) {
      System.out.println("File tidak ditemukan");
      System.exit(0);
    }
  }
  
    public static void main(String args[]){
	  UniverseUsingSTL world= new UniverseUsingSTL(10,10);
	  
	  for (int i = 0 ; i < 10 ; i ++){
		  world.addRandomCreature(3);
		  world.print();		 
		  System.out.println();
	  }
	  try{
			world.printFile("tes.txt");
			System.out.println("Printed file to tes.txt");
		} catch (IOException e){
			System.out.println("File tidak ditemukan");
			System.exit(0);		
		}
	 }
 
}
