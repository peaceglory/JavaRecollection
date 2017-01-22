package sources.oop.design.invoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mman on 20.12.16.
 */
public class Invoice {
    private Address address = null;
    private List<LineItem> items = new ArrayList<>();

    public Invoice(Address address) {
        this.address = address;
    }

    public void add(Product product, int quantity) {
        items.add(new LineItem(product, quantity));
    }

    public String format() {
        final StringBuilder output = new StringBuilder(String.format("To: %s%n", address.format()));
        items.forEach((li) -> output.append(li.format()));
        output.append(getTotalDue());
        return output.toString();
    }

    private String getTotalDue() {
        double total = 0.0;
        for (LineItem item : items) {
            total += item.getTotalPrice();
        }
        return Double.toString(total);
    }
}
