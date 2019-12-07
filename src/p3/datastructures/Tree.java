package p3.datastructures;

import p3.interfaces.ITree;

public class Tree<Key extends Comparable<? super Key>, Value> implements ITree<Key, Value> {

    public Node<Key, Value> root;

    //0 S-5[1 E-5[2 A-10[NULL 3 C-11[NULL NULL]] 2 R-8[3 H-3[NULL 4 M-7[5 L-5[NULL NULL] 5 P-4[NULL NULL]]] NULL]] 1 X-0[NULL NULL]]
    //Lies: Der Root hat die Ebene 0 mit Key S und Wert 5, einen linken Teilbaum der Ebene 1 mit Schlüssel E, Wert 5 usw.

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(level).append(" ");
        stringBuilder.append(node.key.toString()).append("-");
        stringBuilder.append(node.value.toString());
        stringBuilder.append("[");
        stringBuilder.append(nodeToString(level+1, node.left));
        stringBuilder.append(" ");
        stringBuilder.append(nodeToString(level+1, node.right));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean contains(Key key){
        return this.contains(this.root, key);
    }

    private boolean contains(Node node, Key key){
        if(null != node){
            System.out.print(key+" : ");
            System.out.println(node.key);
            if(node.key.equals(key)){
                System.out.println("hello");
                return true;
            }else{
                contains(node.left, key);
                contains(node.right, key);
            }
        }

        return false;
    }

    public Value get(Key key){ return this.get(this.root,key); }
    private Value get(Node node, Key key ) {
        System.out.println(node.key);
        if ( node.key.equals( key ) )
        {
            return (Value) node.value;
        }

        if ( key.compareTo( (Key)node.key ) < 0 )
        {
            return node.left.value == null ? null : get(node.left,key);
        }
        else
        {
            return node.right.value == null ? null : get(node.right,key);
        }
    }

    @Override
    public void changeKey(Key old, Key newKey){
        changeKey(this.root, old, newKey);
    }

    private void changeKey(Node node, Key old, Key newKey){
        if(null != node){
            if(node.key.equals(old)){
                node.key = newKey;
            }else{
                changeKey(node.left, old, newKey);
                changeKey(node.right, old, newKey);
            }
        }
    }

    @Override
    public boolean isOrdered(){
        return false;
    }
}
