package p2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p2.datastructures.MinMaxHeap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxHeapTest {

    private MinMaxHeap<Integer> minMaxHeapExampleFromLecture;
    private Integer[] intarry = {null,8,71,41,31,10,11,16,46,51,31,21,13};
    private final int minMaxHeapExampleFromLectureN = intarry.length-2;


    @BeforeEach
    void SetUp() {
        this.minMaxHeapExampleFromLecture = new MinMaxHeap<>(14);
        this.minMaxHeapExampleFromLecture.pq = intarry;
        this.minMaxHeapExampleFromLecture.N = minMaxHeapExampleFromLectureN;
    }

    @Test
    void insertNewSmallestElementWithMinMaxHeapExampleFromLecture() {
        this.minMaxHeapExampleFromLecture.insert(6);
        assertEquals(6, minMaxHeapExampleFromLecture.min());
    }

    @Test
    void insertNewGreatestElementWithMinMaxHeapExampleFromLecture() {
        this.minMaxHeapExampleFromLecture.insert(85);
        assertEquals(85, minMaxHeapExampleFromLecture.max());
    }

    @Test
    void minWithMinMaxHeapExampleFromLecture() {
        assertEquals(8, minMaxHeapExampleFromLecture.min());
    }

    @Test
    void maxWithMinMaxHeapExampleFromLecture() {
        assertEquals(71, minMaxHeapExampleFromLecture.max());
    }

    @Test
    void delMaxWithMinMaxHeapExampleFromLecture() {
        int sizeBeforeDelMax = this.minMaxHeapExampleFromLecture.size();
        this.minMaxHeapExampleFromLecture.delMax();
        assertEquals(51, minMaxHeapExampleFromLecture.max());
        assertEquals(sizeBeforeDelMax-1, minMaxHeapExampleFromLecture.size());
    }

    @Test
    void delMinWithMinMaxHeapExampleFromLecture() {
        int sizeBeforeDelMin = this.minMaxHeapExampleFromLecture.size();
        this.minMaxHeapExampleFromLecture.delMin();
        assertEquals(sizeBeforeDelMin-1, minMaxHeapExampleFromLecture.size());
        assertEquals(10, minMaxHeapExampleFromLecture.min());

    }

    @Test
    void getIndexOfLargestChildOrGrandChildTest() {
        assertEquals(71, minMaxHeapExampleFromLecture.get(minMaxHeapExampleFromLecture.getIndexOfLargestChildOrGrandChild(1)));
    }

    @Test
    void getIndexOfSmallestChildOrGrandChildTest() {
        assertEquals(10, minMaxHeapExampleFromLecture.get(minMaxHeapExampleFromLecture.getIndexOfSmallestChildOrGrandChild(1)));
    }
}
