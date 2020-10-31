package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

import java.util.Optional;

public class StraightFlushRule implements GameRule {

    @Override
    public Optional<Rank> evaluate(Hand hand) {
        boolean hasAStraight = new StraightRule().evaluate(hand).isPresent();
        boolean hasAFlush = new FlushRule().evaluate(hand).isPresent();

        if(hasAStraight && hasAFlush)
            return Optional.of(Rank.straightFlush(hand.getHighestCard()));

        return Optional.empty();
    }
}
