import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.sql.Date;

public class Timer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JLabel timer;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer frame = new Timer();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void clock()
	{
		Thread thread = new Thread() {
			public void run()
			{
				try {
					while(true)
					{
						java.util.Date date = new java.util.Date();
						timer.setText(date.toString());
						Thread.sleep(1000);
					}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			}
		};
		thread.start();
	}

	/**
	 * Create the frame.
	 */
	public Timer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Timer Thread");
		timer = new JLabel("");
		contentPane.add(timer, BorderLayout.CENTER);
		clock();
	}

}
