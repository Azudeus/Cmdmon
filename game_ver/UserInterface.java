import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface {
	public static JFrame mainFrame;
	public static GamePanel mainPanel;
	public static HPLabel hp;
	public static ScoreLabel score;
	private static int frameWidth = 800;
	private static int frameHeight = 600;
	private static int labelWidth = 200;
	private static int labelHeight = 40;
	
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
	}
	
	public void show() {
		mainFrame.setVisible(true);
	}
	
	public static void main(String arg[]) {
		UserInterface ui = new UserInterface();
		ui.show();
	}
	
	class HPLabel extends JLabel implements ActionListener {
		Timer refreshHP;
		
		HPLabel(){
			super("",JLabel.CENTER);
			refreshHP = new Timer(10,this);
			refreshHP.start();
		}
		
		public void actionPerformed(ActionEvent e) {
			String tmp = "Hit Points : ";
			if (mainPanel.world.P.getHealth() > 0){
				tmp = tmp + mainPanel.world.P.getHealth();
			}
			else {
				tmp = tmp + "Bleeding";
			}
			hp.setText(tmp);
		}
	};
	
	class ScoreLabel extends JLabel implements ActionListener {
		Timer refreshScore;
		
		ScoreLabel(){
			super("",JLabel.CENTER);
			refreshScore = new Timer(10,this);
			refreshScore.start();
		}
		
		public void actionPerformed(ActionEvent e) {
			String tmp = "Score : ";
			tmp = tmp + mainPanel.world.getTurn();
			score.setText(tmp);
		}
	};
}