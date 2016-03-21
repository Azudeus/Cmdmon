VAR = Default
ifeq ($(VAR),Lamia)
	CMD = g++ -o lamia driverLamia.cpp Lamia.cpp Animal.cpp Creature.cpp
else
ifeq ($(VAR),Centaur)
	CMD = g++ -o centaur driverCentaur.cpp Centaur.cpp Animal.cpp Creature.cpp
else
ifeq ($(VAR),Harpy)
	CMD = g++ -o harpy driverHarpy.cpp Harpy.cpp Animal.cpp Creature.cpp
else
ifeq ($(VAR),Plant)
	CMD = g++ -o plant driverPlant.cpp Plant.cpp Creature.cpp
else
ifeq ($(VAR),UniverseUsingList)
	CMD = g++ -std=c++11 -o universeusinglist driverUniverseUsingList.cpp UniverseUsingList.cpp Universe.cpp list.cpp elementList.cpp Plant.cpp Lamia.cpp Centaur.cpp Harpy.cpp Animal.cpp Creature.cpp
else
ifeq ($(VAR),UniverseUsingSTL)
	CMD = g++ -o universeusingstl driverUniverseUsingSTL.cpp UniverseUsingSTL.cpp Universe.cpp list.cpp elementList.cpp Plant.cpp Lamia.cpp Centaur.cpp Harpy.cpp Animal.cpp Creature.cpp
else
ifeq ($(VAR),Overloading)
	CMD = g++ -o overload driverOperatorOverloading.cpp Lamia.cpp Animal.cpp Creature.cpp Plant.cpp
else
ifeq ($(VAR),Main)
	CMD = g++ -std=c++11 -o main main.cpp UniverseUsingList.cpp Universe.cpp list.cpp elementList.cpp Harpy.cpp Lamia.cpp Animal.cpp Centaur.cpp Creature.cpp Plant.cpp
else
ifeq ($(VAR),MainSTL)
	CMD = g++ -std=c++11 -o mainSTL mainSTL.cpp UniverseUsingSTL.cpp Universe.cpp Harpy.cpp Lamia.cpp Animal.cpp Centaur.cpp Creature.cpp Plant.cpp
endif	
endif	
endif
endif
endif
endif
endif
endif
endif

compile1:
	$(CMD)