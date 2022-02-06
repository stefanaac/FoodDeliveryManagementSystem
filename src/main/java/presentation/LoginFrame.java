package presentation;

import business.DeliveryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;

public class LoginFrame extends JFrame {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/";
    private final static String DB_NAME = "food_delivery";
    private final static String USER = "root";
    private final static String PASSWORD = "BumBum77!!";


    JComboBox box;
    JButton loginButton;
    JButton registerButton;
    JPasswordField passwordField;
    JTextField userText;


    DeliveryService delivery;

    public LoginFrame() {
        //setari pentru Frame
        this.setSize(1530, 830);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        //adaug logo-ul in bara de sus
        ImageIcon image = new ImageIcon("user.PNG");
        this.setIconImage(image.getImage());
        //setez backgoundul frame-ului
        this.getContentPane().setBackground(new Color(255, 204, 153));
        //adaug labelul cu Logo
        LoginLabel label = new LoginLabel();
        this.add(label);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(255, 204, 153));
        panel.setBounds(550, 390, 800, 295);


        JLabel userLabel = new JLabel("username");
        userLabel.setFont(new Font("MV Boly", Font.BOLD, 16));
        userLabel.setBounds(100, 10, 80, 25);
        userLabel.setForeground(new Color(255, 255, 255));
        panel.add(userLabel);
        userText = new JTextField(10);
        userText.setBounds(180, 10, 165, 25);
        panel.add(userText);

        //password
        JLabel passwordLabel = new JLabel("password");
        passwordLabel.setFont(new Font("MV Boly", Font.BOLD, 16));
        passwordLabel.setBounds(100, 70, 80, 25);
        passwordLabel.setForeground(new Color(255, 255, 255));
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(180, 70, 165, 25);
        panel.add(passwordField);

        //Tablou de stringuri pentru ComboBox
        String[] useri = {"admin", "employee", "client"};
        box = new JComboBox(useri);
        box.setBounds(160, 130, 100, 25);
        box.setBackground(Color.WHITE);
        box.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
				/*if(e.getSource()==loginButton && box.getSelectedIndex()==0)
				{
					//this.dispose();
					presentation.AdminFrame adminFrame=new presentation.AdminFrame();
				}
				else
				{
					if(e.getSource()==loginButton && box.getSelectedIndex()==1)
					{
						//this.dispose();
						presentation.ClientFrame clientFrame=new presentation.ClientFrame();
					}
				}*/
            }
        });
        panel.add(box);


        loginButton = new JButton("Log in");
        loginButton.setBounds(180, 190, 80, 25);
        loginButton.setBackground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            Connection c;

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == loginButton && box.getSelectedIndex() == 0) {
                    try {
                        c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                        String u = userText.getText();
                        String pass = passwordField.getText();
                        //Statement s = c.createStatement();
                        String sql = "Select * from administrator Where username='" + u + "' and password='" + pass + "'";
                        PreparedStatement pst = c.prepareStatement(sql);
                        ResultSet rs = pst.executeQuery(sql);
                        if (u != null && pass != null) {
                            if (rs.next()) {
                                dispose();
                                AdminFrame adminFrame = new AdminFrame();
                            } else {
                                JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                                dispose();
                            }
                        }
                    } catch (SQLException | IOException e1) {
                        JOptionPane.showMessageDialog(null, e1);
                    }
                } else {
                    if (e.getSource() == loginButton && box.getSelectedIndex() == 2) {
                        try {
                            c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                            String u = userText.getText();
                            String pass = passwordField.getText();
                            String sql = "Select * from client Where username='" + u + "' and password='" + pass + "'";
                            PreparedStatement pst = c.prepareStatement(sql);
                            ResultSet rs = pst.executeQuery(sql);
                            if (u != null && pass != null) {
                                if (rs.next()) {
                                    dispose();
                                    ClientFrame clientFrame = new ClientFrame();
                                } else {
                                    JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                                    dispose();
                                }
                            }
                        } catch (SQLException | IOException e2) {
                            JOptionPane.showMessageDialog(null, e2);
                        }
                    } else {/*
                        if (e.getSource() == loginButton && box.getSelectedIndex() == 1) {
                            try {
                                c = DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
                                String u = userText.getText();
                                String pass = passwordField.getText();
                                String sql = "Select * from employee Where username='" + u + "' and password='" + pass + "'";
                                PreparedStatement pst = c.prepareStatement(sql);
                                ResultSet rs = pst.executeQuery(sql);
                                if (u != null && pass != null) {
                                    if (rs.next()) {
                                        dispose();
                                        EmployeeFrame clientFrame = new EmployeeFrame();
                                    } else {
                                        JOptionPane.showMessageDialog(null, "LOGIN FAILED");
                                        dispose();
                                    }
                                }
                            } catch (SQLException e2) {
                                JOptionPane.showMessageDialog(null, e2);
                            }
                        }*/
                    }
                }
            }
        });
        panel.add(loginButton);


        registerButton = new JButton("Register");
        registerButton.setBounds(300, 190, 100, 25);
        registerButton.setBackground(Color.WHITE);
        registerButton.addActionListener(new ActionListener() {
            Connection c;

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if (e.getSource() == registerButton) {
                    dispose();
                    RegisterFrame fr = new RegisterFrame();

                }

            }
        });
        panel.add(registerButton);


        JLabel registerLabel = new JLabel("(If you're not a client yet)");
        registerLabel.setBounds(400, 190, 300, 25);
        registerLabel.setBackground(new Color(255, 204, 153));
        registerLabel.setForeground(Color.WHITE);
        panel.add(registerLabel);

        this.add(panel);
        this.setVisible(true);

    }
}


