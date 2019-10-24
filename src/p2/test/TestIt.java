package p2.test;

import p2.datastructures.Warteschlange;
import p2.interfaces.IWarteschlange;
import p2.util.BottomUpMergesort;

public class TestIt {


    public static void main(String[] args) {

        Warteschlange<Warteschlange<String>> warteschlangen = new Warteschlange<>();

        for (int i = 0; i < 5; i++) {
            Warteschlange<String> w1 = new Warteschlange<>();
            for (int j = 0; j < 10; j++) {
                w1.add(j + "Element");
            }
            warteschlangen.add(w1);
        }

        System.out.println(warteschlangen.toString());
        warteschlangen = BottomUpMergesort.sort(warteschlangen);
        System.out.println(warteschlangen.toString());

    }

}
