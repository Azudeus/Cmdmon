#include "Creature.h"
using namespace std;

#ifndef Plant_H
#define Plant_H
class Plant:public Creature{
	public:
		Plant(int=0,int=0);
		char draw();
	private:
};
#endif