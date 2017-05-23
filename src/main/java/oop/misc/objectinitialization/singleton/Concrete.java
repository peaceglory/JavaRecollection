package oop.misc.objectinitialization.singleton;

import static oop.misc.objectinitialization.Printer.println;

public class Concrete {
    static Concrete me = new Concrete();

    static {
        println("static block before constructor");
    }


    {
        println("block before constructor");
    }

    public Concrete() {
        println("constructor");
    }

    static void throwUp() {
        throw new RuntimeException();
    }

    static {
        println("static block after constructor");
        throwUp();
    }

    {
        println("block after constructor");
    }

}
