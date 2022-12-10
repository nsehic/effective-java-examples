package me.nerminsehic.item87;

import java.io.*;

// StringList with a reasonable custom serialized form
public class StringList implements Serializable {
    private transient int size = 0;
    private transient Entry head = null;


    // Declare an explicit serial version UID in every class you write
    // There is a small performance benefit (p. 351)
    @Serial
    private static final long serialVersionUID = 1L;

    // No longer Serializable
    private static class Entry {
        String data;
        Entry next;
        Entry previous;

        Entry(String data) {
            this.data = data;
        }
    }

    // Appends the specified string to the list
    // Simple linked list append implementation
    public final void add(String s) {
        Entry entry = new Entry(s);
        Entry current = head;
        while(current.next != null)
            current = current.next;

        current.next = entry;
        entry.previous = current;
    }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings it contains)
     * is emitted ({@code int}), followed by all of its elements
     * (each a {@code String}), in the proper sequence.
     *
     * @param s The {@code ObjectOutputStream} to write to.
     * @throws IOException if an error is thrown during serialization.
     */
    @Serial
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // Write out all elements in the proper order.
        for(Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    @Serial
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // Read in all elements and insert them in list
        for(int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }
}
