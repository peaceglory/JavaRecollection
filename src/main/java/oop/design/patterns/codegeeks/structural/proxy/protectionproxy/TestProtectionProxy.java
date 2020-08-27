package oop.design.patterns.codegeeks.structural.proxy.protectionproxy;

/**
 * <p>
 * <b>Type: Structural</b>
 * </p>
 * <p>
 * <b>Intent:</b><br />
 * Proxy objects handle responsibility of managing access to another object.
 * </p>
 *
 * <p>
 * <b>Ups:</b>
 * <ul>
 * <li>The proxy can provide access to a remote object.</li>
 * <li>The proxy can provide security checks before letting the call.</li>
 * <li>The proxy can add functionality before/after the real call.</li>
 * <li>The proxy can provide lazy-loading of big data.</li>
 * </ul>
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Can be misused especially at #4 (see above).
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * RMI, Servlet
 * </p>
 */
public class TestProtectionProxy {

	public static void main(String[] args) {
		
		Owner owner = new Owner();
		ReportGeneratorProxy reportGenerator = new ReportGeneratorProtectionProxy(owner);
		owner.setReportGenerator(reportGenerator);
		
		Employee employee = new Employee();
		reportGenerator = new ReportGeneratorProtectionProxy(employee);
		employee.setReportGenerator(reportGenerator);
		System.out.println("For owner:");
		System.out.println(owner.generateDailyReport());
		System.out.println("For employee:");
		System.out.println(employee.generateDailyReport());
		
	}

}
