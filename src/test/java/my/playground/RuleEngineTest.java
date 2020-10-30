package my.playground;

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
                sevenOf(Clubs),
                fiveOf(Clubs),
                sixOf(Diamonds)
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
                twoOf(Clubs),
                kingOf(Diamonds),
                aceOf(Hearts)
        ));

        RuleEngine ruleEngine = new RuleEngine();

        Rank maxRank = ruleEngine.evaluate(hand);

        assertEquals(2, maxRank.getPriority());
        assertEquals(Rank.Pair.class, maxRank.getClass());
    }


    @Test
    public void test_hand_with_two_pair_pair_of_four_pair_of_seven() {
        Hand hand = new Hand(asList(
                fourOf(Spades),
                fiveOf(Clubs),
                fourOf(Hearts),
                fiveOf(Diamonds),
                sevenOf(Diamonds)
        ));

        RuleEngine ruleEngine = new RuleEngine();

        Rank maxRank = ruleEngine.evaluate(hand);

        assertEquals(3, maxRank.getPriority());
        assertEquals("two pair: Four Five", maxRank.toString());
    }


    @Test
    public void test_hand_with_three_of_kind_of_five() {
        Hand hand = new Hand(asList(
                fiveOf(Spades),
                fiveOf(Hearts),
                fiveOf(Clubs),
                twoOf(Clubs),
                aceOf(Hearts)
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
                fourOf(Clubs),
                sixOf(Clubs),
                sevenOf(Spades)
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
                sevenOf(Spades),
                fiveOf(Spades),
                sevenOf(Spades)
        ));

        RuleEngine ruleEngine = new RuleEngine();
        Rank maxRank = ruleEngine.evaluate(hand);
        assertEquals(6, maxRank.getPriority());
    }

    @Test
    public void test_hand_with_four_ok_kind() {
        Hand hand = new Hand(asList(
                threeOf(Spades),
                threeOf(Clubs),
                threeOf(Diamonds),
                threeOf(Hearts),
                twoOf(Diamonds)
        ));

        RuleEngine ruleEngine = new RuleEngine();
        Rank maxRank = ruleEngine.evaluate(hand);
        assertEquals(8, maxRank.getPriority());
        assertEquals("four of kind: Three", maxRank.toString());
    }

    @Test
    public void test_hand_with_full_house() {
        Hand hand = new Hand(asList(
                threeOf(Spades),
                threeOf(Clubs),
                threeOf(Diamonds),
                kingOf(Clubs),
                kingOf(Spades)
        ));

        RuleEngine ruleEngine = new RuleEngine();
        Rank maxRank = ruleEngine.evaluate(hand);
        assertEquals(7, maxRank.getPriority());
        assertEquals("full house", maxRank.toString());
    }


    @Test
    public void test_hand_with_straight_flush() {
        Hand hand = new Hand(asList(
                threeOf(Spades),
                twoOf(Spades),
                fiveOf(Spades),
                fourOf(Spades),
                sixOf(Spades)
        ));

        RuleEngine ruleEngine = new RuleEngine();
        Rank maxRank = ruleEngine.evaluate(hand);
        assertEquals(9, maxRank.getPriority());
        assertEquals("straight flush", maxRank.toString());
    }


}