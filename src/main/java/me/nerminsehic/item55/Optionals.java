package me.nerminsehic.item55;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class Optionals {
    /**
     * A refactoring of a method from item30 that returns an Optional rather
     * than throwing an exception.
     * @param collection
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> collection) {
        if(collection.isEmpty())
            return Optional.empty();

        E result = null;
        for(E element: collection) {
            if(result == null || element.compareTo(result) > 0)
                result = Objects.requireNonNull(element);
        }

        return Optional.of(result);
    }

    /**
     * Since many stream terminal operations return streams, we can write the above method to use a stream
     * and pass in an explicit comparator.
     * @param collection
     * @return
     * @param <E>
     */
    public static <E extends Comparable<E>> Optional<E> maxUsingStream(Collection<E> collection) {
        return collection.stream().max(Comparator.naturalOrder());
    }
}
