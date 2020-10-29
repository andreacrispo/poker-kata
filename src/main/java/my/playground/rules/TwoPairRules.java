package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair.
 * If these values are the same the hands are ranked by the value of the remaining card.
 */
public class TwoPairRules implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Card.CardValue, Integer> occurrences = new HashMap<>();

        for(Card card : cards){
            if(occurrences.containsKey(card.getValue())){
                occurrences.put(card.getValue(), occurrences.get(card.getValue()) +1);
            }else {
                occurrences.put(card.getValue(), 1);
            }
        }

        for (Map.Entry<Card.CardValue, Integer> entry : occurrences.entrySet()) {
            Integer occurrence = entry.getValue();
            if (occurrence != 2) {
                return null;
            }
        }

        return Rank.twoPair(hand.getHighestCard());

    }
}
