package creature;

/**
*@author Nathan James Runtuwene/13514083
*/

public class CreatureFactory {
	public static Creature createCreature(String what, int row, int column, int directionX, int directionY, int multiplier)
	{
		if (what.equals("Harpy"))
		{
			return new Harpy(row, column, directionX, directionY, multiplier);
		}
		else if (what.equals("Lamia"))
		{
			return new Lamia(row, column, directionX, directionY, multiplier);
		}
		else if (what.equals("Centaur"))
		{
			return new Centaur(row, column, directionX, directionY, multiplier);
		}
		else // if (what.equals("Plant"))
		{
			return new Plant(row, column, multiplier);
		}
	}
}