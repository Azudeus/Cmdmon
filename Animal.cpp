#include "Animal.h"
/**
*Ctor of Animal Class
*do nothing
**/
Animal::Animal(){
    //do nothing
}

/**
*Set the move direction of an Animal
*@param x
*@param y
**/
void Animal::setDirection(int x,int y){
	direction.deltax=x;
	direction.deltay=y;
}

/**
*Get the move direction of an Animal
**/
moveDirection Animal::getDirection(){
	return direction;
}
