package oop.design.patterns.codegeeks.structural.proxy.virtualproxy;

import java.util.List;

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
public class TestVirtualProxy {

    public static void main(String[] args) {
        ContactList contactList = new ContactListProxyImpl();
        Company company = new Company("ABC Company", "India", "+91-011-28458965", contactList);

        System.out.println("Company Name: " + company.getCompanyName());
        System.out.println("Company Address: " + company.getCompanyAddress());
        System.out.println("Company Contact No.: " + company.getCompanyContactNo());

        System.out.println("Requesting for contact list");

        contactList = company.getContactList();

        List<Employee> empList = contactList.getEmployeeList();
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }

}
