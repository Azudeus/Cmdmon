#include "Plant.h"

int main(){
	Plant p1(1,2);
	cout << "Shape :" << p1.draw() << endl;
	cout << "Row Position: " <<p1.getRowPosition() << endl;
	cout << "Column Position: "<<p1.getColumnPosition() << endl;
	cout << "Strength: " << p1.getStrength()<<endl;
}