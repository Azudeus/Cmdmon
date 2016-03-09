#include "Lamia.h"

int main(){
	Lamia p1(1,2,0,1);
	cout << "Shape :" << p1.draw()<<endl;
	cout << "Row Position: " << p1.getRowPosition()<<endl;
	cout << "Column Position: " << p1.getColumnPosition()<<endl;
	cout << "Deltax Position: " << p1.getDirection().deltax<<endl;
	cout << "Deltay Position: " << p1.getDirection().deltay<<endl;
	cout << "Strength: " << p1.getStrength()<<endl;
	p1.move();
	cout << "Shape :" << p1.draw()<<endl;
	cout << "Row Position: " << p1.getRowPosition()<<endl;
	cout << "Column Position: " << p1.getColumnPosition()<<endl;
	cout << "Deltax Position: " << p1.getDirection().deltax<<endl;
	cout << "Deltay Position: " << p1.getDirection().deltay<<endl;
	cout << "Strength: " << p1.getStrength()<<endl;

}