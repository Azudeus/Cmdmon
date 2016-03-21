#include "UniverseUsingList.h"
#include <iostream>
using namespace std;

int main(){
    UniverseUsingList Dunia(10,10);
    Dunia.addRandomCreature(100);
    Dunia.print(cout);
    return 0;
}
