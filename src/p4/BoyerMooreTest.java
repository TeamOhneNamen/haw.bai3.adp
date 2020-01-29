package p4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BoyerMooreTest {
    @Test
    public void findAllTest(){
        String txt = "ABAB";
        String pattern = "A";
        BoyerMoore boyerMoore = new BoyerMoore(pattern);
        List<Integer> occurences = (List<Integer>) boyerMoore.findAll(txt);

        //Assertions.assertEquals(List.of(0,2), occurences);
    }
}
