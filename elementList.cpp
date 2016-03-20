#include "elementList.h"
#include <iostream>
using namespace std;

template <class Type> //Checked
ElementList<Type>::ElementList(){
	NextV = NULL;
	PreviousV = NULL;
}

template <class Type> //Checked
ElementList<Type>::ElementList(Type data){
	Info = data;
	NextV = NULL;
	PreviousV = NULL;
}

template <class Type> //Checked
ElementList<Type>::ElementList(const ElementList& L){
	ElementList<Type>* P;
	
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

template <class Type> //Checked
ElementList<Type>::~ElementList(){
	ElementList<Type>* P;
	P = NextV;
	
	if (P != NULL){
		delete P;
	}
	cout << "KILL ELMT" << endl;
}

template <class Type> //Checked
Type ElementList<Type>::Value(){
	return Info;
}

template <class Type> //Checked
ElementList<Type>* ElementList<Type>::Next(){
	return NextV;
}

template <class Type> //Checked
ElementList<Type>* ElementList<Type>::Previous(){
	return PreviousV;
}

template <class Type> //Checked, kecuali kasus tunggal dan kosong
void ElementList<Type>::DeleteSingle(){
	ElementList<Type>* P;
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
		(*PreviousV).SetNext(NULL); 
		delete this;
	}
	cout << "KILL SINGLE" << endl;
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

template <class Type> //Checked
void ElementList<Type>::SetValue(Type data){
	Info = data;
}

template <class Type> //Checked, belom cek isi
void ElementList<Type>::SetNext(ElementList<Type>* P){
	NextV = P;
}

template <class Type> //Checked, belom cek isi
void ElementList<Type>::SetPrevious(ElementList<Type>* P){
	PreviousV = P;
}

template class ElementList<int>;