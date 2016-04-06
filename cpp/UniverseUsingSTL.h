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
	
	void moveAllCreaturesOnce();

	void print(ostream&);

	Creature* getCreatureList(int i){
		return CreatureList[i];
	}

	vector<Creature*> getList(){
		return CreatureList;
	}

private:
	vector <Creature*> CreatureList;
};

#endif
