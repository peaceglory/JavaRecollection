package oop.design.vendingmachine;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by mman on 17.12.16.
 */
public class VendingMachine {
    private static final Path PATH = Paths.get("conf/oop/design/vendingmachine/products.conf");
    private static final int SLOT_SIZE = 10;

    private final Map<Integer, Queue<Product>> productsByCode = new HashMap<>();
    private final Stack<Product> released = new Stack<>();
    private final List<Double> bank = new ArrayList<>();

    private double deposited = 0.0;
    private int currentProduct = -1;

    public VendingMachine() {
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(PATH)) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Queue<Product> products = new LinkedList<>();
        final int[] code = new int[1];
        code[0] = 10;
        props.forEach((k, v) -> {
            for (int i = 0; i < SLOT_SIZE; i++) {
                products.add(new Product(k.toString(), new Double(v.toString())));
            }
            productsByCode.put(code[0]++, products);
        });
    }

    public String showMenu() {
        final StringBuilder sb = new StringBuilder(productsByCode.size());
        sb.append("[\n");

        productsByCode.forEach((i, l) -> {
            sb.append(String.format("&d - &s %f%n", i, l.isEmpty() ? "N/A" : l.peek().getName(), l.peek().getPrice()));
        });
        sb.append("]");
        return  sb.toString();
    }

    public String placeOrder(int productCode, double money) {
        deposited += money;
        currentProduct = productCode;

        Queue<Product> available = productsByCode.get(productCode);
        if (available == null) {
            return "Invalid code. Enter code corresponding to the product or cancel!";
        }
        if (available.isEmpty()) {
            return "This product is currently not available. Choose another or cancel!";
        }
        Product p = available.peek();
        if (deposited < p.getPrice()) {
            return "Still to deposit: " + (p.getPrice() - deposited);
        }

        releaseProduct(available);
        return "Take your product and enjoy";
    }

    public double cancelOrder() {
        double cashback = deposited;
        deposited = 0.0;
        currentProduct = -1;
        return cashback;
    }

    public String deposit(double money) {
        if (currentProduct > 0) {
            return placeOrder(currentProduct, money);
        } else {
            deposited += money;
            return deposited + "";
        }
    }

    private void releaseProduct(Queue<Product> available) {
        released.push(available.poll());
        bank.add(deposited);
        deposited = 0.0;
        currentProduct = -1;
    }
}
