public class Plant extends Creature {
  public Plant(int row, int column) {
    setRowPosition(row);
    setColumnPosition(column);
    setStrength(5);
    setActionInterval(3000);
  }
  
  public char draw() {
    return 'T';
  }
  
  public void doAction() {
    setStrength(getStrength() + 1);
  }
}