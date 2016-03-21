#ifndef UNIVERSELIST_H
#define UNIVERSELIST_H

#include "Universe.h"

class UniverseUsingList : public Universe {
public:
	UniverseUsingList(int,int);

	void killCreature(Creature* C);
	void addCreature(Creature* C);
	void addRandomCreature(int amount);
	void print(ostream&);

private:
	List<Creature*> CreatureList;
};

#ifndef