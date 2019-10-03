public class Node {

    private Node predecessor;
    private Node successor;
    private Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node() {}

    public Object getValue() {
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
