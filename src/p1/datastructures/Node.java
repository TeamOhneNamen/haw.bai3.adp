package p1.datastructures;

public class Node<E> {

    private Node<E> predecessor;
    private Node<E> successor;
    private E value;

    public Node(E value) {
        this.value = value;
    }

    public Node() {}

    public E getValue() {
        return value;
    }

    public Node<E> getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node<E> predecessor) {
        this.predecessor = predecessor;
    }

    public Node<E> getSuccessor() {
        return successor;
    }

    public void setSuccessor(Node<E> successor) {
        this.successor = successor;
    }
}
