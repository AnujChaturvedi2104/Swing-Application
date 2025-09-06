package com.version.one;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Registration implements ActionListener {
    private JFrame frame; 
    private JButton register;
    private JButton cancel;

    // Global fields
    private JTextField nameField;
    private JTextField userNameField;       // username
    private JPasswordField passwordField;

    public Registration() {
        frame = new JFrame("Registration");
        frame.setSize(400 , 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void start() {
        Dimension labelDimension = new Dimension(85, 15);
        JLabel label = new JLabel ("REGISTRATION");
        JPanel panel = new JPanel();
        BorderLayout layout0 = new BorderLayout(10, 5);
        panel.setLayout(layout0);
    
        panel.setBackground(Color.LIGHT_GRAY);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);
        panel.setPreferredSize(new Dimension(400, 25));
        
        // Full name
        JPanel panel1 = new JPanel();
        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        panel1.setLayout(layout1);
        
        JLabel fullName = new JLabel("Full Name");
        fullName.setPreferredSize(labelDimension);
        nameField = new JTextField(15);
        
        panel1.add(fullName);
        panel1.add(Box.createHorizontalStrut(10));
        panel1.add(nameField);
        panel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel1.getPreferredSize().height));
        
        // Username
        JPanel panel2 = new JPanel();
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
        panel2.setLayout(layout2);
        JLabel label2 = new JLabel("Username");
        userNameField = new JTextField(15);
        label2.setPreferredSize(labelDimension);
        panel2.add(label2);
        panel2.add(Box.createHorizontalStrut(10));
        panel2.add(userNameField);
        panel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel2.getPreferredSize().height));
        
        // Password
        JPanel panel3 = new JPanel();
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
        panel3.setLayout(layout3);
        JLabel label3 = new JLabel("Password");
        passwordField = new JPasswordField(15);
        label3.setPreferredSize(labelDimension);
        panel3.add(label3);
        panel3.add(Box.createHorizontalStrut(10));
        panel3.add(passwordField);
        panel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel3.getPreferredSize().height));
        
        // Buttons
        JPanel panel4 = new JPanel();
        register = new JButton("Submit");
        register.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        panel4.add(register);
        panel4.add(Box.createHorizontalStrut(15));
        panel4.add(cancel);
        panel4.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel4.getPreferredSize().height));
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(panel);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(panel1);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(panel2);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(panel3);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(panel4);
        frame.add(mainPanel);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == register) {
            String fullName = nameField.getText();
            String userName = userNameField.getText();
            String password = new String(passwordField.getPassword());
            System.out.println("FullName: " + fullName);
            System.out.println("UserName: "+userName);
            System.out.println("Password: "+ password);
            DataBaseConnection con = new MySQLConnection();
            con.addUser(fullName, userName, password);
            frame.dispose();
            new Login();
        }
        else if(e.getSource() == cancel) {
            nameField.setText("");
            userNameField.setText("");
            passwordField.setText("");
            System.exit(0);
        }
    }

    // Entry point
    public static void main(String[] args) {
        new Registration().start();
    }
}
