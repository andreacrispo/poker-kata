package my.playground;

import my.playground.Card.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static my.playground.Card.Suit.*;
import static my.playground.CardFactory.*;
import static org.junit.jupiter.api.Assertions.*;

public class RuleEngineTest {


    @Test
    public void test_hand_with_highCard_seven() {
        Hand hand = new Hand(asList(
                twoOf(Diamonds),
                fourOf(Hearts),
                sevenOf(Clubs)
        ));
        RuleEngine ruleEngine = new RuleEngine();

        Rank maxRank = ruleEngine.evaluate(hand);

        assertEquals(1, maxRank.getPriority());
        assertEquals(Rank.HighCard.class, maxRank.getClass());

        Rank.HighCard highCardRank = (Rank.HighCard) maxRank;
        assertEquals(Card.CardValue.Seven, highCardRank.card.getValue());
    }

    @Test
    public void test_hand_with_pair_of_two() {
        Hand hand = new Hand(asList(
                twoOf(Spades),
                threeOf(Spades),
                twoOf(Clubs)
        ));

        RuleEngine ruleEngine = new RuleEngine();

        Rank maxRank = ruleEngine.evaluate(hand);

        assertEquals(2, maxRank.getPriority());
        assertEquals(Rank.Pair.class, maxRank.getClass());
    }


    @Test
    public void test_hand_with_three_of_kind_of_five() {
        Hand hand = new Hand(asList(
                fiveOf(Spades),
                fiveOf(Hearts),
                fiveOf(Clubs)
        ));

        RuleEngine ruleEngine = new RuleEngine();

        Rank maxRank = ruleEngine.evaluate(hand);

        assertEquals(4, maxRank.getPriority());
    }


    @Test
    public void test_hand_with_straight() {
        Hand hand = new Hand(asList(
                threeOf(Spades),
                fiveOf(Hearts),
                fourOf(Clubs)
        ));

        RuleEngine ruleEngine = new RuleEngine();
        Rank maxRank = ruleEngine.evaluate(hand);
        assertEquals(5, maxRank.getPriority());
    }


    @Test
    public void test_hand_with_flush() {
        Hand hand = new Hand(asList(
                threeOf(Spades),
                fiveOf(Spades),
                sevenOf(Spades)
        ));

        RuleEngine ruleEngine = new RuleEngine();
        Rank maxRank = ruleEngine.evaluate(hand);
        assertEquals(6, maxRank.getPriority());
    }
}