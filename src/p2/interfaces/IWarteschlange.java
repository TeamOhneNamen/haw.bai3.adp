package p2.interfaces;

import java.util.List;

public interface IWarteschlange<E> {

    E pop();

    void push(E item);

}
