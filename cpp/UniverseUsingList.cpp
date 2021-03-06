#include "UniverseUsingList.h"
#include <thread>
#include <chrono>
#include <cstdlib>
#include <ctime>

/**
*Constructor of UniverseUsingList class
**/
UniverseUsingList::UniverseUsingList(int amountOfRows,int amountOfColumns)
{
	this->setAmountOfRows(amountOfRows);
	this->setAmountOfColumns(amountOfColumns);
}

List<Creature*>& UniverseUsingList::getCreatureList(){
    return CreatureList;
}

/**
*Kill a creature from CreatureList
*@param C
**/
void UniverseUsingList::killCreature(Creature* C)
{
	CreatureList.Delete(C);
}

/**
*Add a creature to CreatureList
*@param C
**/
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
    ElementList<Creature*>* currentCreature;
    ElementList<Creature*>* tempCreature;
    int Found;
    int counter = 0;

    //hapus semua makhluk yang keluar batas
    currentCreature = CreatureList.GetAddressList();
    while(currentCreature!=NULL){
        if((((*currentCreature).Value() )->getRowPosition() >= getAmountOfRows()) || (((*currentCreature).Value())->getColumnPosition() >= getAmountOfColumns()) || (((*currentCreature).Value() )->getRowPosition() < 0)  || (((*currentCreature).Value())->getColumnPosition() < 0)  ){
            killCreature(currentCreature->Value());
<<<<<<< HEAD
            //cout << currentCreature << endl;
=======
>>>>>>> 657c28adc9be45b586aee8c1432923c794b1edea
            currentCreature = CreatureList.GetAddressList();
        }
        else{
            currentCreature = (*currentCreature).Next();
        }
    }
    if (CreatureList.GetAddressList() != NULL){
        for (int row = 0 ; row < getAmountOfRows(); row++)
        {
            for(int column = 0 ; column < getAmountOfColumns(); column++){
                Found = 0;
                counter = 0;
                currentCreature = CreatureList.GetAddressList();
                //Cek setiap kotak apakah ada makhluk yang mengisi
                while((currentCreature!= NULL)&&(!Found)){
                    if((((*currentCreature).Value())->getRowPosition() == row) && (((*currentCreature).Value())->getColumnPosition() == column)){
                        tempCreature = currentCreature;
                        Found = 1;
                        counter++;
                    }
                    currentCreature = (*currentCreature).Next();

                }

                //apabila ada, cek apakah lebih satu dan dapatkan makhluk dengan strength terendah
                if(Found){
                    while(currentCreature!=NULL){
                        if((((*currentCreature).Value())->getRowPosition() == row) && (((*currentCreature).Value())->getColumnPosition() == column))
                        {
                            if((((*currentCreature).Value())->getStrength()) < ( ((*tempCreature).Value()) ->getStrength() )  ){
                                tempCreature = currentCreature;
                            }
                            counter++;
                        }
                        currentCreature = (*currentCreature).Next();
                    }
                }

                //apabiladi kotak ada lebih dari 1 makhluk hapus makhluk dengan strength terkecil
                if(counter>1){
                    killCreature(tempCreature->Value());
                }

            }

        }
    }
}

/**
*Print the world
**/
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
    if(CreatureList.GetAddressList()!=NULL){
        ElementList<Creature*>* currentCreature = (CreatureList.GetAddressList());
        while ((currentCreature != NULL) && (((*currentCreature).Value()) != NULL)){
            int lastElement = 0;


            ((*currentCreature).Value())->doAction();
            if ((*currentCreature).Next() == NULL){
                lastElement  = 1;
            }
            checkForCollisions();
            if (CreatureList.GetAddressList() != NULL){
                if (lastElement != 1){
                    currentCreature = ((*currentCreature).Next());
                }
                else{
                    currentCreature = NULL;
                }
            }
            else{
                currentCreature = NULL;
            }
        }

        currentCreature = NULL;
    }
}

int UniverseUsingList::isWorldEmpty(){
	return CreatureList.isListEmpty();
}
