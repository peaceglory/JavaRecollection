package oop.misc;

/**
 * Created by mman on 02.02.17.
 */
public class Scratch {

    public class Itch { // 'public' is fine here.
//        static String text = "text"; // Does not compile - static members not allowed in non-static inner classes.
        static final String text = "text"; // Compiles since it's a constant.

        int integer = 10;
    }

    public static class Itch2 {
        static String text = "text2"; // Compiles

        int integer = 20;
    }
}

class Test {

    public static void main(String[] args) {
        System.out.println(Scratch.Itch.text); // Access to static variable in a non-static inner class.
        System.out.println(new Scratch().new Itch().integer);

        System.out.println(Scratch.Itch2.text);
//        System.out.println(new Scratch().new Itch2().integer); // Does not compile - Itch2 does not live in an instance of Scratch.
        System.out.println(new Scratch.Itch2().integer); // Compiles -

    }
}
