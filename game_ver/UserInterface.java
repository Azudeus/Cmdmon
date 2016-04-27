import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
*@author Andri Hardono Hutama/13514055
*/
public class UserInterface {
	/**
	*mainFrame adalah JFrame yang merupakan layar utama program.
	*/
	public static JFrame mainFrame;

	/**
	*gameOverFrame adalah JFrame yang akan ditampilkan sebagai Pop-Up ketika permainan berakhir.
	*/
	public static JFrame gameOverFrame;
	
	/**
	*mainPanel merupakan objek turunan JPanel untuk menampilkan bidang permainan.
	*/
	public static GamePanel mainPanel;
	
	/**
	*hp adalah HPLabel(turunan JLabel) yang menampilkan informasi hit points dari player.
	*/
	public static HPLabel hp;
	
	/**
	*score merupakan ScoreLabel(turunan JLabel) yang menampilkan informasi score dari player.
	*/
	public static ScoreLabel score;
	
	/**
	*frameWidth merupakan integer yang menentukan lebar dari frame utama.
	*/
	private static int frameWidth = 800;

	/**
	*frameHeight merupakan integer yang menentukan tinggi dari frame utama.
	*/
	private static int frameHeight = 600;

	/**
	*labelWidth merupakan integer yang menentukan lebar dari label.
	*/
	private static int labelWidth = 200;

	/**
	*labelHeight merupakan integer yang menentukan tinggi dari label.
	*/
	private static int labelHeight = 40;
	
	/**
	*Constructor dari UserInterface yang melakukan inisialisasi attributes.
	*<br> Frame, panel, dan label dari UserInterface akan dibuat dalam proses ini.
	*/
	public UserInterface() {
		mainFrame = new JFrame("Cmdmon");
		mainFrame.setSize(frameWidth,frameHeight);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JPanel holder = new JPanel();
		holder.setMaximumSize(new Dimension(frameWidth,frameHeight - 550));
		holder.setBackground(Color.black);
		holder.setLayout(new FlowLayout(0));
		mainFrame.add(holder);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		mainPanel = new GamePanel();
		mainPanel.setMaximumSize(new Dimension(frameWidth, frameHeight - 50));
		mainFrame.add(mainPanel);
		
		hp = new HPLabel();
		hp.setPreferredSize(new Dimension(labelWidth, labelHeight));
		hp.setBackground(Color.white);
		hp.setOpaque(true);
		holder.add(hp);
		
		score = new ScoreLabel();
		score.setPreferredSize(new Dimension(labelWidth, labelHeight));
		score.setBackground(Color.white);
		score.setOpaque(true);
		holder.add(score);
		
		gameOverFrame = new JFrame("Game Over");
		
		gameOverFrame.setSize(300,100);
		gameOverFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JLabel gameOverLabel = new JLabel("Game Over",JLabel.CENTER);	
		gameOverFrame.add(gameOverLabel);
		gameOverFrame.setLocationRelativeTo(mainFrame);
	}
	
	/**
	*Menampilkan mainFrame ke layar agar terlihat oleh pengguna.
	*/
	public void show() {
		mainFrame.setVisible(true);
	}
	
	
	class HPLabel extends JLabel implements ActionListener {
		/**
		*Timer yang digunakan untuk menentukan refresh rate.
		*/
		Timer refreshHP;
		
		/**
		*Constructor dari HPLabel yang memanggil constructor dari parent (JLabel).
		*<br> Timer juga diciptakan dan dimulai pada constructor ini.
		*/
		HPLabel(){
			super("",JLabel.CENTER);
			refreshHP = new Timer(10,this);
			refreshHP.start();
		}
		
		
		/**
		*Realisasi actionPerformed dari interface ActionListener.
		*Mengubah text pada hp menjadi jumlah hit points player.
		*@param e, ActionEvent yang diterima.
		*/
		public void actionPerformed(ActionEvent e) {
			String tmp = "Hit Points : ";
			if (mainPanel.world.P.getHealth() > 0){
				tmp = tmp + mainPanel.world.P.getHealth();
			}
			else if (mainPanel.world.getIsGameOver()) {
				tmp = "DEAD";
			}
			else {
				tmp = tmp + "Bleeding";
			}
			hp.setText(tmp);
		}
	};
	
	class ScoreLabel extends JLabel implements ActionListener {
		/**
		*Timer yang digunakan untuk menentukan refresh rate.
		*/
		Timer refreshScore;
		
		/**
		*Constructor dari ScoreLabel yang memanggil constructor dari parent (JLabel).
		*<br> Timer juga diciptakan dan dimulai pada constructor ini.
		*/
		ScoreLabel(){
			super("",JLabel.CENTER);
			refreshScore = new Timer(10,this);
			refreshScore.start();
		}
		
		/**
		*Realisasi actionPerformed dari interface ActionListener.
		*Mengubah text pada score menjadi jumlah turn yang sudah dilewati.
		*@param e, ActionEvent yang diterima.
		*/
		public void actionPerformed(ActionEvent e) {
			String tmp = "Score : ";
			tmp = tmp + mainPanel.world.getTurn();
			score.setText(tmp);
		}
	};
}