package presentation;

import business.BaseProduct;
import business.DeliveryService;
import business.Order;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class AdminFrame {
    JButton back;
    JButton deleteButton;
    JButton addProductsButton;
    JButton seeProductsButton;
    JButton modifyProductsButton;
    JButton raport1Button;
    JButton raport2Button;
    JButton raport3Button;
    JButton raport4Button;
    JButton logoutButton;
    JButton importButton;


    JLabel nameLabel;
    JLabel typeLabel;
    JLabel priceLabel;
    JLabel caloriesLabel;
    JLabel proteinsLabel;
    JLabel fatsLabel;
    JLabel sodiumLabel;
    JLabel ratingLabel;
    JLabel startHourLabel;
    JLabel endHourLabel;
    JLabel nrOfTimesLabel;
    JLabel nrOfOrdersLabel;
    JLabel sumLabel;
    JLabel timeLabel;


    JTextField nameTextField;
    JTextField typeTextField;
    JTextField priceTextField;
    JTextField caloriesTextField;
    JTextField proteinsTextField;
    JTextField fatsTextField;
    JTextField sodiumTextField;
    JTextField ratingTextField;
    JTextField startHourTextField;
    JTextField endHourTextField;
    JTextField nrOfTimesTextField;
    JTextField nrOfOrdersTextField;
    JTextField sumTextField;
    JTextField timeTextField;


    JTable table;
    BaseProduct prod;
    DefaultTableModel tableModel;
    JFrame frame;
    HashMap<Order, Collection<BaseProduct>> ordersList;
    DeliveryService service = new DeliveryService();


    public AdminFrame() throws IOException {

        frame = new JFrame();
        frame.setSize(1530, 830);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);


        //setez backgoundul frame-ului
        frame.getContentPane().setBackground(new Color(255, 204, 153));
        //CreateAccountLabel label=new CreateAccountLabel();
        //this.add(label);
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
                    frame.dispose();
                    LoginFrame myFrame = new LoginFrame();
                }
            }
        });
        frame.add(back);

        JPanel p = new JPanel();
        p.setBorder(new EtchedBorder());
        frame.add(p);
        p.setLayout(null);
        p.setBounds(0, 140, 200, 400);
        p.setBackground(Color.WHITE);

        JPanel pan = new JPanel();
        pan.setBorder(new EtchedBorder());
        frame.add(pan);
        pan.setLayout(null);
        pan.setBounds(550, 100, 900, 500);
        pan.setBackground(Color.WHITE);
        pan.setVisible(true);


        deleteButton = new JButton("DELETE");
        deleteButton.setToolTipText("Click here to manage products");
        deleteButton.setFocusable(false);
        deleteButton.setFont(new Font("MV Boly", Font.BOLD, 15));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBounds(15, 30, 170, 30);
        deleteButton.setBackground(new Color(255, 204, 153));
        deleteButton.setBorderPainted(false);
        p.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == deleteButton) {
                    //dispose();
                    //ModifyStockFrame newFrame=new ModifyStockFrame();
                }
            }
        });


        addProductsButton = new JButton("ADD");
        addProductsButton.setToolTipText("Click here to import products");
        addProductsButton.setBounds(15, 80, 170, 30);
        addProductsButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        addProductsButton.setFocusable(false);
        addProductsButton.setForeground(Color.WHITE);
        addProductsButton.setBackground(new Color(255, 204, 153));
        addProductsButton.setBorderPainted(false);
        p.add(addProductsButton);
        addProductsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == addProductsButton) {
                    //dispose();
                    // AddDiscountsFrame newFrame=new AddDiscountsFrame();
                    String nam = nameTextField.getText();
                    String ty = typeTextField.getText();
                    Float price = Float.parseFloat(priceTextField.getText());
                    Float cal = Float.parseFloat(caloriesTextField.getText());
                    Float pro = Float.parseFloat(proteinsTextField.getText());
                    Float fat = Float.parseFloat(fatsTextField.getText());
                    Float sod = Float.parseFloat(sodiumTextField.getText());
                    Float rat = Float.parseFloat(ratingTextField.getText());
                    //productsTextField;
                    BaseProduct myNewProduct = new BaseProduct(nam, rat, cal, pro, fat, sod, price);
                    service.createNewMenuItem(myNewProduct);


                }
            }
        });


        modifyProductsButton = new JButton("MODIFY");
        modifyProductsButton.setToolTipText("Click this to modify product");
        modifyProductsButton.setBounds(15, 130, 170, 30);
        modifyProductsButton.setFocusable(false);
        modifyProductsButton.setBackground(new Color(255, 204, 153));
        modifyProductsButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        modifyProductsButton.setForeground(Color.WHITE);
        modifyProductsButton.setBorderPainted(false);
        p.add(modifyProductsButton);
        modifyProductsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == modifyProductsButton) {
                    //dispose();
                    //SendOrdersFrame newFrame=new SendOrdersFrame();
                }
            }
        });


        raport1Button = new JButton("RAPORT1");
        raport1Button.setBounds(15, 180, 170, 30);
        raport1Button.setFocusable(false);
        raport1Button.setBackground(new Color(255, 204, 153));
        raport1Button.setFont(new Font("Monospaced", Font.BOLD, 20));
        raport1Button.setForeground(Color.WHITE);
        raport1Button.setBorderPainted(false);
        p.add(raport1Button);
        raport1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == raport1Button) {

                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime dateTime1 = LocalDateTime.parse(startHourTextField.getText(), formatter);
                        LocalDateTime dateTime2 = LocalDateTime.parse(endHourTextField.getText(), formatter);
                        service.raport1(dateTime1, dateTime2);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });


        raport2Button = new JButton("RAPORT2");
        raport2Button.setBounds(15, 230, 170, 30);
        raport2Button.setFocusable(false);
        raport2Button.setBackground(new Color(255, 204, 153));
        raport2Button.setFont(new Font("Monospaced", Font.BOLD, 20));
        raport2Button.setForeground(Color.WHITE);
        raport2Button.setBorderPainted(false);
        p.add(raport2Button);
        raport2Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == raport2Button) {
                    DeliveryService d = new DeliveryService();
                    try {
                        d.raport2(Integer.parseInt(nrOfTimesLabel.getText()));
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        raport3Button = new JButton("RAPORT3");
        raport3Button.setBounds(15, 280, 170, 30);
        raport3Button.setFocusable(false);
        raport3Button.setBackground(new Color(255, 204, 153));
        raport3Button.setFont(new Font("Monospaced", Font.BOLD, 20));
        raport3Button.setForeground(Color.WHITE);
        raport3Button.setBorderPainted(false);
        p.add(raport3Button);
        raport3Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == raport3Button) {
                    DeliveryService d = new DeliveryService();
                    try {
                        d.raport3(Integer.parseInt(nrOfOrdersTextField.getText()),Integer.parseInt(sumTextField.getText()) );
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        raport4Button = new JButton("RAPORT4");
        raport4Button.setBounds(15, 330, 170, 30);
        raport4Button.setFocusable(false);
        raport4Button.setBackground(new Color(255, 204, 153));
        raport4Button.setFont(new Font("Monospaced", Font.BOLD, 20));
        raport4Button.setForeground(Color.WHITE);
        raport4Button.setBorderPainted(false);
        p.add(raport4Button);
        raport4Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == raport4Button) {
                    DeliveryService d = new DeliveryService();
                    try {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                        LocalDateTime dateTime1 = LocalDateTime.parse(timeTextField.getText(), formatter);
                        d.raport4(dateTime1);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

        logoutButton = new JButton("Log out");
        logoutButton.setBounds(1350, 700, 150, 25);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setFocusable(false);
        frame.add(logoutButton);
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


        importButton = new JButton("Import Products");
        importButton.setBounds(900, 600, 150, 25);
        importButton.setBackground(Color.WHITE);
        importButton.setFocusable(false);
        frame.add(importButton);
        importButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (e.getSource() == importButton) {
                    prod = new BaseProduct();
                    tableModel = new DefaultTableModel();
                    tableModel.addColumn("Title");
                    tableModel.addColumn("Rating");
                    tableModel.addColumn("Calories");
                    tableModel.addColumn("Protein");
                    tableModel.addColumn("Fat");
                    tableModel.addColumn("Sodium");
                    tableModel.addColumn("Price");
                    List<BaseProduct> list = null;
                    try {
                        list = service.readFile();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }


                    for (BaseProduct bp : list) {
                        String name = bp.getTitle();
                        String rating = Float.toString(bp.getRating());
                        String calories = Float.toString(bp.getCalories());
                        String protein = Float.toString(bp.getProtein());
                        String fat = Float.toString(bp.getFat());
                        String sodium = Float.toString(bp.getSodium());
                        String price = Float.toString(bp.getPrice());
                        tableModel.addRow(new Object[]{name, rating, calories, protein, fat, sodium, price});
                    }

                    table = new JTable(tableModel);
                    table.setVisible(true);
                    table.setBounds(0, 0, 900, 500);
                    table.setForeground(new Color(255, 204, 153));
                    table.setFont(new Font("Monospaced", Font.BOLD, 20));
                    table.getColumnModel().getColumn(0).setPreferredWidth(400);
                    JScrollPane sp = new JScrollPane(table);
                    sp.setBounds(0, 0, 900, 500);
                    pan.add(sp);
                }
            }
        });


        JPanel p2 = new JPanel();
        p2.setBorder(new EtchedBorder());
        frame.add(p2);
        p2.setLayout(null);
        p2.setBounds(220, 100, 300, 500);
        p2.setBackground(Color.WHITE);
        p2.setVisible(true);


        nameLabel = new JLabel("NAME");
        nameLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        nameLabel.setForeground(new Color(255, 204, 153));
        nameLabel.setBounds(15, 30, 170, 30);
        p2.add(nameLabel);


        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        nameTextField.setForeground(Color.WHITE);
        nameTextField.setBackground(new Color(255, 204, 153));
        nameTextField.setBounds(105, 30, 170, 30);
        p2.add(nameTextField);


        typeLabel = new JLabel("TYPE");
        typeLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        typeLabel.setForeground(new Color(255, 204, 153));
        typeLabel.setBounds(15, 80, 170, 30);
        p2.add(typeLabel);


        typeTextField = new JTextField();
        typeTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        typeTextField.setForeground(Color.WHITE);
        typeTextField.setBackground(new Color(255, 204, 153));
        typeTextField.setBounds(105, 80, 170, 30);
        p2.add(typeTextField);


        priceLabel = new JLabel("PRICE");
        priceLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        priceLabel.setForeground(new Color(255, 204, 153));
        priceLabel.setBounds(15, 130, 170, 30);
        p2.add(priceLabel);

        priceTextField = new JTextField();
        priceTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        priceTextField.setForeground(Color.WHITE);
        priceTextField.setBackground(new Color(255, 204, 153));
        priceTextField.setBounds(105, 130, 170, 30);
        p2.add(priceTextField);

        caloriesLabel = new JLabel("CALORIES");
        caloriesLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        caloriesLabel.setForeground(new Color(255, 204, 153));
        caloriesLabel.setBounds(5, 180, 170, 30);
        p2.add(caloriesLabel);

        caloriesTextField = new JTextField();
        caloriesTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        caloriesTextField.setForeground(Color.WHITE);
        caloriesTextField.setBackground(new Color(255, 204, 153));
        caloriesTextField.setBounds(105, 180, 170, 30);
        p2.add(caloriesTextField);


        proteinsLabel = new JLabel("PROTEINS");
        proteinsLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        proteinsLabel.setForeground(new Color(255, 204, 153));
        proteinsLabel.setBounds(5, 230, 170, 30);
        p2.add(proteinsLabel);

        proteinsTextField = new JTextField();
        proteinsTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        proteinsTextField.setForeground(Color.WHITE);
        proteinsTextField.setBackground(new Color(255, 204, 153));
        proteinsTextField.setBounds(105, 230, 170, 30);
        p2.add(proteinsTextField);

        fatsLabel = new JLabel("FATS");
        fatsLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        fatsLabel.setForeground(new Color(255, 204, 153));
        fatsLabel.setBounds(15, 280, 170, 30);
        p2.add(fatsLabel);

        fatsTextField = new JTextField();
        fatsTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        fatsTextField.setForeground(Color.WHITE);
        fatsTextField.setBackground(new Color(255, 204, 153));
        fatsTextField.setBounds(105, 280, 170, 30);
        p2.add(fatsTextField);

        sodiumLabel = new JLabel("SODIUM");
        sodiumLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        sodiumLabel.setForeground(new Color(255, 204, 153));
        sodiumLabel.setBounds(15, 330, 170, 30);
        p2.add(sodiumLabel);

        sodiumTextField = new JTextField();
        sodiumTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        sodiumTextField.setForeground(Color.WHITE);
        sodiumTextField.setBackground(new Color(255, 204, 153));
        sodiumTextField.setBounds(105, 330, 170, 30);
        p2.add(sodiumTextField);


        ratingLabel = new JLabel("RATING");
        ratingLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        ratingLabel.setForeground(new Color(255, 204, 153));
        ratingLabel.setBounds(15, 380, 170, 30);
        p2.add(ratingLabel);

        ratingTextField = new JTextField();
        ratingTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        ratingTextField.setForeground(Color.WHITE);
        ratingTextField.setBackground(new Color(255, 204, 153));
        ratingTextField.setBounds(105, 380, 170, 30);
        p2.add(ratingTextField);


        seeProductsButton = new JButton("PRODUCTS");
        seeProductsButton.setToolTipText("Click this to go to Send Orders section");
        seeProductsButton.setBounds(15, 130, 170, 30);
        seeProductsButton.setFocusable(false);
        seeProductsButton.setBackground(new Color(255, 204, 153));
        seeProductsButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        seeProductsButton.setForeground(Color.WHITE);
        seeProductsButton.setBorderPainted(false);
        p.add(seeProductsButton);
        seeProductsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == seeProductsButton) {
                    pan.add(table);
                }
            }
        });


        JLabel n = new JLabel("NAME");
        n.setBounds(700, 60, 100, 25);
        n.setForeground(Color.WHITE);
        n.setFont(new Font("Monospaced", Font.BOLD, 15));
        //frame.add(n);

        JLabel r = new JLabel("RATING");
        r.setBounds(955, 60, 100, 15);
        r.setForeground(Color.WHITE);
        r.setFont(new Font("Monospaced", Font.BOLD, 15));
        //frame.add(r);

        JLabel c = new JLabel("CALORIES");
        c.setBounds(1035, 60, 100, 15);
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Monospaced", Font.BOLD, 15));
        //frame.add(c);

        JLabel pr = new JLabel("PROTEIN");
        pr.setBounds(1115, 60, 100, 15);
        pr.setForeground(Color.WHITE);
        pr.setFont(new Font("Monospaced", Font.BOLD, 15));
        //frame.add(pr);

        JLabel f = new JLabel("FAT");
        f.setBounds(1210, 60, 100, 15);
        f.setForeground(Color.WHITE);
        f.setFont(new Font("Monospaced", Font.BOLD, 15));
        //frame.add(f);

        JLabel s = new JLabel("SODIUM");
        s.setBounds(1280, 60, 100, 15);
        s.setForeground(Color.WHITE);
        s.setFont(new Font("Monospaced", Font.BOLD, 15));
        //frame.add(s);

        JLabel pri = new JLabel("PRICE");
        pri.setBounds(1360, 60, 100, 15);
        pri.setForeground(Color.WHITE);
        pri.setFont(new Font("Monospaced", Font.BOLD, 15));
        // frame.add(pri);


        startHourLabel = new JLabel("START H");
        startHourLabel.setBounds(100, 620, 80, 25);
        startHourLabel.setForeground(Color.WHITE);
        startHourLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(startHourLabel);


        startHourTextField = new JTextField();
        startHourTextField.setBounds(180, 620, 200, 25);
        //startHourTextField.setForeground(Color.WHITE);
        startHourTextField.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(startHourTextField);


        endHourLabel = new JLabel("END H");
        endHourLabel.setBounds(400, 620, 150, 25);
        endHourLabel.setForeground(Color.WHITE);
        endHourLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(endHourLabel);

        endHourTextField = new JTextField();
        endHourTextField.setBounds(450, 620, 200, 25);
        //startHourTextField.setForeground(Color.WHITE);
        endHourTextField.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(endHourTextField);

        nrOfTimesLabel = new JLabel("NR TIMES");
        nrOfTimesLabel.setBounds(100, 670, 100, 25);
        nrOfTimesLabel.setForeground(Color.WHITE);
        nrOfTimesLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(nrOfTimesLabel);

        nrOfTimesTextField = new JTextField();
        nrOfTimesTextField.setBounds(200, 670, 100, 25);
        //startHourTextField.setForeground(Color.WHITE);
        nrOfTimesTextField.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(nrOfTimesTextField);


        nrOfOrdersLabel = new JLabel("NR ORDERS");
        nrOfOrdersLabel.setBounds(100, 720, 100, 25);
        nrOfOrdersLabel.setForeground(Color.WHITE);
        nrOfOrdersLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(nrOfOrdersLabel);

        nrOfOrdersTextField = new JTextField();
        nrOfOrdersTextField.setBounds(200, 720, 100, 25);
        //startHourTextField.setForeground(Color.WHITE);
        nrOfOrdersTextField.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(nrOfOrdersTextField);

        sumLabel = new JLabel("SUM");
        sumLabel.setBounds(400, 720, 150, 25);
        sumLabel.setForeground(Color.WHITE);
        sumLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(sumLabel);

        sumTextField = new JTextField();
        sumTextField.setBounds(450, 720, 200, 25);
        //startHourTextField.setForeground(Color.WHITE);
        sumTextField.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(sumTextField);


        timeLabel = new JLabel("DATE");
        timeLabel.setBounds(100, 750, 100, 25);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(timeLabel);

        timeTextField = new JTextField();
        timeTextField.setBounds(200, 750, 100, 25);
        //startHourTextField.setForeground(Color.WHITE);
        timeTextField.setFont(new Font("Monospaced", Font.BOLD, 15));
        frame.add(timeTextField);


        p.setVisible(true);
        frame.setVisible(true);
    }
}


