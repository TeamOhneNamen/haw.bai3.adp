package p2.datastructures;

import p2.interfaces.IMinMaxHeap;

import java.util.ArrayList;
import java.util.List;

public class MinMaxHeap<Key extends Comparable<? super Key>> implements IMinMaxHeap {

    public Key[] pq;
    public int N = 0; // in pq [1..N] 0 wird nicht verwendet

    /***
     * source: AD_2 Sortieren 2 Fol. 31
     * @param maxN
     */
    public MinMaxHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public MinMaxHeap(List<Key> list) {
        //TODO Build method
    }

    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     */
    private void floydBuildHeap(){
        for(int i = N/2; i > 1; i--){
            this.pushDown(i);
        }
    }

    private boolean isIndexMinLevel(int i) {
        return (Math.log(i) % 2) == 0;
    }

    private int getParentIndex(int i) {
        return i / 2;
    }

    private int getGrandparentIndex(int i) {
        return i / 4;
    }

    private boolean hasGrandparent(int i) {
        return this.getGrandparentIndex(i) > 0;
    }

    private boolean isGrandChildOf(int grandchild, int grandparent) {
        return this.getGrandparentIndex(grandchild) == grandparent;
    }

    public int getIndexOfSmallestChildOrGrandChild(int index){
        int leftChildIndex = this.getLeftChildIndex(index);
        int rightChildIndex = this.getRightChildIndex(index);
        int leftChildLeftChildIndex = this.getLeftChildIndex(leftChildIndex);
        int rightChildLeftChildIndex = this.getRightChildIndex(leftChildIndex);
        int leftChildRightChildIndex = this.getLeftChildIndex(rightChildIndex);
        int rightChildRightChildIndex = this.getRightChildIndex(rightChildIndex);

        int currentMinIndex = leftChildIndex;
        if(rightChildIndex <= N && this.less(rightChildIndex,currentMinIndex)){
            currentMinIndex = rightChildIndex;
        }
        if(leftChildLeftChildIndex <= N && this.less(leftChildLeftChildIndex,currentMinIndex)){
            currentMinIndex = leftChildLeftChildIndex;
        }
        if(rightChildLeftChildIndex <= N && this.less(rightChildLeftChildIndex,currentMinIndex)){
            currentMinIndex = rightChildLeftChildIndex;
        }
        if(leftChildRightChildIndex <= N && this.less(leftChildRightChildIndex,currentMinIndex)){
            currentMinIndex = leftChildRightChildIndex;
        }
        if(rightChildRightChildIndex <= N && this.less(rightChildRightChildIndex,currentMinIndex)){
            currentMinIndex = rightChildRightChildIndex;
        }
        return currentMinIndex;
    }

    public int getIndexOfLargestChildOrGrandChild(int index) {
        int leftChildIndex = this.getLeftChildIndex(index);
        int rightChildIndex = this.getRightChildIndex(index);
        int leftChildLeftChildIndex = this.getLeftChildIndex(leftChildIndex);
        int rightChildLeftChildIndex = this.getRightChildIndex(leftChildIndex);
        int leftChildRightChildIndex = this.getLeftChildIndex(rightChildIndex);
        int rightChildRightChildIndex = this.getRightChildIndex(rightChildIndex);

        int currentMaxIndex = leftChildIndex;
        if(this.less(currentMaxIndex,rightChildIndex)){
            currentMaxIndex = rightChildIndex;
        }
        if(this.less(currentMaxIndex,leftChildLeftChildIndex)){
            currentMaxIndex = leftChildLeftChildIndex;
        }
        if(this.less(currentMaxIndex,rightChildLeftChildIndex)){
            currentMaxIndex = rightChildLeftChildIndex;
        }
        if(this.less(currentMaxIndex,leftChildRightChildIndex)){
            currentMaxIndex = leftChildRightChildIndex;
        }
        if(this.less(currentMaxIndex,rightChildRightChildIndex)){
            currentMaxIndex = rightChildRightChildIndex;
        }
        return currentMaxIndex;
    }

    private int getLeftChildIndex(int i) {
        return 2 * i;
    }

    private int getRightChildIndex(int i) {
        return (2 * i) + 1;
    }

    private boolean hasChildren(int i) {
        return (this.getLeftChildIndex(i) <= N );
    }

    @Override
    public Key min() {
        return this.pq[1];
    }

    @Override
    public int size() {
        return this.N;
    }

    public Key get(int i) {
        return this.pq[i];
    }

    private void set(int i, Key key) {
        this.pq[i] = key;
    }


    @Override
    public Key max() {
        return this.get(this.getMaxIndex());
    }

    /***
     *
     * @return index of the greatest element
     */
    private int getMaxIndex() {
        if (this.size() == 0) {
            return -1;
        }

        if (this.size() == 1) {
            return 1;
        }

        if (this.size() == 2) {
            return 2;
        }
        if (max(this.get(2), this.get(3)) == this.get(2)) {
            return 2;
        }
        return 3;
    }

    private Key max(Key leftValue, Key rightValue) {
        if (leftValue.compareTo(rightValue) < 0) {
            return rightValue;
        }
        return leftValue;
    }

    //AD_2 Sortieren 2 Fol. 30
    // exchange two elements via their index
    private void exch(int i, int j) {
        Key tmp = this.get(i);
        this.set(i, this.get(j));
        this.set(j, tmp);
    }


