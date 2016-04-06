#include "elementList.h"
#include "Creature.h"
#include "Animal.h"
#include "Lamia.h"
#include "Plant.h"
#include <iostream>
using namespace std;

/**
*ctor of ElementList
**/
template <class Type> //Checked
ElementList<Type>::ElementList(){
	NextV = NULL;
	PreviousV = NULL;
}

/**
*ctor with parameter of ElementList
**/
template <class Type> //Checked
ElementList<Type>::ElementList(Type& data){
	Info = data;
	NextV = NULL;
	PreviousV = NULL;
}

/**
*dtor of ElementList
**/
template <class Type> //Checked
ElementList<Type>::~ElementList(){
	ElementList<Type>* P;
	P = NextV;

	if (P != NULL){
		delete P;
	}
	delete Info;
<<<<<<< HEAD
=======
//	 cout << "KILL ELMT" << endl;
>>>>>>> d89a12817c0de65ceee3058fe177e5d7ab285933
}

/**
*Get the value of this elemnt
**/
template <class Type> //Checked
Type ElementList<Type>::Value(){
	return Info;
}

/**
*Get the pointer of Next Elemnt
**/
template <class Type> //Checked
ElementList<Type>* ElementList<Type>::Next(){
	return NextV;
}

/**
*Get the pointer of Previous Elemnt
**/
template <class Type> //Checked
ElementList<Type>* ElementList<Type>::Previous(){
	return PreviousV;
}

/**
*Erase an elementList by switching it with last elementList of it's List or erase it if it's single elementList.
**/
template <class Type> //Checked, kecuali kasus tunggal dan kosong
void ElementList<Type>::DeleteSingle(){
	ElementList<Type>* P;
	P = NextV;
	Type temp;

	if (P != NULL){
		while ((*P).NextV != NULL){
			P = (*P).NextV;
		}
		temp = Info;
		Info = (*P).Info;
		(*P).Info = temp;
		(*((*P).PreviousV)).NextV = NULL;
		delete P;
	}
	else{
		(*PreviousV).SetNext(NULL);
		delete this;
	}
}

/**
*Set the Value of this Element
*@param data
**/
template <class Type> //Checked
void ElementList<Type>::SetValue(Type& data){
	Info = data;
}

/**
*Set the pointer of Next Elemnt
*@param P
**/
template <class Type> //Checked, belom cek isi
void ElementList<Type>::SetNext(ElementList<Type>* P){
	NextV = P;
}

/**
*Set the pointer of Previous Elemnt
*@param P
**/
template <class Type> //Checked, belom cek isi
void ElementList<Type>::SetPrevious(ElementList<Type>* P){
	PreviousV = P;
}

template class ElementList<int*>;
template class ElementList<Creature*>;
