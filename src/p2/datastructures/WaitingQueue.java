package p2.datastructures;

import java.util.*;

public class WaitingQueue<E extends Comparable> implements Queue<E>, Comparable<WaitingQueue> {

    private List<E> data;

    public WaitingQueue() {
        this.data = new ArrayList<>();
    }

    public WaitingQueue(E e) {
        this.data = new ArrayList<>();
        this.data.add(e);
    }

    public WaitingQueue(Collection<E> c) {
        this.data = new ArrayList<>();
        this.data.addAll(c);
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.data.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return this.data.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.data.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return this.data.add(e);
    }

    public void add(int i, E e) {
        this.data.add(i, e);
    }

    //return element at the position i in the WaitingQueue
    public E get(int i){
        return this.data.get(i);
    }

    //TODO: add sorted
    @Override
    public boolean remove(Object o) {
        return this.data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return this.data.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.retainAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.retainAll(c);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o.getClass().equals(this.getClass()))) {
            return false;
        } else if (((WaitingQueue) o).size() != this.size()) {
            return false;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if(!this.get(i).equals(((WaitingQueue) o).get(i))){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int hashCode() {
        return this.data.hashCode();
    }

    @Override
    public boolean offer(E e) {
        return this.data.add(e);
    }

    @Override
    public E remove() {
        return this.data.remove(0);
    }

    @Override
    public E poll() {
        if(this.isEmpty()){
            return null;
        }
        return this.data.remove(0);
    }

    @Override
    public E element() {
        return this.data.get(0);
    }

    @Override
    public E peek() {
        if(this.isEmpty()){
            return null;
        }
        return this.data.get(0);
    }

    public WaitingQueue<E> clone(){
        return new WaitingQueue<>(this.data);
    }

    @Override
    public String toString(){
        return Arrays.toString(this.toArray());
    }

    @Override
    public int compareTo(WaitingQueue waitingQueue) {
        return this.size()-waitingQueue.size();
    }

    public E getLast() {
        return this.data.get(this.size()-1);
    }

    public E getSecondLast() {
        return this.data.get(this.size()-2);
    }

    public E getSecond() {
        return this.get(1);
    }

    public void removeAtPosition(int i) {
        this.data.remove(this.data.get(i));
    }

    public void removeLast() {
        this.removeAtPosition(this.size()-1);
    }
}
