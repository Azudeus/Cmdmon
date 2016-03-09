#include "UniverseUsingList.h"

UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->amountOfRows=amountOfRows;
	this->amountOfColumns=amountOfColumns;
	//randomly create creatures
}

void UniverseUsingList::killCreature(Creature* C)
{
	//delete C from list
}

void UniverseUsingList::addCreature(Creature* C)
{
	//add C to list
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

	while ()
	{
		board[getRow][getColumn]=draw();
	}

	for (int i=0;i<amountOfRows;i++)
	{
		for (int j=0;j<amountOfColumns;j++)
		{
			output << board[i][j];
		}
		output << endl;
	}
}