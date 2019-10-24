package p2;

import org.junit.jupiter.api.BeforeEach;
import p1.datastructures.DoublyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public class MergeSort {


    protected static WaitingQueue<E> mergeSortedLists(WaitingQueue<E> list1, WaitingQueue<E> list2) {
        WaitingQueue<E> mergeList = list1.clone();
        WaitingQueue<E> pollList = list2.clone();
        for (int i = 0; i < mergeList.size()-1; i++) {
            while(!pollList.isEmpty()){
                E polledElement = pollList.peek();
                if(i < mergeList.size()-2){
                    if((((Comparable) mergeList.get(i)) < polledElement) && (mergeList.get(i++) > polledElement)){
                        mergeList.add(i+1,polledElement);
                        pollList.remove();
                    }
                }else {
                    break;
                }
            }

            if(mergeList.get(i).equals(polledElement)){
                System.out.println("add: "+polledElement);
                mergeList.add(i,polledElement);
                mergeList.remove(polledElement);
            }
            if(pollList.isEmpty()){
                break;
            }
        }
        return mergeList;
    }
}
