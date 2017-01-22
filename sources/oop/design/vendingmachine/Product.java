package sources.oop.design.vendingmachine;

/**
 * Created by mman on 17.12.16.
 */
public class Product {
    private String name = null;
    private double price = 0.0;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
