package presentation;

import javax.swing.*;
import java.awt.*;

public class LoginLabel extends JLabel {

    LoginLabel() {
        ImageIcon image = new ImageIcon("user.PNG");
        //Border border=BorderFactory.createLineBorder(Color.WHITE,0);
        this.setText("FOOD DELIVERY");//seteaza textul etichetei
        this.setIcon(image);//
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setForeground(new Color(255, 255, 255));
        this.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 30));
        this.setIconTextGap(0);
        this.setBackground(new Color(255, 204, 153));
        this.setOpaque(true);
        //this.setBorder(border);
        this.setBounds(500, 30, 495, 350);
    }
}
