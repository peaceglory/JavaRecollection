package oop.design.invoice;

/**
 * Created by mman on 20.12.16.
 */
public class LineItem {
    private Product product = null;
    private int quantity = 0;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String format() {
        return String.format("Product: %s, Qty: %d", product.getName(), quantity);
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
