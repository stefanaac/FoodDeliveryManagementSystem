package presentation;

import business.Order;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


public class EmployeeFrame extends JFrame implements Observer {
    JButton back;
    JButton searchProductsButton;
    JButton makeAnOrderButton;

    JLabel title;

    JButton logoutButton;
    JLabel label;

    public EmployeeFrame(Order o) {
        this.setSize(1530, 830);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);


        //setez backgoundul frame-ului
        this.getContentPane().setBackground(new Color(255, 204, 153));
        back = new JButton("Back");
        back.setFocusable(false);
        back.setBackground(Color.WHITE);
        back.setBounds(1350, 730, 150, 25);
        back.setToolTipText("Click this to go back to Home Page");
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == back) {
                    dispose();
                    LoginFrame myFrame = new LoginFrame();
                }
            }
        });
        this.add(back);

        JPanel p = new JPanel();
        p.setBorder(new EtchedBorder());
        this.add(p);
        p.setLayout(null);
        p.setBounds(70, 150, 600, 550);
        p.setBackground(Color.WHITE);

        label = new JLabel();
        label.setBounds(0, 0, 600, 550);
        label.setForeground(new Color(255, 204, 153));
        String s = o.getClientId() + "\n" + o.getOrderId() + "\n" + o.getDate() + "\n" + o.getItemOrdered() + "\n";
        label.setText(convertToMultiline(o.toString()));
        p.add(label);


        title = new JLabel("Notifications");
        title.setBounds(100, 20, 800, 100);
        title.setFont(new Font("Monospaced", Font.BOLD, 50));
        title.setForeground(Color.WHITE);

        this.add(title);


        logoutButton = new JButton("Log out");
        logoutButton.setBounds(1350, 700, 150, 25);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setFocusable(false);
        this.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == logoutButton) {
                    //dispose();
                    //MyFrame openMainFrame = new MyFrame();
                }
            }
        });

        p.setVisible(true);

        this.setVisible(true);
    }

    //method for printing the string from my bill label on multiple lines
    public static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(null, "A new order has been made!!!!");

    }

}


