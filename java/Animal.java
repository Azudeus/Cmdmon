struct moveDirection
{
    int deltax;
    int deltay;
};

public class Creature extends Creature{
	private moveDirection direction;

    public Animal() {
    	
    }
	public abstract char draw();
    public abstract void doAction();
   	public void setDirection(int,int) {

   	}

   	public moveDirection getDirection() {

   	}

    protected abstract void move();
};