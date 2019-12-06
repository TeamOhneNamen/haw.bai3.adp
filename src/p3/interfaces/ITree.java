package p3.interfaces;

public interface ITree<Key> {
    void changeKey(Key old, Key newKey);
    boolean isOrdered();
}
