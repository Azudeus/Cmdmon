#include "UniverseUsingList.h"

UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
}

void UniverseUsingList::killCreature(Creature* C)
{
	CreatureList.Delete(*C);
}

void UniverseUsingList::addCreature(Creature* C)
{
    CreatureList.InsertLast(*C);
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
