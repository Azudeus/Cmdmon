#include "list.h"
#include <iostream>
using namespace std;

template <class Type>
List<Type>::List(){
	NextV = NULL;
	PreviousV = NULL;
}

template <class Type>
List<Type>::List(Type data){
	Info = data;
	NextV = NULL;
	PreviousV = NULL;
}

template <class Type>
List<Type>::List(const List& L){
	List<Type>* P;
	
	P = L.NextV;
	Info = L.Info;
	PreviousV = NULL;
	if (P == NULL){
		NextV = NULL;
	}
	else{
		NextV = (new List<Type>(*P));
		(*NextV).PreviousV = this;
	}
}

template <class Type>
List<Type>::~List(){
	List<Type>* P;
	P = NextV;
	
	if (P != NULL){
		delete P;
	}
	cout << "KILL" << endl;
}

template <class Type>
Type List<Type>::Value(){
	return Info;
}

template <class Type>
List<Type>* List<Type>::Next(){
	return NextV;
}

template <class Type>
List<Type>* List<Type>::Previous(){
	return PreviousV;
}

template <class Type>
void List<Type>::DeleteSingle(){
	List<Type>* P;
	P = NextV;

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
		Info = (*P).Info;
		(*((*P).PreviousV)).NextV = NULL;
		delete P;
	}
	else{
		delete this;
	}
	cout << "KILL SINGLE" << endl;
}

template <class Type>
void List<Type>::InsertLast(Type data){
	List<Type> *P;
	
	P = NextV;
	if (P != NULL){
		while ((*P).Next() != NULL){
			P = (*P).Next();
		}
		(*P).NextV = new List<Type>(data);
		(*((*P).NextV)).PreviousV = P;
	}
	else{
		NextV = new List<Type>(data);
		(*NextV).PreviousV = this;
	}
}

template <class Type>
void List<Type>::SetValue(Type data){
	Info = data;
}

template <class Type>
void List<Type>::SetNext(List<Type>* P){
	NextV = P;
}

template <class Type>
void List<Type>::SetPrevious(List* P){
	PreviousV = P;
}

template class List<int>;