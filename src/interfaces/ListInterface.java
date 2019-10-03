package interfaces;

import java.util.Collection;

public interface ListInterface<E> extends Collection<E>, Iterable<E> {
    void pop();
}