#include "UniverseUsingList.h"

UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
	addRandomCreature();
}

void UniverseUsingList::killCreature(Creature* C)
{
	//delete C from list
}

void UniverseUsingList::addCreature(Creature* C)
{
	//add C to list
}

void UniverseUsingList::addRandomCreature()
{
	//randomly create and add creature
}

void checkForCollisions()
{
	//Check for creatures in same cell
	//Kill creatures if more than n in same cell
}
	
void createThreadsForCreatures()
{

}

void moveAllCreaturesOnce()
{
	//Traverse List and move all creatures once
	//Then Check For Collisions
}

void UniverseUsingList::print(ostream& output)
{
	char board[amountOfRows][amountOfColumns];
	for (int i=0;i<amountOfRows;i++)
	{
		for (int j=0;j<amountOfColumns;j++)
		{
			board[i][j]='.';
		}
	}

	// Traverse List (code ngaco)
	// currentCreature=CreatureList;

	// do
	// {
	// 	currentCreature=*(currentCreature.Next());
	// 	board[currentCreature.getRowPosition()][currentCreature.getColumnPosition()]=currentCreature.draw();
	// }
	// while (currentCreature.Next()!=NULL)

	for (int i=0;i<amountOfRows;i++)
	{
		for (int j=0;j<amountOfColumns;j++)
		{
			output << board[i][j];
		}
		output << endl;
	}
}