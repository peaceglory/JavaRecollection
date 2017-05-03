package datastructures.stacks

import datastructures.custom.stacks.CustomDynamicStack

/**
 * Created by mman on 24.10.16.
 */
class CustomDynamicStackTest extends GroovyTestCase {

    void testPush() {
        CustomDynamicStack stack = new CustomDynamicStack();
        assert stack.pop() == null && stack.size() == 0;

        stack.push("A");
        assert stack.size() == 1 && stack.pop() == "A" && stack.size() == 0;

        stack.push("A").push("B").push("C");
        assert stack.size() == 3 && stack.pop() == "C" && stack.pop() == "B" && stack.pop() == "A";
    }

    void testPop() {

    }
}
