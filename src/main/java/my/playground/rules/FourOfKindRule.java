package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;
import java.util.Map;

/**
 * 4 cards with the same value. Ranked by the value of the 4 cards.
 */
public class FourOfKindRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        Map<Card.CardValue, List<Card>> cardGroupByValue = hand.cardGroupByValue();
        return cardGroupByValue.values().stream()
                .filter(cards -> cards.size() == 4)
                .findFirst()
                .map(cards -> Rank.fourOfKind(cards.get(3)))
                .orElse(null);
    }
}
