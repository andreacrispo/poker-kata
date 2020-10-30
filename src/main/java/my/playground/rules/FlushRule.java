package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hand contains 5 cards of the same suit.
 * Hands which are both flushes are ranked using the rules for High Card.
 */
public class FlushRule implements GameRule {


    @Override
    public Rank evaluate(Hand hand) {
        List<Card.Suit> suitList = hand.getCards().stream().map(Card::getSuit).collect(Collectors.toList());

        for(int i=0; i < suitList.size(); i++){
            if(i+1 < suitList.size()) {
                Card.Suit current = suitList.get(i);
                Card.Suit  next = suitList.get(i+1);
                if (!current.equals(next)) {
                    return null;
                }
            }
        }
        return Rank.flush(hand.getHighestCard());
    }
}
