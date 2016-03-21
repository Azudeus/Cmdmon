#ifndef UNIVERSELIST_H
#define UNIVERSELIST_H

#include "Universe.h"

class UniverseUsingList : public Universe {
public:
	UniverseUsingList(int,int);

    List<Creature*>& getCreatureList();

	void killCreature(Creature* C);

	void addCreature(Creature* C);

	void addRandomCreature(int);

	void checkForCollisions();

	void compareStrength(int row, int column);

	void createThreadsForCreatures();

	void moveAllCreaturesOnce();

	void print(ostream&);

private:
	List<Creature*> CreatureList;
};

#endif
