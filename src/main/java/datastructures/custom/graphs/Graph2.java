package datastructures.custom.graphs;

import com.urbanise.mmanchev.source.helpers.MemoryQueue;

import java.util.*;

/**
 * Created by mman on 22.02.17.
 */
public class Graph2 {
    private Map<String, Vertex> dependencies = new HashMap<>();
    private String[] tmpInput = { // Needs to come from console input or a file.
            "A B C",
            "B C E",
            "C G",
            "D A F",
            "E F",
            "F H"
    };

    private static class Vertex {
        String name;
        List<Vertex> adjacent;

        Vertex(String name) {
            this.name = name;
            this.adjacent = new LinkedList<>();
        }
    }

    public Graph2() {
        fillDependencies();
    }

    public void showFullDependencies() {
        Iterator<Vertex> dependanciesIterator = dependencies.values().iterator();
        MemoryQueue<Vertex> queue = new MemoryQueue<>();

        while (dependanciesIterator.hasNext()) {
            Vertex start = dependanciesIterator.next();
            queue.offer(start);

            while (!queue.isEmpty()) {
                Vertex vertex = queue.remove();
                System.out.print(vertex.name + " ");
                if (!vertex.adjacent.isEmpty()) {
                    vertex.adjacent.forEach(queue::offer);
                }
            }

            queue.clearMemory();
            System.out.println(); // Consider calling this from an util class.
        }
    }

    private void fillDependencies() {
        String[] feedLine;

        for (String s : tmpInput) {
            feedLine = s.split(" ");
            Vertex dependant = dependencies.get(feedLine[0]); // For the testing check for empty array or nulls

            if (dependant == null) {
                dependant = new Vertex(feedLine[0]);
                dependencies.put(feedLine[0], dependant);
            }

            for (int i = 1; i < feedLine.length; i++) {
                Vertex dependee = dependencies.get(feedLine[i]);
                if (dependee == null) {
                    dependee = new Vertex(feedLine[i]);
                    dependencies.put(dependee.name, dependee);
                }
                dependant.adjacent.add(dependee);
            }
        }
    }

    public static void main(String[] args) {
        DependencyGraph g = new DependencyGraph();
        g.showFullDependencies();
        System.out.println();
    }
}
