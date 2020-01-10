package p4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashAttack {
    static int lowest_ascii = 65; //==A
    static int highest_ascii = 122; //==z
    final int MAX_N = 8;
    static int N = 1;

    public static void main(String[] args) {
        attack();
    }

    public static int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 31) + s.charAt(i);
        }
        return hash;
    }

    public static void attack(){
        List<String> words = HashAttack.generateWords((char)lowest_ascii,(char)highest_ascii, (int)Math.pow(2,N));
        Map<String, Integer> hashesWords = new HashMap<>();
        words.forEach(word -> hashesWords.put(word,hash(word)));
        //https://stackoverflow.com/a/22990086
        Map<Integer, Long> occurrences = hashesWords.values().stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        occurrences.forEach((hash, occurs) -> {
            if(occurs == (int)Math.pow(2,N)){
                System.out.println("with N=="+N+" it found: "+keys(hashesWords,hash));
            }
        });
    }

    // https://stackoverflow.com/a/19934822
    private static List<String> generateWords(char min, char max, int n) {
        List<String> ret = new ArrayList<String>();
        if(n == 0) {
            ret.add("");
            return ret;
        }
        for(String word : generateWords(min, max, n - 1)) {
            for(char c = min; c <= max; ++c) {
                ret.add(word + c);
            }
        }
        return ret;
    }

    //https://www.baeldung.com/java-map-key-from-value
    private static <K, V> List<K> keys(Map<K, V> map, V value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
