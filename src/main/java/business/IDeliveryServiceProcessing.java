package business;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Observer;

/**
 * Aceasta clasa trebuie sa contina operatiile care pot fi executate de client/administrator:(import products, manage the products from the menu, generate reports--administrator)  & (create new order which implies computing the price for an order and generating a bill in .txt format, searching for products based on several criteria--client)
 */
public interface IDeliveryServiceProcessing extends Serializable, Observer {

    /**
     * Metoda care adauga un nou produs in lista de produse
     */
    void createNewMenuItem(BaseProduct menuItem);

    /**
     * Metoda care sterge un anumit produs
     */
    void deleteMenuItem(MenuItem menuItem);

    /**
     * Metoda care editeaza un produs al restaurantului
     */
    void editMenuIten(MenuItem menuItem, MenuItem newMenuItem);

    /**
     * Metoda care creeaza o noua comanda
     */
    void createNewOrder(Order order);

    /**
     * Metoda care calculeaza costul unei comenzi
     */
    int computePrice(Order order);

    /**
     * Metoda care genereaza chitanta unei anumite comenzi
     */
    void generateBill(Order order);


    //report1
    void raport3(Integer nrOrders, Integer sum) throws IOException;

    void raport4(LocalDateTime date) throws IOException;

    void raport1(LocalDateTime startDate, LocalDateTime endDate) throws IOException;

    void raport2(Integer nrOrders) throws IOException;
}
