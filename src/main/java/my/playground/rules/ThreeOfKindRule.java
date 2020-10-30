package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Three of a Kind: Three of the cards in the hand have the same value.
 * Hands which both contain three of a kind are ranked by the value of the 3 cards.
 */
public class ThreeOfKindRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        Map<Card.CardValue,List<Card>> cardGroupByValue = hand.cardGroupByValue();
        return cardGroupByValue.values().stream()
                .filter(cards -> cards.size() == 3)
                .findFirst()
                .map(cards -> Rank.threeOfKind(cards.get(2)))
                .orElse(null);
    }
}
