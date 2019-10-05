public class Node<E> {

    private Node predecessor;
    private Node successor;
    private E value;

    public Node(E value) {
        this.value = value;
    }

    public Node() {}

    public E getValue() {
        return value;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public Node getSuccessor() {
        return successor;
    }

    public void setSuccessor(Node successor) {
        this.successor = successor;
    }
}
