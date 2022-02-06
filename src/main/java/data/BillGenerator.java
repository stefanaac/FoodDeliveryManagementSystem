package data;

import business.MenuItem;
import business.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BillGenerator {
    public BillGenerator(Order o) {
        try {
            File myObj = new File("bill.txt");
            FileWriter myWriter = new FileWriter("bill.txt");
            //Float f=o.getQuantity()*o.getTotal();
            myWriter.write("Your BILL:\n" + "Id client:........................... " + o.getClientId() + "\n" + "Produs/Produse:" + "\n");
            String s = "";
            float k = 0f;
            for (MenuItem m : o.getItemOrdered()) {
                s = s + m.getProductName() + "..................." + m.getPrice() + "\n";
                k = k + m.getPrice();
            }
            myWriter.write(s);
            myWriter.write("Total:" + k);
            myWriter.close();
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
