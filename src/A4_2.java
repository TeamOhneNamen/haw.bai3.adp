import java.util.Arrays;
import java.util.List;

public class A4_2 {


    private final static List<Integer> PRIME_NUMBERS =List.of(0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199);
    public static void main(String[] args) {
        hash("VERYIMPOTANS");
    }


    private static void hash(String string){
        //size of the hash table (Buch Listing 3.17)
        int M = 17;
        int[] hashes = new int[string.length()];
        int prime_number_index = 0;
        do {
            System.out.print(PRIME_NUMBERS.get(prime_number_index) + ": \t\t");
            for (int i = 0; i < string.length(); i++) {
                hashes[i] = hash(PRIME_NUMBERS.get(prime_number_index), M, string.charAt(i));
                System.out.print(hashes[i] + "\t");
            }
            System.out.println();
            prime_number_index++;
        }
        while(hasDuplicates(hashes));
        System.out.println();
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i)+"\t");
        }
    }
    //perfect hash function for a set S is a hash function that maps distinct elements in S to a set of integers, with no collisions
    private static int hash(int a, int M, char character){
        return (a * (int)character) % M;
    }

    private static boolean hasDuplicates(int[] arry){
        for (int j=0;j<arry.length;j++) {
            for (int k=j+1;k<arry.length;k++) {
                if (arry[k]==arry[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
