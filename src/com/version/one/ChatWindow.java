package com.version.one;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame {
	private JTextArea chatArea;
	private JTextArea textBox;
	private JButton sendButton;
	
	public ChatWindow() {
		setTitle("Chat Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(400, 500));
		setLocationRelativeTo(null); // pops up on the center of the screen
		
		chatArea = new JTextArea(1,25);
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true); // so word goes next line when no space and not character
		
		JScrollPane scrollPanel = new JScrollPane(chatArea);
		
		textBox = new JTextArea(1, 25);
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		sendButton = new JButton("Send");
		sendButton.setPreferredSize(new Dimension(80, 40));
		JPanel panel1 = new JPanel();
		JScrollPane paneForMessage = new JScrollPane(textBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel1.setLayout(new BorderLayout());
		panel1.add(paneForMessage, BorderLayout.CENTER);
		panel1.add(sendButton, BorderLayout.EAST); // check position
	 
		
		setLayout(new BorderLayout());
		add(scrollPanel, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);
		 
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ChatWindow chatWindow = new ChatWindow();
	}
}
