#ifndef Harpy_H
#define Harpy_H

#include "Animal.h"

class Harpy:public Animal{
public:
    Harpy(int=0, int=0,int=0,int=0);
    void doAction();
    char draw();
protected:
	void move();
private:
};
#endif