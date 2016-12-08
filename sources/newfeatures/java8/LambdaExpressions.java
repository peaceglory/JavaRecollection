package sources.newfeatures.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mman on 06.12.16.
 */
public class LambdaExpressions {

    interface Redeclare {
        boolean equals(Object obj);
        int hashCode();
        Object clone() throws CloneNotSupportedException;

        default void myPrintln() {
            System.out.println("Redeclare.myPrintln()");
        }
    }

    interface MyRedeclare extends Redeclare {
        default void myPrintln() {
            System.out.println("MyRedeclare.myPrintln()");
        }
    }

    interface AnotherRedeclare {
        default void myPrintln() {
            System.out.println("AnotherRedeclare.myPrintln()");
        }

        static void thisIsPossibleNow() {
            System.out.println("AnotherRedeclare.thisIsPossibleNow()");
        }
    }

    class MyConcreteRedeclare implements MyRedeclare/*, AnotherRedeclare*/ {

        @Override
        public Object clone() throws CloneNotSupportedException {
            return null;
        }
    }

    class MyConcreteAnotherRedeclare implements AnotherRedeclare{

    }

    public static void main(String[] args) {
        String[] strings = new String[]{"Bebeeeeee", "Miro", "Eli"};

        List<String> list = Arrays.asList(strings);
        list.forEach((s) -> System.out.println(s));
        System.out.println("-----------------------");

        Arrays.sort(strings, (str1, str2) -> {
            if (str1.length() < str2.length()) {
                return -1;
            }
            if (str1.length() > str2.length()) {
                return 1;
            }
            return 0;
        });

        list.forEach(System.out::println); // object::instanceMethod; this is equal to (x) -> System.out.println(x);
        System.out.println("-----------------------");

        Arrays.sort(strings, String::compareTo); // Class::instanceMethod; equals to (x,y) -> x.compareTo(y)
        list.forEach(System.out::println);

        Redeclare r = new LambdaExpressions().new MyConcreteRedeclare();
        r.myPrintln(); // The closes super default implementation is chosen.

        AnotherRedeclare ar = new LambdaExpressions().new MyConcreteAnotherRedeclare();
        AnotherRedeclare.thisIsPossibleNow(); // static method in interface only callable from the interface itself.
    }
}
