#include "UniverseUsingSTL.h"
#include <time.h>
#include <thread>
#include <chrono>
#include <stdlib.h>

using namespace std;

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
		int Found = 1;
        int counter = 0;

        //cari apakah sudah ada
        while((counter<(getAmountOfColumns()*getAmountOfRows()))&&(Found)){
            Found = 0;
            counter = 0;
            int sz = CreatureList.size();
            int i = 0;
            while((i<sz) && (!Found)&& (counter<(getAmountOfColumns()*getAmountOfRows())) ){
                counter++;
                if((CreatureList[i]->getRowPosition() == row) && (CreatureList[i]->getColumnPosition() == column))
                    Found = 1;
                i++;
            }

            if(Found)
            {
                column++;
                if (column == getAmountOfColumns()){column = 0; row++;}
                if (row == getAmountOfRows()){column = 0; row =0;}
            }

        }
        if(counter<(getAmountOfColumns()*getAmountOfRows())){
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
}

int UniverseUsingSTL::isWorldEmpty()
{
	return (CreatureList.size()==0);
}

void UniverseUsingSTL::checkForCollisions()
{
	int sz = CreatureList.size();
	int i = 0;
	//Kill Out Of Bounds
	while (i<sz)
	{
		if ((CreatureList[i]->getRowPosition()<0)||
			(CreatureList[i]->getColumnPosition()<0)||
			(CreatureList[i]->getRowPosition()>=getAmountOfRows())||
			(CreatureList[i]->getColumnPosition()>=getAmountOfColumns()))
		{
			killCreature(CreatureList[i]);
			i--;
			sz--;
		}
		i++;
	}

	//Kill Collisions
	sz = CreatureList.size();
	for (i=0;i<getAmountOfRows();i++)
	{
		for (int j=0;j<getAmountOfColumns();j++)
		{
			int minimumStrength = 999; //UNDEF
			int minimumIndex = -1;
			int counter = 0;
			for (int k=0;k<sz;k++)
			{
				if (((CreatureList[k])->getRowPosition()==i)&&
					((CreatureList[k])->getColumnPosition()==j))
				{
					if (minimumStrength>CreatureList[k]->getStrength())
					{
						minimumStrength=CreatureList[k]->getStrength();
						minimumIndex=k;
					}
					counter++;
				}
			}
			if (counter>1)
			{
				killCreature(CreatureList[minimumIndex]);
				sz--;
			}
		}
	}
}

void UniverseUsingSTL::moveAllCreaturesOnce()
{
    for (int i=0;i<CreatureList.size();i++)
    {
    	CreatureList[i]->doAction();
    }
    checkForCollisions();
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

void UniverseUsingSTL::createThreadsForCreatures(){
 	// int sz = CreatureList.size();
 	// int i = 0;
 	// thread t[sz];
  //   for (i;i<sz;i++){
  //  		t[i] = thread(activateCreature);
  //       i++;
  //   }
  //   i = 0;
  //   for(i=0;i<sz;i++){
  //       t[i].join();
  //   }

}

void UniverseUsingSTL::activateCreature(){
		// Creature* C = CreatureList[i];
  //       C->doAction();
  //       this_thread::sleep_for(chrono::milliseconds(C->getActionInterval()));
  //       checkForCollisions();

}