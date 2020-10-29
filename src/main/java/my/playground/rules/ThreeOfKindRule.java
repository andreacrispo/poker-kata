package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Three of a Kind: Three of the cards in the hand have the same value.
 * Hands which both contain three of a kind are ranked by the value of the 3 cards.
 */
public class ThreeOfKindRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Card.CardValue, Integer> cardOccurrences = new HashMap<>();
        for (Card card: cards) {
            if(cardOccurrences.containsKey(card.getValue())){
                cardOccurrences.put(card.getValue(), cardOccurrences.get(card.getValue()) +1);
            }else {
                cardOccurrences.put(card.getValue(), 1);
            }
        }
        for (Map.Entry<Card.CardValue, Integer> entry : cardOccurrences.entrySet()) {
            Card.CardValue cardValue = entry.getKey();
            Integer occurrence = entry.getValue();
            if (occurrence == 3) {
                List<Card> threeOfKindCard = cards.stream().filter(c -> cardValue == c.getValue()).collect(Collectors.toList());
                return Rank.threeOfKind(threeOfKindCard.get(0));
            }
        }
        return null;
    }
}
