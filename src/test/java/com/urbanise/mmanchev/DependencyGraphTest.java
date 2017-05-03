package com.urbanise.mmanchev;

import com.urbanise.mmanchev.source.dataproviders.DataInputProvider;
import com.urbanise.mmanchev.source.exceptions.DataSourceNotFound;
import com.urbanise.mmanchev.source.graph.DependencyGraph;
import com.urbanise.mmanchev.source.graph.SimpleDependencyGraph;
import com.urbanise.mmanchev.source.helpers.DataProviderFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by mman on 26.02.17.
 */
public class DependencyGraphTest {
    private static final String testCasesPath = "conf/com/urbanise/tests/";

    private static final String CIRCLE = "circle.txt";
    private static final String EMPTY = "empty.txt";
    private static final String MAIN = "main.txt";
    private static final String MORE_DEPS = "more_dependencies.txt";
    private static final String NO_EDGES = "no_edges.txt";
    private static final String ONE_EDGE = "one_edge.txt";
    private static final String ONE_LONER = "one_loner.txt";

    @Test
    public void testCircular() {
        Path path = Paths.get(testCasesPath + CIRCLE).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Set<String> expected = new HashSet<>();
        expected.add("A B");
        expected.add("B A");

        assertExpected(expected, result);
    }

    @Test
    public void testEmpty() {
        Path path = Paths.get(testCasesPath + EMPTY).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testMain() {
        Path path = Paths.get(testCasesPath + MAIN).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Set<String> expected = new HashSet<>();
        expected.add("A B C E G F H");
        expected.add("B C E G F H");
        expected.add("C G");
        expected.add("D A F B C H E G");
        expected.add("E F H");
        expected.add("F H");

        assertExpected(expected, result);
    }

    @Test
    public void testMoreDependencies() {
        Path path = Paths.get(testCasesPath + MORE_DEPS).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Set<String> expected = new HashSet<>();
        expected.add("A B C D E F G H I");
        expected.add("I A B C D E F G H");
        expected.add("G E C");
        expected.add("C E G");
        expected.add("M A N B C D E F G H I");

        assertExpected(expected, result);
    }

    @Test
    public void testNoEdges() {
        Path path = Paths.get(testCasesPath + NO_EDGES).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Set<String> expected = new HashSet<>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");
        expected.add("E");
        expected.add("F");
        expected.add("G");

        assertExpected(expected, result);
    }

    @Test
    public void testOneEdge() {
        Path path = Paths.get(testCasesPath + ONE_EDGE).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Set<String> expected = new HashSet<>();
        expected.add("A");
        expected.add("B");
        expected.add("C D");
        expected.add("E");
        expected.add("F");

        assertExpected(expected, result);
    }

    @Test
    public void testOneLoner() {
        Path path = Paths.get(testCasesPath + ONE_LONER).toAbsolutePath();
        Exception error = null;
        List<String> result = null;

        try {
            result = parse(init(path.toString()));
        } catch (Exception e) {
            error = e;
        }

        Assert.assertNull(error);

        Set<String> expected = new HashSet<>();
        expected.add("A C E G I H");
        expected.add("B D F H");
        expected.add("C E G I H");
        expected.add("D F H");
        expected.add("E G I H");
        expected.add("F H");
        expected.add("G I H");
        expected.add("H");
        expected.add("I H");

        assertExpected(expected, result);
    }

    private String init(String dataFile) throws DataSourceNotFound, IOException {
        DataInputProvider input = DataProviderFactory.getDataProvider(dataFile);
        DependencyGraph dependencyGraph = new SimpleDependencyGraph(input.provide());
        return dependencyGraph.build();
    }

    private List<String> parse(String str) {
        Scanner scan = null;
        List<String> strList = new LinkedList<>();
        try {
            scan = new Scanner(str);
            while (scan.hasNextLine()) {
                strList.add(scan.nextLine());
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
        return strList;
    }

    private void assertExpected(Set<String> expected, List<String> result) {
        for (String s : result) {
            Assert.assertTrue(expected.contains(s), "Unknown result: [" + s + "]");
            expected.remove(s);
        }
        Assert.assertTrue(expected.isEmpty(), "Something expected didn't come!");
    }
}
