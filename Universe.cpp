#include "Universe.h"

Universe::Universe(int amountOfRows,int amountOfColumns)
{
	this->amountOfRows=amountOfRows;
	this->amountOfColumns=amountOfColumns;
	//randomly create shit
}

void Universe::print(ostream& output)
{
	char board[amountOfRows][amountOfColumns];
	for (int i=0;i<amountOfRows;i++)
	{
		for (int j=0;j<amountOfColumns;j++)
		{
			board[i][j]='.';
		}
	}

	while ()
	{
		board[getRow][getColumn]=draw();
	}

	for (int i=0;i<amountOfRows;i++)
	{
		for (int j=0;j<amountOfColumns;j++)
		{
			output << board[i][j];
		}
		output << endl;
	}
}