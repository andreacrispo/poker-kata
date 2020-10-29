package my.playground;


import java.util.Objects;

public class Rank implements Comparable<Rank> {

    protected Integer priority;
    protected  Card.CardValue highestCardValue;

    public Rank(Integer priority, Card.CardValue value) {
        this.priority = priority;
        this.highestCardValue = value;
    }

    public static Rank highCard(Card card) {
        return new HighCard(card);
    }

    public static Rank pair(Card cardOne, Card cardTwo) {
        return new Pair(cardOne, cardTwo);
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public boolean isHigherThen(Rank other) {
        int compare = this.compareTo(other);
        if(compare == 0) {
            return this.highestCardValue.numericValue > other.highestCardValue.numericValue;
        }
        return compare > 0;
    }


    @Override
    public int compareTo(Rank other) {
        if(this.priority > other.priority)
            return 1;
        else if( this.priority < other.priority)
            return -1;

        return  0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(priority, rank.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority);
    }

    public static class HighCard extends  Rank{
        Card card;
        public HighCard(Card card) {
            super(1, card.getValue());
            this.card = card;
        }

        @Override
        public String toString() {
            return "high card: " + card.getValue();
        }
    }

    public static class Pair extends Rank {
        Card cardOne;
        Card cardTwo;
        public Pair(Card cardOne, Card CardTwo) {
            super(2, cardOne.getValue());
            this.cardOne = cardOne;
            this.cardTwo = cardTwo;
        }

        @Override
        public String toString() {
            return "pair: " + cardOne.getValue();
        }
    }

}


