#include <iostream>
#include "list.h"
#include "Creature.h"
#include "Animal.h"
#include "Lamia.h"
#include "Plant.h"
using namespace std;

/**
*Ctor of a generic List
**/
template <class Type>
List<Type>::List(){ //Checked
	AddressList = NULL;
}

/**
*Ctor of a generic List, using data as parameter
*@param data
**/
template <class Type> //Checked
List<Type>::List(Type& data){
	AddressList = new ElementList<Type>(data);
}

/**
*Dtor of a generic List
**/
template <class Type> //Checked
List<Type>::~List(){
	ElementList<Type>* P;
	P = AddressList;

	if (P != NULL){
		delete P;
	}
<<<<<<< HEAD
=======
//	cout << "KILL" << endl;
>>>>>>> d89a12817c0de65ceee3058fe177e5d7ab285933
}

/**
*Set the Adress of List
*@param L
**/
template <class Type> //Checked
void List<Type>::SetAddressList(ElementList<Type>* L){
	AddressList = L;
}

/**
*Get the Adress of List
**/
template <class Type> //Checked
ElementList<Type>* List<Type>::GetAddressList(){
	return AddressList;
}

/**
*Insert a data to last of the list
*@param data
**/
template <class Type> //Checked
void List<Type>::InsertLast(Type& data){
	ElementList<Type>* P;

	P = AddressList;
	if (P != NULL){
		while ((*P).Next() != NULL){
			P = (*P).Next();
		}
		(*P).SetNext(new ElementList<Type>(data));
		(*((*P).Next())).SetPrevious(P);
	}
	else{
		AddressList = new ElementList<Type>(data);
	}
	P = NULL;
}

/**
*Delete an data from the list
*@param data
**/
template <class Type>
void List<Type>::Delete(Type& data){ //Checked
//Asumsi: data pasti ada di dalam list.
	ElementList<Type>* P;

	P = AddressList;
	while ((*P).Value() != data){
		P = (*P).Next();
	}
	if (((*P).Previous() != NULL)||((*P).Next() != NULL)){
		(*P).DeleteSingle();
	}
	else{
		delete P;
		AddressList = NULL;
	}
}

/**
*Return 1 if List empty, 0 otherwise
**/
template <class Type> //Checked
bool List<Type>::isListEmpty(){
	return (AddressList == NULL);
}

template class List<int*>;
template class List<Creature*>;