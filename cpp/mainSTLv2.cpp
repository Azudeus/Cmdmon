#include <stdio.h>
#include <string>
#include <iostream>
#include <fstream>
#include <time.h>
#include <stdlib.h>
#include <thread>
<<<<<<< HEAD:mainSTLv2.cpp
#include <conio.h>
#include <chrono>
=======
#include <curses.h>
#include <chrono> 
>>>>>>> 24832f8482f08f2e1f1f059aa9e32c8343ab0315:cpp/mainSTLv2.cpp
#include "UniverseUsingSTL.h"
#include <cstdlib>
#include <ctime>


using namespace std;

bool stop=false;
char CC = 'a';
int row = 25;
int column = 25;

UniverseUsingSTL world(row,column);

void keyListener(){
	CC=getchar();
	stop=true;
}
void initialize(){
	world.addRandomCreature(10);
}

void activateCreature(int i){
	Creature* C = world.getCreatureList(i);
	while(!stop){
	    C->doAction();
	    this_thread::sleep_for(chrono::milliseconds(C->getActionInterval()));
	    world.checkForCollisions();
	}
}

void printEvery(){
	while(!stop){
		system("clear");
		world.print(cout);
		 this_thread::sleep_for(chrono::milliseconds(500));
	}
}

int main(){
	initialize();
	while(CC != 'E'){
		stop=false;

		int sz = world.getList().size();
		thread t[sz];
	    for (int i=0;i<sz;i++){
	   		t[i] = thread(activateCreature,i);
	    }

		thread t2(keyListener);
		thread t3(printEvery);
		while(!stop){}
		t2.detach();
		t3.join();

	// cout << "t2 detach" << endl;
		for (int i=0;i<sz;i++){
			t[i].join();
			// cout << "t[i] join" << endl;
		}
		switch (CC){
			case 'p'
:			{
				cout << "To P" << endl;
				world.print(cout);
				break;
			}
			case 'a' :
			{
				cout << "To A" << endl;
				int amount;
				srand(time(NULL));
				amount = rand()%(row*column/10)+1;
				world.addRandomCreature(amount);
				break;
			}
			case 'f' :
			{
				string filename;
				cout << "Input Filename : " << endl;
				cin >> filename;
				filebuf fb;
				fb.open(filename,ios::out);
				ostream os(&fb);
				world.print(os);
				cout << "Print done at file " << filename << endl;
				fb.close();
				break;
			}
			case 'c' :
			{
				system("clear");
			}
			default :
			{
				cout << "Press p to print to terminal" <<endl;
				cout << "Press a to add random creature" << endl;
				cout << "Press f to print to file" << endl;
				cout << "Press E to exit" << endl;
				cout << "Press c to clear screen" << endl;
			}
		}
		if(world.isWorldEmpty()){
			exit(0);
		}else{
		cout << "Press Enter to Continue Program" <<endl;
		getchar();
		fflush(stdin);
		}
	}

	return 0;
}

