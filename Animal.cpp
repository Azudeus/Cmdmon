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
*@param x The horizontal direction with 1 denoting right and -1 denothing left
*@param y The vertical direction with 1 denoting up and -1 denoting down
**/
void Animal::setDirection(int x,int y){
	direction.deltax=x;
	direction.deltay=y;
}

/**
*Get the move direction of an Animal
*@return return the direction attribute of Animal
**/
moveDirection Animal::getDirection(){
	return direction;
}
