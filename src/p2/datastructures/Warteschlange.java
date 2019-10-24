package p2.datastructures;

import p2.interfaces.IWarteschlange;

import java.util.ArrayList;

public class Warteschlange<E> extends ArrayList<E> implements IWarteschlange<E> {
    @Override
    public E pop() {
        E elemtent = get(0);
        remove(0);
        return elemtent;
    }

    @Override
    public void push(E item) {
        add(size(), item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            if(i!=0){
                sb.append(", ");
            }
            sb.append(get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
