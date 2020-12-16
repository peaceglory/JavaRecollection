package clone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestClone {

    @Test
    public void testDeepCopy_WithClone() throws CloneNotSupportedException {
        final Department dpt = new Department(1, "IT");
        final Employee empOriginal = new Employee(12, "Man", dpt);

        final Employee empClone = (Employee) empOriginal.clone();

        dpt.setName("Better IT");

        assertNotEquals(empOriginal, empClone);
        assertEquals("Better IT", empOriginal.getDepartment().getName());
        assertEquals("IT", empClone.getDepartment().getName());
    }
}

class Employee implements Cloneable {
    private int empoyeeId;
    private String employeeName;
    private Department department;

    public Employee(int id, String name, Department dept) {
        this.empoyeeId = id;
        this.employeeName = name;
        this.department = dept;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        final Employee empClone = (Employee) super.clone();
        final Object dptClone = empClone.getDepartment().clone();

        empClone.setDepartment((Department) dptClone);

        return empClone;
    }

    public int getEmpoyeeId() {
        return empoyeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

class Department implements Cloneable {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}