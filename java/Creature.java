public abstract class Creature {
  private int strength;
  private int rowPosition;
  private int columnPosition;
  private int actionInterval;

  public Creature() {
    //do nothing
  }

  public abstract char draw();

  public abstract void doAction();

  public void setRowPosition(int rowPosition) {
    this.rowPosition = rowPosition;
  }

  public void setColumnPosition(int columnPosition) {
    this.columnPosition = columnPosition;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setActionInterval(int actionInterval) {
    this.actionInterval = actionInterval;
  }

  public int getRowPosition() {
    return rowPosition;
  }

  public int getColumnPosition() {
    return columnPosition;
  }

  public int getStrength() {
    return strength;
  }

  public int getActionInterval() {
    return actionInterval;
  }
}