# Multi-User Chat Application in Java (Swing, Multi-Threading & JDBC)

## Overview

This project is a **multi-user chat application** built in **Java** using **Swing for the GUI**, **multi-threaded socket programming** for real-time client-server communication, and **JDBC/MySQL** for user authentication. The application supports **simultaneous connections**, **secure login**, and a **central chat server**, demonstrating advanced software engineering concepts, concurrency handling, and database integration—key skills valued by recruiters.

---

## Key Features

1. **User Registration & Login (JDBC Integration)**
   - Users register with full name, unique username, and password stored in a MySQL database.
   - Login validates credentials via **JDBC**, ensuring secure authentication.
   - The login username is used throughout the chat session to personalize interactions.

2. **Multi-User Chat with Multi-Threading**
   - Supports multiple simultaneous users connected to a single server.
   - Each client connection is handled in its own thread (`ClientHandler`) to allow concurrent message handling.
   - Messages are broadcast to all connected clients in real-time.

3. **Server-Controlled System Messages**
   - Server administrator can broadcast messages to all users.
   - System messages are clearly distinguished using `[Server]: ...`.

4. **Robust Networking**
   - Uses **Java Sockets (`Socket` & `ServerSocket`)** for TCP communication.
   - Handles multiple clients concurrently using **thread-safe `CopyOnWriteArrayList`**.
   - Graceful handling of client disconnections with automatic cleanup of resources.

5. **Responsive GUI**
   - Built with **Java Swing**, featuring:
     - Scrollable chat area
     - Text area for composing messages
     - Intuitive login and registration forms
     - Dynamic updates for incoming messages

6. **Extensible Architecture**
   - Separation between **GUI (ChatWindow)**, **Server (ChatServer)**, and **Database (JDBC)** layers.
   - Easily extensible to include features like private messaging, chat rooms, or encryption.

---

## Tech Stack

- **Programming Language:** Java (SE 17+)
- **GUI Framework:** Swing
- **Networking:** TCP Sockets (`Socket` / `ServerSocket`)
- **Concurrency:** Java Threads, Multi-threaded client handling, `CopyOnWriteArrayList`
- **Database:** MySQL via JDBC (user authentication and registration)
- **IDE:** Eclipse / IntelliJ IDEA

---

## How It Works

### Server
1. Listens on a TCP port (4000) for incoming client connections.
2. For each client connection:
   - Creates a `ClientHandler` thread to manage communication concurrently.
   - Receives the client’s username directly from login via JDBC.
   - Broadcasts messages to all connected clients in real-time.
3. Administrator can send system-wide messages from the console.

### Client
1. User registers or logs in with credentials stored in MySQL.
2. Upon login, `ChatWindow` connects to the server and sends the username.
3. Messages typed in the client GUI are sent to the server and broadcast to all clients.
4. Incoming messages are displayed dynamically in the chat area.

---

## Skills Demonstrated

- **Object-Oriented Programming (OOP) with Java**
- **GUI Development using Swing**
- **Multi-Threading & Concurrent Client Handling**
- **Socket Programming & Networking**
- **Database Integration using JDBC & MySQL**
- **Clean Architecture & Separation of Concerns**

---

## How to Run

1. **Set up MySQL Database**
   - Create a `users` table with fields: `id`, `full_name`, `username`, `password`.
2. **Compile Java Files**
```bash
javac com/version/one/*.java
