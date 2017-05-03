package oop.atm;

import oop.atm.enums.CashBills;
import oop.atm.exceptions.InsufficientCashStorageException;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mman on 19.02.17.
 */
public class CashStorage {
    private Map<CashBills, Integer> storage;

    public CashStorage() {
        loadStorage();
    }

    public void loadStorage() {
        storage = new EnumMap<>(CashBills.class);
        storage.put(CashBills.TEN, 1000);
        storage.put(CashBills.TWENTY, 800);
        storage.put(CashBills.FIFTY, 500);
        storage.put(CashBills.HUNDRED, 300);
    }

    public List<CashBills> withdraw(CashBills bill, int amount) throws InsufficientCashStorageException {
        int available = checkAvailability(bill, amount);

        List<CashBills> stack = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            stack.add(bill);
        }

        modifyStorage(bill, available - amount);
        return stack;
    }

    private void modifyStorage(CashBills bill, int newAmount) {
        storage.put(bill, newAmount);
    }

    private int checkAvailability(CashBills bills, int amount) throws InsufficientCashStorageException {
        int available = storage.get(bills);
        if (amount > available) {
            throw new InsufficientCashStorageException("We're out of " + bills);
        }
        return available;
    }
}
