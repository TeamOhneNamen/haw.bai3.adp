package p1.interfaces;

public interface ListInterface<E> extends Iterable<E> {
    /*delete last element*/
    void removeLast();

    /*delete first element*/
    void removeFirst();

    /*delete element at the position i*/
    void deleteAtPosition(int i);

    /*Inserts an item at the position i*/
    void insertAtPosition(int i, E item);

    /*Retrieve the item at the position i*/
    E retrieve(int i);
}