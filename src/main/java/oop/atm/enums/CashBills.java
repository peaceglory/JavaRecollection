package oop.atm.enums;

/**
 * Created by mman on 19.02.17.
 */
public enum CashBills {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private final int value;

    CashBills(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("/%d/", value);
    }

    public static void main(String[] args) {
        System.out.println(CashBills.FIFTY);
    }
}
