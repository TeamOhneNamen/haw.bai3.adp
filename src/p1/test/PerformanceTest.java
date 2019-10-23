package p1.test;

import p1.datastructures.DoublyLinkedList;
import p1.util.Stopwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PerformanceTest {

    private static final String INSERT = "insert";
    private static final String DELETE_AT_POSITION = "deleteAtPosition";
    private static final String REMOVE_ELEMENT = "remove";
    private static final String CONTAINS = "contains";

    private static final String ELEMENT = "asdf";
    private static final int LIST_SIZE = 400000*2;
    private static final int TIMES = 500;
    private static final int EXPERIMENTS = 10;
    private static final int POSITION= LIST_SIZE/2;

    public static void main(String [] args) {
        String method;
        int listSize;
        int times;
        int experiments;

        if(4 == args.length){
            method = args[0];
            listSize = Integer.valueOf(args[3]);
            times = Integer.valueOf(args[2]);
            experiments = Integer.valueOf(args[1]);
        }else {
            method = INSERT;
            listSize = LIST_SIZE;
            times = TIMES;
            experiments = EXPERIMENTS;
        }

        System.out.println(method+" "+times+"-mal,\t"+"Listenlaenge="+listSize+", "+"\tAnzahl Exp="+experiments);
        System.out.println("WDH "+"Zeit(ms) "+"Zeit/repOp(ms)");

        ArrayList<Integer> arr=new ArrayList<>(Collections.nCopies(listSize, 0));
        for(int count = 0; count < experiments ; count++) {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(arr);
            Stopwatch stopwatch = new Stopwatch();
            for(int innerCount = 0; innerCount < times ; innerCount++) {
                switch(method){
                    case INSERT:
                        doublyLinkedList.insertAtPosition(POSITION, ELEMENT);
                        break;
                    case DELETE_AT_POSITION:
                        doublyLinkedList.deleteAtPosition(POSITION);
                        break;
                    case REMOVE_ELEMENT:
                        doublyLinkedList.remove(ELEMENT);
                        break;
                    case CONTAINS:
                        doublyLinkedList.contains(ELEMENT);
                        break;
                    default:
                        System.err.println(method + "is not a valid value");
                }

            }

            double elapsedTime = stopwatch.elapsedTime();
            double rate = elapsedTime / times;
            System.out.println(times+"\t"+elapsedTime+"\t"+rate);
        }
    }
}
