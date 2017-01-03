package sources.oop.design.dzone.adapter.client;

import sources.oop.design.dzone.adapter.target.SortListAdapter;
import sources.oop.design.dzone.adapter.target.Sorter;

/**
 * Created by mman on 20.12.16.
 */
public class Client {

    public static void main(String[] args) {
        int[] numbers = new int[]{34, 2, 4, 12, 1};
        Sorter sorter = new SortListAdapter();
        sorter.sort(numbers);
    }
}
