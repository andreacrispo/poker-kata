package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

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
        Map<Card.CardValue,List<Card>> cardGroupByValue = hand.cardGroupByValue();

        List<List<Card>> pair = cardGroupByValue.values().stream()
                .filter(cards -> cards.size() == 2)
                .collect(Collectors.toList());

        if(pair.size() == 2){
            return Rank.twoPair(pair.get(0).get(0), pair.get(1).get(0));
        }

        return null;
    }

}
