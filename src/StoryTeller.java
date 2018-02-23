import javax.swing.JPanel;
import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoryTeller extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public StoryTeller() {
		// JFrame f= new JFrame("Panel Example");
		setLayout(new GridLayout(2, 0, 0, 0));
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.MAGENTA);
		add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel_1, "Hello Workd");
			}
		});
		panel_1.add(btnNewButton);
		//setVisible(true);
	}
public static void main(String[] args)
	{
		 new StoryTeller().setVisible(true);
		
	}

}
