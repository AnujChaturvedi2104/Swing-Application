package com.version.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {
	private static final int PORT = 4000;
	private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

	public static void entryPoint() {
		try (ServerSocket server_socket = new ServerSocket(PORT)) {
			System.out.println("Server is connected and running!");

			new Thread(() -> // writing server messages to everyone
			{
				try (Scanner scan = new Scanner(System.in)) {

					System.out.print("Enter message as SYS admin: ");
					while (true) {
						String message = scan.nextLine();
						broadcast("[Server]: " + message, null);
					}
				}
			}).start();

			while (true) {
				Socket sock = server_socket.accept();
				ClientHandler client = new ClientHandler(sock);
				clients.add(client);
				new Thread(client).start();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	static void broadcast(String message, ClientHandler client) {
		for (ClientHandler c : clients) {

			c.sendMessage(message);
		}
	}

	static class ClientHandler implements Runnable {
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		private String username;

		public ClientHandler(Socket socket) {
			try {
				clientSocket = socket;
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		@Override
		public void run() {
			out.print("Enter your username : ");
			try {
				username = in.readLine();
				System.out.println(username + " just connected chat room!");
				out.println("Welcome to the chat " + username);

				String input;
				while (!((input = in.readLine()) == null)) {
					System.out.println("[" + username + "]" + ": " + input); // server logs
					broadcast("[" + username + "]: " + input, this);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
					out.close();
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				clients.remove(this);
				System.out.println("Client: " + username + " just disconnected!");

			}
		}

		void sendMessage(String message) {
			out.println(message);
		}

	}
}
