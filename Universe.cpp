#include "Universe.h"

Universe::Universe(int amountOfRows,int amountOfColumns)
{
	this->amountOfRows=amountOfRows;
	this->amountOfColumns=amountOfColumns;
}

int Universe::getAmountOfRows()
{
	return amountOfRows;
}

int Universe::getAmountOfColumns()
{
	return amountOfColumns;
}

void Universe::setAmountOfRows(int amountOfRows)
{
	this->amountOfRows=amountOfRows;
}

void Universe::setAmountOfColumns(int amountOfColumns)
{
	this->amountOfColumns=amountOfColumns;
}