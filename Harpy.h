#include "Animal.h"

#ifndef Harpy_H
#define Harpy_H
class Harpy:public Animal{
public:
    Harpy(int=0, int=0,int=0,int=0);
    void move();
    char draw();
private:
};
#endif