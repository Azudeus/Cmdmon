#include <iostream>
using namespace std;

#ifndef Creature_H
#define Creature_H
class Creature{
	public :
		Creature();
		virtual char draw() = 0;
		void setRowPosition(int);
		void setColumnPosition(int);
		void setStrength(int);
		int getRowPosition();
		int getColumnPosition();
		int getStrength();
	protected:
		
	private:
		int strength;
		int rowPosition;
		int columnPosition;
};
#endif