public abstract class Universe{
	private int amountOfRows;
	private int amountOfColumns;

	public Universe(){
		amountOfRows = 0;
		amountOfColumns = 0;
	}
	
	public Universe(int rows,int columns){
		amountOfRows = rows;
		amountOfColumns = columns;
	}

	public int getAmountOfRows(){
		return amountOfRows;
	}
	
	public int getAmountOfColumns(){
		return amountOfColumns;
	}

	void setAmountOfRows(int rows){
		amountOfRows = rows;
	}
	
	void setAmountOfColumns(int columns){
		amountOfColumns = columns;
	}

	/**
	*Kill a creature from CreatureList
	*@param C a pointer to creature
	**/
//	abstract void killCreature(Creature C);
	abstract void killCreature(int C);

	/**
	*Add a creature to CreatureList
	*@param C a pointer to creature
	**/
//	abstract void addCreature(Creature C);
	abstract void addCreature(int C);

	/**
	*Add "amount" amount of random creatures to CreatureList
	*@param amount an integer
	**/
	abstract void addRandomCreature(int amount);

	/**
	*return 1 if Universe is empty, 0 otherwise
	**/
	abstract int isWorldEmpty();

	/**
	*check for a collision or out of bounds creatures to be killed
	**/
	abstract void checkForCollisions();


	/**
	*Move all creature from CreatureList once
	**/
	abstract void moveAllCreaturesOnce();

	/**
	*Print the world and all its creatures
	**/
	abstract void printFile(String str);
	
	abstract void print();
}