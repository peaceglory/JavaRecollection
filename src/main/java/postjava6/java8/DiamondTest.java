package postjava6.java8;

public class DiamondTest {

    // https://www.javabrahman.com/java-8/java-8-multiple-inheritance-conflict-resolution-rules-and-diamond-problem/
    // Rule 1 – Classes take higher precedence than interfaces
    // Rule 2 – Derived interfaces or sub-interfaces take higher precedence than the interfaces higher-up in the inheritance hierarchy
    // Rule 3 – In case Rule 1 and Rule 2 are not able to resolve the conflict then the implementing class has to specifically override and provide a method with the same method definition
    public static void main(String[] args) {
        FirstAndSecondImpl firstAndSecond = new FirstAndSecondImpl();
        firstAndSecond.call();

        FirstAndSecondImpl third = new Third();
        third.call();

        FirstAndSecondImpl fourth = new Fourth();
        fourth.call();

        Fifth fifth = new Fifth();
        fifth.call();
    }
}

// Two equally-levelled interfaces with the same default method. The implementing class won't compile unless it
// defines its own method of the same signature.
interface First {
    default void call() {
        System.out.println("First.call");
    }
}

interface Second {
    default void call() {
        System.out.println("Second.call");
    }
}

class FirstAndSecondImpl implements First, Second {

    public void call() {
//        First.super.call();
        System.out.println("FirstAndSecond.call");
    }
}

//
class Third extends FirstAndSecondImpl implements Second {


}

class Fourth extends FirstAndSecondImpl implements Second {

    @Override
    public void call() {
//        Second.super.call(); // Won't compile
        System.out.println("Fourth.call");

    }
}

class FirstImpl implements First {

    @Override
    public void call() {
        System.out.println("FirstImpl.call");
    }
}

class Fifth extends FirstImpl implements Second {

}