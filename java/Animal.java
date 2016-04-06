struct moveDirection
{
	int deltax;
	int deltay;
};

public abstract class Animal extends Creature{
	private moveDirection direction;

	public Animal() {
		//do nothing
	}

	public abstract char draw();
	public abstract void doAction();
	public void setDirection(int,int) {

	}

	public moveDirection getDirection() {

	}

	protected void move() {
		setRowPosition(getRowPosition()+getDirection().deltax);
		setColumnPosition(getColumnPosition()+getDirection().deltay);
	}
}