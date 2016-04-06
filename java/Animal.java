public abstract class Animal extends Creature{
	private int directionX;
	private int directionY;

	public Animal() {
		//do nothing
	}

	public abstract char draw();
	public abstract void doAction();

	public void setDirectionX(int x) {
		directionX = x;
	}

	public void setDirectionY(int y) {
		directionY = y;
	}

	public int getDirectionX() {
		return directionX;
	}

	public int getDirectionY() {
		return directionY;
	}

	protected void move() {
		setRowPosition(getRowPosition()+getDirectionX());
		setColumnPosition(getColumnPosition()+getDirectionY());
	}
}