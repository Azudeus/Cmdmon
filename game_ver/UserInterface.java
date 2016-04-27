import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserInterface {
	public static JFrame mainFrame;
	public static GamePanel mainPanel;
	public static ActiveLabel hp;
	
	public UserInterface() {
		mainFrame = new JFrame("Cmdmon");
		mainFrame.setSize(800,600);
		mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JPanel holder = new JPanel();
		holder.setMaximumSize(new Dimension(800,50));
		holder.setBackground(Color.black);
		holder.setLayout(new FlowLayout(0));
		mainFrame.add(holder);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		mainPanel = new GamePanel();
		mainPanel.setMaximumSize(new Dimension(800,550));
		mainFrame.add(mainPanel);
		
		hp = new ActiveLabel();
		hp.setPreferredSize(new Dimension(200,40));
		hp.setBackground(Color.white);
		hp.setOpaque(true);
		holder.add(hp);
	}
	
	public void show() {
		mainFrame.setVisible(true);
	}
	
	public static void main(String arg[]) {
		UserInterface ui = new UserInterface();
		ui.show();
	}
	
	class ActiveLabel extends JLabel implements ActionListener{
		Timer refresh;
		
		ActiveLabel(){
			super();
			refresh = new Timer(10,this);
			refresh.start();
		}
		
		public void actionPerformed(ActionEvent e){
			String tmp = "";
			tmp = tmp + mainPanel.world.P.getHealth();
			hp.setText(tmp);
		}
	};
}