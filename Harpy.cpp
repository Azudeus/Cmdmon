#include "Harpy.h"

/**
*Make Harpy on postion (x,y)
*@param x
*@param y
**/
Harpy::Harpy(int r, int c, int x, int y){
    setRowPosition(r);
    setColumnPosition(c);
    setDirection(x,y);
    setStrength(15);
}
/**
*move the Harpy
**/
void Harpy::move(){
    setRowPosition(getRowPosition()+getDirection().deltax);
    setColumnPosition(getColumnPosition()+getDirection().deltay);
}
/**
*draw the Harpy
**/
char Harpy::draw(){
    return 'H';
}