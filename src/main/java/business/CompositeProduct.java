package business;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
    List<MenuItem> productsList = new ArrayList<MenuItem>();
    private float price;
    private String productName;
    float totalSum =0;

    @Override
    public float computePrice() {
        for(int i=0;i<productsList.size();i++)
        {
            totalSum=totalSum+productsList.get(i).getPrice();
        }
        this.price = totalSum;
        return totalSum;
    }

    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public void setProductName(String name) {
        this.productName = name;

    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }


    public void addProduct(BaseProduct baseproduct) {
        this.productsList.add(baseproduct);
    }

    public void deleteProduct(BaseProduct baseproduct) {
        this.productsList.remove(baseproduct);
    }

    @Override
    public List<MenuItem> getItems() {
        return productsList;
    }

    public void setItems(List<MenuItem> list) {
        this.productsList = list;
    }

    @Override
    public float getSodium() {
        return 0;
    }

    @Override
    public float getFat() {
        return 0;
    }

    @Override
    public float getProtein() {
        return 0;
    }

    @Override
    public float getCalories() {
        return 0;
    }

    @Override
    public float getRating() {
        return 0;
    }


}
