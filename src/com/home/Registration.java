package com.home;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration {
	private JFrame frame;
	
	public Registration() {
		frame = new JFrame("Registration Page");
		frame.setSize(400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form();
		frame.setLocationRelativeTo(null);
	}
	
	void form() {
		// dimensions for Labels
		Dimension dimension = new Dimension(80, 25);
		
		JPanel panel = new JPanel();
		BoxLayout layout1 = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout1);
		
		JLabel name = new JLabel("Full Name");
		name.setPreferredSize(dimension);
		JTextField nameField = new JTextField(15);
		panel.add(name);
		panel.add(Box.createHorizontalStrut(10)); // creates spacing between two components.
		panel.add(nameField);
		panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
		
		JPanel panel2 = new JPanel();
		BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(layout2);
		JLabel username = new JLabel("Username");
		username.setPreferredSize(dimension);
		JTextField usernameField = new JTextField(15);
		panel2.add(username);
		panel2.add(Box.createHorizontalStrut(10));
		panel2.add(usernameField);
		panel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel2.getPreferredSize().height));

		JPanel panel3 = new JPanel();
		BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
		panel3.setLayout(layout3);
		JLabel password = new JLabel("Password");
		password.setPreferredSize(dimension);
		JPasswordField passwordField = new JPasswordField(15);
		panel3.add(password);
		panel3.add(Box.createHorizontalStrut(10));
		panel3.add(passwordField);
		panel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel3.getPreferredSize().height));

		
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); // 20px horizontal gap, 0 vertical
		JButton submit = new JButton("Registration");
		JButton cancel = new JButton("Cancel");
		panel4.add(submit);
		panel4.add(cancel);
		panel4.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel4.getPreferredSize().height));

		
		JPanel mainPanel = new JPanel();
		BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainLayout);
		mainPanel.add(panel);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(panel2);
		mainPanel.add(Box.createVerticalStrut(10));
		mainPanel.add(panel3);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(panel4);
		mainPanel.add(Box.createVerticalGlue());

		
		frame.add(mainPanel);
		frame.setVisible(true);
	}
}
