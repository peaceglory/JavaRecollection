package sources.oop;

/**
 * Created by mman on 04.11.16.
 */
public class Employee implements Worker {
    private String name = null;
    private double salary = 0.0;

    public static void callStatic() {
        System.out.println("Employee.callStatic");
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

}
