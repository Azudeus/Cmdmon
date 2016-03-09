#ifndef Centaur_H
#define Centaur_H

#include "Animal.h"

class Centaur:public Animal{
public:
    Centaur(int=0, int=0,int=0,int=0);
    void move();
    char draw();
private:
};
#endif