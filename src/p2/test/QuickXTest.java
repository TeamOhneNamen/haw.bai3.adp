package p2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p2.util.QuickX;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickXTest {

    private Integer[] sortedIntListA = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
            47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    @Test
    void quickXTestSortedIntListAPositive(){
        QuickX.sort(this.sortedIntListA);
        Assertions.assertTrue(QuickX.isSorted(this.sortedIntListA));
    }

    @Test
    void quickXTestReverseSortedIntListAPositive(){
        List<Integer> reversedIntListA = Arrays.asList(sortedIntListA);
        Collections.reverse(reversedIntListA);
        Integer[] reversedIntArray = new Integer[reversedIntListA.size()];
        reversedIntListA.toArray(reversedIntArray);
        QuickX.sort(reversedIntArray);
        Assertions.assertTrue(QuickX.isSorted(reversedIntArray));
    }

    @Test
    void quickXTestUnsortedIntListAPositive(){
        List<Integer> shuffledIntListA = Arrays.asList(sortedIntListA);
        Collections.shuffle(shuffledIntListA);
        Integer[] shuffledIntArray = new Integer[shuffledIntListA.size()];
        shuffledIntListA.toArray(shuffledIntArray);
        QuickX.sort(shuffledIntArray);
        Assertions.assertTrue(QuickX.isSorted(shuffledIntArray));
    }
}
