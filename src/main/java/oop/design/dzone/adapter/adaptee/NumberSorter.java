package oop.design.dzone.adapter.adaptee;

import java.util.ArrayList;
import java.util.List;

/**
 * This is our adaptee,a third party implementation of a number sorter that deals with Lists,not arrays.
 */

public class NumberSorter {

    public List<Integer> sort(List<Integer> numbers) {
        return new ArrayList<Integer>();
    }
}
