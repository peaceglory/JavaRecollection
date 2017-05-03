package oop.design.dzone.adapter.client;

import oop.design.dzone.adapter.target.SortListAdapter;
import oop.design.dzone.adapter.target.Sorter;

/**
 * <p>
 * <b>Intent:</b><br />
 * Provide client with the needed (expected) interface while at the same time makes use of the existing interface.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * Makes two different interfaces compatible with each other.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Arguably adds a level of complexity.
 * </p>
 *
 * <p>
 * <b>Examples:</b>
 * <ul>
 * <li>Third party software vendors.</li>
 * <li>Legacy code.</li>
 * <li>Sorting algorithm vendor.</li>
 * </ul>
 * </p>
 */
public class Client {

    public static void main(String[] args) {
        int[] numbers = new int[]{34, 2, 4, 12, 1};
        Sorter sorter = new SortListAdapter();
        sorter.sort(numbers);
    }
}
