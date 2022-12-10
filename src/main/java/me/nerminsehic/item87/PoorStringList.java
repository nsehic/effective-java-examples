package me.nerminsehic.item87;


import java.io.Serializable;

// Awful candidate for default serialized form.
public class PoorStringList implements Serializable {
    private int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable {
        String data;
        Entry next;
        Entry previous;
    }

    // ... Remainder omitted
}
