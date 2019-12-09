package p3.datastructures;

import p3.interfaces.ITree;

/***
 * Implementation of the binary search tree
 * @param <Key>
 * @param <Value>
 */
public class Tree<Key extends Comparable<? super Key>, Value> implements ITree<Key, Value>  {

    public Node<Key, Value> root;
    public Tree(Key key, Value value){
        this.root = new Node<>(key, value);
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
