public class Lamia extends Animal {
	public Lamia(int r, int c, int x, int y) {
		setRowPosition(r);
	    setColumnPosition(c);
	    setDirectionX(x);
	    setDirectionY(y);
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