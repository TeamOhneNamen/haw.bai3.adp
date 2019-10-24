package p2.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p2.util.MergeSort;
import p2.datastructures.WaitingQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortTest {


    private List<Integer> singleElementIntListA;
    private List<Integer> singleElementIntListB;
    private List<Integer> singleElementIntListAAndBMerged;
    private List<Integer> sortedIntListA;
    private List<Integer> reversedIntListA;
    private List<Integer> shuffledIntListA;
    private List<Integer> sortedIntListB;
    private List<Integer> sortedIntListAAndBMerged;

    private WaitingQueue<Integer> singleElementWaitingQueueA;
    private WaitingQueue<Integer> singleElementWaitingQueueB;
    private WaitingQueue<Integer> singleElementWaitingQueueAANdBMerged;

    private WaitingQueue<Integer> singleElementWaitingQueueBAndsortedIntWaitingQueueBBMerged;
    private WaitingQueue<Integer> sortedIntWaitingQueueA;
    private WaitingQueue<Integer> sortedIntWaitingQueueB;
    private WaitingQueue<Integer> sortedIntWaitingQueueAAndBMerged;

    @BeforeEach
    void SetUp() {
        this.singleElementIntListA = List.of(47);
        this.singleElementIntListB = List.of(11);
        this.singleElementIntListAAndBMerged = List.of(11, 47);
        this.sortedIntListA = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        this.sortedIntListB = List.of(17, 18, 19, 20);
        this.sortedIntListAAndBMerged = List.of(2, 3, 5, 7, 11, 13, 17, 17, 18, 19, 19, 20, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        this.reversedIntListA = new ArrayList<>(sortedIntListA);
        Collections.reverse(reversedIntListA);
        this.shuffledIntListA = new ArrayList<>(sortedIntListA);
        Collections.shuffle(shuffledIntListA);


        this.sortedIntWaitingQueueA = new WaitingQueue<>(this.sortedIntListA);
        this.sortedIntWaitingQueueB = new WaitingQueue<>(this.sortedIntListB);
        this.sortedIntWaitingQueueAAndBMerged = new WaitingQueue<>(this.sortedIntListAAndBMerged);
        this.sortedIntWaitingQueueA = new WaitingQueue<>(this.sortedIntListA);
        this.sortedIntWaitingQueueB = new WaitingQueue<>(this.sortedIntListB);
        this.sortedIntWaitingQueueAAndBMerged = new WaitingQueue<>(this.sortedIntListAAndBMerged);
        this.singleElementWaitingQueueA = new WaitingQueue<>(this.singleElementIntListA);
        this.singleElementWaitingQueueB = new WaitingQueue<>(this.singleElementIntListB);
        this.singleElementWaitingQueueAANdBMerged = new WaitingQueue<>(this.singleElementIntListAAndBMerged);
        this.singleElementWaitingQueueBAndsortedIntWaitingQueueBBMerged = new WaitingQueue<>(List.of(11,17,18,19,20));

    }


    @Test
    void mergeSortedLists(){
        Assertions.assertEquals(this.sortedIntWaitingQueueAAndBMerged, MergeSort.mergeSortedLists(this.sortedIntWaitingQueueA, this.sortedIntWaitingQueueB));
    }

    @Test
    void mergeSortedListsSingleElementListsSmallerElementLast(){
        Assertions.assertEquals(this.singleElementWaitingQueueAANdBMerged, MergeSort.mergeSortedLists(this.singleElementWaitingQueueA, this.singleElementWaitingQueueB));
    }

    @Test
    void mergeSortedListsSingleElementListsSmallerElementFirst(){
        Assertions.assertEquals(this.singleElementWaitingQueueAANdBMerged, MergeSort.mergeSortedLists(this.singleElementWaitingQueueB, this.singleElementWaitingQueueA));
    }

    @Test
    void mergeSortedListsSingleElementAndSortedIntListsSmallerElementFirst(){
        Assertions.assertEquals(this.singleElementWaitingQueueBAndsortedIntWaitingQueueBBMerged, MergeSort.mergeSortedLists(this.singleElementWaitingQueueB, this.sortedIntWaitingQueueB));
    }

    @Test
    void topDownReservedIntList(){
        Assertions.assertEquals(sortedIntListA, MergeSort.topDown(reversedIntListA));
    }

    @Test
    void topDownShuffledIntList(){
        Assertions.assertEquals(sortedIntListA, MergeSort.topDown(reversedIntListA));
    }

    @Test
    void topDownSortedIntList(){
        Assertions.assertEquals(sortedIntListA, MergeSort.topDown(sortedIntListA));
    }
}
