#include "Creature.h"
using namespace std;

class Plant:public Creature{
	public:
		Plant(int=0,int=0);
		char draw();
	private:
};
