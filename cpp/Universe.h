#ifndef UNIVERSE_H
#define UNIVERSE_H

#include "list.h"
#include "Plant.h"
#include "Lamia.h"
#include "Centaur.h"
#include "Harpy.h"

class Universe {
public:
    Universe();
	Universe(int,int);

	int getAmountOfRows();
	int getAmountOfColumns();

	void setAmountOfRows(int);
	void setAmountOfColumns(int);

	/**
	*Kill a creature from CreatureList
	*@param C a pointer to creature
	**/
	virtual void killCreature(Creature*)=0;

	/**
	*Add a creature to CreatureList
	*@param C a pointer to creature
	**/
	virtual void addCreature(Creature*)=0;

	/**
	*Add "amount" amount of random creatures to CreatureList
	*@param amount an integer
	**/
	virtual void addRandomCreature(int)=0;

	/**
	*return 1 if Universe is empty, 0 otherwise
	**/
	virtual int isWorldEmpty() = 0;

	/**
	*check for a collision or out of bounds creatures to be killed
	**/
	virtual void checkForCollisions()=0;

<<<<<<< HEAD:Universe.h
/**
=======
	/**
>>>>>>> 24832f8482f08f2e1f1f059aa9e32c8343ab0315:cpp/Universe.h
	*Move all creature from CreatureList once
	**/
	virtual void moveAllCreaturesOnce()=0;

	/**
	*Print the world and all its creatures
	**/
	virtual void print(ostream&)=0;

private:
	int amountOfRows;
	int amountOfColumns;
};

#endif
