import interfaces.ListInterface;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DoublyLinkedList<E> implements ListInterface<E> {
    private final Node FIRST = new Node();
    private final Node LAST = new Node();
    private int size;
    private final String SEPARATOR = ", ";

    DoublyLinkedList() {
        this.size = 0;
        this.FIRST.setPredecessor(this.LAST);
        this.FIRST.setSuccessor(this.LAST);
        this.LAST.setPredecessor(this.FIRST);
        this.LAST.setSuccessor(this.FIRST);
    }

    DoublyLinkedList(List list) {
        this.size = 0;
        this.FIRST.setPredecessor(this.LAST);
        this.FIRST.setSuccessor(this.LAST);
        this.LAST.setPredecessor(this.FIRST);
        this.LAST.setSuccessor(this.FIRST);
        this.addAll(list);
    }

    @Override
    public void removeLast() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node secondLastNode = this.LAST.getPredecessor().getPredecessor();
        this.LAST.setPredecessor(secondLastNode);
        secondLastNode.setSuccessor(this.LAST);
        this.size--;
    }

    @Override
    public void removeFirst() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node secondNode = this.FIRST.getSuccessor().getSuccessor();
        this.FIRST.setSuccessor(secondNode);
        secondNode.setPredecessor(this.FIRST);
        this.size--;
    }

    @Override
    public void deleteAtPosition(int index) {
        Node currentNode = this.FIRST.getSuccessor();
        while (index > 0) {
            currentNode = currentNode.getSuccessor();
            index--;
        }
        Node predecessor = currentNode.getPredecessor();
        Node successor = currentNode.getSuccessor();
        predecessor.setSuccessor(successor);
        successor.setPredecessor(predecessor);
        this.size--;
    }

    @Override
    public void insertAtPosition(int index, E item) {
        Node nodeToInsert = new Node(item);
        Node currentNode = this.FIRST.getSuccessor();
        while (index > 0) {
            currentNode = currentNode.getSuccessor();
            index--;
        }
        Node predecessorCurrentNode = currentNode.getPredecessor();
        predecessorCurrentNode.setSuccessor(nodeToInsert);
        currentNode.setPredecessor(nodeToInsert);
        nodeToInsert.setPredecessor(predecessorCurrentNode);
        nodeToInsert.setSuccessor(currentNode);
        this.size++;
    }

    @Override
    public E retrieve(int index) {
        Node currentNode = this.FIRST.getSuccessor();
        while (index > 0) {
            currentNode = currentNode.getSuccessor();
            index--;
        }
        return (E)currentNode.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (0 == this.size);
    }

    @Override
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

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        //TODO
        return null;
    }

    @Override
    public boolean add(E o) {
        Node<E> node = new Node<>(o);
        Node lastNodeBeforePush = this.LAST.getPredecessor();
        lastNodeBeforePush.setSuccessor(node);
        this.LAST.setPredecessor(node);
        node.setPredecessor(lastNodeBeforePush);
        node.setSuccessor(this.LAST);
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node currentNode = this.FIRST.getSuccessor();
        boolean removed = false;
        while ((this.LAST != currentNode) && !removed) {
            if (currentNode.getValue().equals(o)) {
                Node successor = currentNode.getSuccessor();
                Node predecessor = currentNode.getPredecessor();
                currentNode.getPredecessor().setSuccessor(successor);
                currentNode.getSuccessor().setPredecessor(predecessor);
                removed = true;
            }
            currentNode = currentNode.getSuccessor();
        }
        return removed;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        c.forEach(element -> this.add((E) element));
        return true;
    }

    @Override
    public void clear() {
        //TODO
    }

    @Override
    public boolean retainAll(Collection c) {
        //TODO
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        //TODO
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        //TODO
        return false;
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

    @Override
    public Spliterator<E> spliterator() {
        //TODO
        return null;
    }

    @Override
    public Stream<E> stream() {
        //TODO
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        //TODO
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int currentIndex = 0;
            private Node currentNode = FIRST.getSuccessor();

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                currentIndex++;
                currentNode = currentNode.getSuccessor();
                return (E) currentNode.getValue();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        this.iterator().forEachRemaining(action);
    }
}
