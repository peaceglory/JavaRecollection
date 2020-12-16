package algorithms;

import utils.FileUtils;

import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Test;



/**
 * Created by mman on 24.10.16.
 */
class DirectoryTraverseTest {

    @Test
    void testBreadthFirstSearch() {
        File userInput = new File(System.getProperty("user.dir"));
        FileUtils.traverseDirectoryBFS(userInput);
    }

    @Test
    void testDepthFirstSearch() {
        File userInput = new File(System.getProperty("user.dir"));
        FileUtils.traverseDirectoryDFS(userInput);
    }
}
