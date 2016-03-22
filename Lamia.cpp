#include "Lamia.h"

/**
*Make Lamia on postion (x,y)
*@param x
*@param y
**/
Lamia::Lamia(int r, int c, int x, int y){
    setRowPosition(r);
    setColumnPosition(c);
    setDirection(x,y);
    setStrength(10);
    setActionInterval(1200);
}

void Lamia::doAction(){
	Lamia::move();
}

/**
*move the Lamia
**/
void Lamia::move(){
    setRowPosition(getRowPosition()+getDirection().deltax);
    setColumnPosition(getColumnPosition()+getDirection().deltay);
}
/**
*draw the Lamia
**/
char Lamia::draw(){
    return 'L';
}