#include <stdio.h>
#include <string>
#include <iostream>
#include <fstream>
#include <time.h>
#include <thread>
#include <conio.h>
#include <chrono>
#include "UniverseUsingSTL.h"
#include <cstdlib>
#include <ctime>

using namespace std;

bool stop=false;
char CC = 'a';
int row = 25;
int column = 25;

UniverseUsingSTL world(row,column);

void printEvery(){
	while(!stop){
		system("cls");
		world.print(cout);
		 this_thread::sleep_for(chrono::milliseconds(1000));
	}
}

void activateWorld(){
	int i=0;
//	while ((!stop)&&(!world.isWorldEmpty())){
	 while ((!stop)){
		world.moveAllCreaturesOnce();
		this_thread::sleep_for(chrono::milliseconds(1000));
	}
	stop=true;
}

void keyListener(){
	CC=_getch();
	stop=true;
}

void initialize(){
	world.addRandomCreature(10);
}

int main(){
	initialize();
	while(CC != 'E'){
		stop=false;
		thread t1(activateWorld);
		thread t2(keyListener);
		thread t3(printEvery);

		while(!stop){}
		t2.detach();
		t3.join();
		t1.join();
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

