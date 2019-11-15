package p2.datastructures;

import java.util.ArrayList;
import java.util.List;

public class MinMaxHeap<Key extends Comparable <? super Key>> {

    public Key [] pq;
    public int N = 0 ; // in pq [1..N] 0 wird nicht verwendet

    /***
     * @source AD_2 Sortieren 2 Fol. 31
     * @param maxN
     */
    public MinMaxHeap (int maxN){
        pq = (Key []) new Comparable [ maxN+1];
    }

    public MinMaxHeap (List<Key> list){
        pq = (Key []) new Comparable [ list.size()+1];
        list.forEach(this::insert);
    }

    public boolean isIndexMinLevel(int i) {
        return (Math.log(i) % 2) == 0;
    }

    public int getParentIndex(int i) {
        return i / 2;
    }

    public int getGrantparentIndex(int i) {
        return i / 4;
    }

    public boolean hasGrandparent(int i) {
        return this.getGrantparentIndex(i) > 0;
    }

    public int getLeftChildIndex(int i) {
        return 2 * i;
    }

    public int getRightChildIndex(int i) {
        return (2 * i) + 1;
    }

    public Key getMin() {
        return this.pq[1];
    }

    public int size() {
        return this.pq.length;
    }

    public Key get(int i) {
        return this.pq[i];
    }

    public void set(int i, Key key) {
        this.pq[i] = key;
    }

    public Key getMax() {
        if (this.size() == 0) {
            return null;
        }

        if (this.size() == 1) {
            return this.get(1);
        }

        if (this.size() == 2) {
            return this.get(2);
        }
        return max(this.get(2), this.get(3));
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
     * Der größere Kindknoten „schwimmt“ nach oben
     * solange bis er kleiner als der erste Elternknoten ist.
     * @source AD_2 Sortieren 2 Fol. 31
     * @param k index of the element
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /***
     * Schlüssel hinten an den Heap anfügen
     * und mit dem Schlüssel Größe um 1 erhöhen
     * mit dem Schlüssel nach oben schwimmen
     * @source AD_2 Sortieren 2 Fol. 30
     * @param v element which should be inserted
     */
    public void insert (Key v) {
        pq[++N] = v;
        pushUp(N);
    }


    /***
     * @source https://en.wikipedia.org/wiki/Min-max_heap
     * @param i
     */
    private void pushUp(int i){
        if(i != 1){
            if(isIndexMinLevel(i)){
                if(this.get(i).compareTo(this.get(this.getParentIndex(i)))>=0){
                    exch(i, this.getParentIndex(i));
                    this.pushUpMax(this.getParentIndex(i));
                } else {
                    this.pushUpMin(i);
                }
            } else {
                if(this.get(i).compareTo(this.get(this.getParentIndex(i)))<0){
                    exch(i, this.getParentIndex(i));
                    this.pushUpMin(this.getParentIndex(i));
                } else {
                    this.pushUpMax(i);
                }
            }
        }
    }

    /***
     * @source https://en.wikipedia.org/wiki/Min-max_heap
     * @param i
     */
    private void pushUpMin(int i){
        if(this.hasGrandparent(i) && this.get(i).compareTo(this.get(this.getGrantparentIndex(i))) <0){
            exch(i,this.getGrantparentIndex(i));
            pushUpMin(this.getGrantparentIndex(i));
        }
    }

    /***
     * @source https://en.wikipedia.org/wiki/Min-max_heap
     * @param i
     */
    private void pushUpMax(int i){
        if(this.hasGrandparent(i) && this.get(i).compareTo(this.get(this.getGrantparentIndex(i))) >0){
            exch(i,this.getGrantparentIndex(i));
            pushUpMax(this.getGrantparentIndex(i));
        }
    }


    @Override
    public String toString () {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("digraph G {\n");
        stringBuffer.append(branchToString(1));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    private List<Integer> getChildrenIndexes(int i){
        ArrayList<Integer> childrenIndexes = new ArrayList<>();
        int leftChildrenIndex = this.getLeftChildIndex(i);
        if(leftChildrenIndex > this.size()-1){
            return childrenIndexes;
        }
        if(null != this.get(leftChildrenIndex)){
            childrenIndexes.add(leftChildrenIndex);
        }

        int rightChildrenIndex = this.getRightChildIndex(i);
        if(rightChildrenIndex > this.size()-1){
            return childrenIndexes;
        }
        if(null != this.get(rightChildrenIndex)){
            childrenIndexes.add(rightChildrenIndex);
        }
        return childrenIndexes;
    }

    private String branchToString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\""+i+"\""+" [label="+this.get(i)+"]");
        getChildrenIndexes(i).forEach(childIndex -> {
            stringBuffer.append("\""+i+"\" -> \""+childIndex+"\";\n");
        });
        getChildrenIndexes(i).forEach(child -> {
            stringBuffer.append(branchToString(child));
        });
        return stringBuffer.toString();
    }
}
