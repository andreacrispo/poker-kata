package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;

import java.util.List;
import java.util.Optional;

/**
 * Straight: Hand contains 5 cards with consecutive values.
 * Hands which both contain a straight are ranked by their highest card.
 */
public class StraightRule implements GameRule {
    
    @Override
    public Optional<Rank> evaluate(Hand hand) {
        List<Card> cards = hand.getCards();

        for(int i=0; i < cards.size(); i++){
            if(i+1 < cards.size()) {
                Card current = cards.get(i);
                Card next = cards.get(i+1);
                if (!current.getValue().cameBeforeValue(next.getValue())) {
                   return Optional.empty();
                }
            }
        }
        return Optional.of(Rank.straight(hand.getHighestCard()));
    }
}
