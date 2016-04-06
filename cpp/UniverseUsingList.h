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

	void moveAllCreaturesOnce();

	void print(ostream&);

	int isWorldEmpty();
	
private:
	List<Creature*> CreatureList;
};

#endif
