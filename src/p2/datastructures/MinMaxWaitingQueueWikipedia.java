//package p2.datastructures;
//
//import java.util.Collections;
//import java.util.List;
//
//public class MinMaxWaitingQueueWikipedia {
//    public List floydBuildHeap(List<Integer> h){
//        for (int i = h.size()/2; i > 1; i--) {
//            pushDown(h, i);
//        }
//        return h;
//    }
//    private void pushDown(List<Integer> h, int i){
//        if(isMinLevel(i)){
//            pushDownMin(h,i);
//        }else {
//            pushDownMax(h,i);
//        }
//    }
//
//    private void pushDownMin(List<Integer> h, int i){
//        if(hasChildren(i)){
//            int m = smallestChildOrGrandchildOf(i);
//            if(isGrandChildOf(m, i)){
//                if(h.get(m)<h.get(i)){
//                    Collections.swap(h, m, i);
//                    if(h.get(m)>h.get(getParent(m))){
//                        Collections.swap(h, getParent(m), i);
//                    }
//                }
//                pushDownMin(h,m);
//            }else if(h.get(m)<h.get(i)){
//                Collections.swap(h, m, i);
//            }
//        }
//    }
//
//    private void pushDownMax(List<Integer> h, int i){
//        if(hasChildren(i)){
//            int m = largestChildOrGrandchildOf(i);
//            if(isGrandChildOf(m, i)){
//                if(h.get(m)>h.get(i)){
//                    Collections.swap(h, m, i);
//                    if(h.get(m)<h.get(getParent(m))){
//                        Collections.swap(h, getParent(m), i);
//                    }
//                }
//                pushDownMin(h,m);
//            }else if(h.get(m)>h.get(i)){
//                Collections.swap(h, m, i);
//            }
//        }
//    }
//    private void kth
//
//    private int getIndexOfLeftChild(int k){
//        return 2*k;
//    }
//
//    private int getIndexOfRightChild(int k){
//        return 2*k+1;
//    }
//}
