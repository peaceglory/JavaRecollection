package oop.misc.objectinitialization;

import static oop.misc.objectinitialization.Printer.println;

public class Concrete extends Abstract {

    static {
        println("static block before Concrete constructor");
    }

    {
        println("block before Concrete constructor");
    }

    public Concrete() {
        println("Concrete constructor");
    }

    static {
        println("static block after Concrete constructor");
    }

    {
        println("block after Concrete constructor");
    }

}
