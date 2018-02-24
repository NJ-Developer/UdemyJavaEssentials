import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Story extends JFrame {
	private JTextField txtRegexExample;
	JTextArea input,output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Story frame = new Story();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Story() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 3, 5));
		panel.setBackground(Color.LIGHT_GRAY);
		//panel.setSize(100000,getContentPane().getWidth());
		getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{59, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				output.setText("");
				Pattern pattern  =Pattern.compile("[A-Z][a-z]* [A-Z][a-z]*");
				Matcher matcher = pattern.matcher(input.getText());
				while(matcher.find())
				{
					output.append(matcher.group()+"\n");
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(5, 3, 5, 3);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNumber = new JButton("Number");
		btnNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				output.setText("");
				Pattern pattern = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");   //514-792-1313
				Matcher matcher = pattern.matcher(input.getText());
				while(matcher.find())
				{
					output.append(matcher.group()+"\n");
				}
			}
		});
		GridBagConstraints gbc_btnNumber = new GridBagConstraints();
		gbc_btnNumber.anchor = GridBagConstraints.WEST;
		gbc_btnNumber.insets = new Insets(5, 5, 5, 5);
		gbc_btnNumber.gridx = 0;
		gbc_btnNumber.gridy = 1;
		panel.add(btnNumber, gbc_btnNumber);
		
		JButton btnEmail = new JButton("Email");
		btnEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				Pattern pattern = Pattern.compile("[A-Za-z0-9]*@[A-Za-z]*.[A-Za-z]*");   //navsingh@gmail.com
				Matcher matcher = pattern.matcher(input.getText());
				while(matcher.find())
				{
					output.append(matcher.group()+"\n");
				}
			}
			
		});
		GridBagConstraints gbc_btnEmail = new GridBagConstraints();
		gbc_btnEmail.insets = new Insets(0, 3, 0, 3);
		gbc_btnEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEmail.gridx = 0;
		gbc_btnEmail.gridy = 2;
		panel.add(btnEmail, gbc_btnEmail);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewButton}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{72, 290, 0};
		gbl_panel_1.rowHeights = new int[]{37, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		txtRegexExample = new JTextField();
		txtRegexExample.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegexExample.setEditable(false);
		txtRegexExample.setBackground(Color.LIGHT_GRAY);
		txtRegexExample.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		txtRegexExample.setText(" Regex Example");
		txtRegexExample.setBorder(null);
		GridBagConstraints gbc_txtRegexExample = new GridBagConstraints();
		gbc_txtRegexExample.insets = new Insets(0, 40, 0, 0);
		gbc_txtRegexExample.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRegexExample.gridx = 1;
		gbc_txtRegexExample.gridy = 0;
		panel_1.add(txtRegexExample, gbc_txtRegexExample);
		txtRegexExample.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		output = new JTextArea();
		output.setRows(3);
		output.setLineWrap(true);
		output.setColumns(30);
		JLabel lblNewLabel = new JLabel("Result ");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		input = new JTextArea();
		input.setRows(3);
		input.setLineWrap(true);
		input.setColumns(30);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(output, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(input, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(151)
							.addComponent(lblNewLabel)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(25)
					.addComponent(input, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(output, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);

	}
}
