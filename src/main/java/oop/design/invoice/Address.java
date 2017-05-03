package oop.design.invoice;

/**
 * Created by mman on 20.12.16.
 */
public class Address {
    private String country = "";
    private String city = "";
    private String street = "";

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String format() {
        return String.format("Country: %s%nCity: %s%nStreet: %s%n", country, city, street);
    }
}
