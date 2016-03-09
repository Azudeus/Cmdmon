#include "UniverseUsingList.h"

UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
	for (int i=1;i<=n;i++)
	{

	}
}

void UniverseUsingList::killCreature(Creature* C)
{
	//delete C from list
}

void UniverseUsingList::addCreature(Creature* C)
{
	//add C to list
}

void addRandomCreature(int amount)
{
	//randomly create creature
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

	currentCreature=CreatureList;

	do
	{
		currentCreature=*(currentCreature.Next());
		board[currentCreature.getRowPosition()][currentCreature.getColumnPosition()]=currentCreature.draw();
	}
	while (currentCreature.Next()!=NULL)

	for (int i=0;i<amountOfRows;i++)
	{
		for (int j=0;j<amountOfColumns;j++)
		{
			output << board[i][j];
		}
		output << endl;
	}
}