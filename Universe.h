#ifndef UNIVERSE_H
#define UNIVERSE_H

#include "List.h"
#include "Creature.h"

class Universe {
public:
	Universe(int,int);

	virtual void killCreature(Creature* C);
	virtual void addCreature(Creature* C);
	virtual void print(ostream&);

private:
	int amountOfRows;
	int amountOfColumns;
};

#endif