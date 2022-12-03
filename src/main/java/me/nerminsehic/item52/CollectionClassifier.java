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

    /**
     * Assuming a static method is required, the best way to fix the CollectionClassifier
     * program is to replace all three overloadings of classify with a single method that does
     * explicit instanceof tests.
     * @param collection
     * @return String classifier
     */
    public static String classifyGood(Collection<?> collection) {
        return collection instanceof Set ? "Set" :
                collection instanceof List ? "List" : "Unknown collection";
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
