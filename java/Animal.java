public abstract class Animal extends Creature {
  private int directionX;
  private int directionY;

  public Animal() {
    //do nothing
  }

  public abstract char draw();

  public abstract void doAction();

  public void setDirectionX(int directionX) {
    this.directionX = directionX;
  }

  public void setDirectionY(int directionY) {
    this.directionY = directionY;
  }

  public int getDirectionX() {
    return directionX;
  }

  public int getDirectionY() {
    return directionY;
  }

  protected void move() {
    setRowPosition(getRowPosition() + getDirectionX());
    setColumnPosition(getColumnPosition() + getDirectionY());
  }
}