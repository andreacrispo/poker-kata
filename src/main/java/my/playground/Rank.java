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

    public static Rank threeOfKind(Card card) {
        return new ThreeOfKind(card);
    }

    public static Rank straight(Card card) {
        return new Straight(card);
    }

    public static Rank flush(Card card) {
        return new Flush(card);
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
            super(RankValue.HighCard.numericValue, card.getValue());
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
            super(RankValue.Pair.numericValue, cardOne.getValue());
            this.cardOne = cardOne;
            this.cardTwo = cardTwo;
        }

        @Override
        public String toString() {
            return "pair: " + cardOne.getValue();
        }
    }

    private static class DoublePair extends Rank {
        Card card;
        public DoublePair(Card card) {
            super(RankValue.DoublePair.numericValue, card.getValue());
            this.card = card;
        }

        @Override
        public String toString() {
            return "double pair: " + card.getValue();
        }
    }

    private static class ThreeOfKind extends Rank {
        Card card;
        public ThreeOfKind(Card card) {
            super(RankValue.ThreeOfKind.numericValue, card.getValue());
            this.card = card;
        }

        @Override
        public String toString() {
            return "three of kind: " + card.getValue();
        }
    }

    private static class Straight extends Rank {
        Card card;
        public Straight(Card card) {
            super(RankValue.Straight.numericValue, card.getValue());
            this.card = card;
        }

        @Override
        public String toString() {
            return "straight: " + card.getValue();
        }
    }

    private static class Flush extends Rank {
        Card card;
        public Flush(Card card) {
            super(RankValue.Flush.numericValue, card.getValue());
            this.card = card;
        }

        @Override
        public String toString() {
            return "flush: " + card.getSuit();
        }
    }

    public enum RankValue {
        HighCard(1),
        Pair(2),
        DoublePair(3),
        ThreeOfKind(4),
        Straight(5),
        Flush(6);

        public final Integer numericValue;
        RankValue(int numValue){
            this.numericValue = numValue;
        }
    }
}


