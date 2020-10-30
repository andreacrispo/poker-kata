package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;
import java.util.Map;

/**
 * Pair: 2 of the 5 cards in the hand have the same value.
 * Hands which both contain a pair are ranked by the value of the cards forming the pair.
 * If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
 */
public class PairRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        List<Card> pair = hand.cardsEqualValueTwoByTwo();
        if(pair.size() == 2) {
            List<Card> kickers = hand.allCardsExcept(pair);
            Card highestKicker = kickers.stream().max(Card::compareTo).get();
            return Rank.pair(pair.get(0), pair.get(1), highestKicker);
        }

        return null;
    }
}
