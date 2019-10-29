package p2.test;

import p1.datastructures.DoublyLinkedList;
import p1.util.Stopwatch;
import p2.util.MergeSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SplittableRandom;

public class RuntimeTest {

    private static final String MERGE_TOP_DOWN = "mergeTopDown";

    private static final String ELEMENT = "asdf";
    private static final int LIST_SIZE = 4000;
    private static final int ITERATIONS = 30;
    private static final int STEP_SIZE = LIST_SIZE/4;

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String method;
        int listSize;
        int iterations;

        if (3 == args.length) {
            method = args[0];
            listSize = Integer.valueOf(args[3]);
            iterations = Integer.valueOf(args[2]);
        } else {
            method = MERGE_TOP_DOWN;
            listSize = LIST_SIZE;
            iterations = ITERATIONS;
        }

        stringBuilder.append("method;" + "size;" + "time(ms);" + "size/time(ms)\n");


        for (int count = 0; count < iterations; count++) {
            ArrayList<Integer> arr = new ArrayList<>(Collections.nCopies(listSize, 0));
            Stopwatch stopwatch = new Stopwatch();
            switch (method) {
                case MERGE_TOP_DOWN:
                    break;
                default:
                    System.err.println(method + "is not a valid value");

            }

            double elapsedTime = stopwatch.elapsedTime();
            double rate = listSize / elapsedTime;
            stringBuilder.append(method + ";" + listSize + ";" + elapsedTime + ";" + rate+"\n");
            listSize = listSize + STEP_SIZE;
        }
        String printSTring = stringBuilder.toString().replace(".", ",");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("./src/p2/log/"+method+".csv"), "utf-8"))) {
            writer.write(printSTring);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}