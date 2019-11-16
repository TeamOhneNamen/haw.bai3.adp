package p2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p2.datastructures.MinMaxHeap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxHeapTest {

    private MinMaxHeap<Integer> minMaxHeapExampleFromLecture;


    @BeforeEach
    void SetUp() {
        this.minMaxHeapExampleFromLecture = new MinMaxHeap<>(14);
        Integer[] intarry = {null,8,71,41,31,10,11,16,46,51,31,21,13};
        this.minMaxHeapExampleFromLecture.pq = intarry;
        this.minMaxHeapExampleFromLecture.N = 11;
    }

    @Test
    void insertNewSmallestElementWithMinMaxHeapExampleFromLecture() {
        this.minMaxHeapExampleFromLecture.insert(6);
        System.out.println(this.minMaxHeapExampleFromLecture);
        assertEquals(6, minMaxHeapExampleFromLecture.getMin());
    }

    @Test
    void insertNewGreatestElementWithMinMaxHeapExampleFromLecture() {
        this.minMaxHeapExampleFromLecture.insert(85);
        System.out.println(this.minMaxHeapExampleFromLecture);
        assertEquals(85, minMaxHeapExampleFromLecture.getMax());
    }

    @Test
    void getMinWithMinMaxHeapExampleFromLecture() {
        assertEquals(8, minMaxHeapExampleFromLecture.getMin());
    }

    @Test
    void getMaxWithMinMaxHeapExampleFromLecture() {
        assertEquals(71, minMaxHeapExampleFromLecture.getMax());
    }

    @Test
    void delMaxWithMinMaxHeapExampleFromLecture() {
        this.minMaxHeapExampleFromLecture.delMax();
        System.out.println(this.minMaxHeapExampleFromLecture);
        assertEquals(51, minMaxHeapExampleFromLecture.getMax());
    }
}
