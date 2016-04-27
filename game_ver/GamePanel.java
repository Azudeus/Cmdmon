import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GamePanel extends JPanel implements ActionListener {
	UniverseUsingSTL world;
	Timer mainTimer;
	int velX = 0;
	int velY = 0;
	
	public GamePanel() {
		super();
		setFocusable(true);
		setBackground(Color.white);
		world = new UniverseUsingSTL(740,460);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_W) {
					velY = -2;
				}
				else if (key == KeyEvent.VK_S) {
					velY = 2;
				}
				else if (key == KeyEvent.VK_A) {
					velX = -2;
				}
				else if  (key == KeyEvent.VK_D) {
					velX = 2;
				}
			}
			
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_W) {
					velY = 0;
				}
				else if (key == KeyEvent.VK_S) {
					velY = 0;
				}
				else if (key == KeyEvent.VK_A) {
					velX = 0;
				}
				else if  (key == KeyEvent.VK_D) {
					velX = 0;
				}				
			}			
		});
		
		mainTimer = new Timer(10,this);
		mainTimer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		int size = world.CreatureList.size();
		for (int i = 0 ; i < size ; i++){
		  world.CreatureList.get(i).draw(g2);
		  //System.out.println(world.CreatureList.get(i).getRowPosition());
		  //System.out.println(world.CreatureList.get(i).getColumnPosition());
		  //System.out.println(world.CreatureList.get(i).draw());
		}
		world.P.draw(g2);
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (!world.isGameOver()){
			world.P.setRowPosition(world.P.getRowPosition() + velX);
			world.P.setColumnPosition(world.P.getColumnPosition() + velY);
		}
	}
}