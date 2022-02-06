package data;

import business.BaseProduct;
import business.DeliveryService;
import business.Order;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DeliverySerializator implements Serializable {
    public static void hashMapSerialization(HashMap<Order, Collection<BaseProduct>> hmap) {
        try {
            FileOutputStream file;
            file = new FileOutputStream("delivery.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(hmap);
            out.close();
            file.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public static HashMap<Order, Collection<BaseProduct>> hashMapDeserialization() {
        HashMap<Order, Collection<BaseProduct>> map = new HashMap<Order, Collection<BaseProduct>>();
        try {
            ObjectInputStream inputObject;
            FileInputStream file = new FileInputStream("delivery.ser");
            inputObject = new ObjectInputStream(file);
            map = (HashMap<Order, Collection<BaseProduct>>) inputObject.readObject();
            inputObject.close();
            file.close();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return map;
    }



    public void productsSerialization(List<BaseProduct> products) {
        try {
            FileOutputStream file;
            file = new FileOutputStream("prod.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(products);
            out.close();
            file.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public Collection<BaseProduct> productsDeserialization(List<BaseProduct> products) {
        try {
            ObjectInputStream inputObject;
            FileInputStream file = new FileInputStream("prod.ser");
            inputObject = new ObjectInputStream(file);
            products = (List<BaseProduct>) inputObject.readObject();
            inputObject.close();
            file.close();
        } catch (IOException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return products;
    }
}
