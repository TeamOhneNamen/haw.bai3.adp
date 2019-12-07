package p3.interfaces;

public interface ITree<Key, Value> {
    void changeKey(Key old, Key newKey);
    boolean isOrdered();
}
