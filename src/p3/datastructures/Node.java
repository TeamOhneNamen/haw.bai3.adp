package p3.datastructures;

public class Node<Key, Value> {
    public Key key;
    public Value value;
    public Node left;
    public Node right;
    public Node parent;

    public Node(Key key, Value value){
        this.key = key;
        this.value = value;
    }

    public void insertLeft(Node node){
        this.left = node;
        this.left.parent = this;
    }

    public void insertLeft(Key key, Value value){
        this.insertLeft(new Node<Key, Value>(key, value));
    }

    public void insertRight(Node node){
        this.right = node;
        this.right.parent = this;
    }

    public void insertRight(Key key, Value value){
        this.insertRight(new Node<Key, Value>(key, value));
    }
}
