public class Harpy extends Animal {
	public Harpy(int r, int c, int x, int y) {
		setRowPosition(r);
	    setColumnPosition(c);
	    setDirectionX(x);
	    setDirectionY(y);
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