package my.playground;

import java.util.Objects;

public class Card implements Comparable<Card> {
    private final CardValue value;
    private final Suit suit;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }


    public boolean hasSameValue(Card other) {
        return this.value.equals(other.value);
    }

    @Override
    public int compareTo(Card other) {
        return this.value.numericValue.compareTo(other.value.numericValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    public enum Suit {
        Clubs,
        Diamonds,
        Hearts,
        Spades
    }

    public enum CardValue {
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Queen(12),
        King(13),
        Ace(14);

        public final Integer numericValue;

        CardValue(int numValue){
            this.numericValue = numValue;
        }
    }
}
