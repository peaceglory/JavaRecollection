package tests.oop.employees;

import sources.oop.employees.ToiletCleaner;

/**
 * Created by mman on 03.12.16.
 */
public class EmployeeTests1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        ToiletCleaner cleaner = new ToiletCleaner("Hazan", 550);
        cleaner.setShiftBuddy(new ToiletCleaner("Miro", 5000));

        ToiletCleaner copy = cleaner.clone();
        copy.getShiftBuddy().setSalary(20); // That will change the original as well since clone is shallow.

        copy.setSalary(1100); // Works since salary is a simple type.

        System.out.printf("original salary: %f, clone salary: %f%n", cleaner.getSalary(), copy.getSalary());
        System.out.printf("original shift buddy salary: %f, clone shift buddy salary: %f%n",
                            cleaner.getShiftBuddy().getSalary(), copy.getShiftBuddy().getSalary());
    }
}
