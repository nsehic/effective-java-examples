package me.nerminsehic.item52;

import java.math.BigInteger;
import java.util.*;

/**
 * Since the choice of which overloading to invoke is made at compile time
 * the `classify` overloading that accepts the Collection type is invoked three times.
 * This is because the compile-time type of all three instances is `Collection<?>`,
 * therefore the overloading that accepts this type is selected, even if the runtime type differs
 *
 * As a general rule, selection among overloaded methods is static, while selection
 * among overridden methods is dynamic.
 *
 * @see Overriding
 */
public class CollectionClassifier {
    public static String classify(Set<?> set) {
        return "Set";
    }

    public static String classify(List<?> list) {
        return "List";
    }

    public static String classify(Collection<?> collection) {
        return "Unknown collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for(Collection<?> collection: collections) {
            System.out.println(classify(collection));
        }
    }
}
