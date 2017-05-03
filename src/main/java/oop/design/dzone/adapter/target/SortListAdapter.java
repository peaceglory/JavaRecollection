package oop.design.dzone.adapter.target;

import oop.design.dzone.adapter.adaptee.NumberSorter;

import java.util.ArrayList;
import java.util.List;

public class SortListAdapter implements Sorter {

    @Override
    public int[] sort(int[] numbers) {
        //convert the array to a List
        List<Integer> numberList = new ArrayList<>();

        //call the adapter
        NumberSorter sorter = new NumberSorter();
        numberList = sorter.sort(numberList);

        //convert the list back to an array and return
        return new int[numberList.size()];
    }
}
