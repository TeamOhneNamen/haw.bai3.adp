package p2.util;

import p2.datastructures.WaitingQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MergeSort {

    public static int arrayAccessCount = 0;


    public static WaitingQueue mergeSortedQueues(WaitingQueue q1, WaitingQueue q2) {
        WaitingQueue merged = new WaitingQueue<>();
        Comparable e1 = q1.peek();
        Comparable e2 = q2.peek();
        while(true){
            if(e1.compareTo(e2) < 0){
                merged.add(e1);
                q1.poll();
                e1 = q1.peek();
            }else {
                merged.add(e2);
                q2.poll();
                e2 = q2.peek();
            }
            if(q1.isEmpty()){
                merged.addAll(q2);
                break;
            }else if(q2.isEmpty()){
                merged.addAll(q1);
                break;
            }
        }
        return merged;
    }

    public static List bottomUp(List list) throws ClassCastException {
        MergeSort.arrayAccessCount = 0;
        WaitingQueue<WaitingQueue> hyperWaitingQueue = prepareHyperWaiting(list);

        while (hyperWaitingQueue.size() > 1) {
            MergeSort.arrayAccessCount++;
            WaitingQueue mergeList = hyperWaitingQueue.poll();
            MergeSort.arrayAccessCount++;
            WaitingQueue pollList = hyperWaitingQueue.poll();
            WaitingQueue waitingQueueAfterMerge = MergeSort.mergeSortedQueues(mergeList, pollList);
            MergeSort.arrayAccessCount++;
            hyperWaitingQueue.add(waitingQueueAfterMerge);
        }
        return List.of(hyperWaitingQueue.peek().toArray());
    }

    private static WaitingQueue prepareHyperWaiting(List list) throws ClassCastException {
        WaitingQueue<WaitingQueue> hyperWaitingQueue = new WaitingQueue<>();
        list.forEach(element -> {
                    MergeSort.arrayAccessCount++;
                    if (element instanceof Comparable) {
                        hyperWaitingQueue.add(new WaitingQueue((Comparable) element));
                    } else {
                        throw new ClassCastException();
                    }
                }
        );
        return hyperWaitingQueue;
    }
}
