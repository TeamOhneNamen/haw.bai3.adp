import util.Stopwatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PerformanceTest {

    public static final String INSERT = "insert";

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
            listSize = 400000;
            times = 2;
            experiments = 10;
        }

        printTableHead(method, listSize, times, experiments);
        switch(method){
            case INSERT:
                PerformanceTest.insertAtPositionPerformanceTest(listSize, Integer.valueOf(times), Integer.valueOf(experiments));
                break;
            default:
                System.err.println(method + "is not a valid value");
        }
    }

    private static void insertAtPositionPerformanceTest(int listSize, int times, int experiments) {
        ArrayList<Integer> arr=new ArrayList<Integer>(Collections.nCopies(listSize, 0));
        int position = 0;
        for(int count = 0; count < experiments ; count++) {
            DoublyLinkedList emptyDoublyLinkedList = new DoublyLinkedList();
            Stopwatch stopwatch = new Stopwatch();
            for(int innerCount = 0; innerCount < times ; innerCount++) {
                arr.forEach(element -> emptyDoublyLinkedList.insertAtPosition(position, element));
            }
            double elapsedTime = stopwatch.elapsedTime();
            double rate = elapsedTime / times;
            System.out.println(times+"\t"+elapsedTime+"\t"+rate);
        }

    }

    private static void printTableHead(String method, int listSize, int times, int experiments) {
        System.out.println(method+" "+times+"-mal,\t"+"Listenlaenge="+listSize+", "+"\tAnzahl Exp="+experiments);
        System.out.println("WDH "+"Zeit(ms) "+"Zeit/repOp(ms)");}
}
