#include "Harpy.h"

/**
*Make Harpy on postion (x,y)
*@param r r is the starting row position of Harpy
*@param c c is the starting column position of Harpy
*@param x x is hoizontal component of moveDirection
*@param y y is vertical componen of moveDirection
**/
Harpy::Harpy(int r, int c, int x, int y){
    setRowPosition(r);
    setColumnPosition(c);
    setDirection(x,y);
    setStrength(15);
    setActionInterval(1000);
}

/**
*Move the Harpy one step according to its moveDirection
**/
void Harpy::move(){
    setRowPosition(getRowPosition()+getDirection().deltax);
    setColumnPosition(getColumnPosition()+getDirection().deltay);
}

/**
*Make creature do some kind of action
**/
void Harpy::doAction(){
	Harpy::move();
}

/**
*Draw the Harpy by returning its character symbol
*@return Special char denoting Harpy
**/
char Harpy::draw(){
    return 'H';
}