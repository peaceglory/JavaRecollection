package oop.misc;

/**
 * new SuperClass().a() returns “superclass”.
 * new SubClass().a() returns “subclasssubclass”.
 *
 * If we change the visibility of method c() to private, however:
 * new SuperClass().a() returns “superclass”.
 * new SubClass().a() returns “superclasssuperclass”.
 */
public class SuperClass {

    public String a() {
        return b();
    }

    public String b() {
        return c();
    }

    public String c() {
        return "superclass";
    }
}

class SubClass extends SuperClass {

    public String a() {
        return b() + b();
    }

    public String c() {
        return "subclass";
    }

    // TEST
    public static void main(String[] args) {
        System.out.println(new SuperClass().a());
        System.out.println(new SubClass().a());
    }
}