package sources.algorithms;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mman on 24.10.16.
 */
public class DirectoryTraverse {

    public void breadthFirstSearch(File dir) {
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

    public void depthFirstSearch(File dir) {
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

    private void ensureDirInput(File f) {
        if (!f.isDirectory()) {
            throw new IllegalArgumentException("Not a dir: " + f.getName());
        }
    }
}
