package tests.oop

import sources.oop.Employee
import sources.oop.Engineer

/**
 * Created by mman on 04.11.16.
 */
class MapTest extends GroovyTestCase {

    void testMap() {
        Map<String, Employee> employeesByName = new HashMap<>();

        employeesByName.put("Kuncho", new Employee("Kuncho", 2500));
        employeesByName.put("Mancho", new Engineer("Mancho", 4500));
        employeesByName.put("Mancho", new Engineer("Mancho2", 5500));

        println employeesByName;
    }

    void testMap2() {
        Map<Integer, Integer> ints = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            ints.put(1, i);
        }
        System.out.println(ints);

        Dictionary<String, String> strings = new Hashtable<>();
        strings.put("FB", "Value1");
        strings.put("Ea", "Value2");
        System.out.println(strings);

        println "FB".hashCode();
        println "Ea".hashCode();
    }
}
