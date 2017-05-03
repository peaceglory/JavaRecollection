package oop.atm;

import oop.atm.enums.CashBills;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by mman on 19.02.17.
 */
public class CashBin {
    private Stack<CashBills> cashStack;

    public CashBin() {
        cashStack = new Stack<>();
    }

    public void placeCash(CashBills... cashBills) {
        for (int i = 0; i < cashBills.length; i++) {
            if (cashBills[i] != null) {
                cashStack.push(cashBills[i]);
            } else {
                throw new IllegalArgumentException("cashBills cannot contain null values!");
            }
        }
    }

    public void placeCash(Stack<CashBills> cashStack) {
        if (cashStack == null) {
            throw new IllegalArgumentException("cashStack cannot be null");
        }
        this.cashStack = cashStack;
    }

    public void clear() {
        cashStack.clear();
    }

    public static void main(String[] args) {
        CashBin cb = new CashBin();
        CashBills bills = null;
        cb.placeCash(bills);

        Stack<CashBills> s = new Stack<>();
        s.push(null);

        List<CashBills> l = new LinkedList<>();
        l.add(null);
    }
}
