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
    virtual void move()=0;
    virtual char draw()=0;
   	void setDirection(int,int);
   	moveDirection getDirection();
private:
    moveDirection direction;
};
#endif