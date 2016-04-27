import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*@author Yeksadiningrat Al Valentino/13514055
*/
public class Main{
  /**
  *strength merupakan integer yang menunjukan kekuatan dari suatu Creature. 
  *Kekuatan ini akan menentukan kelangsungan hidup dalam persaingan.
  *rowPosition merupakan integer yang menunjukan posisi baris dari Creature pada dunia.
  *columnPosition merupakan integer yang menunjukan posisi kolom dari Creature pada dunia.
  *actionInterval merupakan integer yang menunjukan jeda waktu antar aksi dari suatu Creature.
  */
  private static char CC;
  private static boolean stop = false;
  private static final int row = 680;
  private static final int col = 485;
//  private static UniverseUsingSTL world = new UniverseUsingSTL(row,col);
  private static Vector<Thread> vectorThread = new Vector<Thread>();
  private static UserInterface userInterface;
  private static final int spawnInterval = 10;
  private static final int spawnAmount = 3;

  /**
  *Menambahkan creature ke dunia dengan jumlah acak.
  *<br>Dilakukan dengan memanggil method addRandomCreature.
  */
  public static void initializeRandom(){
    System.out.println("initialized Random Creature");
    Random rand = new Random();
    int randomNum = rand.nextInt(spawnAmount);
    userInterface.mainPanel.world.addRandomCreature(spawnAmount + randomNum);;
    // System.out.println("initialize " + randomNum);
    // System.out.println();
  }

  public static void createPlayerThread() {
    new Thread(new Runnable() {
      public void run() {
		    try{
            Player p = userInterface.mainPanel.world.getPlayer();
            while(!stop){
            p.doAction();
            userInterface.mainPanel.world.checkForCollisions();
            userInterface.mainPanel.world.attackPlayer();
            Thread.sleep(p.getActionInterval());
            if(userInterface.mainPanel.world.getIsGameOver()) {
              stop = true;
            }
          }
        } catch (InterruptedException e){
          System.err.println("Message player thread interrupted");
        }
      }
    }).start();
  }
  
  public static void createAllMonsterThread() {
    new Thread(new Runnable() {
      public void run() {
        try {
          while((!stop) && (!userInterface.mainPanel.world.getIsGameOver())) {
            userInterface.mainPanel.world.moveAllCreaturesOnce();
            userInterface.mainPanel.world.addTurn();
            if (userInterface.mainPanel.world.getTurn() % spawnInterval == 0) {
              initializeRandom();
            }
            Thread.sleep(userInterface.mainPanel.world.getPlayer().getActionInterval());  
          }

        } catch (InterruptedException e) {
          System.err.println("Message All Monster Thread interrupted");
        }
      }
    }).start();
  }

  /**
  *Main dari program yang akan dijalankan ketika program dijalankan.
  *@param args, Array of String untuk argument program ketika dijalankan.
  */
  public static void main(String[] args){
    userInterface = new UserInterface();
    userInterface.show();
    createPlayerThread();
//    createCreatorThread();
    initializeRandom();
    createAllMonsterThread();
  }
}