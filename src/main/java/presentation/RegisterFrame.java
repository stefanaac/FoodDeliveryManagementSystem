package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterFrame {
    private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
    private final static String DB_NAME = "food_delivery";
    private final static String USER = "root";
    private final static String PASSWORD = "BumBum77!!";
    JFrame frame;
    JButton createAccountButton;

    public RegisterFrame() {
        frame = new JFrame();
        frame.setSize(1530, 830);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 204, 153));
        frame.setResizable(false);
        frame.setLayout(null);

        JLabel title = new JLabel("Register");
        title.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 46));
        title.setForeground(Color.WHITE);
        title.setBounds(10, 10, 500, 85);
        frame.add(title);

        JLabel numeLabel = new JLabel("First name");
        numeLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        numeLabel.setBounds(10, 180, 150, 20);
        numeLabel.setForeground(new Color(255, 255, 255));
        frame.add(numeLabel);
        JTextField numeText = new JTextField(10);
        numeText.setBounds(150, 180, 200, 25);
        frame.add(numeText);

        JLabel prenumeLabel = new JLabel("Last name");
        prenumeLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        prenumeLabel.setBounds(10, 250, 150, 25);
        prenumeLabel.setForeground(new Color(255, 255, 255));
        frame.add(prenumeLabel);
        JTextField prenumeText = new JTextField(10);
        prenumeText.setBounds(150, 250, 200, 25);
        frame.add(prenumeText);

        JLabel adresaLabel = new JLabel("Address");
        adresaLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        adresaLabel.setBounds(10, 320, 100, 25);
        adresaLabel.setForeground(new Color(255, 255, 255));
        frame.add(adresaLabel);
        JTextField adresaText = new JTextField(10);
        adresaText.setBounds(150, 320, 200, 25);
        frame.add(adresaText);

        JLabel phoneLabel = new JLabel("Tel");
        phoneLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        phoneLabel.setBounds(10, 390, 100, 25);
        phoneLabel.setForeground(new Color(255, 255, 255));
        frame.add(phoneLabel);
        JTextField phoneText = new JTextField(10);
        phoneText.setBounds(150, 390, 200, 25);
        frame.add(phoneText);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        emailLabel.setBounds(10, 460, 100, 25);
        emailLabel.setForeground(new Color(255, 255, 255));
        frame.add(emailLabel);
        JTextField emailText = new JTextField(10);
        emailText.setBounds(150, 460, 200, 25);
        frame.add(emailText);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        userLabel.setBounds(10, 530, 100, 25);
        userLabel.setForeground(new Color(255, 255, 255));
        frame.add(userLabel);
        JTextField userText = new JTextField(10);
        userText.setBounds(150, 530, 200, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        passwordLabel.setBounds(10, 600, 100, 25);
        passwordLabel.setForeground(new Color(255, 255, 255));
        frame.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 600, 200, 25);
        frame.add(passwordField);

        //buton creare cont
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(320, 670, 150, 25);
        createAccountButton.setBackground(Color.WHITE);
        createAccountButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == createAccountButton) {
                    String query = "{call client_nou(?, ?)}";
                    ResultSet rez;
                    try (Connection c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                         CallableStatement statement = c.prepareCall(query)) {
                        String n = numeText.getText();
                        String p = prenumeText.getText();
                        String a = adresaText.getText();
                        String email = emailText.getText();
                        String u = userText.getText();
                        String pass = passwordField.getText();
                        String tel = phoneText.getText();
                        statement.setString(1, u);
                        statement.setString(2, pass);
                        // statement.setString(3, a);
                        //statement.setString(4, tel);
                        //statement.setString(5, email);
                        //statement.setString(6, u);
                        //statement.setString(7, pass);
                        rez = statement.executeQuery();
                        statement.executeUpdate();
                        // System.out.println("Stored procedure called successfully!");
                        JOptionPane.showMessageDialog(null, "Your account was created succesfully!");
                        frame.dispose();
                        LoginFrame log = new LoginFrame();
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                }
            }

        });
        frame.add(createAccountButton);
        frame.setVisible(true);
    }
}
