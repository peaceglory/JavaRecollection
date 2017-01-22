package sources.oop.design.invoice;

/**
 * Created by mman on 20.12.16.
 */
public class Product {
    private String name = "";
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
}