    //AD_2 Sortieren 2 Fol. 30
    private boolean less(int i, int j) {
        return this.get(i).compareTo(this.get(j)) < 0;
    }

    /***
     * Schlüssel hinten an den Heap anfügen
     * und mit dem Schlüssel Größe um 1 erhöhen
     * mit dem Schlüssel nach oben schwimmen
     * source: AD_2 Sortieren 2 Fol. 30
     * @param k element which should be inserted
     */
    @Override
    public void insert(Comparable k) {
        pq[++N] = (Key) k;
        pushUp(N);
    }


    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     * @param i index of the element
     */
    private void pushUp(int i) {
        if (i != 1) {
            if (isIndexMinLevel(i)) {
                if (this.get(i).compareTo(this.get(this.getParentIndex(i))) >= 0) {
                    exch(i, this.getParentIndex(i));
                    this.pushUpMax(this.getParentIndex(i));
                } else {
                    this.pushUpMin(i);
                }
            } else {
                if (this.get(i).compareTo(this.get(this.getParentIndex(i))) < 0) {
                    exch(i, this.getParentIndex(i));
                    this.pushUpMin(this.getParentIndex(i));
                } else {
                    this.pushUpMax(i);
                }
            }
        }
    }

    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     * @param i
     */
    private void pushUpMin(int i) {
        if (this.hasGrandparent(i) && this.get(i).compareTo(this.get(this.getGrandparentIndex(i))) < 0) {
            exch(i, this.getGrandparentIndex(i));
            pushUpMin(this.getGrandparentIndex(i));
        }
    }

    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     * @param i
     */
    private void pushUpMax(int i) {
        if (this.hasGrandparent(i) && this.get(i).compareTo(this.get(this.getGrandparentIndex(i))) > 0) {
            exch(i, this.getGrandparentIndex(i));
            pushUpMax(this.getGrandparentIndex(i));
        }
    }

    /***
     * delete the greatest element
     * @return the value of the deleted element
     */
    @Override
    public Key delMax() {
        return this.delete(this.getMaxIndex());
    }

    /***
     * delete the smallest element
     * @return the value of the deleted element
     */
    @Override
    public Key delMin() {
        return this.delete(1);
    }

    /***
     * delete the element with the index index
     * @param index of the element
     * @return the value of the deleted element
     */
    private Key delete(int index){
        Key deletedElement = this.get(index);
        if (N == 1) {
            pq[N] = null;
            N--;
            return deletedElement;
        }
        pq[index] = pq[N--];
        pushDown(index);
        return deletedElement;
    }

        private boolean isLastIndex(int index) {
        return index == N;
    }


    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     * @param index
     */
    private void pushDown(int index) {
        if (isIndexMinLevel(index)) {
            this.pushDownMin(index);
        } else {
            this.pushDownMax(index);
        }
    }

    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     * @param index of the element should be pushed down on a min level
     */
    private void pushDownMin(int index) {
        if (this.hasChildren(index)) {
            int m = this.getIndexOfSmallestChildOrGrandChild(index);
            if (this.isGrandChildOf(m, index)) {
                if (this.less(m, index)) {
                    this.exch(m, index);
                    int parentIndexOfM = this.getParentIndex(m);
                    if (this.less(parentIndexOfM, m)) {
                        this.exch(m, parentIndexOfM);
                    }
                    this.pushDownMin(m);
                }
            } else if (this.less(m, index)) {
                this.exch(m, index);
            }
        }
    }

    /***
     * source: https://en.wikipedia.org/wiki/Min-max_heap
     * @param index
     */
    private void pushDownMax(int index) {
        if (this.hasChildren(index)) {
            int m = this.getIndexOfLargestChildOrGrandChild(index);
            if (this.isGrandChildOf(m, index)) {
                if (this.less(index, m)) {
                    this.exch(m, index);
                    int parentIndexOfM = this.getParentIndex(m);
                    if (this.less(m, parentIndexOfM)) {
                        this.exch(m, parentIndexOfM);
                    }
                    this.pushDownMax(m);
                }
            } else if (this.less(m, index)) {
                this.exch(m, index);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("digraph G {\n");
        stringBuffer.append(branchToString(1));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private List<Integer> getChildrenIndexes(int i) {
        ArrayList<Integer> childrenIndexes = new ArrayList<>();
        int leftChildrenIndex = this.getLeftChildIndex(i);
        if (leftChildrenIndex > this.size() - 1) {
            return childrenIndexes;
        }
        if (null != this.get(leftChildrenIndex)) {
            childrenIndexes.add(leftChildrenIndex);
        }

        int rightChildrenIndex = this.getRightChildIndex(i);
        if (rightChildrenIndex > this.size() - 1) {
            return childrenIndexes;
        }
        if (null != this.get(rightChildrenIndex)) {
            childrenIndexes.add(rightChildrenIndex);
        }
        return childrenIndexes;
    }

    private String branchToString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"" + i + "\"" + " [label=" + this.get(i) + "]");
        getChildrenIndexes(i).forEach(childIndex -> {
            stringBuffer.append("\"" + i + "\" -> \"" + childIndex + "\";\n");
        });
        getChildrenIndexes(i).forEach(child -> {
            stringBuffer.append(branchToString(child));
        });
        return stringBuffer.toString();
    }
}
