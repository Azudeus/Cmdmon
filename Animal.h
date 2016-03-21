#ifndef Animal_H
#define Animal_H

#include "Creature.h"

struct moveDirection
{
    int deltax;
    int deltay;
};

class Animal:public Creature{
public:
    Animal();
	virtual char draw()=0;
    virtual void doAction()=0;
   	void setDirection(int,int);
   	moveDirection getDirection();
protected:
    virtual void move()=0;
private:
    moveDirection direction;
};
#endif