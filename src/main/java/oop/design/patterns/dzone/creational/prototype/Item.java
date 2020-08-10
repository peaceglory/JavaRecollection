package oop.design.patterns.dzone.creational.prototype;

//Prototype
public abstract class Item {
    private String title;
    private double price;

    public Item clone() {
        Item clonedItem = null;
        try {
            //use default object clone.
            clonedItem = (Item) super.clone();

            //specialised clone
            clonedItem.setPrice(price);
            clonedItem.setTitle(title);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clonedItem;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}