package p3.interfaces;

public interface ITree<Key extends Comparable<? super Key>, Value>  {

    /**
     * method to change a key of a node in a tree
     * @param old
     * @param newKey
     */
    void changeKey(Key old, Key newKey);

    /**
     *
     * @param minKey
     * @param maxKey
     * @return
     */
    boolean isOrdered(Key minKey, Key maxKey);
}
