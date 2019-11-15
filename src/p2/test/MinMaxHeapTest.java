package p2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p2.datastructures.MinMaxHeap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMaxHeapTest {

    private MinMaxHeap<Integer> minMaxHeapOfSortedintListLength3;
    private MinMaxHeap<Integer> minMaxHeapOfSortedintListLength10;
    private MinMaxHeap<Integer> minMaxHeapOfUnsortedintListLength10;
    private MinMaxHeap<Integer> minMaxHeapExampleFromWikipediaAndLecture;
    private MinMaxHeap<Integer> minMaxHeapExampleFromWikipediaAndLectureForInsertion;


    @BeforeEach
    void SetUp() {
        this.minMaxHeapOfSortedintListLength3 = new MinMaxHeap<>(List.of(1, 2, 3));
        this.minMaxHeapOfSortedintListLength10 =
                new MinMaxHeap<>(List.of(11, 12, 23, 44, 45, 46, 77, 78, 89, 90));
        this.minMaxHeapOfUnsortedintListLength10 =
                new MinMaxHeap<>(List.of(3, 4, 0, 2, 1, 6, 8, 9, 7, 5));
        this.minMaxHeapExampleFromWikipediaAndLecture =
                new MinMaxHeap<>(List.of(46, 51, 31, 21, 13, 31, 10, 71, 8, 41, 11, 16));
        this.minMaxHeapExampleFromWikipediaAndLectureForInsertion = new MinMaxHeap<>(14);
        Integer[] intarry = {null,8,71,41,31,10,11,16,46,51,31,21,13};
        this.minMaxHeapExampleFromWikipediaAndLectureForInsertion.pq = intarry;
        this.minMaxHeapExampleFromWikipediaAndLectureForInsertion.N = 11;
    }

    @Test
    void minMaxHeapOfSortedintListLength3GetMin() {
        assertEquals(1, minMaxHeapOfSortedintListLength3.getMin());
    }

    @Test
    void minMaxHeapOfSortedintListLength3GetMax() {
        System.out.println(this.minMaxHeapOfSortedintListLength3);
        assertEquals(3, minMaxHeapOfSortedintListLength3.getMax());

    }

    @Test
    void minMaxHeapOfSortedintListLength10GetMin() {
        assertEquals(11, minMaxHeapOfSortedintListLength10.getMin());
    }

    @Test
    void minMaxHeapOfSortedintListLength10GetMax() {
        System.out.println(this.minMaxHeapOfSortedintListLength10);
        assertEquals(90, minMaxHeapOfSortedintListLength10.getMax());
    }

    @Test
    void minMaxHeapExampleFromWikipediaAndLectureGetMax() {
        System.out.println(this.minMaxHeapExampleFromWikipediaAndLecture);
        assertEquals(71, minMaxHeapExampleFromWikipediaAndLecture.getMax());
    }

    @Test
    void minMaxHeapExampleFromWikipediaAndLectureGetMin() {
        assertEquals(8, minMaxHeapExampleFromWikipediaAndLecture.getMin());
    }

    @Test
    void minMaxHeapExampleFromWikipediaAndLectureForInsertionInsertNewSmallestElement() {
        this.minMaxHeapExampleFromWikipediaAndLectureForInsertion.insert(6);
        System.out.println(this.minMaxHeapExampleFromWikipediaAndLectureForInsertion);
        assertEquals(6, minMaxHeapExampleFromWikipediaAndLectureForInsertion.getMin());
    }

    @Test
    void minMaxHeapExampleFromWikipediaAndLectureForInsertionInsertNewGreatestElement() {
        this.minMaxHeapExampleFromWikipediaAndLectureForInsertion.insert(85);
        System.out.println(this.minMaxHeapExampleFromWikipediaAndLectureForInsertion);
        assertEquals(85, minMaxHeapExampleFromWikipediaAndLectureForInsertion.getMax());
    }

    @Test
    void minMaxHeapExampleFromWikipediaAndLectureForInsertionGetMin() {
        assertEquals(8, minMaxHeapExampleFromWikipediaAndLectureForInsertion.getMin());
    }

    @Test
    void minMaxHeapExampleFromWikipediaAndLectureForInsertionGetMax() {
        assertEquals(71, minMaxHeapExampleFromWikipediaAndLectureForInsertion.getMax());
    }

    @Test
    void minMaxHeapOfUnsortedintListLength10GetMax() {
        System.out.println(this.minMaxHeapOfUnsortedintListLength10);
        assertEquals(9, minMaxHeapOfUnsortedintListLength10.getMax());
    }

    @Test
    void minMaxHeapOfUnsortedintListLength10GetMin() {
        assertEquals(0, minMaxHeapOfUnsortedintListLength10.getMin());
    }
}
