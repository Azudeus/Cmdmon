class Universe {
public:
	Universe(int,int);
	void print(ostream&);

private:
	int amountOfRows;
	int amountOfColumns;
	List<Creature> CreatureList;
}