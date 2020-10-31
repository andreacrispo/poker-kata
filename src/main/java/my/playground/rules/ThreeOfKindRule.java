package my.playground.rules;

import my.playground.Card;
import my.playground.Hand;
import my.playground.Rank;
import java.util.List;
import java.util.Optional;

/**
 * Three of a Kind: Three of the cards in the hand have the same value.
 * Hands which both contain three of a kind are ranked by the value of the 3 cards.
 */
public class ThreeOfKindRule implements GameRule {

    @Override
    public Optional<Rank> evaluate(Hand hand) {
        System.out.println("ThreeOfKindRule");

        List<Card> cardsThrees = hand.cardsEqualValueThreeByThree();
         if(cardsThrees.size() == 3)
            return Optional.of(Rank.threeOfKind(cardsThrees.get(2)));
         return Optional.empty();
    }
}
