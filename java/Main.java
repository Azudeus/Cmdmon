import java.util.Scanner;
import java.util.Random;
import java.io.*;

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
  private static int row = 25;
  private static int col = 25;
  private static UniverseUsingSTL world = new UniverseUsingSTL(row,col);
	
	// public static void CLS(){
	// 	try{
	// 		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	// 	} catch (IOException e){
	// 		e.printStackTrace();
	// 	} catch (InterruptedException e){
	// 		e.printStackTrace();
	// 	} 
	// }

	public final static void clearConsole()
	{
		try
		{
			final String os = System.getProperty("os.name");

			if (os.contains("Windows"))
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else
			{
				new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
			}
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void printEvery() {	
		clearConsole();
		world.print();
		// System.out.println("Print Every");
		// System.out.println();
	}
	
	public static void activeWorld(){
		world.moveAllCreaturesOnce();
		// System.out.println("Moving All Creature");
		// System.out.println();
	}

	public static void initialize(){
		world.addRandomCreature(10);
		// System.out.println("initialize");
	}
	
	public static void initializeRandom(){
		Random rand = new Random();
		int randomMax = ((row * col) / 10) + 1; 
		int randomNum = rand.nextInt(randomMax);
		world.addRandomCreature(randomNum);
		// System.out.println("initialize " + randomNum);
		// System.out.println();
	}
	
	public static void printToFile(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input File Name : ");
		String filename;
		filename = scan.next();
		try{
			world.printFile(filename);
			System.out.println("Printed file to "+filename);
		} catch (IOException e){
			System.out.println("File tidak ditemukan");
			System.exit(0);		
		}
	}
	
	public static void main(String[] args){
		
		initialize();
		Scanner scan = new Scanner(System.in);
		while (CC != 'E') {
			switch (CC){
				case 'p' : {
					printEvery();
					break;
				}
				case 'a' : {
					initializeRandom();
					break;
				}
				case 'f' : {
					printToFile();
				}
				default : {
					System.out.println("Press p to print to terminal");
					System.out.println("Press a to add random creature");
					System.out.println("Press f to print to file");
					System.out.println("press E to exit");
					break;
				}
			}
			if (world.isWorldEmpty()){
				System.exit(0);
			}

			activeWorld();	
			CC = scan.next().trim().charAt(0);
		}
		
	}	

}