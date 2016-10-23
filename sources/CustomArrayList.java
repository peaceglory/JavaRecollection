package sources;

/**
 * Created by mman on 20.10.16.
 */
public class CustomArrayList {
    private int size = 0;
    private Object[] array = null;

    public CustomArrayList() {
        this(10);
    }

    public CustomArrayList(int capacity) {
        array = new Object[capacity];
    }

    public void add(int index, Object o) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index is: " + index);
        }
        if (!hasCapacity()) {
            growArray();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = o;
        size++;
    }

    public void add(Object o) {
        add(size, o);
    }

    public Object get(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index is: " + index);
        }
        return array[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public boolean remove(Object o) {
        int idx = indexOf(o);
        if (idx < 0) {
            return false;
        }
        Object removed = remove(idx);
        return o != null ? (removed != null) : (removed == null);
    }

    public Object remove(int idx) {
        if (!isValidIndex(idx)) {
            throw new IndexOutOfBoundsException("Index is: " + idx);
        }
        Object toRemove = array[idx];
        System.arraycopy(array, idx + 1, array, idx, size - 1 - idx);
        array[size - 1] = null;
        size--;
        return toRemove;
    }

    public void reverse() {
        if (size < 2) {
            return;
        }
        Object tmp = null;
        for (int i = 0; i < size/2; i++) {
            tmp = array[i];
            array[i] = array[(size-1) - i];
            array[(size-1) - i] = tmp;
        }
    }

    private boolean hasCapacity() {
        return size < array.length;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void growArray() {
        Object[] newArray = new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
