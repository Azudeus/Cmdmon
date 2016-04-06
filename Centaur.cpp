#include "Centaur.h"

/**
*Make Centaur on postion (x,y)
*@param x
*@param y
**/
Centaur::Centaur(int r, int c, int x, int y){
    setRowPosition(r);
    setColumnPosition(c);
    setDirection(x,y);
    setStrength(25);
    setActionInterval(800);
}
/**
*move the Centaur
**/
void Centaur::move(){
    setRowPosition(getRowPosition()+getDirection().deltax);
    setColumnPosition(getColumnPosition()+getDirection().deltay);
}
/**
*draw the Centaur
**/
char Centaur::draw(){
    return 'C';
}

void Centaur::doAction(){
	Centaur::move();
}

