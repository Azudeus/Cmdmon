#include "Centaur.h"

/**
*Make Centaur on postion (x,y)
*@param r r is the starting row position of Centaur
*@param c c is the starting column position of Centaur
*@param x x is hoizontal component of moveDirection
*@param y y is vertical componen of moveDirection
**/
Centaur::Centaur(int r, int c, int x, int y){
    setRowPosition(r);
    setColumnPosition(c);
    setDirection(x,y);
    setStrength(25);
    setActionInterval(800);
}

/**
*Move the Centaur one step according to its moveDirection
**/
void Centaur::move(){
    setRowPosition(getRowPosition()+getDirection().deltax);
    setColumnPosition(getColumnPosition()+getDirection().deltay);
}

/**
*Make creature do some kind of action
**/
void Centaur::doAction(){
	Centaur::move();
}


/**
*Draw the Centaur by returning its character symbol
*@return Special char denoting Centaur
**/
char Centaur::draw(){
    return 'C';
}
