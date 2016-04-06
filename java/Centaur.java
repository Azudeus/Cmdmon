public class Centaur extends Animal {
  public Centaur(int row, int column, int directionX, int directionY) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(25);
    setActionInterval(800);
  }

  public char draw() {
    return 'C';
  }

  public void doAction() {
    move();
  }
}