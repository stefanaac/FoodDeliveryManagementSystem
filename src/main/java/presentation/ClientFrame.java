package presentation;

import business.BaseProduct;
import business.DeliveryService;
import business.MenuItem;
import business.Order;
import data.BillGenerator;
import data.DeliverySerializator;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;


public class ClientFrame implements Observer {
    JButton back;
    JButton searchProductsButton;
    JButton makeAnOrderButton;

    JFrame frame;
    DefaultTableModel tableModel;
    JTable table;

    JButton logoutButton;
    JLabel nameLabel;
    JLabel typeLabel;
    JLabel priceLabel;
    JLabel caloriesLabel;
    JLabel proteinsLabel;
    JLabel fatsLabel;
    JLabel sodiumLabel;
    JLabel ratingLabel;
    JLabel productsLabel;


    JTextField nameTextField;
    JTextField typeTextField;
    JTextField priceTextField;
    JTextField caloriesTextField;
    JTextField proteinsTextField;
    JTextField fatsTextField;
    JTextField sodiumTextField;
    JTextField ratingTextField;
    JTextField productsTextField;


    JTextField searchedValueTextField;
    JTextField maxTextField;
    JLabel searchedValueLabel;
    JLabel maxLabel;
    JComboBox box;
    Integer ii = 0;

    HashMap<Order, Collection<BaseProduct>> hmap;
    List<BaseProduct> menuItems;
    HashMap<Order, Collection<BaseProduct>> ordersList;
    DeliveryService service = new DeliveryService();

