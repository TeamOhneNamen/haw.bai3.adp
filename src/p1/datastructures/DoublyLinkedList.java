package p1.datastructures;

import p1.interfaces.ListInterface;

import java.util.*;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements ListInterface<E> {
    private final Node<E> FIRST = new Node<>();
    private final Node<E> LAST = new Node<>();
    private int size;
    private final String SEPARATOR;

    public DoublyLinkedList() {
        this.size = 0;
        this.FIRST.setPredecessor(this.LAST);
        this.FIRST.setSuccessor(this.LAST);
        this.LAST.setPredecessor(this.FIRST);
        this.LAST.setSuccessor(this.FIRST);
        SEPARATOR = ", ";
    }

    public DoublyLinkedList(List list) {
        this.size = 0;
        this.FIRST.setPredecessor(this.LAST);
        this.FIRST.setSuccessor(this.LAST);
        this.LAST.setPredecessor(this.FIRST);
        this.LAST.setSuccessor(this.FIRST);
        this.addAll(list);
        SEPARATOR = ", ";
    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> secondLastNode = this.LAST.getPredecessor().getPredecessor();
        this.LAST.setPredecessor(secondLastNode);
        secondLastNode.setSuccessor(this.LAST);
        this.size--;
    }

    @Override
    public void removeFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> secondNode = this.FIRST.getSuccessor().getSuccessor();
        this.FIRST.setSuccessor(secondNode);
        secondNode.setPredecessor(this.FIRST);
        this.size--;
    }

    @Override
    public void deleteAtPosition(int index) {
        if(size-1 < index){
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = this.FIRST.getSuccessor();
        while (index > 0) {
            currentNode = currentNode.getSuccessor();
            index--;
        }
        Node<E> predecessor = currentNode.getPredecessor();
        Node<E> successor = currentNode.getSuccessor();
        predecessor.setSuccessor(successor);
        successor.setPredecessor(predecessor);
        this.size--;
    }

    @Override
    public void insertAtPosition(int index, E item) {
        if(size < index){
            throw new IndexOutOfBoundsException();
        }
        Node<E> nodeToInsert = new Node<>(item);
        Node<E> currentNode = this.FIRST.getSuccessor();
        while (index > 0) {
            currentNode = currentNode.getSuccessor();
            index--;
        }
        Node<E> predecessorCurrentNode = currentNode.getPredecessor();
        predecessorCurrentNode.setSuccessor(nodeToInsert);
        currentNode.setPredecessor(nodeToInsert);
        nodeToInsert.setPredecessor(predecessorCurrentNode);
        nodeToInsert.setSuccessor(currentNode);
        this.size++;
    }

    @Override
    public E retrieve(int index) {
        if(size-1 < index){
            throw new IndexOutOfBoundsException();
        }
        Node<E> currentNode = this.FIRST.getSuccessor();
        while (index > 0) {
            currentNode = currentNode.getSuccessor();
            index--;
        }
        return currentNode.getValue();
    }

    //@Override
    public int size() {
        return this.size;
    }

    //@Override
    public boolean isEmpty() {
        return (0 == this.size);
    }

    //@Override
    public boolean contains(Object o) {
        boolean contains = false;
        for (E element : this) {
            if (element == o) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    //@Override
    public boolean add(E o) {
        Node<E> node = new Node<>(o);
        Node<E> lastNodeBeforePush = this.LAST.getPredecessor();
        lastNodeBeforePush.setSuccessor(node);
        this.LAST.setPredecessor(node);
        node.setPredecessor(lastNodeBeforePush);
        node.setSuccessor(this.LAST);
        this.size++;
        return true;
    }

    //@Override
    public boolean remove(Object o) {
        Node<E> currentNode = this.FIRST.getSuccessor();
        boolean removed = false;
        while ((this.LAST != currentNode) && !removed) {
            if (currentNode.getValue().equals(o)) {
                Node<E> successor = currentNode.getSuccessor();
                Node<E> predecessor = currentNode.getPredecessor();
                currentNode.getPredecessor().setSuccessor(successor);
                currentNode.getSuccessor().setPredecessor(predecessor);
                removed = true;
            }
            currentNode = currentNode.getSuccessor();
        }
        return removed;
    }

    //@Override
    public boolean addAll(Collection c) {
        c.forEach(element -> this.add((E) element));
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node currentNode = this.FIRST.getSuccessor();
        stringBuilder.append("[");
        while (this.LAST != currentNode) {
            stringBuilder.append(currentNode.getValue().toString());
            currentNode = currentNode.getSuccessor();
            if (this.LAST != currentNode) {
                stringBuilder.append(this.SEPARATOR);
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Collection<?>)) {
            return false;
        } else if (((Collection) o).size() != this.size()) {
            return false;
        } else {
            return Arrays.equals(this.toArray(), ((Collection) o).toArray());
        }
    }

    public Object[] toArray() {
        return toList().toArray();
    }

    private List<E> toList() {
        List<E> list = new ArrayList<>();
        this.forEach(list::add);
        return list;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private int currentIndex = 0;
            private Node<E> currentNode = FIRST.getSuccessor();

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                currentIndex++;
                currentNode = currentNode.getSuccessor();
                return currentNode.getValue();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        this.iterator().forEachRemaining(action);
    }
}
