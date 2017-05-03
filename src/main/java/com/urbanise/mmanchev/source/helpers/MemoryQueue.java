package com.urbanise.mmanchev.source.helpers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * This class represents a queue with some memory for what elements have been previously added.
 * Equal elements can be added only once until memory is cleared via <name>clearMemory()</name> method.
 * This queue is unbounded and non-blocking.
 * This class is not thread-safe.
 *
 * @author mmanchev, 25.02.17
 */
public class MemoryQueue<T> {
    private final Queue<T> queue;
    private final Set<T> memory;

    /**
     * Constructs a MemoryQueue object.
     */
    public MemoryQueue() {
        queue = new LinkedList<>();
        memory = new HashSet<>();
    }

    /**
     * Tries to add an element to the queue.
     * The elements is added to the queue only if it hasn't been added previously, i.e. is not in the memory of the queue.
     * Equal elements can be added more than once only after memory is cleared. See clearMemory().
     *
     * @param element The element to be added to the queue only if not in the memory of the queue.
     */
    public void offer(T element) {
        if (!memory.contains(element)) {
            queue.add(element);
            memory.add(element);
        }
    }

    /**
     * Removes the head of this queue. Note that it doesn't make the queue "forget" about this element.
     *
     * @return the head of this queue.
     */
    public T remove() {
        return queue.remove();
    }

    /**
     * Returns true if this queue does not contain elements.
     *
     * @return true if this queue does not contain elements.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Clears the memory of this queue, meaning that elements that have been already added previously to this queue,
     * can be added again.
     */
    public void clearMemory() {
        memory.clear();
    }
}
