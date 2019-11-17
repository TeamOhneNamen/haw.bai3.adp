package p2.interfaces;

public interface IMinMaxHeap<Key extends Comparable<? super Key>> {
    void insert(Key k);
     Key max();
     Key min();
     Key delMin();
     Key delMax();
     int size();
}
