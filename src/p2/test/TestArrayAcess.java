package p2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p2.datastructures.WaitingQueue;
import p2.edu.princeton.cs.algs4.Merge;
import p2.util.MergeSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayAcess {

    private List<Integer> sortedIntList;
    private List<Comparable> shuffledIntList;

    private List<Integer> sortedIntListWorst;
    private List<Comparable> shuffledIntListWorst;


    @BeforeEach
    void SetUp() {

        this.sortedIntList = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);

        this.sortedIntListWorst = List.of(4, 6, 2, 7, 3, 5, 1);

        this.shuffledIntList = new ArrayList<>(sortedIntList);
        Collections.shuffle(shuffledIntList);

        this.shuffledIntListWorst = new ArrayList<>(sortedIntListWorst);
        Collections.shuffle(shuffledIntListWorst);

    }

    @Test
    void countSmalerThenExpected() {
        Merge.sort(this.shuffledIntList.toArray(Comparable[]::new));
        System.out.println(this.shuffledIntList.size());
        System.out.println("-------------------------------");
        System.out.println(Merge.arrayAccessCount);
        System.out.println(6 * this.shuffledIntList.size() * Math.log(this.shuffledIntList.size())/Math.log(2));
        Assertions.assertTrue(Merge.arrayAccessCount<6 * this.shuffledIntList.size() * Math.log(this.shuffledIntList.size())/Math.log(2));

    }

}
