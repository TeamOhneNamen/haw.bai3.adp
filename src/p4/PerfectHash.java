package p4;

import java.util.HashSet;

public class PerfectHash {

    private static int M;
    private static int a;
    private static HashSet<Integer> hashes = new HashSet<>();
    private final static String str = "VERYIMPOTANS";

    private static int hash(char c){
        return ((a* ((int) c)) % M);
    }

    public static void main(String[] args) {
        for (M = 1; M==M; M++){
            for (a = 1; a < M; a++) {
                hashes.clear();
                for (char c: str.toCharArray()) {
                    hashes.add(hash(c));
                }
                if(hashes.size() == str.length()){
                    System.out.println("M: "+M+" a: "+a+" "+hashes);
                    return;
                }
            }
        }
    }
}