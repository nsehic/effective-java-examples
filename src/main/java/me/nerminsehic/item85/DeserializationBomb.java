package me.nerminsehic.item85;

import java.util.HashSet;
import java.util.Set;

public class DeserializationBomb {

    private static byte[] serialize(Set<Object> set) {
        return new byte[0];
    }

    // Deserialization bomb - deserializing this stream takes forever.
    static byte[] bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();

        for(int i = 0; i < 100; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo");
            s1.add(t1); s1.add(t2);
            s2.add(t1); s2.add(t2);
            s1 = t1;
            s2 = t2;
        }

        return serialize(root); // Method omitted for brevity
    }
}
