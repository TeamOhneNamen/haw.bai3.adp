package p3.datastructures;

import p3.interfaces.ITree;

public class Tree<Key> implements ITree<Key> {

    public Node root = new Node();

    //0 S-5[1 E-5[2 A-10[NULL 3 C-11[NULL NULL]] 2 R-8[3 H-3[NULL 4 M-7[5 L-5[NULL NULL] 5 P-4[NULL NULL]]] NULL]] 1 X-0[NULL NULL]]
    //Lies: Der Root hat die Ebene 0 mit Key S und Wert 5, einen linken Teilbaum der Ebene 1 mit Schlüssel E, Wert 5 usw.

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node current = this.root;
        int level = 0;
        while(null != current.right){
            level++;
        }
        stringBuilder.append(nodeToString(level, current));
    return stringBuilder.toString();
    }

    private String nodeToString(int level, Node node){
        if(null == node){
            return "NULL";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(level+" ");
        stringBuilder.append(node.key.toString()+"-");
        stringBuilder.append(node.value.toString());
        return stringBuilder.toString();
    }

    @Override
    public void changeKey(Key old, Key newKey){}

    @Override
    public boolean isOrdered(){
        return false;
    }
}
