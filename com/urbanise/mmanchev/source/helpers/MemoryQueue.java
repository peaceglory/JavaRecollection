package com.urbanise.mmanchev.source.helpers;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by mman on 25.02.17.
 *
 * Equal elements can be added only once until clearMemory is called.
 */
public class MemoryQueue<T> {
    private final Queue<T> queue;
    private final Set<T> memory;

    public MemoryQueue() {
        queue = new LinkedList<>();
        memory = new HashSet<>();
    }

    public void offer(T element) {
        if (!memory.contains(element)) {
            queue.add(element);
            memory.add(element);
        }
    }

    public T remove() {
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clearMemory() {
        memory.clear();
    }
}
