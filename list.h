#include <iostream>
#include "elementList.h"

#ifndef LIST_H
#define LIST_H
/* template <class Type>
class ElementList{
public:
	ElementList();
	ElementList(Type data);
	ElementList(const ElementList& L);
	~ElementList();
	
	Type Value();
	ElementList* Next();
	ElementList* Previous();
	void DeleteSingle();
	void SetValue(Type data);
	void SetNext(ElementList* P);
	void SetPrevious(ElementList* P);
private:
	Type Info;
	ElementList* NextV;
	ElementList* PreviousV;
}; */

template <class Type>
class List{
public:
	List();
	List(Type data);
	List(const List& L);
	~List();
	void SetAddressList(ElementList<Type>* L);
	ElementList<Type>* GetAddressList();
	void InsertLast(Type data);
	void Delete(Type data);
	bool isListEmpty();
private:
	ElementList<Type>* AddressList;
};
#endif