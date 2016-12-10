package tests.algorithms

import sources.utils.Utils
/**
 * Created by mman on 24.10.16.
 */
class DirectoryTraverseTest extends GroovyTestCase {

    public static void main(String[] args) {
        DirectoryTraverseTest test = new DirectoryTraverseTest();
//        test.testBreadthFirstSearch();
        test.testDepthFirstSearch();
    }

    void testBreadthFirstSearch() {
        File userInput = getUserInput();
        Utils.traverseDirectoryBFS(userInput);
    }

    void testDepthFirstSearch() {
        File userInput = getUserInput();
        Utils.traverseDirectoryDFS(userInput);
    }

    private static File getUserInput() {
        System.out.println("Enter a starting directory!: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return new File(input);
    }
}
