package me.nerminsehic.item30;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CollectionUtil {

    /*
    * Generic method
    * Improved to the below code with generates compiler warnings
    *
    * public static Set union(Set s1, Set s1) {
    *   Set result = new HashSet(s1);
    *   result.addAll(s2);
    *   return result;
    * }
    * */
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /*
    * Recursive type bound
    */
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if(c.isEmpty())
            throw new IllegalArgumentException("Empty collection");

        E result = null;
        for(E e: c) {
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }

        return result;
    }
}
