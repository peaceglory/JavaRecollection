package algorithms;

import org.testng.annotations.Test;
import utils.FileUtils;

import java.io.File;
import java.util.Scanner;

/**
 * Created by mman on 24.10.16.
 */
public class DirectoryTraverseTest {

    public static void main(String[] args) {
        DirectoryTraverseTest test = new DirectoryTraverseTest();
//        test.testBreadthFirstSearch();
        test.testDepthFirstSearch();
    }

    @Test
    public void testBreadthFirstSearch() {
        File userInput = getUserInput();
        FileUtils.traverseDirectoryBFS(userInput);
    }

    @Test
    public void testDepthFirstSearch() {
        File userInput = getUserInput();
        FileUtils.traverseDirectoryDFS(userInput);
    }

    private static File getUserInput() {
        System.out.println("Enter a starting directory!: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return new File(input);
    }

}
