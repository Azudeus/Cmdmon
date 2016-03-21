#include <iostream>
#ifndef ELEMENT_LIST_H
#define ELEMENT_LIST_H
template <class Type>
class ElementList{
public:
	ElementList();
	ElementList(Type& data);
//	ElementList(const ElementList& L);
	~ElementList();
	
	Type Value();
	ElementList* Next();
	ElementList* Previous();
	void DeleteSingle();
	void SetValue(Type& data);
	void SetNext(ElementList* P);
	void SetPrevious(ElementList* P);
private:
	Type Info;
	ElementList* NextV;
	ElementList* PreviousV;
};

#endif