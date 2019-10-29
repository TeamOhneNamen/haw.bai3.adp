package p2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p2.util.NearlySort;

import java.util.Arrays;
import java.util.List;

public class NearlySortTest {
    @Test
    void sortKSortedArrayTest(){
        List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        int k = 2;
        NearlySort.sortKSortedArray(list, k);
        Assertions.assertTrue(TestUtil.isSorted(list));
    }
}
