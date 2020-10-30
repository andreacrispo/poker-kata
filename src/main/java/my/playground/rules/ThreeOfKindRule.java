package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;
import java.util.List;
import java.util.Map;

/**
 * Three of a Kind: Three of the cards in the hand have the same value.
 * Hands which both contain three of a kind are ranked by the value of the 3 cards.
 */
public class ThreeOfKindRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
         List<Card> cardsThrees = hand.cardsEqualValueThreeByThree();
         if(cardsThrees.size() == 3)
            return Rank.threeOfKind(cardsThrees.get(2));
         return null;
    }
}
