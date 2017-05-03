package reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Converts an object to a string representation that lists all fields.
     *
     * @param obj an object
     * @return a string with the object's class name and all field names and
     * values
     */
    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);

        Class clazz = obj.getClass();

        if (clazz == String.class) {
            return (String) obj;
        }

        if (clazz.isArray()) {
            String str = clazz.getComponentType() + "[]{";

            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    str += ",";
                }
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) {
                    str += val;
                } else {
                    str += toString(val);
                }
            }
            return str + "}";
        }

        String str = clazz.getName();
        // inspect the fields of this class and all superclasses
        do {
            str += "[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            // get the names and values of all fields
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!str.endsWith("[")) {
                        str += ",";
                    }
                    str += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) {
                            str += val;
                        } else {
                            str += toString(val);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            str += "]";
            clazz = clazz.getSuperclass();
        }
        while (clazz != null);

        return str;
    }
}