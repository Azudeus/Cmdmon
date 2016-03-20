#include "list.h"
#include <iostream>
using namespace std;

template <class Type>
List<Type>::List(){ //Checked
	AddressList = NULL;
}

template <class Type> //Checked
List<Type>::List(Type data){
	AddressList = new ElementList<Type>(data);
}

template <class Type> //Checked
List<Type>::List(const List& L){
	AddressList = new ElementList<Type>(*(L.AddressList));
}

template <class Type> //Checked
List<Type>::~List(){
	ElementList<Type>* P;
	P = AddressList;
	
	if (P != NULL){
		delete P;
	}
	cout << "KILL" << endl;
}

template <class Type> //Checked
void List<Type>::SetAddressList(ElementList<Type>* L){
	AddressList = L;
}

template <class Type> //Checked
ElementList<Type>* List<Type>::GetAddressList(){
	return AddressList;
}

template <class Type> //Checked
void List<Type>::InsertLast(Type data){
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
}

template <class Type>
void List<Type>::Delete(Type data){ //Checked
//Asumsi: data pasti ada di dalam list.
	ElementList<Type>* P;
	
	P = AddressList;
	while ((*P).Value() != data){
		P = (*P).Next();
	}
	if ((*P).Previous() != NULL){
		(*P).DeleteSingle();
	}
	else{
		AddressList = NULL;
		delete P;
	}
}

template <class Type> //Checked
bool List<Type>::isListEmpty(){
	return (AddressList == NULL);
}

template class List<int>;