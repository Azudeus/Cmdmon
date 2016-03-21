#include "UniverseUsingList.h"
#include <time.h>
#include <stdlib.h>

UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
}

List<Creature*>& UniverseUsingList::getCreatureList(){
    return CreatureList;
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
    ElementList<Creature*>* currentCreature;
	Creature* temp;
	srand(time(NULL));
	//randomly create creature
	for (int i = 0; i < amount; i++){
        int j = 0;
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

        int Found = 1;
        int counter = 0;

        //cari apakah sudah ada
        while((counter<(getAmountOfColumns()*getAmountOfRows()))&&(Found)){
            currentCreature = (CreatureList.GetAddressList());
            Found = 0;
            counter = 0;
            while((currentCreature!=NULL) && (!Found)&& (counter<(getAmountOfColumns()*getAmountOfRows())) ){
                counter++;
                if((((currentCreature)->Value())->getRowPosition() == row) && (((currentCreature)->Value())->getColumnPosition() == column))
                    Found = 1;
                currentCreature = (currentCreature)->Next();
            }

            if(Found)
            {
                column++;
                if (column == getAmountOfColumns()){column = 0; row++;}
                if (row == getAmountOfRows()){column = 0; row =0;}
            }

        }

        currentCreature = NULL;

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

void UniverseUsingList::print(ostream& output)
{
	char board[getAmountOfRows()][getAmountOfColumns()];
	for (int i=0;i<getAmountOfRows();i++)
	{
		for (int j=0;j<getAmountOfColumns();j++)
		{
			board[i][j] = '.';
		}
	}
    if(!CreatureList.isListEmpty()){
        ElementList<Creature*>* currentCreature = (CreatureList.GetAddressList());
        do
        {
            board[((*currentCreature).Value())->getRowPosition()][((*currentCreature).Value())->getColumnPosition()]=((*currentCreature).Value())->draw();
            currentCreature= ((*currentCreature).Next());

        }
        while (currentCreature != NULL);
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
