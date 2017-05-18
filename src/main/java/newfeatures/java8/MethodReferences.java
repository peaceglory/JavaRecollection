package newfeatures.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by mman on 18.05.17.
 */
public class MethodReferences {

    static class Car {

        Car() {
            System.out.println("Car created!");
        }

        static Car create(final Supplier<Car> supplier) {
            return supplier.get();
        }

        static void collide(final Car car) {
            System.out.println("Collided: " + car);
        }

        static void someStatic() {
            System.out.println("Just some static");
        }

        void follow(final Car another) {
            System.out.println("Following: " + another);
        }

        void repair() {
            System.out.println("Repair: " + this);
        }

        Object getObject() {
            return new Object();
        }
    }

    public static void main(String[] args) {
        Supplier<Car> sup = Car::new; // a ref to a no-arg constructor (basically returns result)
        Car car = Car.create(sup);
        List<Car> carList =Arrays.asList(car);

        Supplier<Object> objSup = car::getObject; // a ref to an instance method that has no args and returns result.

        Consumer<Car> cons = Car::collide; // a ref to a static method that accepts an arg and doesn't return result.
        carList.forEach(cons);

        Consumer<Car> cons2 = Car::repair; // a ref to an instance method that has no args and doesn't return result.

        Runnable someStatic = Car::someStatic; // a ref to a static method, no args, no res; seems only Runnable satisfies this.
    }
}
