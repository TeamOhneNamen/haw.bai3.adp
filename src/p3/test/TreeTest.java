package p3.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p3.datastructures.BST;
import p3.datastructures.Node;
import p3.datastructures.Tree;

class TreeTest {

    private Tree<Character,Integer> padbergTree;
    private Tree<Integer,String> wikipediaTreeNotBST;
    private String padbergTreeString;
    private Node<Character, String> node_l_r_l_r_r;
    private BST<String, Integer> bst = new BST<String, Integer>();

    @BeforeEach
    void SetUp() {
        preparePadbergTree();
        prepareWikipedia();
    }

    private void preparePadbergTree() {
        ////
        String test = "S E A R C H E X A M P L E";
        String[] keys = test.split(" ");
        int n = keys.length;
        for (int i = 0; i < n; i++)
            bst.put(keys[i], i);
        ////
        this.padbergTreeString = "0 S-5[1 E-5[2 A-10[NULL 3 C-11[NULL NULL]] 2 R-8[3 H-3[NULL 4 M-7[5 L-5[NULL NULL] 5 P-4[NULL NULL]]] NULL]] 1 X-0[NULL NULL]]";
        this.padbergTree = new Tree<>('S', 5);
        Node<Character, Integer> node_l = new Node<>('E', 5);
        Node<Character, Integer> node_r = new Node<>('X', 0);
        Node<Character, Integer> node_l_l = new Node<>('A', 10);
        Node<Character, Integer> node_l_r = new Node<>('R', 8);
        Node<Character, Integer> node_l_l_r = new Node<>('C', 11);
        Node<Character, Integer> node_l_r_l = new Node<>('H', 3);
        Node<Character, Integer> node_l_r_l_r = new Node<>('M', 7);
        Node<Character, Integer> node_l_r_l_r_l = new Node<>('L', 5);
        node_l_r_l_r_r = new Node('P', 4);
        this.padbergTree.root.insertLeft(node_l);
        this.padbergTree.root.insertRight(node_r);
        node_l.insertLeft(node_l_l);
        node_l.insertRight(node_l_r);
        node_l_l.insertRight(node_l_l_r);
        node_l_r.insertLeft(node_l_r_l);
        node_l_r_l.insertRight(node_l_r_l_r);
        node_l_r_l_r.insertLeft(node_l_r_l_r_l);
        node_l_r_l_r.insertRight(node_l_r_l_r_r);
    }

    private void prepareWikipedia() {
        this.wikipediaTreeNotBST = new Tree<>(20, "Wurzel");
        this.wikipediaTreeNotBST.root.insertLeft(10,"Linkes Kind");
        Node<Integer,String> rechtes_kind = new Node<>(30, "Rechtes Kind");
        this.wikipediaTreeNotBST.root.insertRight(rechtes_kind);
        rechtes_kind.insertLeft(5, "Linker Enkel");
        rechtes_kind.insertRight(40, "Rechter Enkel");
    }

    @Test
    void treeTest(){
        Assertions.assertEquals(this.padbergTreeString,this.padbergTree.toString());
    }

    @Test
    void isOrderedTestNegative(){
        Assertions.assertFalse(this.wikipediaTreeNotBST.isOrdered(1,50));
    }

    @Test
    void isOrderedTestPositive(){
        Assertions.assertTrue(this.padbergTree.isOrdered('A','Z'));
    }

    @Test
    void getTest(){
        Assertions.assertEquals(this.node_l_r_l_r_r.value, this.padbergTree.get(this.node_l_r_l_r_r.key));
    }

    @Test
    void changeKeyTest(){
        Character key = 'Y';
        Assertions.assertTrue(this.padbergTree.isOrdered('A','Z'));
        this.padbergTree.changeKey(this.node_l_r_l_r_r.key, key);
        Assertions.assertFalse(this.padbergTree.isOrdered('A','Z'));
    }

    @Test
    void ofBSTTest(){
        Tree tree = new Tree(this.bst);
        Assertions.assertTrue(tree.isOrdered(bst.min(),bst.max()));
    }
}
