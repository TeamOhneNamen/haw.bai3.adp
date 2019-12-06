package p3.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p3.datastructures.ArrayST;

public class ArraySTTest {
    String[] keys = {"eins", "zwei", "drei"};
    String[] values = {"one", "two", "three"};
    ArrayST<String, String> emptyUnsortedStringArrayST;
    ArrayST<String, String> emptySortedStringArrayST;


    @BeforeEach
    void SetUp() {
        this.emptyUnsortedStringArrayST =  new  ArrayST<>();
        this.emptySortedStringArrayST = new ArrayST<>(true,10);
    }

    @Test
    void setTest(){
        int i = 0;
        this.emptyUnsortedStringArrayST.set(this.keys[i],this.values[i]);
        Assertions.assertEquals("{eins : one}",this.emptyUnsortedStringArrayST.toString());
    }

    @Test
    void setWithArraysTest(){
        this.emptyUnsortedStringArrayST.set(this.keys,this.values);
        Assertions.assertEquals("{eins : one}, {zwei : two}, {drei : three}",this.emptyUnsortedStringArrayST.toString());
    }

    @Test
    void getUnsortdTest(){
        this.emptyUnsortedStringArrayST.set(this.keys,this.values);
        int index = 2;
        Assertions.assertEquals(this.values[index], this.emptyUnsortedStringArrayST.get(this.keys[index]));
    }

    @Test
    void getSortedTest(){
        this.emptySortedStringArrayST.set(this.keys,this.values);
        this.emptySortedStringArrayST.get(this.keys[2]);
        Assertions.assertEquals("{drei : three}, {eins : one}, {zwei : two}",this.emptySortedStringArrayST.toString());
    }
}
