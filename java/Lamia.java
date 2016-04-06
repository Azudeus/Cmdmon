public class Lamia extends Animal {
  public Lamia(int row, int column, int directionX, int directionY) {
    setRowPosition(row);
    setColumnPosition(column);
    setDirectionX(directionX);
    setDirectionY(directionY);
    setStrength(10);
    setActionInterval(1200);
  }

  public char draw() {
    return 'L';
  }

  public void doAction() {
    move();
  }
}