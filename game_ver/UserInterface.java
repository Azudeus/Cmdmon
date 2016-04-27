import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface {
	public static JFrame mainFrame;
	public static GamePanel mainPanel;
	
	public UserInterface() {
		mainFrame = new JFrame("Cmdmon");
		mainFrame.setSize(800,600);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		mainPanel = new GamePanel();
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