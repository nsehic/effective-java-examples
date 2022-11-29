package me.nerminsehic.item47;

import java.util.*;

public class PowerSet {
    public static <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if(src.size() > 30)
            throw new IllegalArgumentException("Set too big " + s);

        return new AbstractList<>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for(int i = 0; index != 0; i++, index >>= 1)
                    if((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && new HashSet<>(src).containsAll((Set) o);
            }

            @Override
            public int size() {
                return 1 << src.size();
            }
        };
    }
}
