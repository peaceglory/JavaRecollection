package clone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClone {
    private static final String ORIGINAL_DEPARTMENT_NAME = "IT";
    private static final String NEW_DEPARTMENT_NAME = "Better IT";
    private static final String EMPLOYEE_NAME = "M Man";

    private Department department;
    private Employee employee;

    @BeforeEach
    void setUp() {
        department = new Department(1, ORIGINAL_DEPARTMENT_NAME);
        employee = new Employee(12, EMPLOYEE_NAME, department);
    }

    @AfterEach
    void tearDown() {
        employee = null;
        department = null;
    }

    @Test
    void testDeepCopy_UsingCloneMethod() throws CloneNotSupportedException {
        final Employee empClone = (Employee) employee.clone();

        department.setName(NEW_DEPARTMENT_NAME);

        assertNotEquals(employee, empClone);
        assertEquals(NEW_DEPARTMENT_NAME, employee.getDepartment().getName());
        assertEquals(ORIGINAL_DEPARTMENT_NAME, empClone.getDepartment().getName());
    }

    @Test
    void testDeepCopy_UsingReflection() {
        final List<String> roomNames = new ArrayList<>();
        roomNames.add("East");
        roomNames.add("North");
        roomNames.add("West");
        roomNames.add("South");

        department.setRoomNames(roomNames);

        final Employee empClone = CloneUtil.cloneObject(employee);

        department.setName(NEW_DEPARTMENT_NAME);

        assertNotEquals(employee, empClone);
        assertEquals(NEW_DEPARTMENT_NAME, employee.getDepartment().getName());
        assertEquals(ORIGINAL_DEPARTMENT_NAME, empClone.getDepartment().getName());
    }
}

class Employee implements Cloneable {
    private int empoyeeId;
    private String employeeName;
    private Department department;
    private final int privateFinalField = 42;

    public Employee() {
    }

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

    public int getPrivateFinalField() {
        return privateFinalField;
    }
}

class Department implements Cloneable {
    private int id;
    private String name;
    private List<String> roomNames;

    public Department() {
    }

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

    public List<String> getRoomNames() {
        return roomNames;
    }

    public void setRoomNames(List<String> roomNames) {
        this.roomNames = roomNames;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class CloneUtil {

    static <T> T cloneObject(T obj) {
        try {
            final Object clone = obj.getClass().newInstance();

            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                if (field.get(obj) == null || Modifier.isFinal(field.getModifiers())) {
                    continue;
                }

                if (field.getType().isPrimitive()
                        || field.getType().equals(String.class)
                        || (field.getType().getSuperclass() != null
                            && field.getType().getSuperclass().equals(Number.class))
                        || field.getType().equals(Boolean.class)) {
                    field.set(clone, field.get(obj));
                } else {
                    final Object childObj = field.get(obj);

                    if (childObj == obj) {
                        field.set(clone, clone);
                    } else {
                        field.set(clone, cloneObject(field.get(obj)));
                    }
                }
            }

            return (T) clone;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}