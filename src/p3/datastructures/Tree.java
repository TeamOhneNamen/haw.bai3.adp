package p3.datastructures;

import p3.interfaces.ITree;

/***
 * Implementation of the binary search tree
 * @param <Key>
 * @param <Value>
 */
public class Tree<Key extends Comparable<? super Key>, Value> implements ITree<Key, Value>  {

    public Node<Key, Value> root;

    /**
     * Schreiben Sie einen Konstruktor, dem Sie einenBST übergeben, aus dem ein Treeerzeugt wird. Der Treesoll die BST Eigenschaft erfüllen.
     */
    public Tree(BST bst){
        bst.levelOrder().forEach(key -> this.put((Key)key, (Value) bst.get((Key)key)));
    }
    public Tree(Key key, Value value){
        this.root = new Node<>(key, value);
    }
    private Tree(){ }


    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo((Key)x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.value   = val;
        return x;
    }

    // return number of key-value pairs in BST rooted at x
    private Value size(Node x) {
        return (Value) x.value;
    }


    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        this.root = delete(this.root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo((Key)x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    @Override
    public String toString(){
        return nodeToString(0, this.root);
    }
    private String nodeToString(int level, Node node){
        if(null == node){
            return "NULL";
        }
        return String.valueOf(level) + " " +
                node.key.toString() + "-" +
                node.value.toString() +
                "[" +
                nodeToString(level + 1, node.left) +
                " " +
                nodeToString(level + 1, node.right) +
                "]";
    }

    public Value get(Key key){ return this.get(this.root,key); }

    /**
     * get value of the given key searched in the given Node
     * @param node
     * @param key
     * @return value of the key
     */
    private Value get(Node node, Key key ) {
        if ( node.key.equals( key ) )  {
            return (Value) node.value;
        }

        if ( key.compareTo( (Key)node.key ) < 0 ) {
            return node.left.value == null ? null : get(node.left,key);
        }
        else {
            return node.right.value == null ? null : get(node.right,key);
        }
    }

    /***
     * replaces oldKey with newKey
     * only works if the tree is in order
     * @param oldKey key which should be replaced
     * @param newKey key which replaces oldKey
     * @throws NullPointerException if the tree is not ordered
     */
    @Override
    public void changeKey(Key oldKey, Key newKey){
        changeKey(this.root, oldKey, newKey);
    }
    private void changeKey(Node node, Key oldKey, Key newKey){
        if(null != node){
            if(node.key.equals(oldKey)){
                node.key = newKey;
            }else{
                changeKey(node.left, oldKey, newKey);
                changeKey(node.right, oldKey, newKey);
            }
        }
    }

    /***
     * https://en.wikipedia.org/wiki/Binary_search_tree#Verification
     * @param minKey the minimal key in the binary search tree
     * @param maxKey the maximal key in the binary search tree
     * @return boolean if the tree is in the binary search tree order
     */
    @Override
    public boolean isOrdered(Key minKey, Key maxKey){
        return this.isOrdered(this.root, minKey, maxKey);
    }
    private boolean isOrdered(Node node, Key minKey, Key maxKey){
        if(null == node) return true;
        if(node.key.compareTo(minKey) < 0 || node.key.compareTo(maxKey) > 0){
            return false;
        }
        return isOrdered(node.left, minKey, (Key) node.key) && isOrdered(node.right, (Key) node.key, maxKey);
    }
}
