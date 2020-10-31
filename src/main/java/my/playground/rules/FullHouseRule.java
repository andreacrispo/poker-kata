package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

import java.util.Optional;

/**
 *  3 cards of the same value, (Three Of Kind Rule)
 *  with the remaining 2 cards forming a pair. (Pair Rule)
 *  Ranked by the value of the 3 cards.
 */
public class FullHouseRule implements GameRule {

    @Override
    public Optional<Rank> evaluate(Hand hand) {
        boolean hasAPair = new PairRule().evaluate(hand).isPresent();
        boolean hasAThreeOfKind = new ThreeOfKindRule().evaluate(hand).isPresent();
        if(hasAPair && hasAThreeOfKind)
            return Optional.of(Rank.fullHouse());

        return Optional.empty();
    }
}
