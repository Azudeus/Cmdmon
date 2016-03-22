#include "Lamia.h"

/**
*Make Lamia on postion (x,y)
*@param r r is the starting row position of Lamia
*@param c c is the starting column position of Lamia
*@param x x is hoizontal component of moveDirection
*@param y y is vertical componen of moveDirection
**/
Lamia::Lamia(int r, int c, int x, int y){
    setRowPosition(r);
    setColumnPosition(c);
    setDirection(x,y);
    setStrength(10);
    setActionInterval(1200);
}

/**
*Make creature do some kind of action
**/
void Lamia::doAction(){
	Lamia::move();
}

/**
*Move the Lamia one step according to its moveDirection
**/
void Lamia::move(){
    setRowPosition(getRowPosition()+getDirection().deltax);
    setColumnPosition(getColumnPosition()+getDirection().deltay);
}
/**
*Draw the Lamia by returning its character symbol
*@return Special char denoting Lamia
**/
char Lamia::draw(){
    return 'L';
}