    public ClientFrame() throws IOException {
        frame = new JFrame();
        frame.setSize(1530, 830);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel pan = new JPanel();
        pan.setBorder(new EtchedBorder());
        frame.add(pan);
        pan.setLayout(null);
        pan.setBounds(550, 100, 900, 500);
        pan.setBackground(Color.WHITE);
        pan.setVisible(true);


        //setez backgoundul frame-ului
        frame.getContentPane().setBackground(new Color(255, 204, 153));
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


        searchProductsButton = new JButton("SEARCH");
        searchProductsButton.setToolTipText("Click here to view products");
        searchProductsButton.setFocusable(false);
        searchProductsButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        searchProductsButton.setForeground(Color.WHITE);
        searchProductsButton.setBounds(15, 30, 170, 30);
        searchProductsButton.setBackground(new Color(255, 204, 153));
        searchProductsButton.setBorderPainted(false);
        p.add(searchProductsButton);
        searchProductsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == searchProductsButton) {
                    if (box.getSelectedItem().equals("Title")) {
                        SearchResults s = new SearchResults((ArrayList<MenuItem>) searchByName(nameTextField.getText()));

                    } else {
                        if (box.getSelectedItem().equals("Rating")) {
                            SearchResults s = new SearchResults((ArrayList<MenuItem>) searchByRating(Float.parseFloat(searchedValueTextField.getText())));

                        } else {
                            if (box.getSelectedItem().equals("Calories")) {
                                SearchResults s = new SearchResults((ArrayList<MenuItem>) searchByCalories(Float.parseFloat(searchedValueTextField.getText())));

                            } else {
                                if (box.getSelectedItem().equals("Protein")) {
                                    SearchResults s = new SearchResults((ArrayList<MenuItem>) searchByProteins(Float.parseFloat(searchedValueTextField.getText())));


                                } else {
                                    if (box.getSelectedItem().equals("Fat")) {
                                        SearchResults s = new SearchResults((ArrayList<MenuItem>) searchByFats(Float.parseFloat(searchedValueTextField.getText())));


                                    } else {
                                        if (box.getSelectedItem().equals("Sodium")) {
                                            SearchResults s = new SearchResults((ArrayList<MenuItem>) searchBySodium(Float.parseFloat(searchedValueTextField.getText())));


                                        } else {
                                            if (box.getSelectedItem().equals("Price")) {
                                                SearchResults s = new SearchResults((ArrayList<MenuItem>) serachByPrice(Float.parseFloat(searchedValueTextField.getText())));


                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });


        BaseProduct prod = new BaseProduct();
        menuItems = service.readFile();
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Title");
        tableModel.addColumn("Rating");
        tableModel.addColumn("Calories");
        tableModel.addColumn("Protein");
        tableModel.addColumn("Fat");
        tableModel.addColumn("Sodium");
        tableModel.addColumn("Price");


        List<BaseProduct> list = service.readFile();

        for (BaseProduct bp : list) {
            String nameString = bp.getTitle();
            String ratingString = Float.toString(bp.getRating());
            String caloriesString = Float.toString(bp.getCalories());
            String proteinString = Float.toString(bp.getProtein());
            String fatString = Float.toString(bp.getFat());
            String sodiumString = Float.toString(bp.getSodium());
            String priceString = Float.toString(bp.getPrice());
            tableModel.addRow(new Object[]{nameString, ratingString, caloriesString, proteinString, fatString, sodiumString, priceString});
        }

        table = new JTable(tableModel);
        table.setVisible(true);
        table.setBounds(0, 0, 900, 500);
        table.setForeground(new Color(255, 204, 153));
        table.setFont(new Font("Monospaced", Font.BOLD, 20));
        table.getColumnModel().getColumn(0).setPreferredWidth(400);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(true);
        table.addRowSelectionInterval(1, 10);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 900, 500);
        pan.add(sp);

        makeAnOrderButton = new JButton("ORDER");
        makeAnOrderButton.setToolTipText("Click here to make an order");
        makeAnOrderButton.setBounds(15, 80, 170, 30);
        makeAnOrderButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        makeAnOrderButton.setFocusable(false);
        makeAnOrderButton.setForeground(Color.WHITE);
        makeAnOrderButton.setBackground(new Color(255, 204, 153));
        makeAnOrderButton.setBorderPainted(false);
        p.add(makeAnOrderButton);
        makeAnOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == makeAnOrderButton) {
                    int[] selectedrows = table.getSelectedRows();
                    List<MenuItem> l = new ArrayList<>();
                    for (int i = 0; i < selectedrows.length; i++) {
                        BaseProduct sel = menuItems.get(table.convertRowIndexToModel(selectedrows[i]));
                        l.add(sel);
                    }
                    HashMap<Order, Collection<BaseProduct>> ll = DeliverySerializator.hashMapDeserialization();
                    Order o = new Order(l);
                    BillGenerator bg = new BillGenerator(o);
                    o.setClientId(ll.size() + 3);
                    o.setIdOrder(ll.size() + 1);
                    o.setDate(LocalDateTime.now());
                    service.addObserver(new EmployeeFrame(o));
                    service.createMyOrder(o, menuItems);
                    System.out.println(o.toString());
                }
            }
        });

        searchedValueLabel = new JLabel("VALUE ");
        searchedValueLabel.setBounds(15, 230, 80, 30);
        searchedValueLabel.setFocusable(false);
        searchedValueLabel.setBackground(new Color(255, 204, 153));
        searchedValueLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        searchedValueLabel.setForeground(new Color(255, 204, 153));
        p.add(searchedValueLabel);


        searchedValueTextField = new JTextField();
        searchedValueTextField.setBounds(100, 230, 80, 30);
        searchedValueTextField.setBackground(new Color(255, 204, 153));
        searchedValueTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        searchedValueTextField.setForeground(Color.WHITE);
        p.add(searchedValueTextField);


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

        p.setVisible(true);


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

        String[] crit = {"Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
        box = new JComboBox(crit);
        box.setBounds(15, 130, 170, 30);
        box.setBackground(new Color(255, 204, 153));
        box.setForeground(Color.WHITE);
        box.setFocusable(false);
        p.add(box);
        frame.setVisible(true);
    }


    public List<MenuItem> searchByName(String keyword) {

        return this.menuItems.stream().filter(e -> e.getProductName().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    public List<MenuItem> searchByRating(float searchedValue) {
        return this.menuItems.stream().filter(e -> e.getRating() == searchedValue).collect(Collectors.toList());

    }

    public List<MenuItem> searchByCalories(float searchedValue) {
        return this.menuItems.stream().filter(e -> e.getCalories() == searchedValue).collect(Collectors.toList());
    }

    public List<MenuItem> searchByProteins(float searchedValue) {
        return this.menuItems.stream().filter(e -> e.getProtein() <= searchedValue).collect(Collectors.toList());

    }

    public List<MenuItem> searchByFats(float searchedValue) {
        return this.menuItems.stream().filter(e -> e.getFat() <= searchedValue).collect(Collectors.toList());

    }

    public List<MenuItem> searchBySodium(float serachedValue) {
        return this.menuItems.stream().filter(e -> e.getSodium() <= serachedValue).collect(Collectors.toList());

    }

    public List<MenuItem> serachByPrice(float serachedValue) {
        return this.menuItems.stream().filter(e -> e.getPrice() <= serachedValue).collect(Collectors.toList());

    }

    @Override
    public void update(Observable o, Object arg) {
        JOptionPane.showMessageDialog(null, "New Order!");

    }

}


