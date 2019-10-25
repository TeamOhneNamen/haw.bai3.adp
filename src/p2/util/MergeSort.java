package p2.util;

import p2.datastructures.WaitingQueue;

import java.util.List;

public class MergeSort {

    public static int arrayAccessCount = 0;

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
                MergeSort.arrayAccessCount++;
                Object polledElement = pollList.peek();
                if (i < mergeList.size() - 1) {
                    if (((mergeList.get(i)).compareTo(polledElement) <= 0) && (mergeList.get(i + 1)).compareTo(polledElement) >= 0) {
                        MergeSort.arrayAccessCount++;
                        mergeList.add(i + 1, (Comparable) polledElement);
                        MergeSort.arrayAccessCount++;
                        pollList.remove();
                    }
                } else if ((mergeList.get(i)).compareTo(polledElement) <= 0) {
                    MergeSort.arrayAccessCount++;
                    mergeList.add(i + 1, (Comparable) polledElement);
                    MergeSort.arrayAccessCount++;
                    pollList.remove();
                } else {
                    MergeSort.arrayAccessCount++;
                    mergeList.add(0, (Comparable) polledElement);
                    MergeSort.arrayAccessCount++;
                    pollList.remove();
                }
                i++;
            } else {
                break;
            }
        }
        return mergeList;
    }

    public static List topDown(List list) throws ClassCastException {
        MergeSort.arrayAccessCount = 0;
        WaitingQueue<WaitingQueue> hyperWaitingQueue = prepareHyperWaiting(list);

        while (hyperWaitingQueue.size() > 1) {
            MergeSort.arrayAccessCount++;
            WaitingQueue mergeList = hyperWaitingQueue.peek();
            MergeSort.arrayAccessCount++;
            WaitingQueue pollList = hyperWaitingQueue.getSecond();
            MergeSort.arrayAccessCount++;
            hyperWaitingQueue.remove();
            MergeSort.arrayAccessCount++;
            hyperWaitingQueue.remove();
            WaitingQueue waitingQueueAfterMerge = MergeSort.mergeSortedLists(mergeList, pollList);
            MergeSort.arrayAccessCount++;
            hyperWaitingQueue.add(0, waitingQueueAfterMerge);
        }
        return List.of(hyperWaitingQueue.peek().toArray());
    }

    public static List bottomUp(List list) throws ClassCastException {
        MergeSort.arrayAccessCount = 0;
        WaitingQueue<WaitingQueue> hyperWaitingQueue = prepareHyperWaiting(list);

        while (hyperWaitingQueue.size() > 1) {
            MergeSort.arrayAccessCount++;
            WaitingQueue mergeList = hyperWaitingQueue.getLast();
            MergeSort.arrayAccessCount++;
            WaitingQueue pollList = hyperWaitingQueue.getSecondLast();
            MergeSort.arrayAccessCount++;
            hyperWaitingQueue.removeLast();
            MergeSort.arrayAccessCount++;
            hyperWaitingQueue.removeLast();
            WaitingQueue waitingQueueAfterMerge = MergeSort.mergeSortedLists(mergeList, pollList);
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
