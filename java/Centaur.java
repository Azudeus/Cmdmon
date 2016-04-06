public class Centaur extends Animal {
	public Centaur(int r, int c, int x, int y) {
		setRowPosition(r);
	    setColumnPosition(c);
	    setDirection(x,y);
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