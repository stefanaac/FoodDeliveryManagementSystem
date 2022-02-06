package business;


import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class BaseProduct extends MenuItem implements Serializable {
    private String title;
    private float rating;
    private float calories;
    private float protein;
    private float fat;
    private float sodium;
    private float price;
    private int nrOrders;

    public BaseProduct(String element, float rating, float calories, float protein, float fat, float sodium, float price) {
        this.title = element;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public BaseProduct() {

    }

    public int getNrOrders() {
        return nrOrders;
    }

    public void setNrOrders(int nrOrders) {
        this.nrOrders = nrOrders;
    }

    @Override
    public float computePrice() {
        return this.price;
    }

    @Override
    public String getProductName() {
        return this.title;
    }

    @Override
    public void setProductName(String name) {
        this.title = name;
    }

    @Override
    public List<MenuItem> getItems() {
        return new List<MenuItem>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<MenuItem> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(MenuItem menuItem) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends MenuItem> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends MenuItem> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public MenuItem get(int index) {
                return null;
            }

            @Override
            public MenuItem set(int index, MenuItem element) {
                return null;
            }

            @Override
            public void add(int index, MenuItem element) {

            }

            @Override
            public MenuItem remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<MenuItem> listIterator() {
                return null;
            }

            @Override
            public ListIterator<MenuItem> listIterator(int index) {
                return null;
            }

            @Override
            public List<MenuItem> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }

    @Override
    public void setItems(List<MenuItem> list) {

    }

    @Override
    public float getSodium() {
        return this.sodium;
    }

    @Override
    public float getFat() {
        return this.fat;
    }

    @Override
    public float getProtein() {
        return this.protein;
    }

    @Override
    public float getCalories() {
        return this.calories;
    }

    @Override
    public float getRating() {
        return this.rating;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BaseProduct:\n" +
                "Product name:'" + title + '\'';
    }
}
