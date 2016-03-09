#include "Animal.h"

#ifndef Centaur_H
#define Centaur_H
class Centaur:public Animal{
public:
    Centaur(int=0, int=0,int=0,int=0);
    void move();
    char draw();
private:
};
#endif