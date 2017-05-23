package oop.misc.objectinitialization.singleton;

import static oop.misc.objectinitialization.Printer.println;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        println("creating concrete object");
        Concrete c = new Concrete();
        println("1st concrete object done");
        c = new Concrete();
        println("2nd concrete object done");
    }
}
