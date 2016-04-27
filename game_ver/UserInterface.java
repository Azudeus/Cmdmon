import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface {
	public static JFrame mainFrame;
	public static GamePanel mainPanel;
	
	public UserInterface() {
		mainFrame = new JFrame("Cmdmon");
		mainFrame.setSize(800,600);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JPanel holder = new JPanel();
		holder.setMaximumSize(new Dimension(800,50));
		holder.setBackground(Color.black);
		mainFrame.add(holder);
		
		//JButton tmp = new JButton("tmp");
		//mainFrame.add(tmp);
		//JButton X = new JButton("X");
		//mainFrame.add(X);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		mainPanel = new GamePanel();
		mainPanel.setMaximumSize(new Dimension(800,550));
		mainFrame.add(mainPanel);
	}
	
	public void show() {
		mainFrame.setVisible(true);
	}
	
	public static void main(String arg[]) {
		UserInterface ui = new UserInterface();
		ui.show();
	}
}