package tests.algorithms

import sources.algorithms.DirectoryTraverse

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
        DirectoryTraverse dt = new DirectoryTraverse();
        File userInput = getUserInput();
        dt.breadthFirstSearch(userInput);
    }

    void testDepthFirstSearch() {
        DirectoryTraverse dt = new DirectoryTraverse();
        File userInput = getUserInput();
        dt.depthFirstSearch(userInput);
    }

    private static File getUserInput() {
        System.out.println("Enter a starting directory!: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return new File(input);
    }
}
