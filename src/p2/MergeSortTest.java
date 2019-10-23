package p2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MergeSortTest {


    private List<Integer> sortedIntListA;
    private List<Integer> sortedIntListB;
    private List<Integer> sortedIntListAAndBMerged;

    private WaitingQueue<Integer> sortedIntWaitingQueueA;
    private WaitingQueue<Integer> sortedIntWaitingQueueB;
    private WaitingQueue<Integer> sortedIntWaitingQueueAAndBMerged;

    @BeforeEach
    void SetUp() {
        this.sortedIntListA = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        this.sortedIntListB = List.of(17, 18, 19, 20);
        this.sortedIntListAAndBMerged = List.of(2, 3, 5, 7, 11, 13, 17, 17, 18, 19, 19, 20, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        this.sortedIntWaitingQueueA = new WaitingQueue<>(this.sortedIntListA);
        this.sortedIntWaitingQueueB = new WaitingQueue<>(this.sortedIntListB);
        this.sortedIntWaitingQueueAAndBMerged = new WaitingQueue<>(this.sortedIntListAAndBMerged);

    }


    @Test
    void mergeSortedLists(){
        assertEquals(this.sortedIntWaitingQueueAAndBMerged, MergeSort.mergeSortedLists(this.sortedIntWaitingQueueA, this.sortedIntWaitingQueueB));
    }
}
