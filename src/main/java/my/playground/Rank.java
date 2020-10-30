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

    public static Rank twoPair(Card cardOne, Card cardTwo) {
        return new TwoPair(cardOne, cardTwo);
    }

    public static Rank fourOfKind(Card card) {
        return new FourOfKind(card);
    }

    public static Rank fullHouse() {
        return new FullHouse();
    }

    public static Rank straightFlush(Card card) {
        return new StraightFlush(card);
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

    private static class TwoPair extends Rank {
        Card cardOne;
        Card cardTwo;
        public TwoPair(Card cardOne, Card cardTwo) {
            super(RankValue.TwoPair.numericValue, cardTwo.getValue());
            this.cardOne = cardOne;
            this.cardTwo = cardTwo;
        }

        @Override
        public String toString() {
            return "two pair: " + cardOne.getValue() + " " + cardTwo.getValue();
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

    private static class FourOfKind extends Rank {
        Card card;
        public FourOfKind(Card card) {
            super(RankValue.FourOfKind.numericValue, card.getValue());
            this.card = card;
        }
        @Override
        public String toString() {
            return "four of kind: " + card.getValue();
        }
    }

    private static class FullHouse extends Rank {
        Card card;
        public FullHouse() {
            super(RankValue.FullHouse.numericValue, null);
        }
        @Override
        public String toString() {
            return "full house";
        }
    }

    private static class StraightFlush extends Rank {
        Card card;
        public StraightFlush(Card card) {
            super(RankValue.StraightFlush.numericValue, null);
            this.card = card;
        }
        @Override
        public String toString() {
            return "straight flush";
        }
    }


    public enum RankValue {
        HighCard(1),
        Pair(2),
        TwoPair(3),
        ThreeOfKind(4),
        Straight(5),
        Flush(6),
        FullHouse(7),
        FourOfKind(8),
        StraightFlush(9);

        public final Integer numericValue;
        RankValue(int numValue){
            this.numericValue = numValue;
        }
    }
}


