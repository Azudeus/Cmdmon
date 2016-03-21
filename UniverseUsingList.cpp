#include "UniverseUsingList.h"
#include <time.h>
#include <stdlib.h>

UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
}

void UniverseUsingList::killCreature(Creature* C)
{
	CreatureList.Delete(C);
}

void UniverseUsingList::addCreature(Creature* C)
{
    CreatureList.InsertLast(C);
}

void UniverseUsingList::addRandomCreature(int amount)
{
	Creature* temp;
	srand(time(NULL));
	//randomly create creature
	for (int i = 0; i < amount; i++){
		int r;
		int row;
		int column;
		int directionX;
		int directionY;
		r = (rand() % 3);
		row = (rand() % getAmountOfRows());
		column = (rand() % getAmountOfColumns());
		directionX = (rand() % 2);
		if (directionX == 0){
			directionX = -1;
		}
		directionY = (rand() % 2);
		if (directionY == 0){
			directionY = -1;
		}
		if (r == 0){
			temp = new Plant(row, column);
			CreatureList.InsertLast((temp));
		}
		else if (r == 1){
			temp = new Lamia(row, column, directionX, directionY);
			CreatureList.InsertLast((temp));
		}
		else if (r == 2){
			temp = new Centaur(row, column, directionX, directionY);
			CreatureList.InsertLast((temp));
		}
		else{
			temp = new Harpy(row, column, directionX, directionY);
			CreatureList.InsertLast((temp));
		}
	}
}

void UniverseUsingList::print(ostream& output)
{
	char board[getAmountOfRows()][getAmountOfColumns()];
	for (int i=0;i<getAmountOfRows();i++)
	{
		for (int j=0;j<getAmountOfColumns();j++)
		{
			board[i][j]='.';
		}
	}

	ElementList<Creature*> currentCreature = *(CreatureList.GetAddressList());

	do
	{
		currentCreature=*(currentCreature.Next());
		board[(currentCreature.Value())->getRowPosition()][(currentCreature.Value())->getColumnPosition()]=(currentCreature.Value())->draw();
	}
	while (currentCreature.Next()!=NULL);

	for (int i=0;i<getAmountOfRows();i++)
	{
		for (int j=0;j<getAmountOfColumns();j++)
		{
			output << board[i][j];
		}
		output << endl;
	}
}
