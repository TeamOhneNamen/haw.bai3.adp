package p2.interfaces;

import java.util.List;

public interface IWarteschlange<E> {

    /**
     * deletes and returns the first element
     * @return the deleted Element
     */
    E pop();

    /**
     * inserting the item into the Queue
     * @param item
     */
    void push(E item);

}
