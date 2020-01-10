package p4.LinearesSondieren;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestLinearesSondieren {

    LinearesSondieren ls = new LinearesSondieren(20);
    String vi = "VERYIMPORTANTPERSON";

    @BeforeEach
    public void setUp(){
        ls.add(vi);
    }

    @Test
    public void testLsVI(){
        System.out.println(ls.toString());
    }

}
