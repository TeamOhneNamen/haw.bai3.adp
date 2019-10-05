import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    private ArrayList stringList;
    private DoublyLinkedList emptyDoublyLinkedList;
    private DoublyLinkedList doublyLinkedListFilledWithStringList;
    private String str;
    private int index;
    private String strToInsert;


    @BeforeEach
    public void SetUp(){
        this.emptyDoublyLinkedList = new DoublyLinkedList();
        List list = List.of("one", "two", "three", "four");
        this.stringList = new ArrayList();
        this.stringList.addAll(list);
        this.str = "NIL";
        this.index = list.size()/2;
        this.strToInsert = "INSERTME";
        this.doublyLinkedListFilledWithStringList = new DoublyLinkedList(this.stringList);
    }

    @Test
    public void addTest(){
        ArrayList addList = new ArrayList();
        assertEquals(addList.toString(), emptyDoublyLinkedList.toString());
        emptyDoublyLinkedList.add(this.strToInsert);
        addList.add(strToInsert);
        assertEquals(addList.toString(), emptyDoublyLinkedList.toString());
        emptyDoublyLinkedList.add(4);
        addList.add(4);
        assertEquals(addList.toString(), emptyDoublyLinkedList.toString());
    }

    @Test
    public void removeFirstTest(){
        assertThrows(NoSuchElementException.class, () -> this.emptyDoublyLinkedList.removeFirst());
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.removeFirst();
        this.stringList.remove(0);
        assertEquals(this.emptyDoublyLinkedList.toString(), this.stringList.toString());
    }

    @Test
    public void removeLastTest(){
        assertThrows(NoSuchElementException.class, () -> this.emptyDoublyLinkedList.removeLast());
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.removeLast();
        this.stringList.remove(this.stringList.size()-1);
        assertEquals(this.stringList.toString(), this.emptyDoublyLinkedList.toString());
    }

    @Test
    public void deleteAtPositionTest(){
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.deleteAtPosition(this.index);
        this.stringList.remove(this.index);
        assertEquals(this.stringList.toString(), this.emptyDoublyLinkedList.toString());
    }

    @Test
    public void removeTest(){
        int index = 1;
        assertFalse(this.emptyDoublyLinkedList.remove(str));
        this.emptyDoublyLinkedList.addAll(stringList);
        this.emptyDoublyLinkedList.remove(stringList.get(index));
        this.stringList.remove(index);
        assertEquals(this.emptyDoublyLinkedList.toString(), this.stringList.toString());
    }

    @Test
    public void insertAtPositionTest(){
        this.stringList.add(this.index, this.strToInsert);
        this.doublyLinkedListFilledWithStringList.insertAtPosition(this.index, this.strToInsert);
        assertEquals(this.stringList.toString(), this.doublyLinkedListFilledWithStringList.toString());
    }

    @Test
    public void containsTestEmptyList(){
        assertFalse(this.emptyDoublyLinkedList.contains(this.str));
    }

    @Test
    public void containsTestFilledListPositive(){
        this.emptyDoublyLinkedList.addAll(this.stringList);
        assertTrue(this.emptyDoublyLinkedList.contains(this.stringList.get(this.index)));
    }

    @Test
    public void containsTestFilledListNegative(){
        this.emptyDoublyLinkedList.addAll(this.stringList);
        assertFalse(this.emptyDoublyLinkedList.contains(this.str));
    }

    @Test
    public void retrieveTest(){
        assertEquals(this.stringList.get(this.index),this.doublyLinkedListFilledWithStringList.retrieve(this.index));
    }

    @Test
    public void sizeTest(){
        assertEquals(this.emptyDoublyLinkedList.size(), 0);
        this.emptyDoublyLinkedList.addAll(stringList);
        assertEquals(this.emptyDoublyLinkedList.size(), stringList.size());
    }

    @Test
    public void isEmptyTest(){
        assertTrue(this.emptyDoublyLinkedList.isEmpty());
        this.emptyDoublyLinkedList.addAll(this.stringList);
        assertFalse(this.emptyDoublyLinkedList.isEmpty());
    }

    @Test
    public void toStringTest(){
        assertEquals(this.stringList.toString(), this.doublyLinkedListFilledWithStringList.toString());
    }

    @Test
    public void addAllTest(){
        this.emptyDoublyLinkedList.addAll(stringList);
        assertEquals(stringList.toString(), this.emptyDoublyLinkedList.toString());
    }

    @Test
    public void equalsTest(){
        assertEquals(this.emptyDoublyLinkedList,new ArrayList<>());
    }
}
