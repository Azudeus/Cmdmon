import java.util.Scanner;
import java.util.Random;

public class Main{
	//private UniverseUsingSTL world;
	private static char CC;
	private static boolean stop = false;
	private static int row = 25;
	private static int col = 25;
	
	
	public static void printEvery() {	
		//(this.world).print();
		System.out.println("Print Every");
		System.out.println();
	}
	
	public static void activeWorld(){
		//(this.world).moveAllCreaturesOnce();
		System.out.println("Moving All Creature");
		System.out.println();
	}

	public static void initialize(){
		//(this.world).addRandomCreature(10);
		System.out.println("initialize");
	}
	
	public static void initializeRandom(){
		Random rand = new Random();
		int randomMax = ((row * col) / 10) + 1; 
		int randomNum = rand.nextInt(randomMax);
		//(this.world).addRandomCreature(randomNum);
		System.out.println("initialize " + randomNum);
		System.out.println();
	}
	
	public static void printToFile(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input File Name : ");
		String filename;
		filename = scan.next();
		//(this.world).print(filename);
		System.out.println("Printed file to "+filename);
	}
	
	public static void main(String[] args){
		
		initialize();
		Scanner scan = new Scanner(System.in);
		while (CC != 'E'){

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
					System.out.println("press e to exit");
					break;
				}
			}
			
			activeWorld();	
			CC = scan.next().trim().charAt(0);
		}
		
	}	
}