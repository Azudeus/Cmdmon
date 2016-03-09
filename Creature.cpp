#include "Creature.h"

Creature::Creature(){
	
}

void Creature::setRowPosition(int _r){
	rowPosition = _r;
}

void Creature::setColumnPosition(int _c){
	columnPosition = _c;
}

void Creature::setStrength(int _s){
	strength = _s;
}

int Creature::getRowPosition(){
	return rowPosition;
}

int Creature::getColumnPosition(){
	return columnPosition;
}

int Creature::getStrength(){
	return strength;
}