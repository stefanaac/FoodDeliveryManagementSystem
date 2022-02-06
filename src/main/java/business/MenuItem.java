package business;

import java.io.Serializable;
import java.util.List;

public abstract class MenuItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private float rating;
    private float calories;
    private float protein;
    private float fat;
    private float sodium;
    private float price;

    public abstract float computePrice();

    public abstract String getProductName();

    public abstract void setProductName(String name);

    public abstract float getPrice();

    public abstract void setPrice(float price);

    public abstract List<MenuItem> getItems();

    public abstract void setItems(List<MenuItem> list);

    public abstract float getSodium();

    public abstract float getFat();

    public abstract float getProtein();

    public abstract float getCalories();

    public abstract float getRating();

    @Override
    public String toString() {
        return "MenuItem{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
}
