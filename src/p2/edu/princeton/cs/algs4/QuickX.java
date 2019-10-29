package p2.edu.princeton.cs.algs4;

/******************************************************************************
 *  Compilation:  javac QuickX.java
 *  Execution:    java QuickX < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/23quicksort/tiny.txt
 *                https://algs4.cs.princeton.edu/23quicksort/words3.txt
 *
 *  Uses the Hoare's 2-way partitioning scheme, chooses the partitioning
 *  element using median-of-3, and cuts off to insertion sort.
 *
 ******************************************************************************/

import p2.util.Insertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * The {@code QuickX} class provides static methods for sorting an array
 * using an optimized version of quicksort (using Hoare's 2-way partitioning
 * algorithm, median-of-3 to choose the partitioning element, and cutoff
 * to insertion sort).
 * <p>
 * For additional documentation,
 * see <a href="https://algs4.cs.princeton.edu/23quick">Section 2.3</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class QuickX {

    // cutoff to insertion sort, must be >= 1
    private static final int INSERTION_SORT_CUTOFF = 8;

    // This class should not be instantiated.
    private QuickX() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        // StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        /**
         * @author Thorben
         */
        System.out.println("array to sort: " + Arrays.toString(Arrays.copyOfRange(a, lo, hi)));

        // cutoff to insertion sort (Insertion.sort() uses half-open intervals)
        int n = hi - lo + 1;
        if (n <= INSERTION_SORT_CUTOFF) {
            Insertion.sort(a, lo, hi + 1);
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int n = hi - lo + 1;
        int m = median5(a, lo, lo + n / 2, hi);
        exch(a, m, lo);

        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        // a[lo] is unique largest element
        while (less(a[++i], v)) {
            if (i == hi) {
                exch(a, lo, hi);
                return hi;
            }
        }

        // a[lo] is unique smallest element
        while (less(v, a[--j])) {
            if (j == lo + 1) return lo;
        }

        // the main loop
        while (i < j) {
            exch(a, i, j);
            while (less(a[++i], v)) ;
            while (less(v, a[--j])) ;
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    // return the index of the median element among a[i], a[j], and a[k]
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
                (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
                (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }

    /**
     * @link https://www.u-helmich.de/inf/BlueJ/kurs121/folge13/Quicksort.pdf
     * @author Thorben
     * @return the index of the median element among a[i], a[j], and a[k]
     */
    private static int median5(Comparable[] a, int i, int j, int k) {
        int l = (i+j)/2;
        int m = (j+k)/2;
        return median5(a, i, j, k, l, m);
    }

    private static int median5(Comparable[] a, int i, int j, int k, int l, int m) {
        Comparable[] medianArray = {a[i], a[j], a[k], a[l], a[l], a[m]};
        Arrays.sort(medianArray);
        if(medianArray.equals(a[i])){
            return i;
        } else if(medianArray.equals(a[j])){
            return j;
        } else if(medianArray.equals(a[k])){
            return k;
        } else if(medianArray.equals(a[l])){
            return l;
        }else {
            return m;
        }
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; quicksorts them
     * (using an optimized version of 2-way quicksort);
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            while (true) {

                System.out.print("Enter something : ");
                String input = br.readLine();
                br.close();
                String[] a = input.split(" ");

                QuickX.sort(a);
                assert isSorted(a);
                System.out.print("result: ");
                show(a);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
