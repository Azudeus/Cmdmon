import java.io.*;
import java.util.Scanner;
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
  private Player P;
  private boolean isGameOver; 
  private int Turn;
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
  public UniverseUsingSTL(int amountOfRows, int amountOfColumns) {
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
    System.out.println("Delete Creature");  
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
  
  public final Vector<Creature> getCreatureList(){
	return CreatureList;
  } 
  
  public final Player getPlayer(){
	  return P;
  }
  
  public final boolean getIsGameOver(){
	  return isGameOver;
  }
  
  public void addTurn() {
	  Turn++;
  }
  
  public final int getTurnInterval() {
	return turnInterval;
  }
  public final int getTurn() {
	  return Turn;
  }
  
  public int Distance(Creature c1, Creature c2){
	return (Math.abs(c1.getColumnPosition() - c2.getColumnPosition()) + Math.abs(c1.getRowPosition() - c2.getRowPosition()));
  }
  
  public void attackPlayer() {
	int size = CreatureList.size();
	int i = 0;
    while(i < size){
		if(Distance(P, CreatureList.get(i)) <= (P.getRange() + P.getSize() + CreatureList.get(i).getSize())) {
      System.out.println("Player Attack Creature");
			CreatureList.get(i).setHealth(CreatureList.get(i).getHealth() - P.getStrength());
			if(CreatureList.get(i).getHealth() <= 0){
				killCreature(CreatureList.get(i));
				size--;
				i--;
			}	
		}
		i++;
	}
  }
  
  public void attackCreature(Creature c){
  //System.out.println(Distance(P,c) + " " + (P.getSize() + c.getRange() + c.getSize()));
  if(Distance(P,c) <= (c.getRange() + c.getSize())){
    System.out.println("Creature attack Player");
		P.setHealth(P.getHealth() - c.getStrength());
		if(P.getHealth() <= 0){
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
	  int MaxCreature = 30;
	  int CreatureSize = 20;
      boolean found = true;
      int counter = 0;

      //cari apakah sudah ada
      while ((counter < MaxCreature) && (found)) {
        found = false;
        counter = 0;
        int sz = CreatureList.size();
        int index = 0;

    		if((Math.abs(P.getRowPosition() - row) + Math.abs(P.getColumnPosition() - column)) <= (P.getSize() + CreatureSize + P.getRange())) {
    			found = true;
    		}
        while ((index < sz) && (!found) && (counter < MaxCreature)) {
          counter++;
          if ((Math.abs(CreatureList.get(index).getRowPosition() - row) + Math.abs(CreatureList.get(index).getColumnPosition() - column)) 
			       <= (2*CreatureSize)) {
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
          addCreature(CreatureFactory.createCreature("Plant",row, column, 0, 0, getTurn()/3));
        } else if (rand == 1) {
          // temp = new Lamia(row, column, directionX, directionY, getTurn()/3);
          // addCreature((temp));
          addCreature(CreatureFactory.createCreature("Lamia",row, column, directionX, directionY, getTurn()/3));
        } else if (rand == 2) {
          // temp = new Centaur(row, column, directionX, directionY, getTurn()/3);
          // addCreature((temp));
          addCreature(CreatureFactory.createCreature("Centaur",row, column, directionX, directionY, getTurn()/3));
        } else {
          // temp = new Harpy(row, column, directionX, directionY, getTurn()/3);
          // addCreature((temp));
          addCreature(CreatureFactory.createCreature("Harpy",row, column, directionX, directionY, getTurn()/3));
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
	//is Player Out Of Bounds
	if((P.getRowPosition() < 0)
		|| (P.getColumnPosition() < 0)
		|| (P.getRowPosition() >= getAmountOfRows())
		|| (P.getColumnPosition() >= getAmountOfColumns())){
			isGameOver = true;
		}
		
	//Kill Player if Collision
	index = 0;
	while((!isGameOver) && (index < sz)) {
		if(Distance(P, CreatureList.get(index)) <= (P.getSize() + CreatureList.get(index).getSize())){
	    System.out.println("Player collide with monster");
      isGameOver = true;
		}
		index++;
	}

    //Kill Collisions
	/*
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
    }*/
  }

  /**
  *{@inheritDoc}
  *<br>Melakukan traversal pada list dan memanggil doAction untuk setiap mahluk.
  */
  public void moveAllCreaturesOnce() {
    int i = 0;
    while ((i < CreatureList.size()) && (!isGameOver)){
      CreatureList.get(i).doAction();
	    attackCreature(CreatureList.get(i));
      i++;
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
	
	board[P.getRowPosition()][P.getColumnPosition()] = P.draw();

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

	  board[P.getRowPosition()][P.getColumnPosition()] = P.draw();
	  
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
  
  public static void main (String[] args){
	  UniverseUsingSTL universe = new UniverseUsingSTL(150,150);
	  Scanner scan = new Scanner(System.in);
	  while(!universe.getIsGameOver()){
		  universe.addRandomCreature(10);
		  universe.print();
		 //universe.moveAllCreaturesOnce();
		  //String c = scan.next();
		  System.out.println();
		  System.out.println();
		  System.out.println();
	  }
  }
}
