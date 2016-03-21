#ifndef Creature_H
#define Creature_H

#include <iostream>
using namespace std;


class Creature{
	public :
		Creature();
		virtual char draw() = 0;
		virtual void doAction() = 0;
		void setRowPosition(int);
		void setColumnPosition(int);
		void setStrength(int);
		int getRowPosition();
		int getColumnPosition();
		int getStrength();
		bool compareStrength(Creature&);
        virtual int operator!=(Creature&);
	protected:

	private:
		int strength;
		int rowPosition;
		int columnPosition;
};
#endif
