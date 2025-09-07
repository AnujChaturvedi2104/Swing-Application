package com.version.one;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ChatWindow extends JFrame implements ActionListener {
	private JTextArea chatArea;
	private JTextArea textBox;
	private JButton sendButton;

	private static int countForServer = 0;
	private String messageOutgoing;
	Socket socket;
	PrintWriter out;
	BufferedReader in;

	static {
		if (countForServer < 1) {
			new ChatServer(); // starts the server only once.
			countForServer++;
		}
	}

	public ChatWindow() {

		setTitle("Chat Window");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(400, 500));
		setLocationRelativeTo(null); // pops up on the center of the screen

		chatArea = new JTextArea(1, 25);
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true); // so word goes next line when no space and not character

		JScrollPane scrollPanel = new JScrollPane(chatArea);

		textBox = new JTextArea(1, 25);
		textBox.setLineWrap(true);
		textBox.setWrapStyleWord(true);
		sendButton = new JButton("Send");
		sendButton.setPreferredSize(new Dimension(80, 40));
		sendButton.addActionListener(this);
		JPanel panel1 = new JPanel();
		JScrollPane paneForMessage = new JScrollPane(textBox, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel1.setLayout(new BorderLayout());
		panel1.add(paneForMessage, BorderLayout.CENTER);
		panel1.add(sendButton, BorderLayout.EAST); // check position

		setLayout(new BorderLayout());
		add(scrollPanel, BorderLayout.CENTER);
		add(panel1, BorderLayout.SOUTH);

		chatArea.append("Welcome to the Chat room!\n");
		try {
			socket = new Socket("localhost", 4000);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			new Thread(() -> { // reading messages
				try {
					String input;
					while ((input = in.readLine()) != null) {
						String message = input;
						SwingUtilities.invokeLater(() -> chatArea.append(message + "\n"));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

			}).start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sendButton) {
			String message = textBox.getText().trim();
			if (!message.isEmpty()) {
				out.println(message);
				textBox.setText("");
			}
		}

	}

	public static void main(String[] args) {
		ChatWindow chatWindow = new ChatWindow();
	}

}
