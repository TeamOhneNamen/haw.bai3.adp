package p2.util;

import p2.datastructures.Warteschlange;

import java.util.Random;

public class BottomUpMergesort {

    public static <T> Warteschlange<T> shuffle(Warteschlange<T> warteschlange1, Warteschlange<T> warteschlange2){

        Warteschlange<T> returnSchlange = new Warteschlange<>();
        for (int i = 0; i < warteschlange1.size(); i++) {
            Random random = new Random();
            int randomIntInRange;
            if(returnSchlange.size()==0){
                randomIntInRange = 0;
            }else{
                randomIntInRange = random.nextInt(returnSchlange.size());
            }
            returnSchlange.add(randomIntInRange, warteschlange1.get(i));
        }

        for (int i = 0; i < warteschlange2.size(); i++) {
            Random random = new Random();
            int randomIntInRange;
            if(returnSchlange.size()==0){
                randomIntInRange = 0;
            }else{
                randomIntInRange = random.nextInt(returnSchlange.size());
            }
            returnSchlange.add(randomIntInRange, warteschlange2.get(i));
        }

        return returnSchlange;
    }

    public static <E> Warteschlange<Warteschlange<E>> sort(Warteschlange<Warteschlange<E>> warteschlange){

        while(warteschlange.size()>1){
            Warteschlange<E> w1 = warteschlange.pop();
            Warteschlange<E> w2 = warteschlange.pop();
            warteschlange.add(shuffle(w1, w2));
        }
        return warteschlange;
    }

}
