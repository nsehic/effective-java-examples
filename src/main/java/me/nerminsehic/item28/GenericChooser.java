package me.nerminsehic.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenericChooser<T> {
    private final List<T> choiceList;

    public GenericChooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rand = ThreadLocalRandom.current();
        return choiceList.get(rand.nextInt(choiceList.size()));
    }
}
