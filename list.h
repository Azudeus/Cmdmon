#include <iostream>

#ifndef LIST_H
#define LIST_H
template <class Type>
class List{ // List adalah Node
public:
	List();
	List(Type data);
	List(const List& L);
	~List();
	
	Type Value();
	List* Next();
	List* Previous();
	void DeleteSingle();
	void InsertLast(Type data);
	void SetValue(Type data);
	void SetNext(List* P);
	void SetPrevious(List* P);
private:
	Type Info;
	List* NextV;
	List* PreviousV;
};
#endif