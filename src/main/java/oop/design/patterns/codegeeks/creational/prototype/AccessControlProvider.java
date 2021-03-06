package oop.design.patterns.codegeeks.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class AccessControlProvider {
    private static Map<String, AccessControl> map = new HashMap<>();

    static {
        System.out.println("Fetching data from external resources and creating access control objects...");
        map.put("USER", new AccessControl("USER", "DO_WORK"));
        map.put("ADMIN", new AccessControl("ADMIN", "ADD/REMOVE USERS"));
        map.put("MANAGER", new AccessControl("MANAGER", "GENERATE/READ REPORTS"));
        map.put("VP", new AccessControl("VP", "MODIFY REPORTS"));
    }

    public static AccessControl getAccessControlObject(String controlLevel) {
        AccessControl ac = null;
        ac = map.get(controlLevel);
        if (ac != null) {
            AccessControl acc = ac.clone();
            return acc;
        }
        return null;
    }
}
