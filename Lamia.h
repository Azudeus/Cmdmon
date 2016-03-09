#include "Animal.h"

#ifndef Lamia_H
#define Lamia_H
class Lamia:public Animal{
public:
    Lamia(int=0, int=0,int=0,int=0);
    void move();
    char draw();
private:
};
#endif