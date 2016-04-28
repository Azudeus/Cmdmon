package userinterface;

import universe.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	/**
	*world adalah representasi dunia dalam bentuk UniverseUsingSTL.
	*/
	private UniverseUsingSTL world;
	
	/**
	*Timer yang akan menentukan refresh rate.
	*/
	private Timer mainTimer;
	
	/**
	*Integer yang akan berubah ketika tombol ditekan.
	*Berguna untuk mengubah posisi player ketika refresh terjadi.
	*/
	private int velX = 0;

	/**
	*Integer yang akan berubah ketika tombol ditekan.
	*Berguna untuk mengubah posisi player ketika refresh terjadi.
	*/
	private int velY = 0;
	
	/**
	*Construction dari GamePanel.
	*Mempersiapkan world, menambahkan keyListener, dan kemudian memulai Timer.
	*/
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

	public Timer getMainTimer() {
		return mainTimer;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public UniverseUsingSTL getWorld() {
		return world;
	}

	/**
	*Override dari fungsi paint JPanel.
	*Berfungsi menggambarkan posisi creature dan player pada mainPanel.
	*/
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		int size = world.getCreatureList().size();
		for (int i = 0 ; i < size ; i++){
		  world.getCreatureList().get(i).draw(g2);
		  size = world.getCreatureList().size();
		}
		world.getPlayer().draw(g2);
	}
	
	/**
	*Realisasi actionPerformed dari interface ActionListener.
	*Memanggil kembali paint(). Hal ini sama saja dengan me-refresh layar.
	*Selain itu jika permainana belum selesei maka posisi player akan diubah sesuai tombol yang ditekan.
	*@param e, ActionEvent yang diterima.
	*/
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (!world.getIsGameOver()){
			world.getPlayer().setRowPosition(world.getPlayer().getRowPosition() + velX);
			world.getPlayer().setColumnPosition(world.getPlayer().getColumnPosition() + velY);
		}
	}
}