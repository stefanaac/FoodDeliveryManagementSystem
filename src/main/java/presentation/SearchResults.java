package presentation;

import business.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class SearchResults {
    JFrame frame;
    JScrollPane sp;
    DefaultTableModel tableModel;
    JTable table;
    JLabel myTitle;
    public SearchResults(ArrayList<MenuItem> s) {
        frame = new JFrame();
        frame.setSize(930, 530);
        frame.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground((new Color(255, 204, 153)));
        frame.setResizable(false);
        frame.setLayout(null);

        myTitle = new JLabel("SEARCH RESULTS");
        myTitle.setBounds(300, 0, 400, 100);
        myTitle.setFont(new Font("Monospaced", Font.BOLD, 30));
        myTitle.setForeground(Color.WHITE);
        frame.add(myTitle);


        tableModel = new DefaultTableModel();
        tableModel.addColumn("Title");
        tableModel.addColumn("Rating");
        tableModel.addColumn("Calories");
        tableModel.addColumn("Protein");
        tableModel.addColumn("Fat");
        tableModel.addColumn("Sodium");
        tableModel.addColumn("Price");


        for (MenuItem bp : s) {
            String name = bp.getProductName();
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
        sp.setBounds(50, 80, 800, 400);
        frame.add(sp);
        frame.setVisible(true);

    }
}
