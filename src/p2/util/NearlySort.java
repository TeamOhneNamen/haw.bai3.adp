package p2.util;

import java.util.List;
import java.util.PriorityQueue;

//https://www.techiedelight.com/sort-k-sorted-array/
public class NearlySort {
    // Function to sort a K-Sorted Array
    public static void sortKSortedArray(List<Integer> list, int k) {
        // create an empty min heap and insert first k+1 elements in the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k + 1));

        int index = 0;

        //TODO: gehe über das 2*k window über die liste
        // do for remaining elements of the array
        for (int i = k + 1; i < list.size(); i++) {
            // pop top element from min-heap and assign it to
            // next available array index
            list.set(index++, pq.poll());

            // push next array element into min-heap
            pq.add(list.get(i));
        }

        // pop all remaining elements from the min heap and assign it to
        // next available array index
        while (!pq.isEmpty()) {
            list.set(index++, pq.poll());
        }
    }
}