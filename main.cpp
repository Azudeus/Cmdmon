#include <stdio.h>
#include <iostream>
#include <time.h>
#include <thread>
#include <conio.h>
#include <chrono> 
//#include "UniverseUsingList.h"

using namespace std;

bool stop=false;	
char CC = 'a';
int row = 25;
int column = 25;

void waiting(){
	int i=0;
	while ((!stop)&&(i<15000)){
		cout <<i<<endl;
		i++;
	}
	stop=true;
}
void keyListener(){
	CC=_getch();
	stop=true;
}
void initialize(){
	
}

int main(){
//	UniverseUsingList world(row,column);
	while(CC != 'E'){
		stop=false;
		thread t1(waiting);
		thread t2(keyListener);
		while(!stop){}
		t2.detach();
		t1.join();
		switch (CC){
			case 'p' : 
//				world.print(cout);
			case 'a' :
//				int amount;
//				srand(time(NULL));
//				amount = rand()%(row*column/10)+1;
//				world.addRandomCreature(amount);
			case 'f' :
//				string filename;
//				cin >> filename;
//				ostringstream oss(filename);
//				world.print(oss);
			default :
				{}
		}
		cout << "Press Enter to Continue" <<endl;
		getchar();
	}

	return 0;
}

