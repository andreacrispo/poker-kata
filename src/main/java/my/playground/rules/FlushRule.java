package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

/**
 * Hand contains 5 cards of the same suit.
 * Hands which are both flushes are ranked using the rules for High Card.
 */
public class FlushRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        List<Card> cards = hand.getCards();

        boolean isAllCardsSameSuit = cards.stream()
                .collect(groupingBy(Card::getSuit))
                .values().stream()
                .anyMatch(s -> s.size() == cards.size());

        if(isAllCardsSameSuit)
            return Rank.flush(hand.getHighestCard());

        return null;
    }
}
