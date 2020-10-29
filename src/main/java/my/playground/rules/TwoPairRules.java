package my.playground.rules;

import my.playground.Hand;
import my.playground.Rank;

/**
 * Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair.
 * If these values are the same the hands are ranked by the value of the remaining card.
 */
public class TwoPairRules implements GameRule {

    // TODO: When manage four card
    @Override
    public Rank evaluate(Hand hand) {
        return null;
    }
}
