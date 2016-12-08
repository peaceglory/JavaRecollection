package sources.newfeatures.java7;

import sources.reflection.ArrayGrower;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by mman on 05.12.16.
 */
public class ExceptionHandling {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperties());

        // Try-with-resources
        try (Scanner in = new Scanner(Paths.get("/media/mman/Data/Big Files/big.txt"));
             PrintWriter out = new PrintWriter("/media/mman/Data/Big Files/out.txt")) {
            while (in.hasNext()) {
                out.println(in.next());
            }
        }


        // Multiple exceptions caught.
        try (Scanner in = new Scanner(Paths.get("/media/mman/Data/Big Files/NOTHING.txt"));
             PrintWriter out = new PrintWriter("/media/mman/Data/Big Files/out.txt")) {
            while (in.hasNext()) {
                out.println(in.next());
            }
        } catch (RuntimeException | IOException e) {
            // Multiple exceptions caught.
        }

        // Common superclass for reflection related exceptions.
        try {
            Method m = Class.forName("sources.reflection.ArrayGrower").getMethod("growArray", Object.class);
            m.invoke(new ArrayGrower(), (Object)new String[] {"Ha", "Hi"});
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
