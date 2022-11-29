package me.nerminsehic.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamAdapter {

    // Adapter method from Stream<E> to Iterable<E>
    // Makes it possible to use for-each on streams
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    // Adapter from Iterable<E> to Stream<E>
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static void main(String[] args) {
        // How to use adapter method to use for-each on streams (but actually iterable)
        for(ProcessHandle p: iterableOf(ProcessHandle.allProcesses())) {
            System.out.println(p);
        }
    }
}
