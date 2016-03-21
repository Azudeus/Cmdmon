#include "Plant.h"

/**
 *Make Plant on postion (x,y)
 * @param data
 **/
Plant::Plant(int _r, int _c){
	setRowPosition(_r);
	setColumnPosition(_c);
	setStrength(5);
}
/**
 *draw the Plant
 * @param data
 **/
char Plant::draw(){
	return 'T';
}


void Plant::doAction(){
	
}
