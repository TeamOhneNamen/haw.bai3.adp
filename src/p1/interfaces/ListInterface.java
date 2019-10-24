package p1.interfaces;

/**
 * Interface for a List with a gernerig Interafce
 * @param <E>
 */
public interface ListInterface<E> extends Iterable<E> {

    /**
     * delete last element
     */
    void removeLast();

    /**
     * delete first element
     */
    void removeFirst();

    /**
     * delete first occurrence of the item
     *
     * @param item
     * @return boolean if item was deleted
     */
    boolean remove(E item);

    /**
     * delete element at the position i
     * @param i position
     */
    void deleteAtPosition(int i);

    /**
     * delete all occurrences of the item
     * @param item
     */
    void deleteAllOccurrences(E item);

    /**
     * Inserts an item at the position i
     * @param i
     * @param item
     */
    void insertAtPosition(int i, E item);

    /**/

    /**
     * Retrieve the item at the position i
     * @param i
     * @return item at position i
     */
    E retrieve(int i);
}