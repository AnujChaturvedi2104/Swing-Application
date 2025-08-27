# Swing Registration App

A simple Java Swing application that allows users to register by entering their **Full Name**, **Username**, and **Password**.  
Currently, the app prints the entered details to the console when the **Submit** button is clicked.

---

## Features
- User-friendly Swing UI with labeled fields:
  - Full Name
  - Username
  - Password
- Buttons:
  - **Submit** → prints entered user details in console
  - **Cancel** → cancels the operation
- Uses `ActionListener` for button click handling
- All input fields are **class-level variables** so they can be accessed in the `actionPerformed` method

---

## How to Run
1. Clone this repository or copy the `Registration.java` file into your project.
2. Compile the program:
   ```bash
   javac Registration.java
