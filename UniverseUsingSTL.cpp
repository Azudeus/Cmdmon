#include "UniverseUsingSTL.h"
#include <time.h>
#include <stdlib.h>

UniverseUsingSTL::UniverseUsingSTL(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
}

void UniverseUsingSTL::killCreature(Creature* C)
{
	bool found=false;
	int size=CreatureList.size();
	int i=0;
	while ((!found)&&(i<size))
	{
		if (CreatureList[i]==C)
		{
			found=true;
			swap(CreatureList[i],CreatureList[size-1]);
		}
		i++;
	}
	CreatureList.pop_back();
}

void UniverseUsingSTL::addCreature(Creature* C)
{
    CreatureList.push_back(C);
}

void UniverseUsingSTL::addRandomCreature(int amount)
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
			addCreature((temp));
		}
		else if (r == 1){
			temp = new Lamia(row, column, directionX, directionY);
			addCreature((temp));
		}
		else if (r == 2){
			temp = new Centaur(row, column, directionX, directionY);
			addCreature((temp));
		}
		else{
			temp = new Harpy(row, column, directionX, directionY);
			addCreature((temp));
		}
	}
}

void UniverseUsingSTL::print(ostream& output)
{
	char board[getAmountOfRows()][getAmountOfColumns()];
	for (int i=0;i<getAmountOfRows();i++)
	{
		for (int j=0;j<getAmountOfColumns();j++)
		{
			board[i][j] = '.';
		}
	}

	for (int i=0;i<CreatureList.size();i++)
	{
		Creature* currentCreature = (CreatureList[i]);
		board[currentCreature->getRowPosition()][currentCreature->getColumnPosition()]=currentCreature->draw();
	}

	for (int i=0;i<getAmountOfRows();i++)
	{
		for (int j=0;j<getAmountOfColumns();j++)
		{
			output << board[i][j];
		}
		output << endl;
	}
}
