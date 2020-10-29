package my.playground;

import my.playground.Card.Suit;
import org.junit.Test;

import static java.util.Arrays.asList;
import static my.playground.Card.Suit.*;
import static my.playground.CardFactory.sevenOf;
import static my.playground.CardFactory.twoOf;
import static org.junit.jupiter.api.Assertions.*;

public class RuleEngineTest {


    @Test
    public void test_hand_with_highCard() {
        Hand hand = new Hand(asList(
                twoOf(Diamonds),
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
                twoOf(Clubs)
        ));

        RuleEngine ruleEngine = new RuleEngine();

        Rank maxRank = ruleEngine.evaluate(hand);

        assertEquals(2, maxRank.getPriority());
        assertEquals(Rank.Pair.class, maxRank.getClass());
    }
}