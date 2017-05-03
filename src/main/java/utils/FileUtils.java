package utils;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mman on 04.03.17.
 */
public class FileUtils {

    public static void traverseDirectoryBFS(File dir) {
        ensureDirInput(dir);

        Queue<File> q = new LinkedList<>();
        q.add(dir);

        while (!q.isEmpty()) {
            File f = q.poll();
            System.out.println(f.getName());
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory() && !file.getName().startsWith(".")) {
                    q.add(file);
                }
            }
        }
    }

    public static void traverseDirectoryDFS(File dir) {
        ensureDirInput(dir);

        Stack<File> stack = new Stack<>();
        stack.push(dir);

        while (!stack.isEmpty()) {
            File f = stack.pop();
            System.out.println(f.getName());
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory() && !file.getName().startsWith(".")) {
                    stack.add(file);
                }
            }
        }
    }

    private static void ensureDirInput(File f) {
        if (!f.isDirectory()) {
            throw new IllegalArgumentException("Not a dir: " + f.getName());
        }
    }
}
