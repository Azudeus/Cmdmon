#include "Creature.h"

/**
*Ctor of Creature Class
*do nothing
**/
Creature::Creature(){

}

/**
*Set the Row Position of a Creature
*@param _r
**/
void Creature::setRowPosition(int _r){
	rowPosition = _r;
}

/**
*Set the Column Position of a Creature
*@param _c
**/
void Creature::setColumnPosition(int _c){
	columnPosition = _c;
}

/**
*Set the Strength of a Creature
*@param _s
**/
void Creature::setStrength(int _s){
	strength = _s;
}
/**
*Set the Speed of a Creature
*@param _s
**/
void Creature::setActionInterval(int _s){
	actionInterval = _s;
}
/**
*Return the row Position of a Creature in integer
**/
int Creature::getRowPosition(){
	return rowPosition;
}

/**
*Return the column Position of a Creature in integer
**/
int Creature::getColumnPosition(){
	return columnPosition;
}

/**
*Return the strength of a Creature in integer
**/
int Creature::getStrength(){
	return strength;
}

int Creature::getActionInterval(){
	return actionInterval;
}


