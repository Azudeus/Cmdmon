#include <stdio.h>
#include <string>
#include <iostream>
#include <fstream>
#include <time.h>
#include <thread>
<<<<<<< HEAD:main.cpp
#include <conio.h>
#include <chrono>
=======
#include <curses.h>
#include <chrono> 
>>>>>>> 24832f8482f08f2e1f1f059aa9e32c8343ab0315:cpp/main.cpp
#include "UniverseUsingList.h"
#include <cstdlib>
#include <ctime>

using namespace std;

bool stop=false;
char CC = 'a';
int row = 25;
int column = 25;
UniverseUsingList world(row,column);

void printEvery(){
	while(!stop){
		system("cls");
		world.print(cout);
		 this_thread::sleep_for(chrono::milliseconds(1000));
	}
}

void activateWorld(){
	int i=0;
	 // while ((!stop)&&(!world.isWorldEmpty()){
	 while ((!stop)){
		world.moveAllCreaturesOnce();
		this_thread::sleep_for(chrono::milliseconds(1000));
	}
	stop=true;
}
void keyListener(){
	CC=getchar();
	stop=true;
}
void initialize(){
		world.addRandomCreature(10);
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
//	UniverseUsingList world(row,column);
	// int amount;
	// srand(time(NULL));
	// amount = rand()%(row*column/10)+1;
	// world.addRandomCreature(1);

	while(CC != 'E'){
		stop=false;
		thread t1(activateWorld);
		thread t2(keyListener);
		thread t3(printEvery);
		
		while(!stop){}
		t2.detach();
		t3.join();
		t1.join();
		cout << CC << endl;
		switch (CC){
<<<<<<< HEAD:main.cpp
			case 'p'
:			{
=======
			case 'p' :
			{ 
>>>>>>> 24832f8482f08f2e1f1f059aa9e32c8343ab0315:cpp/main.cpp
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
				cout << "Added Random Creature" << endl;
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
			default :
			{
				cout << "Press p to print to terminal" <<endl;
				cout << "Press a to add random creature" << endl;
				cout << "Press f to print to file" << endl;
				cout << "press E to exit" << endl;
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

