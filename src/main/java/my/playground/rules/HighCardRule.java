package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

import java.util.Optional;


/**
 * Hands which do not fit any higher category are ranked by the value of their highest card.
 * If the highest cards have the same value, the hands are ranked by the next highest, and so on.
 */
public class HighCardRule implements GameRule {

    @Override
    public Optional<Rank> evaluate(Hand hand) {
        return Optional.of(Rank.highCard(hand.getHighestCard()));
    }
}
