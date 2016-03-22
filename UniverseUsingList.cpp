#include "UniverseUsingList.h"
#include <time.h>
#include <thread>
#include <chrono>
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

void UniverseUsingList::checkForCollisions(){
    ElementList<Creature*>* currentCreature1 = (CreatureList.GetAddressList());
    ElementList<Creature*>* currentCreature2 = (CreatureList.GetAddressList());
    bool Result;
    while ((currentCreature1 != NULL) && (((*currentCreature1).Value()) != NULL)){
        currentCreature2 = (CreatureList.GetAddressList());
        while ((currentCreature2 != NULL) && (((*currentCreature2).Value()) != NULL)){
            if ((((*currentCreature1).Value())->getRowPosition() == ((*currentCreature2).Value())->getRowPosition()) && (((*currentCreature1).Value())->getColumnPosition() == ((*currentCreature2).Value())->getColumnPosition())){
                Result = ((*currentCreature1).Value())->compareStrength(*((*currentCreature2).Value()));
                if (Result == 1){
                    killCreature(((*currentCreature2).Value()));
                }
                else{
                    killCreature(((*currentCreature1).Value()));
                }
            }
            currentCreature2 = ((*currentCreature2).Next());
        }
        currentCreature1 = ((*currentCreature1).Next());
    }
    currentCreature1 = NULL;
    currentCreature2 = NULL;
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

void UniverseUsingList::moveAllCreaturesOnce(){
    cout << "Step 1" << endl;
    ElementList<Creature*>* currentCreature = (CreatureList.GetAddressList());
//    ElementList<Creature*>* currentCreature;
    cout << "Step 2" << endl;
    cout << "C " << currentCreature->Value() << endl;
    while ((currentCreature != NULL) && (((*currentCreature).Value()) != NULL)){
            cout << "Step it" << endl;

        ((*currentCreature).Value())->doAction();
        cout << "FUCK BOOBS" << endl;
//        checkForCollisions();
        cout << "FUCK TITS" << endl;
        currentCreature = ((*currentCreature).Next());
        cout << "FUCK VAGINA" << endl;
    }
        cout << "Step 3" << endl;

    currentCreature = NULL;
}

void UniverseUsingList::createThreadsForCreatures(){
    ElementList<Creature*>* currentCreature1 = (CreatureList.GetAddressList());
    int i=0;
    int count=0;
    ElementList<Creature*>* temp = currentCreature1;
    while (((*temp).Value()) != NULL){
        temp = ((*temp).Next());
        i++;
    }
    temp = NULL;
    count = i;
    i=0;
    while (((*currentCreature1).Value()) != NULL){
        Creature* C = (*(currentCreature1)).Value();
//		std::thread t(activateCreature,C);
//         thread t[i](activateCreature,C);
//         currentCreature1 = ((*currentCreature1).Next());
//         thread t[i](activateCreature,C);
//        i++;
		break;
    }
    for(int i=0;i<count;i++){
        // t[i].join();
    }

}

void UniverseUsingList::activateCreature(Creature* C){
    while (C != NULL){
        // C->doAction();
        // this_thread::sleep_for(chrono::milliseconds(C->getActionInterval()));
        // *ListC->=checkForCollisions();
    }
}

int UniverseUsingList::isWorldEmpty(){
	return CreatureList.isListEmpty();
}