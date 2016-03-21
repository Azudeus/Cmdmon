#include "Creature.h"

/**
*Ctor of Creature Class
*do nothing
**/
Creature::Creature(){

}

/**
*Set the Row Position of a Creature
**/
void Creature::setRowPosition(int _r){
	rowPosition = _r;
}

/**
*Set the Column Position of a Creature
**/
void Creature::setColumnPosition(int _c){
	columnPosition = _c;
}

/**
*Set the Strength of a Creature
**/
void Creature::setStrength(int _s){
	strength = _s;
}
/**
*Set the Speed of a Creature
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

int Creature::getStrength(){
	return strength;
}

int Creature::getActionInterval(){
	return actionInterval;
}

int Creature::operator!=(Creature& c){
    cout<<"overload"<<endl;
    return !((strength==c.strength)&&(rowPosition==c.rowPosition)&&(columnPosition==c.columnPosition));
}


bool Creature::compareStrength(Creature &C){
	if (strength > C.getStrength()){
		return true;
	}else{
		return false;
	}
}
