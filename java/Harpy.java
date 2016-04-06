public class Harpy extends Animal {
  public Harpy(int row, int column, int directionX, int directionY) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(15);
    setActionInterval(1000);
  }

  public char draw() {
    return 'H';
  }

  public void doAction() {
    move();
  }
}