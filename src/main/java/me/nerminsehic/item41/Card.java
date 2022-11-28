package me.nerminsehic.item41;

import java.util.Objects;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "%s of %s".formatted(rank, suit);
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Card otherCard)) return false;
        return this.suit.equals(otherCard.suit) && this.rank.equals(otherCard.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

}
