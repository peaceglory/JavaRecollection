package tests.oop.employees

import sources.oop.employees.Employee
import sources.oop.employees.Engineer
import sources.oop.employees.Worker

/**
 * Created by mman on 04.11.16.
 */
class EngineerTest extends GroovyTestCase {

    /**
     * Tests whether <method>getJobDescription</method> method throws the expected exception.
     */
    void testSetJobDescription() {
        boolean excCaught = false;

        Worker eng = new Engineer("Kuncho", 2500);
        eng.setJobDescription("Work hard");
        try {
            println eng.getJobDescription();
        } catch (UnsupportedOperationException uoe) {
            excCaught = true;
        }
        assert excCaught;

        eng.callStatic();
        eng.callStatic();
        Employee.callStatic();
    }
}
