package sources.datastructures.custom.graphs;

import com.urbanise.mmanchev.source.helpers.MemoryQueue;

import java.util.*;

/**
 * Created by mman on 22.02.17.
 */
public class DependencyGraph {
    private Map<String, List<String>> adjMap = new HashMap<>();
    private String[] tmpInput = { // Needs to come from console input or a file.
            "A B C",
            "B C E",
            "C G",
            "D A F",
            "E F",
            "F H"
    };

    public DependencyGraph() {
        fillAdjMap();
    }

    public void showFullDependencies() {
        Iterator<String> adjMapKeySetIterator = adjMap.keySet().iterator();
        MemoryQueue<String> queue = new MemoryQueue<>();

        while (adjMapKeySetIterator.hasNext()) {
            String start = adjMapKeySetIterator.next();
            queue.offer(start);

            while (!queue.isEmpty()) {
                String s = queue.remove();
                System.out.print(s + " ");
                List<String> dependencies = adjMap.get(s);
                if (dependencies != null) {
                    dependencies.forEach(queue::offer);
                }
            }

            queue.clearMemory();
            System.out.println(); // Consider calling this from an util class.
        }
    }

    private void fillAdjMap() {
        String[] feedLine;
        List<String> adjList;

        for (String s : tmpInput) {
            feedLine = s.split(" ");
            adjList = new LinkedList<>();
            adjMap.put(feedLine[0], adjList); // For the testing check for empty array or nulls

            for (int i = 1; i < feedLine.length; i++) {
                adjMap.get(feedLine[0]).add(feedLine[i]);
            }
        }
    }

    public static void main(String[] args) {
        DependencyGraph g = new DependencyGraph();
        g.showFullDependencies();
        System.out.println();
    }
}
