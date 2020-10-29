package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Pair: 2 of the 5 cards in the hand have the same value.
 * Hands which both contain a pair are ranked by the value of the cards forming the pair.
 * If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
 */
public class PairRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        List<Card> cards = hand.getCards();

        Set<Integer> uniqueValues = new HashSet<>();
        for (Card card: cards) {
            if(!uniqueValues.add(card.getValue().numericValue)) {
                return Rank.pair(card, card);
            }
        }
        return null;
    }
}
