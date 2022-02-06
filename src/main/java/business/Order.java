package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    int totalPrice;
    private int orderId;
    private int clientId;
    private LocalDateTime date;
    private List<MenuItem> itemOrdered;

    public Order(int client, int order, LocalDateTime date) {
        this.orderId = order;
        this.clientId = client;
        this.date = date;
    }
    public Order(List<MenuItem> items) {
        this.itemOrdered = items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setIdOrder(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int hashCode() {
        return this.orderId;
    }

    public List<MenuItem> getItemOrdered() {
        return itemOrdered;
    }

    public void setItemOrdered(List<MenuItem> itemOrdered) {
        this.itemOrdered = itemOrdered;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", date='" + date + '\'' +
                ", itemOrdered=" + itemOrdered +
                '}';
    }
}
