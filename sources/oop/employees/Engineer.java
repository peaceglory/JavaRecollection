package sources.oop.employees;

/**
 * Created by mman on 04.11.16.
 */
public class Engineer extends Employee implements JobDescription {
    private String jobDescription;

    public static void callStatic() {
        System.out.println("Engineer.callStatic");
    }

    public Engineer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void setJobDescription(String jd) {
        this.jobDescription = jd;
    }
}
