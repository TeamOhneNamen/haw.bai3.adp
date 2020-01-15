package p4;

import p3.datastructures.Queue;

public class BinarySearchMultiST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 2;

    public BinarySearchMultiST() {
        keys = (Key[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
        values = (Value[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public BinarySearchMultiST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return null != get(key);
    }

    public Value get(Key key) {
        if (null == key) {
            throw new IllegalArgumentException("Argument to get() cannot be null");
        }

        if (isEmpty()) {
            return null;
        }

        int rank = rankLast(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            return values[rank];
        } else {
            return null;
        }
    }

    public Iterable<Value> getAll(Key key) {
        Queue<Value> values = new Queue<>();

        if (!contains(key)) {
            return values;
        }

        //GET RANGE OF VALUES OF KEY
        int rankFirst = rankFirst(key);
        int rankLast = rankLast(key);

        //add all values of key to queue between in the Range
        for (int index = rankFirst; index < rankLast; index++) {
            values.enqueue(this.values[index]);
        }

        if (rankLast < size && keys[rankLast].equals(key)) {
            values.enqueue(this.values[rankLast]);
        }

        return values;
    }

    public int rankFirst(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int low = 0;
        int high = size - 1;

        int rankFound = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            int comparison = key.compareTo(keys[middle]);
            if (comparison < 0) {
                high = middle - 1;
            } else if (comparison > 0) {
                low = middle + 1;
            } else {
                rankFound = middle;
                high = middle - 1;
            }
        }

        if (rankFound != -1) {
            return rankFound;
        } else {
            return low;
        }
    }

    public int rankLast(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int low = 0;
        int high = size - 1;

        int rankFound = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            int comparison = key.compareTo(keys[middle]);
            if (comparison < 0) {
                high = middle - 1;
            } else if (comparison > 0) {
                low = middle + 1;
            } else {
                rankFound = middle;
                low = middle + 1;
            }
        }

        if (rankFound != -1) {
            return rankFound;
        } else {
            return low;
        }
    }

    //In the case of duplicates, return the rank of the rightmost key
    public int rank(Key key) {
        return rankLast(key);
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (value == null) {
            delete(key);
            return;
        }

        if (size == keys.length) {
            grow();
        }

        int rank = rankLast(key);

        for (int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        size++;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() cannot be null");
        }

        if (isEmpty() || !contains(key)) {
            return;
        }

        while (contains(key)) {
            int rank = rankLast(key);
            for (int i = rank; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }

            keys[size - 1] = null;
            values[size - 1] = null;
            size--;

            if (size > 1 && size == keys.length / 4) {
                shrink();
            }
        }


    }

    private void shrink(){
        this.resize(this.keys.length/2);
    }
    private void grow(){
        this.resize(this.keys.length*2);
    }
    private void resize(int newSize) {
        Key[] tempKeys = (Key[]) new Comparable[newSize];
        Value[] tempValues = (Value[]) new Object[newSize];

        System.arraycopy(keys, 0, tempKeys, 0, size);
        System.arraycopy(values, 0, tempValues, 0, size);

        keys = tempKeys;
        values = tempValues;
    }
}
