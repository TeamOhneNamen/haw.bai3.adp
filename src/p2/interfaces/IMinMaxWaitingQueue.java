package p2.interfaces;

public interface IMinMaxWaitingQueue {

    /**
     * return size of the heap
     * @return
     */
    int size();

    /**
     * check if heap is empty or not
     * @return
     */
    Boolean isEmpty();

    /**
     * insert specified key into the heap
     * @param key
     */
    void insert(Integer key);

    /**
     * function to remove and return element with highest priority
     * (present at root). It returns null if queue is empty
     * @return null if queue is empty
     */
    Integer delMax();

    /**
     * function to return, but does not remove, element with highest priority
     * (present at root). It returns null if queue is empty
     * @return null if queue is empty
     */
    Integer max();

    /**
     * function to remove all elements from priority queue
     */
    void clear();

    /**
     * @param i
     * @return if queue contains the specified element
     */
    Boolean contains(Integer i);

    /**
     * @return array containing all elements in the queue
     */
    Integer[] toArray();

}
