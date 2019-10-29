package p2.test;

import p2.datastructures.MinMaxWaitingQueue;

import java.util.Arrays;

public class MinMaxWaitingQueueTest {
    public static void main (String[] args)
    {
        // create a Priority Queue of initial capacity 10
        // Priority of an element is decided by element's value
        MinMaxWaitingQueue pq = new MinMaxWaitingQueue(10);

        // insert three integers
        pq.insert(3);
        pq.insert(2);
        pq.insert(15);

        // print Priority Queue size
        System.out.println("Priority Queue Size is " + pq.size());

        // search 2 in Priority Queue
        Integer searchKey = 2;

        if (pq.contains(searchKey)) {
            System.out.println("Priority Queue contains " + searchKey + "\n");
        }

        // empty queue
        pq.clear();

        if (pq.isEmpty()) {
            System.out.println("Queue is Empty");
        }

        System.out.println("\nCalling remove operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.delMax() + '\n');

        System.out.println("Calling max operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.max() + '\n');

        // again insert three integers
        pq.insert(5);
        pq.insert(4);
        pq.insert(45);

        // construct array containing all elements present in the queue
        Integer[] I = pq.toArray();
        System.out.println("Printing array: " + Arrays.toString(I));

        System.out.println("\nElement with highest priority is " + pq.delMax());
        System.out.println("Element with highest priority is " + pq.max());
    }
}
