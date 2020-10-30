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
        List<Card> cardsFourByFour = hand.cardsEqualValueFourByFour();
        if(cardsFourByFour.size() == 4)
            return Rank.fourOfKind(cardsFourByFour.get(3));

        return null;
    }
}
