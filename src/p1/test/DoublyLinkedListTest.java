package p1.test;

import p1.datastructures.DoublyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private ArrayList<String> stringList;
    private DoublyLinkedList<String> emptyDoublyLinkedList;
    private DoublyLinkedList<String> doublyLinkedListFilledWithStringList;
    private String str;
    private int index;
    private String strToInsert;


    @BeforeEach
    void SetUp(){
        this.emptyDoublyLinkedList = new DoublyLinkedList<>();
        List<String> list = List.of("one", "two", "three", "four");
        this.stringList = new ArrayList<>();
        this.stringList.addAll(list);
        this.str = "NIL";
        this.index = list.size()/2;
        this.strToInsert = "INSERTME";
        this.doublyLinkedListFilledWithStringList = new DoublyLinkedList<>(this.stringList);
    }

    @Test
    void addTest(){
        ArrayList<String> addList = new ArrayList<>();
        Assertions.assertEquals(addList.toString(), emptyDoublyLinkedList.toString());
        emptyDoublyLinkedList.add(this.strToInsert);
        addList.add(strToInsert);
        Assertions.assertEquals(addList.toString(), emptyDoublyLinkedList.toString());
        emptyDoublyLinkedList.add("4");
        addList.add("4");
        Assertions.assertEquals(addList.toString(), emptyDoublyLinkedList.toString());
    }

    @Test
    void removeFirstTestPositive(){
        //assertFalse(this.emptyDoublyLinkedList.removeFirst());
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.removeFirst();
        this.stringList.remove(0);
        Assertions.assertEquals(this.emptyDoublyLinkedList.toString(), this.stringList.toString());
    }

    @Test
    void removeFirstTestNegative(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            this.emptyDoublyLinkedList.removeFirst();
        });
    }

    @Test
    void deleteAllOccurencesTest(){
        String checkForStr = "twin";
        List<String> listWithMultipleOccurences = List.of("one", "two",checkForStr, "three", "four",checkForStr);
        this.emptyDoublyLinkedList.addAll(listWithMultipleOccurences);
        assertTrue(this.emptyDoublyLinkedList.contains(checkForStr));
        this.emptyDoublyLinkedList.deleteAllOccurrences(checkForStr);
        assertFalse(this.emptyDoublyLinkedList.contains(checkForStr));
    }

    @Test
    void removeLastTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> this.emptyDoublyLinkedList.removeLast());
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.removeLast();
        this.stringList.remove(this.stringList.size()-1);
        Assertions.assertEquals(this.stringList.toString(), this.emptyDoublyLinkedList.toString());
    }

    @Test
    void removeLastTestNegative(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            this.emptyDoublyLinkedList.removeLast();
        });
    }

    @Test
    void deleteAtPositionTestNegative(){
        assertThrows(IndexOutOfBoundsException.class, () -> this.emptyDoublyLinkedList.deleteAtPosition(this.doublyLinkedListFilledWithStringList.size()+10));
    }

    @Test
    void deleteAtPositionTestPositive(){
        this.doublyLinkedListFilledWithStringList.deleteAtPosition(this.index);
        this.stringList.remove(this.index);
        Assertions.assertEquals(this.stringList.toString(), this.doublyLinkedListFilledWithStringList.toString());
    }

    @Test
    void removeTest(){
        int index = 1;
        Assertions.assertFalse(this.emptyDoublyLinkedList.remove(str));
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.remove(stringList.get(index));
        this.stringList.remove(index);
        Assertions.assertEquals(this.emptyDoublyLinkedList.toString(), this.stringList.toString());
    }

    @Test
    void insertAtPositionTestPositive(){
        this.stringList.add(this.index, this.strToInsert);
        this.doublyLinkedListFilledWithStringList.insertAtPosition(this.index, this.strToInsert);
        Assertions.assertEquals(this.stringList.toString(), this.doublyLinkedListFilledWithStringList.toString());
    }

    @Test
    void insertAtPositionTestNegative(){
        assertThrows(IndexOutOfBoundsException.class, () -> this.emptyDoublyLinkedList.insertAtPosition(10, this.strToInsert));
    }

    @Test
    void containsTestEmptyList(){
        Assertions.assertFalse(this.emptyDoublyLinkedList.contains(this.str));
    }

    @Test
    void containsTestFilledListPositive(){
        this.emptyDoublyLinkedList.addAll(this.stringList);
        Assertions.assertTrue(this.emptyDoublyLinkedList.contains(this.stringList.get(this.index)));
    }

    @Test
    void containsTestFilledListNegative(){
        this.emptyDoublyLinkedList.addAll(this.stringList);
        Assertions.assertFalse(this.emptyDoublyLinkedList.contains(this.str));
    }

    @Test
    void retrieveTestPositive(){
        Assertions.assertEquals(this.stringList.get(this.index),this.doublyLinkedListFilledWithStringList.retrieve(this.index));
    }

    @Test
    void retrieveTestNegative(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            this.emptyDoublyLinkedList.retrieve(5);
        });
    }

    @Test
    void sizeTest(){
        Assertions.assertEquals(this.emptyDoublyLinkedList.size(), 0);
        this.emptyDoublyLinkedList.addAll(stringList);
        Assertions.assertEquals(this.emptyDoublyLinkedList.size(), stringList.size());
    }

    @Test
    void isEmptyTest(){
        Assertions.assertTrue(this.emptyDoublyLinkedList.isEmpty());
        this.emptyDoublyLinkedList.addAll(this.stringList);
        Assertions.assertFalse(this.emptyDoublyLinkedList.isEmpty());
    }

    @Test
    void toStringTest(){
        Assertions.assertEquals(this.stringList.toString(), this.doublyLinkedListFilledWithStringList.toString());
    }

    @Test
    void toArrayTestNegative(){
        String[] strArray = {"String"};
        Assertions.assertNotEquals(strArray, this.doublyLinkedListFilledWithStringList.toArray());
    }


    @Test
    void addAllTest(){
        this.emptyDoublyLinkedList.addAll(stringList);
        Assertions.assertEquals(stringList.toString(), this.emptyDoublyLinkedList.toString());
    }

    @Test
    void equalsTestWithEmptyListPositive(){
        Assertions.assertEquals(this.emptyDoublyLinkedList,new ArrayList<>());
    }


    @Test
    void equalsTestWithCollectionNegative(){
        Assertions.assertNotEquals(this.emptyDoublyLinkedList,this.stringList);
    }

    @Test
    void equalsTestWithNonCollectionNegative(){
        Assertions.assertNotEquals(this.emptyDoublyLinkedList,this.strToInsert);
    }
}