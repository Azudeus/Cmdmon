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


void Centaur::doAction(){
	Centaur::move();
}

char Centaur::draw(){
    return 'C';
}