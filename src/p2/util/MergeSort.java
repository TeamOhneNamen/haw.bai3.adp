package p2.util;

import p2.datastructures.WaitingQueue;

import java.util.List;

public class MergeSort {

    public static WaitingQueue mergeSortedLists(WaitingQueue list1, WaitingQueue list2) throws ClassCastException {
        WaitingQueue mergeList = list1.clone();
        WaitingQueue pollList = list2.clone();
        if (list1.isEmpty()) {
            return list2.clone();
        }
        if (list2.isEmpty()) {
            return list1.clone();
        }
        int i = 0;
        while (!pollList.isEmpty()) {
            if (i < mergeList.size()) {
                Object polledElement = pollList.peek();
                if (i < mergeList.size() - 1) {
                    if (((mergeList.get(i)).compareTo(polledElement) <= 0) && (mergeList.get(i + 1)).compareTo(polledElement) >= 0) {
                        mergeList.add(i + 1, (Comparable) polledElement);
                        pollList.remove();
                    }
                } else if ((mergeList.get(i)).compareTo(polledElement) <= 0) {
                    mergeList.add(i + 1, (Comparable) polledElement);
                    pollList.remove();
                } else {
                    mergeList.add(0, (Comparable) polledElement);
                    pollList.remove();
                }
                i++;
            } else {
                break;
            }
        }
        return mergeList;
    }

    public static List bottomUp(List list) throws ClassCastException {
        WaitingQueue<WaitingQueue> hyperWaitingQueue = new WaitingQueue<>();
        list.forEach(element -> {
                    if (element instanceof Comparable) {
                        hyperWaitingQueue.add(new WaitingQueue((Comparable) element));
                    } else {
                        throw new ClassCastException();
                    }
                }
        );
        while (hyperWaitingQueue.size() > 1) {
            WaitingQueue mergeList = hyperWaitingQueue.get(0);
            WaitingQueue pollList = hyperWaitingQueue.get(1);
            hyperWaitingQueue.remove();
            hyperWaitingQueue.remove();
            WaitingQueue waitingQueueAfterMerge = MergeSort.mergeSortedLists(mergeList, pollList);
            hyperWaitingQueue.add(0, waitingQueueAfterMerge);
        }

        return List.of(hyperWaitingQueue.get(0).toArray());
    }
}
