import interfaces.ListInterface;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<E> implements ListInterface<E> {
    private final Node FIRST = new Node();
    private final Node LAST = new Node();
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public DoublyLinkedList(List list) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addAll(list);
    }

    @Override
    public void pop() {
        Node secondLastNode = this.LAST.getPredecessor().getPredecessor();
        LAST.setPredecessor(secondLastNode);
        secondLastNode.setSuccessor(this.LAST);
        this.size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (0 == this.size);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node(o);
        Node lastNodeBeforePush = this.LAST.getPredecessor();
        lastNodeBeforePush.setSuccessor(node);
        node.setPredecessor(lastNodeBeforePush);
        node.setSuccessor(this.LAST);
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node currentNode = this.FIRST.getSuccessor();
        boolean removed = true;
        while((this.LAST != currentNode) && removed) {
            if (currentNode.getValue().equals(o)) {
                Node successor = currentNode.getSuccessor();
                Node predecessor = currentNode.getPredecessor();
                currentNode.getPredecessor().setSuccessor(successor);
                currentNode.getSuccessor().setPredecessor(predecessor);
                removed = false;
            }
        }
        return removed;
    }

    @Override
    public boolean addAll(Collection c) {
        c.stream().forEach(element -> this.add(element));
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}