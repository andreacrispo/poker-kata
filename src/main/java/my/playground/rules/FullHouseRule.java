package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

/**
 *  3 cards of the same value, (Three Of Kind Rule)
 *  with the remaining 2 cards forming a pair. (Pair Rule)
 *  Ranked by the value of the 3 cards.
 */
public class FullHouseRule implements GameRule {

    @Override
    public Rank evaluate(Hand hand) {
       if(new PairRule().evaluate(hand) == null)
           return null;

       if(new ThreeOfKindRule().evaluate(hand) == null)
            return null;

        return Rank.fullHouse();
    }
}
