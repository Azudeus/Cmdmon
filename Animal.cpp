#include "Animal.h"

Animal::Animal(){
    //do nothing
}

void Animal::setDirection(int x,int y){
	direction.deltax=x;
	direction.deltay=y;
}
moveDirection Animal::getDirection(){
	return direction;
}
