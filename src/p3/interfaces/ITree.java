package p3.interfaces;

public interface ITree<Key extends Comparable<? super Key>, Value>  {
    void changeKey(Key old, Key newKey);
    boolean isOrdered(Key minKey, Key maxKey);
}
