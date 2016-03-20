#ifndef Lamia_H
#define Lamia_H

#include "Animal.h"

class Lamia:public Animal{
public:
    Lamia(int=0, int=0,int=0,int=0);
    void doAction();
    char draw();
protected:
	void move();
private:
};
#endif