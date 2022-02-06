package business;


import data.BillGenerator;
import data.DeliverySerializator;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    public HashMap<Order, Collection<BaseProduct>> map = new HashMap<Order, Collection<BaseProduct>>(); //lista de comenzi
    public List<Order> orders = new ArrayList<Order>();
    public List<BaseProduct> products = new ArrayList<BaseProduct>();
    List<BaseProduct> menu = new ArrayList<BaseProduct>();

    public DeliveryService() {
        map = DeliverySerializator.hashMapDeserialization();
    }

    //ia doar produsele diferite
    public static <T> Predicate<T> sortProd(Function<? super T, ?> keyExtractor) {
        Set<Object> aux = ConcurrentHashMap.newKeySet();
        Predicate<T> ss = t -> aux.add(keyExtractor.apply(t));
        return ss;
    }

    public boolean invariant() {
        return !(this.map.size() <= 0);
    }

    public List<BaseProduct> readFile() throws IOException {
        String fileName = "src\\main\\java\\data\\products.csv";
        List<BaseProduct> products;
        Stream<String> myStream = Files.lines(Paths.get(fileName));
        List<BaseProduct> read = new ArrayList<>();
        products = null;
        myStream.filter(lines -> !lines.startsWith("Title")).forEach(lines ->
        {
            String[] itm = lines.split(",");
            float rating = Float.parseFloat(itm[1]);
            float calories = Float.parseFloat(itm[2]);
            float protein = Float.parseFloat(itm[3]);
            float fat = Float.parseFloat(itm[4]);
            float sodium = Float.parseFloat(itm[5]);
            float price = Float.parseFloat(itm[6]);
            BaseProduct b = new BaseProduct(itm[0], rating, calories, protein, fat, sodium, price);
            read.add(b);
        });
        products = read.stream().filter(sortProd(BaseProduct::getTitle)).collect(Collectors.toList());
        DeliverySerializator ds = new DeliverySerializator();
        ds.productsSerialization(products);
        this.products = products;
        return this.products;
    }

    @Override
    public void createNewMenuItem(BaseProduct menuItem) {
        this.menu.add(menuItem);
    }


    @Override
    public void deleteMenuItem(MenuItem menuItem) {
        MenuItem itemToDelete = findInMenu(menuItem);
        if (itemToDelete != null) {
            if (findMyItem(menuItem) == 0) {
                this.menu.remove(itemToDelete);
            } else {
                System.out.println("Nu se poate stergeeee!!!");
            }
        } else {
            System.out.println("Nu exista produsuuuul!!!");
        }
    }

    public void createMyOrder(Order order, List<BaseProduct> productsList) {
        assert order != null;
        int aux = 0;
        String s = null;
        if (noItems() == true) {
            orders.add(order);
            map.put(order, productsList);
            DeliverySerializator.hashMapSerialization(map);
            s = "";
            aux = 0;
            for (MenuItem m : productsList) {
                if (aux == 0) {
                    s = m.getProductName();
                    aux++;
                } else {
                    s = s + "," + m.getProductName();
                }
            }
            setChanged();
        }
    }

    public boolean noItems() {
        for (int i = 0; i < orders.size(); i++) {
            Collection<BaseProduct> itemsList = this.map.get(orders.get(i));
            return itemsList.size() == 0;
        }
        return true;
    }


    private MenuItem findInMenu(MenuItem menuItem) {
        for (int i = 0; i < this.menu.size(); i++) {
            if (this.menu.get(i).getProductName().equals(menuItem.getProductName()))
                return this.menu.get(i);
        }
        return null;
    }

    private int findMyItem(MenuItem menuItem) {
        int k = 0;

        for (int i = 0; i < orders.size(); i++) {
            Collection<BaseProduct> itemsList = map.get(orders.get(i));
            for (MenuItem it : itemsList) {
                if (it.getItems() != null) {
                    if (it.getProductName().equals(menuItem.getProductName())) {
                        k++;
                    } else {
                        for (MenuItem bp : it.getItems()) {
                            if (bp.getProductName().equals(menuItem.getProductName())) {
                                k++;
                            }
                        }
                    }
                } else {
                    if (it.getProductName().equals(menuItem.getProductName())) {
                        k++;
                    }
                }
            }

        }
        return k;
    }


    @Override
    public void editMenuIten(MenuItem menuItem, MenuItem newMenuItem) {

    }

    @Override
    public void createNewOrder(Order order) {
        this.map.put(order, menu);

    }

    @Override
    public int computePrice(Order order) {
        int totalPrice = 0;
        for (MenuItem item : menu) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void generateBill(Order order) {
        BillGenerator bg = new BillGenerator(order);
    }

    /**
     * @param start
     * @param end
     * @throws IOException
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     */

    //time raport
    @Override
    public void raport1(LocalDateTime start, LocalDateTime end) throws IOException {
        assert this.menu.size() > 0;
        int h1 = start.getHour();
        int h2 = end.getHour();
        FileWriter f = new FileWriter("raport1.txt", true);
        f.write("Raport comenzi cuprinse intre ora " + start.getHour() + " si ora " + end.getHour() + ":\n");
        List<Order> dateOrders = map.keySet().stream().filter(e -> e.getDate().getHour() >= h1 && e.getDate().getHour() <= h2).collect(Collectors.toList());
        dateOrders.stream().forEach(e -> {
            try {
                f.write("Order id:" + e.getOrderId() + "Client ID:" + e.getClientId() + "Date:" + e.getDate().getDayOfMonth() + "\n");
                f.write("Produse:\n");
                int i = 1;
                for (MenuItem pp : e.getItemOrdered()) {
                    f.write("Produsul" + i + ":" + pp.getProductName());
                    i++;
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        f.close();
        assert this.menu.size() > 0;
        assert invariant();

    }

    /**
     * @param nrOrders -numarul de comenzi
     * @throws IOException
     * @assert lista de menuItems
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    @Override
    public void raport2(Integer nrOrders) throws IOException {

        assert this.menu.size() > 0;
        FileWriter wr = new FileWriter("raport2.txt");
        wr.write("Cientii care au comandat de mai mult de" + nrOrders + "ori\n");
        ArrayList<Client> c = new ArrayList<Client>();
        c.stream().distinct().forEach(e -> {
            try {
                if (e.getOrders().equals(nrOrders)) {
                    wr.write("Clientul :" + e.getIdClient() + "are mai mult de" + nrOrders + "comenzi si una din comenzi are valoarea mai mare de" + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        wr.close();
        assert this.menu.size() > 0;
        assert invariant();
    }

    /**
     * @param kOrd
     * @param searchedSum
     * @throws IOException
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     */
    @Override
    public void raport3(Integer kOrd, Integer searchedSum) throws IOException {
        assert this.menu.size() > 0;
        FileWriter wr = new FileWriter("raport3.txt");
        wr.write("Cientii care au comandat de mai mult de" + kOrd + "ori" + "si de suma" + searchedSum + "\n");
        ArrayList<Client> c = new ArrayList<Client>();
        c.stream().distinct().forEach(e -> {
            try {
                if (e.getOrders().equals(kOrd)) {
                    wr.write("Clientul :" + e.getIdClient() + "are mai mult de" + kOrd + "comenzi si una din comenzi are valoarea mai mare de" + searchedSum + "\n");
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        wr.close();
        assert this.menu.size() > 0;
        assert invariant();


    }

    /**
     * @param date
     * @throws IOException
     * @pre size-ul Arraylistului de [produse mai mare ca 0
     * @post size-ul Arraylistului de [produse mai mare ca 0
     * @invariant size-ul Arraylistului de [produse mai mare ca 0
     */

    @Override
    public void raport4(LocalDateTime date) throws IOException {
        assert this.menu.size() > 0;
        FileWriter fw = new FileWriter("raport4.txt", true);
        fw.write("Raport produse ce au fost cumparate in ziua cu numarul:" + date.getDayOfMonth() + "\n");
        Set<MenuItem> men = new HashSet<>();
        HashMap<Order, Collection<BaseProduct>> orders = DeliverySerializator.hashMapDeserialization();
        for (Map.Entry<Order, Collection<BaseProduct>> entry : orders.entrySet()) {

            if (date.getDayOfMonth() == entry.getKey().getDate().getDayOfMonth()) {
                menu.addAll(entry.getValue());
            }

        }
        for (int i = 0; i < menu.size(); i++) {
            fw.write("Produsul:" + i + menu.get(i).getProductName() + "\n");
        }
        fw.close();
        assert this.menu.size() > 0;
        assert invariant();
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
