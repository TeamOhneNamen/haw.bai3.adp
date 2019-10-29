package p2.test;

import java.util.List;

public class TestUtil {
    public static boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size()-1; i++){
            if (list.get(i).compareTo(list.get(i+1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
