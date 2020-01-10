package p4.VerkettetesHashing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestVerkettetesHashing {

    VerkettetesHashing vh = new VerkettetesHashing(6);
    String vip = "VERYIMPORTANTPERSON";

    @BeforeEach
    public void setUp(){
        vh.add(vip);
    }

    @Test
    public void testVhVIP(){
        System.out.println(vh);
    }

}
