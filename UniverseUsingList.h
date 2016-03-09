#include "Universe.h"

class UniverseUsingList : public Universe {
public:
	UniverseUsingList(int,int);

	void killCreature(Creature* C);
	void addCreature(Creature* C);
	void print(ostream&);

private:
	List<Creature> CreatureList;
};