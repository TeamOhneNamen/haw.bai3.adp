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

    @Override
    public boolean remove(Object o) {
        return this.data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.data.containsAll(c);
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
        return this.data.retainAll(c);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Collection<?>)){
            return false;
        }else if(this.size( ) != ((Collection <E>)o).size()){
            return false;
        } else {
            return this.containsAll((Collection <E>) o) && ((Collection <E>) o).containsAll(this);
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

    @Override
    public String toString(){
        return Arrays.toString(this.toArray());
    }

    @Override
    public int compareTo(WaitingQueue waitingQueue) {
        return this.size()-waitingQueue.size();
    }
}
