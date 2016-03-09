#ifndef UNIVERSE_H
#define UNIVERSE_H

#include "List.h"
#include "Creature.h"

class Universe {
public:
	Universe(int,int);

	int getAmountOfRows();
	int getAmountOfColumns();

	void setAmountOfRows(int);
	void setAmountOfColumns(int);

	virtual void killCreature(Creature*);
	virtual void addCreature(Creature*);
	virtual void addRandomCreature(int);
	virtual void print(ostream&);

private:
	int amountOfRows;
	int amountOfColumns;
};

#endif