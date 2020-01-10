package p4;

import java.util.ArrayList;
import java.util.List;

public class HashAttack {
    static int lowest_ascii = 33;
    static int highest_ascii = 126;
    final int MAX_N = 8;
    static int N = 1;
    static ArrayList<Character> characters = new ArrayList<Character>();

    public static int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 31) + s.charAt(i);
        }
        return hash;
    }
    private static void fillCharacters(){
        for (int i = lowest_ascii; i < highest_ascii; i++) {
            characters.add((char)i);
        }
    }
    public static List attack(){
        List<String> strings = new ArrayList<String>();
        int length = (int)Math.pow(2,N)-1;
        //TODO
//        for (int i = 0; i < length; i++) {
//
//        }
        return null;
    }
}
