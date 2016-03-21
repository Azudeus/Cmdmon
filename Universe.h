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

	virtual void killCreature(Creature*)=0;
	virtual void addCreature(Creature*)=0;
	virtual void addRandomCreature(int)=0;

	virtual void checkForCollisions()=0;

	virtual void createThreadsForCreatures()=0;
	virtual void moveAllCreaturesOnce()=0;

	virtual void print(ostream&)=0;

private:
	int amountOfRows;
	int amountOfColumns;
};

#endif
