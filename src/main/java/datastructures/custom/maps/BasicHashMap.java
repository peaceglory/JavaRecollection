package datastructures.custom.maps;

import java.util.*;

/**
 * Created by mman on 09.02.17.
 */
public class BasicHashMap<K, V> implements BasicMap<K, V> {
    private HashEntry[] buckets;
    private int size;
    private final float loadFactor;

    public BasicHashMap() {
        buckets = new HashEntry[10];
        size = 0;
        loadFactor = 0.7f;
    }

    public BasicHashMap(int size, float loadFactor) {
        buckets = new HashEntry[size];
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public BasicHashMap(int size) {
        this(size, 0.7f);
    }

    @Override
    public V put(K key, V value) {
        V prevValue = null;
        if (needsResize()) {
            resize();
        }
        int slot = findBucket(key);
        if (buckets[slot] == null) {
            buckets[slot] = new HashEntry(key, value);
        } else {
            HashEntry curr = buckets[slot];
            if (curr.getKey().equals(key)) {
                prevValue = (V) curr.getValue();
                curr.setValue(value);
            } else { // Collision
                buckets[slot] = new HashEntry(key, value, curr);
            }
        }
        if (prevValue == null) { //There's a new entry.
            size++;
        }
        return prevValue;
    }

    @Override
    public V get(K key) {
        int slot = findBucket(key);
        HashEntry entry = buckets[slot];
        if (entry != null) {
            do {
                if (entry.getKey().equals(key)) {
                    return (V) entry.getValue();
                }
                entry = entry.getNext();
            } while (entry != null);
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public List<K> getKeys() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> getEntrySet() {
        return null;
    }

    private static final class HashEntry<K, V> implements BasicMap.Entry<K, V> {
        private K key;
        private V value;
        private HashEntry next;

        private HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private HashEntry(K key, V value, HashEntry next) {
            this(key, value);
            setNext(next);
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V newValue) {
            this.value = newValue;
        }

        private boolean hasNext() {
            return next != null;
        }

        private HashEntry getNext() {
            return next;
        }

        private void setNext(HashEntry next) {
            this.next = next;
        }

    }

    /* TODO: Needs testing */
    class BasicHashMapIterator implements Iterator<HashEntry> {
        private HashEntry currEntry;
        private int currBucket;

        BasicHashMapIterator() {
            currEntry = null;
            currBucket = -1;
        }

        @Override
        public boolean hasNext() {
            if (currEntry != null && currEntry.hasNext()) {
                return true;
            }
            for (int b = currBucket + 1; b < buckets.length; b++) {
                if (buckets[b] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public HashEntry next() {
            if (currEntry != null && currEntry.hasNext()) {
                currEntry = currEntry.getNext();
                return currEntry;
            }
            for (currBucket = currBucket + 1; currBucket < buckets.length; currBucket++) {
                if (buckets[currBucket] != null) {
                    currEntry = buckets[currBucket];
                    return currEntry;
                }
            }
            throw new NoSuchElementException("No next element found");
        }
    }

    private boolean needsResize() {
        return (float) size / (float) buckets.length >= loadFactor;
    }

    private void resize() {
        buckets = Arrays.copyOf(buckets, 2 * buckets.length);
    }

    /* TODO: Needs improvement since the calculated slot is often the same for different keys! */
    private int findBucket(K key) {
        int hash = Objects.hashCode(key);
        return hash % buckets.length;
    }

    public static void main(String[] args) {
        int size = 2;
        int length = 5;
        System.out.println((float) size / (float) length);
    }

}
