package covariance;

/**
 * Created by developer on 6/14/17.
 * http://www.javaworld.com/article/3172592/java-language/type-dependency-in-java-part-1.html
 */
public class ArrayCovariance {

    public static void main(String[] args) {
        Object[] objectArray;

        // String compatible to Object, so String[] covariant to Object[], so compatible assignment.
        objectArray = new String[3];

        // Can't downcast Object to String because Object is not a String, so throw ArrayStoreException.
        objectArray[0] = new Object();

        //-----------------------------------------------------------------

        Person p = new Person();
        Being b = p; // upcast

        Person p2 = (Person) b; // downcast, b IS Person, so allowed.
    }

    static class Being {

    }

    static class Person extends Being {

    }
}
