#ifndef Plant_H
#define Plant_H

#include "Creature.h"

class Plant:public Creature{
	public:
		Plant(int=0,int=0);
		char draw();
	private:
};
#endif