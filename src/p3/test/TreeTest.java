package p3.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import p3.datastructures.ArrayST;
import p3.datastructures.Node;
import p3.datastructures.Tree;

public class TreeTest {

    Tree<String,Integer> tree;
    String padbergTreeString;
    Node<String, String> node_l_r_l_r_r;

    //0 S-5[1 E-5[2 A-10[NULL 3 C-11[NULL NULL]] 2 R-8[3 H-3[NULL 4 M-7[5 L-5[NULL NULL] 5 P-4[NULL NULL]]] NULL]] 1 X-0[NULL NULL]]
    //Lies: Der Root hat die Ebene 0 mit Key S und Wert 5, einen linken Teilbaum der Ebene 1 mit Schlüssel E, Wert 5 usw.
    @BeforeEach
    void SetUp() {
        this.padbergTreeString = "0 S-5[1 E-5[2 A-10[NULL 3 C-11[NULL NULL]] 2 R-8[3 H-3[NULL 4 M-7[5 L-5[NULL NULL] 5 P-4[NULL NULL]]] NULL]] 1 X-0[NULL NULL]]";
        this.tree = new Tree<>("S", 5);
        Node<String, Integer> node_l = new Node<>("E", 5);
        Node<String, Integer> node_r = new Node<>("X", 0);
        Node<String, Integer> node_l_l = new Node<>("A", 10);
        Node<String, Integer> node_l_r = new Node<>("R", 8);
        Node<String, Integer> node_l_l_r = new Node<>("C", 11);
        Node<String, Integer> node_l_r_l = new Node<>("H", 3);
        Node<String, Integer> node_l_r_l_r = new Node<>("M", 7);
        Node<String, Integer> node_l_r_l_r_l = new Node<>("L", 5);
        node_l_r_l_r_r = new Node("P", 4);
        this.tree.root.insertLeft(node_l);
        this.tree.root.insertRight(node_r);
        node_l.insertLeft(node_l_l);
        node_l.insertRight(node_l_r);
        node_l_l.insertRight(node_l_l_r);
        node_l_r.insertLeft(node_l_r_l);
        node_l_r_l.insertRight(node_l_r_l_r);
        node_l_r_l_r.insertLeft(node_l_r_l_r_l);
        node_l_r_l_r.insertRight(node_l_r_l_r_r);
    }

    @Test
    void treeTest(){
        Assertions.assertEquals(this.padbergTreeString,this.tree.toString());
    }

    @Test
    void getTest(){
        Assertions.assertEquals(this.node_l_r_l_r_r.value, this.tree.get(this.node_l_r_l_r_r.key));
    }

    @Test
    void changeKeyTest(){
        String key = "Y";
        System.out.println(this.tree);
        //this.tree.changeKey(this.node_l_r_l_r_r.key, key);
        System.out.println(this.tree);
        Assertions.assertEquals(this.node_l_r_l_r_r.value, this.tree.get(key));
    }
}
