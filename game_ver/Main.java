import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.Vector;

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
  private static int row = 680;
  private static int col = 485;
  private static UniverseUsingSTL world = new UniverseUsingSTL(row,col);
  private static Vector<Thread> vectorThread = new Vector<Thread>();
    

  /**
  *Melakukan pembersihan layar dan mencetak dunia ke layar.
  *<br>Pembersihan dilakukan dengan memanggil static method CLS.
  */
  public static void printEvery() {	
    // CLS();
    world.print();
    // System.out.println("Print Every");
    // System.out.println();
  }

  public static void initializeRandom() {
    Random rand = new Random();
    int fixedNum = 4; 
    int randomNum = rand.nextInt(fixedNum);
    world.addRandomCreature(fixedNum + randomNum);
    // System.out.println("initialize " + randomNum);
    // System.out.println();
  }

  public static void createMonsterThread(int i) {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        Creature c = world.getCreatureList().get(i);
        vectorThread.add(t1);
        while(!stop) {
          c.doAction();
          world.checkForCollisions();
          world.attackCreature(i);
          t1.sleep(c.getActionInterval());
        }
      }
    });
    t1.start();
  }

  public static void createPlayerThread() {
    new Thread(new Runnable() {
      public void run() {
        Player p = world.getPlayer();
        while(!stop){
          p.doAction();
          world.checkForCollisions();
          world.attackPlayer();
          Thread.sleep(p.getActionInterval());
        }
      }
    }).start();
  }

  public static void createCreatorThread() {
    new Thread(new Runnable() {
      public void run() {
        while(!stop){
          Thread.sleep(world.getTurnInterval());      
          initializeRandom();
          world.addTurn();
        }
      }
    }).start();
  }


  /**
  *Main dari program yang akan dijalankan ketika program dijalankan.
  *@param args, Array of String untuk argument program ketika dijalankan.
  */
  public static void main(String[] args){
    createPlayerThread();
    for (int i=0;i<world.getCreatureList().size();i++){
      createMonsterThread(i);
    }
    createCreatorThread();    
  }
}
