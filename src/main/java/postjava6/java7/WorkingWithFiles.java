package postjava6.java7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by mman on 06.12.16.
 */
public class WorkingWithFiles {

    public static void main(String[] args) throws IOException {
        Path absolute = Paths.get("/", "home", "mman");
        System.out.println("absolute: " + absolute);
        Path relative = Paths.get("conf", "textfile.txt");
        System.out.println("relative: " + relative);

        absolute = Paths.get("/home/mman/programs");
        System.out.println("absolute2: " + absolute);

        Path configPath = absolute.resolve("conf/textfile.txt");
        System.out.println("resolved: " + configPath);

        Path relativezed = absolute.relativize(Paths.get("/home/mman/tmp"));
        System.out.println("relativized: " + relativezed);

        // Reading files.
        Path filePath = relative.toAbsolutePath();
        byte[] bytes = Files.readAllBytes(filePath);
        System.out.println("textfile.txt: " + new String(bytes, StandardCharsets.UTF_8));

        List<String> lines = Files.readAllLines(filePath);
        lines.forEach((str) -> System.out.println(str));

        // Writing files.
        Path out = Paths.get("conf", "out.txt");
        Files.write(out, bytes);
        Files.write(out, lines);

        // For big or binary files.
        InputStream inS = Files.newInputStream(filePath);
        inS.read(bytes);
        OutputStream outS = Files.newOutputStream(out);
        outS.write(bytes);

        // Copy from input stream
        Path newFile = Paths.get("conf/out2.txt");
        Files.deleteIfExists(newFile);
        inS = Files.newInputStream(filePath);
        Files.copy(inS, newFile);
    }
}
