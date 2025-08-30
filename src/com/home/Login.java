package com.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login {
	private JFrame frame;
	
	public Login() {
		frame = new JFrame("Login Page");
		frame.setSize(400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginForm();
		frame.setLocationRelativeTo(null);
	}

	 void loginForm() {
		Dimension dimension = new Dimension(80, 25);
		
		JPanel panel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(boxLayout);
		
		JLabel userName = new JLabel("Username");
		userName.setPreferredSize(dimension);
		JTextField userNameInput = new JTextField(15);
		panel.add(userName);
		panel.add(Box.createHorizontalStrut(10));
		panel.add(userNameInput);
		panel.setMaximumSize(new Dimension(300, panel.getPreferredSize().height));
		
		// Now for Password:
		JPanel panel2 = new JPanel();
		BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
		panel2.setLayout(layout2);
		JLabel password = new JLabel("Password");
		password.setPreferredSize(dimension);
		JPasswordField passwordInput = new JPasswordField();
		panel2.add(password);
		panel2.add(Box.createHorizontalStrut(10));
		panel2.add(passwordInput);
		panel2.setMaximumSize(new Dimension(300, panel2.getPreferredSize().height));
		
		JPanel mainPanel = new JPanel();
		BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainLayout);
		mainPanel.add(getHeadingPanel());
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(panel);
		mainPanel.add(Box.createVerticalStrut(20));
		mainPanel.add(panel2);
		mainPanel.add(buttonPanel());
		mainPanel.add(Box.createVerticalGlue()); // makes all the fields appear compact and not spread out.
		
		frame.add(mainPanel);
		frame.setVisible(true);
		
	}
	private JPanel buttonPanel() {
		JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);
		JButton login = new JButton("Login");
		JButton cancel = new JButton("Cancel");
		panel.add(Box.createHorizontalGlue());
		panel.add(login);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(cancel);
		panel.add(Box.createHorizontalStrut(20));
		panel.setPreferredSize(new Dimension(Integer.MAX_VALUE, panel.getPreferredSize().height));
		return panel;
	}

	private JPanel getHeadingPanel() {
		JPanel panel = new JPanel();
		JLabel heading = new JLabel("LOGIN");
		heading.setFont(new Font("Arial", Font.BOLD, 20));
		heading.setForeground(Color.RED);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(heading);
		panel.setPreferredSize(new Dimension(300, panel.getPreferredSize().height));
		return panel;
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.loginForm();
	}
}
