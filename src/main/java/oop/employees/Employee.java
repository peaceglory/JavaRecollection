package oop.employees;

/**
 * Created by mman on 04.11.16.
 */
public class Employee implements Worker {
    private String name = null;
    private double salary = 0.0;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public static void callStatic() {
        System.out.println("Employee.callStatic");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJobDescription() {
        throw new UnsupportedOperationException();
    }

    Employee aTestOfVisibilityForSubclasses() { // package-private visibility.
        return null;
    }

}
