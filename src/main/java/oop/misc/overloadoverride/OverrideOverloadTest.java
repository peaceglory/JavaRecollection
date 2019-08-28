package oop.misc.overloadoverride;

public class OverrideOverloadTest {
    static class Parent {
//        void print(String a) { System.out.println("Child - String"); }

        void print(Object a) { System.out.println("Parent - Object"); }
    }

    static class Child extends Parent {
        void print(String a) { System.out.println("Child - String"); }
//        void print(Object a) { System.out.println("Child - Object"); }
    }

    /**
     * It appears that Java first picks which method to invoke, before checking for sub-class overrides.
     * In this case, the declared instance type is Parent and the only matching method in Parent is Parent::print(Object).
     * When Java then checks for any potential overrides of Parent::print(Object),
     * it does not find any, so that’s the method which gets executed
     * */
    public static void main(String[] args) {
        String string = "";
        Parent parent = new Child();
        parent.print(string);
    }
}
