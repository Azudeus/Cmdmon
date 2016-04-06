import java.util.Random;
import java.util.Vector;
import java.io.*;


public class UniverseUsingSTL extends Universe {
	private Vector<Creature> CreatureList;

	public UniverseUsingSTL(int amountOfRows,int amountOfColumns)
	{
		this.setAmountOfRows(amountOfRows);
		this.setAmountOfColumns(amountOfColumns);
		CreatureList = new CreatureList<Creature>();
	}

	public void killCreature(Creature C)
	{
		boolean found=false;
		int size=CreatureList.size();
		int i=0;
		while ((!found)&&(i<size))
		{
			if (CreatureList.get(i)==C)
			{
				found=true;
				swap(CreatureList.get(i), CreatureList.get(CreatureList.size()-1));
			}
			i++;
		}
		CreatureList.remove(CreatureList.size()-1);
	}

	public void addCreature(Creature C)
	{
	    CreatureList.add(C);
	}

	public void addRandomCreature(int amount)
	{
		Creature temp;
		Random generator = new Random();
		//randomly create creature
		for (int i = 0; i < amount; i++){
			int r;
			int row;
			int column;
			int directionX;
			int directionY;
			r = generator.nextInt(3);

			r = (rand() % 3);
			row = (generator.nextInt(getAmountOfRows()));
			column = (generator.nextInt(getAmountOfColumns()));
			directionX = (generator.nextInt(2));
			if (directionX == 0){
				directionX = -1;
			}
			directionY = (generator.nextInt(2));
			if (directionY == 0){
				directionY = -1;
			}
			boolean Found = true;
	        int counter = 0;

	        //cari apakah sudah ada
	        while((counter<(getAmountOfColumns()*getAmountOfRows()))&&(Found)){
	            Found = false;
	            counter = 0;
	            int sz = CreatureList.size();
	            int j = 0;
	            while((j<sz) && (!Found)&& (counter<(getAmountOfColumns()*getAmountOfRows())) ){
	                counter++;
	                if((CreatureList.get(j).getRowPosition() == row) && (CreatureList.get(j).getColumnPosition() == column))
	                    Found = true;
	                j++;
	            }

	            if(Found)
	            {
	                column++;
	                if (column == getAmountOfColumns()){column = 0; row++;}
	                if (row == getAmountOfRows()){column = 0; row =0;}
	            }

	        }
	        if(counter<(getAmountOfColumns()*getAmountOfRows())){
				if (r == 0){
					temp = new Plant(row, column);
					addCreature((temp));
				}
				else if (r == 1){
					temp = new Lamia(row, column, directionX, directionY);
					addCreature((temp));
				}
				else if (r == 2){
					temp = new Centaur(row, column, directionX, directionY);
					addCreature((temp));
				}
				else{
					temp = new Harpy(row, column, directionX, directionY);
					addCreature((temp));
				}
			}
		}
	}
	//header changed >.< -----------------------------------------------------------------------------------------------
	public boolean isWorldEmpty()
	{
		return (CreatureList.size()==0);
	}

	public void checkForCollisions()
	{
		int sz = CreatureList.size();
		int i = 0;
		//Kill Out Of Bounds
		while (i<sz)
		{
			if ((CreatureList.get(i).getRowPosition()<0)||
				(CreatureList.get(i).getColumnPosition()<0)||
				(CreatureList.get(i).getRowPosition()>=getAmountOfRows())||
				(CreatureList.get(i).getColumnPosition()>=getAmountOfColumns()))
			{
				killCreature(CreatureList.get(i));
				i--;
				sz--;
			}
			i++;
		}

		//Kill Collisions
		sz = CreatureList.size();
		for (i=0;i<getAmountOfRows();i++)
		{
			for (int j=0;j<getAmountOfColumns();j++)
			{
				int minimumStrength = 999; //UNDEF
				int minimumIndex = -1;
				int counter = 0;
				for (int k=0;k<sz;k++)
				{
					if (((CreatureList.get(k)).getRowPosition()==i)&&
						((CreatureList.get(k)).getColumnPosition()==j))
					{
						if (minimumStrength>CreatureList.get(k).getStrength())
						{
							minimumStrength=CreatureList.get(k).getStrength();
							minimumIndex=k;
						}
						counter++;
					}
				}
				if (counter>1)
				{
					killCreature(CreatureList.get(minimumIndex));
					sz--;
				}
			}
		}
	}

	public void moveAllCreaturesOnce()
	{
	    for (int i=0;i<CreatureList.size();i++)
	    {
	    	CreatureList.get(i).doAction();
	    }
	    checkForCollisions();
	}
//header changed >.< ---------------------------------------------------------------------------
	public void print(){
		char[][] board = new char[getAmountOfRows()][getAmountOfColumns()];
		for (int i=0;i<getAmountOfRows();i++)
		{
			for (int j=0;j<getAmountOfColumns();j++)
			{
				board[i][j] = '.';
			}
		}

		for (int i=0;i<CreatureList.size();i++)
		{
			Creature currentCreature = (CreatureList.get(i));
			board[currentCreature.getRowPosition()][currentCreature.getColumnPosition()]=currentCreature.draw();
		}

		for (int i=0;i<getAmountOfRows();i++)
		{
			for (int j=0;j<getAmountOfColumns();j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}	
	}

//header changed >.< ---------------------------------------------------------------------------
	public void print(String f)
	{
		try {
			BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			char[][] board = new char[getAmountOfRows()][getAmountOfColumns()];
			for (int i=0;i<getAmountOfRows();i++)
			{
				for (int j=0;j<getAmountOfColumns();j++)
				{
					board[i][j] = '.';
				}
			}

			for (int i=0;i<CreatureList.size();i++)
			{
				Creature currentCreature = (CreatureList.get(i));
				board[currentCreature.getRowPosition()][currentCreature.getColumnPosition()]=currentCreature.draw();
			}

			for (int i=0;i<getAmountOfRows();i++)
			{
				for (int j=0;j<getAmountOfColumns();j++)
				{
					outputWriter.write(board[i][j]);
				}
				outputWriter.newLine();
			}	
		} catch (FileNotFoundException e) {
				System.out.println("File tidak ditemukan");
				System.exit(0);
			}
	}
}