#include "UniverseUsingSTL.h"
#include <iostream>
using namespace std;

int main(){
    UniverseUsingSTL Dunia(10,10);
    Dunia.addRandomCreature(3);
    Dunia.print(cout);

    int cnt=0;
    while ((!Dunia.isWorldEmpty())&&(cnt<20))
    {
    	Dunia.moveAllCreaturesOnce();
    	Dunia.print(cout);
    	cout << endl;
    	cnt++;
    }
}
