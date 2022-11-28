package me.nerminsehic.item41;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    /**
     * Iterative Cartesian product computation
     *
     * @return List<Card>
     */
    private static Set<Card> newDeckIterative() {
        Set<Card> result = new HashSet<>();
        for (Suit suit : Suit.values())
            for (Rank rank : Rank.values())
                result.add(new Card(suit, rank));

        return result;
    }

    /**
     * Stream-based Cartesian product computation
     * @return List<Card>
     */
    private static Set<Card> newDeck() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Set<Card> deck = newDeck();
        System.out.printf("Deck size: %d%n", deck.size());
        deck.forEach(System.out::println);
    }


}
