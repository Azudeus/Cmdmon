#include "Plant.h"

/**
*Make Plant on postion (x,y)
*@param r r is the starting row position of Plant
*@param c c is the starting column position of Plant
**/
Plant::Plant(int _r, int _c){
	setRowPosition(_r);
	setColumnPosition(_c);
	setStrength(5);
	setActionInterval(3000);
}

/**
*Draw the Harpy by returning its character symbol
*@return Special char denoting plant
**/
char Plant::draw(){
	return 'T';
}

/**
*Make creature do some kind of action
**/
void Plant::doAction(){
	setStrength(getStrength()+1);
}
