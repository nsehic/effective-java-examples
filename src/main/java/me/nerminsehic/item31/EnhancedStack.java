package me.nerminsehic.item31;

import me.nerminsehic.item29.Stack;

import java.util.Collection;

/*
* For maximum flexibility, use wildcard types on input parameters that represent producers or consumers.
*
* Here is a mnemonic to help you remember which wildcard type to use:
* PECS
* producer-extends, consumer-super
* */
public class EnhancedStack<E> extends Stack<E> {
    public void pushAll(Iterable<? extends E> src) {
        for(E e: src)
            push(e);
    }

    public void popAll(Collection<? super E> dst) {
        while(!isEmpty())
            dst.add(pop());
    }
}
