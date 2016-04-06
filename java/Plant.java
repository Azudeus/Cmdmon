public class Plant extends Creature {
  public Plant(int _r, int _c) {
    setRowPosition(_r);
    setColumnPosition(_c);
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