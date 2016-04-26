import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Main{
	private static char CC;
	private static boolean stop = false;
	private static int row = 25;
	private static int col = 25;
	private static UniverseUsingSTL world = new UniverseUsingSTL(row,col);

	
	 public static void CLS(){
        try{
        	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException e){
        	System.exit(0);
        }catch (InterruptedException e){
        	System.exit(0);
        } 
	 }
	
	public static void printEvery() {	
		CLS();
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