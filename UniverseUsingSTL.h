#ifndef UNIVERSESTL_H
#define UNIVERSESTL_H

#include "Universe.h"
#include <vector>

class UniverseUsingSTL : public Universe {
public:
	UniverseUsingSTL(int,int);

	void killCreature(Creature* C);
	void addCreature(Creature* C);
	void addRandomCreature(int);

	int isWorldEmpty();

	void checkForCollisions();

	void createThreadsForCreatures();
	
	void moveAllCreaturesOnce();

	void print(ostream&);

private:
	vector <Creature*> CreatureList;
};

#endif
