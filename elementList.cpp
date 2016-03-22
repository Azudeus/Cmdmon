#include "elementList.h"
#include "Creature.h"
#include "Animal.h"
#include "Lamia.h"
#include "Plant.h"
#include <iostream>
using namespace std;

template <class Type> //Checked
ElementList<Type>::ElementList(){
	NextV = NULL;
	PreviousV = NULL;
}

template <class Type> //Checked
ElementList<Type>::ElementList(Type& data){
	Info = data;
	NextV = NULL;
	PreviousV = NULL;
}

//Omitted
/*
template <class Type> //Checked
ElementList<Type>::ElementList(const ElementList& L){
	ElementList<Type>* P;

	Type  Creature*
	P = L.NextV;
	Info = L.Info;
	PreviousV = NULL;
	if (P == NULL){
		NextV = NULL;
	}
	else{
		NextV = (new ElementList<Type>(*P));
		(*NextV).PreviousV = this;
	}
}
*/

template <class Type> //Checked
ElementList<Type>::~ElementList(){
	ElementList<Type>* P;
	P = NextV;

	if (P != NULL){
		delete P;
	}
	delete Info;
	 cout << "KILL ELMT" << endl;
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

template <class Type> //Checked, kecuali kasus tunggal dan kosong
void ElementList<Type>::DeleteSingle(){
	ElementList<Type>* P;
	P = NextV;
	Type temp;
/*
	if (P != NULL){
		while ((*P).NextV != NULL){
			P = (*P).NextV;
		}
		(*((*P).Previous())).NextV = NULL;
		(*P).PreviousV = (*this).PreviousV;
		if ((*this).PreviousV != NULL){
			(*((*this).PreviousV)).NextV = P;
		}
		(*P).NextV = (*this).NextV;
		if ((*this).NextV != NULL){
			(*((*this).NextV)).PreviousV = P;
		}
	}
	delete this; */
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
	// cout << "KILL SINGLE" << endl;
}

/* template <class Type>
void ElementList<Type>::InsertLast(Type data){
	ElementList<Type> *P;

	P = NextV;
	if (P != NULL){
		while ((*P).Next() != NULL){
			P = (*P).Next();
		}
		(*P).NextV = new ElementList<Type>(data);
		(*((*P).NextV)).PreviousV = P;
	}
	else{
		NextV = new ElementList<Type>(data);
		(*NextV).PreviousV = this;
	}
} */

/**
*Set the Value of this Element
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
