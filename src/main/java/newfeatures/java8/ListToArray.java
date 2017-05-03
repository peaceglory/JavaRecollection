package newfeatures.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mman on 03.02.17.
 */
public class ListToArray {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        String[] myArray = myList.stream().toArray(String[]::new);
        for (String s : myArray) {
            System.out.println(s);
        }
    }
}
