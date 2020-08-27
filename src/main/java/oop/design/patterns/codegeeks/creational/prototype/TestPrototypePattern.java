package oop.design.patterns.codegeeks.creational.prototype;

/**
 * <p>
 * <b>Type: Creational</b>
 * </p>
 * <p>
 * <b>Intent:</b><br />
 * Enables one-time initialization of complex objects which clients then clone and use.
 * </p>
 *
 * <p>
 * <b>Ups:</b><br />
 * 1. One time initialization of complex or similar objects.<br />
 * 2. Clients don't need to know how to create the object, they just clone it.
 * </p>
 *
 * <p>
 * <b>Downs:</b><br />
 * Object cloning is involved which is potentially error prone.
 * </p>
 *
 * <p>
 * <b>Examples:</b><br />
 * User access control objects.
 * </p>
 */
public class TestPrototypePattern {

	public static void main(String[] args) {
		AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		User user = new User("User A", "USER Level", userAccessControl);
		
		System.out.println("************************************");
		System.out.println(user);
		
		userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		user = new User("User B", "USER Level", userAccessControl);
		System.out.println("Changing access control of: "+user.getUserName());
		user.getAccessControl().setAccess("READ REPORTS");
		System.out.println(user);
		
		System.out.println("************************************");
		
		AccessControl managerAccessControl = AccessControlProvider.getAccessControlObject("MANAGER");
		user = new User("User C", "MANAGER Level", managerAccessControl);
		System.out.println(user);
	}
}
